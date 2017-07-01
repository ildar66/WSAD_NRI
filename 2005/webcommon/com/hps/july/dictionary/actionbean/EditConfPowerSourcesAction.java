/*
 * Created on 28.11.2006
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.SystemException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.cdbc.objects.CDBCDictionaryObject;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.dictionary.formbean.ConfPowerSourcesForm;
import com.hps.july.dictionary.formbean.EditConfPowerSourcesForm;
import com.hps.july.dictionary.valueobject.CmplStruct_VO;
import com.hps.july.persistence.BSInstComplectResourceSetAccessBean;
import com.hps.july.persistence.PowerSupplySetAccessBean;
import com.hps.july.persistence.ResourceSetAccessBean;
import com.hps.july.persistence.UZOPowerSupplySetAccessBean;
import com.hps.july.util.ErrorProcessor;
import com.hps.july.web.util.NavigatedAction;
import com.hps.july.web.util.ParamsParser;

/**
 * @author irogachev
 */
public class EditConfPowerSourcesAction extends NavigatedAction {

	public EditConfPowerSourcesAction() {
		super();
	}

	public ActionForward perform(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response) 
									throws IOException, ServletException
	{
		ActionErrors errors = new ActionErrors();
		//
		EditConfPowerSourcesForm editForm = (EditConfPowerSourcesForm)form;
		ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
		// javax.transaction.UserTransaction utrans = null;						
		try {
			// javax.naming.Context ctx = new javax.naming.InitialContext();
			// utrans = (javax.transaction.UserTransaction)ctx.lookup("jta/usertransaction");
			// !!!
			// utrans.begin();
			if (EditConfPowerSourcesForm.ACTION_ADD.equals(editForm.getAction())) {
				if (editForm.getComplectCode() == null) {
					editForm.setComplectCode(getNextId());
				}
			}
			if (EditConfPowerSourcesForm.TRUE_STR.equals(editForm.getIsSave())) {
				doAction(editForm, request);
			}
			if (EditConfPowerSourcesForm.TRUE_STR.equals(editForm.getIsLoadFromDB())) {
				editForm.loadFromDB();
				editForm.setIsLoadFromDB(EditConfPowerSourcesForm.FALSE_STR);
			}
			// !!!
			// utrans.commit();
		} catch (Exception e) {
			/*
			try {
				if (utrans != null) {
					// !!!
					// utrans.rollback();
				}
			} catch (Exception e1) {
				ErrorProcessor.processException(errors, e1);
			}
			*/
			editForm.setIsSave(EditConfPowerSourcesForm.FALSE_STR);
			ErrorProcessor.processException(errors, e);
		}
		//process errors
		if( !errors.empty() ) {
			saveErrors(request, errors);
		}
		return mapping.findForward("main");	
	}

	/**
	 * @param editForm
	 */
	private void doAction(EditConfPowerSourcesForm editForm, HttpServletRequest request) throws Exception {
		// 1. получить из сессии форму содержащую список ресурсов для текущего комплекта
		HttpSession theSession = request.getSession();
		ConfPowerSourcesForm confPowerSourcesForm = 
		 	(ConfPowerSourcesForm)theSession.getAttribute(
		 		ConfPowerSourcesForm.getFormString(request.getSession()));
		boolean isElAp = ConfPowerSourcesForm.getIsElAp(theSession); 		
		boolean isUzo = ConfPowerSourcesForm.getIsUzo(theSession); 		
		boolean isIkBs = ConfPowerSourcesForm.getIsIkBs(theSession); 		
		if (EditConfPowerSourcesForm.ACTION_ADD.equals(editForm.getAction())) {
			// addAction(editForm, confPowerSourcesForm, isElAp);
			addAction(editForm, confPowerSourcesForm, isElAp, isUzo, isIkBs);
		} else if (EditConfPowerSourcesForm.ACTION_EDIT.equals(editForm.getAction())) {
			// updateAction(editForm, confPowerSourcesForm, isElAp);
			updateAction(editForm, confPowerSourcesForm, isElAp, isUzo, isIkBs);
		} else if (EditConfPowerSourcesForm.ACTION_DELETE.equals(editForm.getAction())) {
			// deleteAction(editForm, confPowerSourcesForm, isElAp);
			// сейчас используем JBDC транзакции
			deleteActionJDBC(editForm, confPowerSourcesForm, isElAp, isUzo, isIkBs);
		}
	}

	/**
	 * @param editForm
	 * @param confPowerSourcesForm
	 * @param isElAp
	 */
	private void deleteActionJDBC(EditConfPowerSourcesForm editForm, ConfPowerSourcesForm confPowerSourcesForm, 
				boolean isElAp, boolean isUzo, boolean isIkBs) throws Exception {
		/*
		// послать в CDBC процедуру id конфигурации и список id оборудования
		CDBCDictionaryObject.removePowerSource(editForm.getComplectCode(), isElAp, isUzo, isIkBs);
		*/		
		try {
			String result = CDBCDictionaryObject.deleteResourceset(new Integer(editForm.getComplectCode()));
			if (!result.equalsIgnoreCase("ok")){
				throw new Exception(result);
			}
			/*
			deleteCurrentPowerResources(editForm, confPowerSourcesForm);
			if (isElAp) {
				PowerSupplySetAccessBean powerSupplySet =new PowerSupplySetAccessBean();
				powerSupplySet.setInitKey_resourceset(Integer.parseInt(editForm.getComplectCode()));
				powerSupplySet.refreshCopyHelper();
				powerSupplySet.getEJBRef().remove();
			} else {
				UZOPowerSupplySetAccessBean uzoPowerSupplySet =new UZOPowerSupplySetAccessBean();
				uzoPowerSupplySet.setInitKey_resourceset(Integer.parseInt(editForm.getComplectCode()));
				uzoPowerSupplySet.refreshCopyHelper();
				uzoPowerSupplySet.getEJBRef().remove();
			}
			*/
			
		} catch (Exception e) {
			editForm.setIsSave(ConfPowerSourcesForm.FALSE_STR);
			editForm.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}		
	}

	/**
	 * @param editForm
	 */
	private void deleteAction(EditConfPowerSourcesForm editForm, 
					ConfPowerSourcesForm confPowerSourcesForm, boolean isElAp) throws RemoteException, RemoveException, CreateException, FinderException, NamingException {
		try {
			System.out.println("in deleteAction");
			// сначала нужно удалить все из состава источника питания
			String result = CDBCDictionaryObject.deleteResourceset(new Integer(editForm.getComplectCode()));
			if (!result.equalsIgnoreCase("ok"))
				throw new Exception(result);
			/*
			deleteCurrentPowerResources(editForm, confPowerSourcesForm);
			if (isElAp) {
				PowerSupplySetAccessBean powerSupplySet =new PowerSupplySetAccessBean();
				powerSupplySet.setInitKey_resourceset(Integer.parseInt(editForm.getComplectCode()));
				powerSupplySet.refreshCopyHelper();
				powerSupplySet.getEJBRef().remove();
			} else {
				UZOPowerSupplySetAccessBean uzoPowerSupplySet =new UZOPowerSupplySetAccessBean();
				uzoPowerSupplySet.setInitKey_resourceset(Integer.parseInt(editForm.getComplectCode()));
				uzoPowerSupplySet.refreshCopyHelper();
				uzoPowerSupplySet.getEJBRef().remove();
			}
			*/
			
		} catch (Exception e) {
			editForm.setIsSave(ConfPowerSourcesForm.FALSE_STR);
			// ErrorProcessor.
			editForm.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 */
	private void deleteCurrentPowerResources(EditConfPowerSourcesForm editForm, ConfPowerSourcesForm confPowerSourcesForm) 
		throws RemoteException, RemoveException, CreateException, FinderException, NamingException {
		List curComplectResourcesList = confPowerSourcesForm.getCmplStructList();
		// 2. для каждого ресурса вызвать процедуру удаления
		for (int i = 0; i < curComplectResourcesList.size(); i++) {
			CmplStruct_VO curCmplStruct_VO = (CmplStruct_VO)curComplectResourcesList.get(i);
			EditPowerResourceAction.deletePowerResourceRoutine(
			editForm.getComplectCode(),	curCmplStruct_VO.getNriCode());
		}
	}

	/**
	 * @param editForm
	 */
	private void updateAction(EditConfPowerSourcesForm editForm, 
			ConfPowerSourcesForm confPowerSourcesForm, 
			boolean isElAp, boolean isUzo, boolean isIkBs) throws RemoteException, CreateException, FinderException, NamingException {
		// try {
			if (isElAp) {
				PowerSupplySetAccessBean powerSupplySet = new PowerSupplySetAccessBean();
				powerSupplySet.setInitKey_resourceset(Integer.parseInt(editForm.getComplectCode()));
				powerSupplySet.refreshCopyHelper();
				powerSupplySet.setName(editForm.getComplectName());
				powerSupplySet.setNfsitemid(editForm.getNfsId());
				powerSupplySet.setPower(new BigDecimal(editForm.getPower()));
				powerSupplySet.setResourcesetclass(confPowerSourcesForm.getResourceSetClassConst());
				// чтоб не ругалась 
				powerSupplySet.setMainpartqty(new BigDecimal(0));//
				powerSupplySet.commitCopyHelper();
			} else if (isUzo) {
				UZOPowerSupplySetAccessBean uzoPowerSupplySet = new UZOPowerSupplySetAccessBean();
				uzoPowerSupplySet.setInitKey_resourceset(Integer.parseInt(editForm.getComplectCode()));
				uzoPowerSupplySet.refreshCopyHelper();
				uzoPowerSupplySet.setName(editForm.getComplectName());
				uzoPowerSupplySet.setNfsitemid(editForm.getNfsId());
				uzoPowerSupplySet.setResourcesetclass(confPowerSourcesForm.getResourceSetClassConst());
				// чтоб не ругалась ?????????????
				uzoPowerSupplySet.setMainpartqty(new BigDecimal(0));//
				uzoPowerSupplySet.commitCopyHelper();
			} else if (isIkBs) {
				BSInstComplectResourceSetAccessBean bsInstComplectResourceSetAccessBean = 
					new BSInstComplectResourceSetAccessBean();
				bsInstComplectResourceSetAccessBean.setInitKey_resourceset(Integer.parseInt(editForm.getComplectCode()));
				bsInstComplectResourceSetAccessBean.refreshCopyHelper();
				bsInstComplectResourceSetAccessBean.setName(editForm.getComplectName());
				bsInstComplectResourceSetAccessBean.setNfsitemid(editForm.getNfsId());
				bsInstComplectResourceSetAccessBean.setResourcesetclass(confPowerSourcesForm.getResourceSetClassConst());
				// чтоб не ругалась ?????????????
				bsInstComplectResourceSetAccessBean.setMainpartqty(new BigDecimal(0));//
				bsInstComplectResourceSetAccessBean.commitCopyHelper();
			}
			confPowerSourcesForm.setCurComplectSelectedID(editForm.getComplectCode());
		/*	
		} catch (Exception e) {
			editForm.setIsSave(ConfPowerSourcesForm.FALSE_STR);
			editForm.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		*/
	}

	/**
	 * @param editForm
	 */
	private void addAction(EditConfPowerSourcesForm editForm, 
			ConfPowerSourcesForm confPowerSourcesForm, 
			boolean isElAp,  boolean isUzo, boolean isIkBs) throws RemoteException, CreateException, FinderException, NamingException {
				// try {
					if (isElAp) {
						PowerSupplySetAccessBean powerSupplySet =
								new PowerSupplySetAccessBean(
									Integer.parseInt(editForm.getComplectCode()), // int argResourceset,
									editForm.getComplectName(), // java.lang.String argName,
									//new Integer(0), // java.lang.Integer argMainPart,
									null, // java.lang.Integer argMainPart,
									new BigDecimal(0), // java.math.BigDecimal argMainPartQty, 
									null, // java.lang.String argType, 
									new BigDecimal(editForm.getPower()) // java.math.BigDecimal argPower
									);
						powerSupplySet.setNfsitemid(editForm.getNfsId());
						powerSupplySet.commitCopyHelper();
					} else if (isUzo) {
						UZOPowerSupplySetAccessBean uzoPowerSupplySet =
								new UZOPowerSupplySetAccessBean(
									Integer.parseInt(editForm.getComplectCode()), // int argResourceset,
									editForm.getComplectName(), // java.lang.String argName,
									//new Integer(0), // java.lang.Integer argMainPart,
									null, // java.lang.Integer argMainPart,
									new BigDecimal(0), // java.math.BigDecimal argMainPartQty, 
									null // java.lang.String argType 
									);
						uzoPowerSupplySet.setNfsitemid(editForm.getNfsId());
						uzoPowerSupplySet.commitCopyHelper();
					} else if (isIkBs) {
						BSInstComplectResourceSetAccessBean bsInstComplectResourceSetAccessBean =
								new BSInstComplectResourceSetAccessBean(
									Integer.parseInt(editForm.getComplectCode()), // int argResourceset,
									editForm.getComplectName(), // java.lang.String argName,
									//new Integer(0), // java.lang.Integer argMainPart,
									null, // java.lang.Integer argMainPart,
									new BigDecimal(0), // java.math.BigDecimal argMainPartQty, 
									null // java.lang.String argType 
									);
						bsInstComplectResourceSetAccessBean.setNfsitemid(editForm.getNfsId());
						bsInstComplectResourceSetAccessBean.commitCopyHelper();
					}
					confPowerSourcesForm.setCurComplectSelectedID(editForm.getComplectCode());
				/*	
				} catch (Exception e) {
					editForm.setIsSave(ConfPowerSourcesForm.FALSE_STR);
					editForm.setErrorMsg(e.getMessage());
					e.printStackTrace();
				}
				*/
	}
	
	private String getNextId() throws RemoteException, CreateException, NamingException {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		int newId = keyGen.getNextKey("tables.resourceset");
		String newIdStr = String.valueOf(newId);
		return newIdStr;
	}

}
