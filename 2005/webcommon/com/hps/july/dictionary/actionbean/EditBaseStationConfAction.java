/*
 * Created on 12.01.2007
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCDictionaryObject;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.dictionary.formbean.EditBaseStationConfForm;
import com.hps.july.dictionary.formbean.ShowConfBaseStationForm;
import com.hps.july.persistence2.ConfBSNfsAccessBean;
import com.hps.july.util.ErrorProcessor;
import com.hps.july.web.util.ParamsParser;

/**
 * @author irogachev
 */
public class EditBaseStationConfAction extends Action {

	public EditBaseStationConfAction() {
		super();
	}

	public ActionForward perform(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response) 
									throws IOException, ServletException
	{
		ActionErrors errors = new ActionErrors();
		//
		EditBaseStationConfForm editForm = (EditBaseStationConfForm) form;
		ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
		try {
			if (EditBaseStationConfForm.TRUE_STR.equals(editForm.getIsSave())) {
				doAction(editForm, request);
			}
			if (EditBaseStationConfForm.TRUE_STR.equals(editForm.getIsLoadFromDB())) {
				editForm.loadFromDB();
				editForm.setIsLoadFromDB(EditBaseStationConfForm.FALSE_STR);
			}
		} catch (Exception e) {
			editForm.setIsSave(EditBaseStationConfForm.FALSE_STR);
			ErrorProcessor.processException( errors, e );
		}
		//process errors
		if( !errors.empty() ) {
			saveErrors(request, errors);
		}
		return mapping.findForward("main");	
	}

	private void doAction(EditBaseStationConfForm editForm, HttpServletRequest request) throws RemoteException, RemoveException, CreateException, FinderException, NamingException {
		if (EditBaseStationConfForm.ACTION_ADD.equals(editForm.getAction())) {
			addAction(editForm);
		} else if (EditBaseStationConfForm.ACTION_EDIT.equals(editForm.getAction())) {
			updateAction(editForm);
		} else if (EditBaseStationConfForm.ACTION_DELETE.equals(editForm.getAction())) {
			deleteAction(editForm);
		}
	}

	private String THIS_CONFOG_ALREADY_EXIST = "«аданна€ конфигураци€ базовой станции уже существует!";

	private void updateAction(EditBaseStationConfForm editForm) throws RemoteException, CreateException, FinderException, NamingException {
		Integer checkId = checkTheSameConfig(editForm);
		if ((checkId != null) && ((Integer.parseInt(editForm.getId())) != checkId.intValue())) {
			editForm.setIsSave(EditBaseStationConfForm.FALSE_STR);
			editForm.setErrorMsg(THIS_CONFOG_ALREADY_EXIST);
			return;
		}	 
		ConfBSNfsAccessBean confBSNfsAccessBean = new ConfBSNfsAccessBean();
		confBSNfsAccessBean.setInitKey_id(Integer.parseInt(editForm.getId())); 
		// try {
			confBSNfsAccessBean.refreshCopyHelper();
			//
			confBSNfsAccessBean.setConftype(editForm.getConftype());
			//
			confBSNfsAccessBean.setSect_a(Integer.parseInt(editForm.getA()));
			confBSNfsAccessBean.setSect_b(Integer.parseInt(editForm.getB()));
			confBSNfsAccessBean.setSect_c(Integer.parseInt(editForm.getC()));
			confBSNfsAccessBean.setSect_d(Integer.parseInt(editForm.getD()));
			confBSNfsAccessBean.setSect_e(Integer.parseInt(editForm.getE()));
			confBSNfsAccessBean.setSect_f(Integer.parseInt(editForm.getF()));
			confBSNfsAccessBean.setSect_g(Integer.parseInt(editForm.getG()));
			confBSNfsAccessBean.setSect_h(Integer.parseInt(editForm.getH()));
			confBSNfsAccessBean.setSect_o900(Integer.parseInt(editForm.getSect_o900()));
			confBSNfsAccessBean.setSect_o1800(Integer.parseInt(editForm.getSect_o1800()));
			//
			BigDecimal voltageVar = null;
			if ((editForm.getVoltage() != null) && (editForm.getVoltage().length() > 0)) {
				voltageVar = new BigDecimal(editForm.getVoltage());
			}	
			confBSNfsAccessBean.setVoltage(voltageVar);
			confBSNfsAccessBean.setNfsitem_id(editForm.getNfsId());
			//
			confBSNfsAccessBean.commitCopyHelper();
		/*	
		} catch (Exception e) {
			editForm.setIsSave(EditBaseStationConfForm.FALSE_STR);
			editForm.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		*/
	}

	/**
	 * @param editForm
	 * @param i
	 * @return
	 */
	private Integer checkTheSameConfig(EditBaseStationConfForm editForm) {
		Integer outIdObject = null;
		// 1. ищем бин с такими же значени€ми
		// ConfBSNfsAccessBean confBSNfsAccessBean = new ConfBSNfsAccessBean();
		// 
		// try {
			BigDecimal theVoltageVal = null;
			if ((editForm.getVoltage() != null) && (editForm.getVoltage().length() > 0)) {
				theVoltageVal = new BigDecimal(editForm.getVoltage()); 
			}	
			CDBCResultSet findAllRS = CDBCDictionaryObject.findByAllBaseStationComplect(
				editForm.getConftype(), // java.lang.String argConfType,
				new Integer(editForm.getA()), // int argSectA,
				new Integer(editForm.getB()), // int argSectB,
				new Integer(editForm.getC()), // int argSectC,
				new Integer(editForm.getD()), // int argSectD,
				new Integer(editForm.getE()), // int argSectE,
				new Integer(editForm.getF()), // int argSectF,
				new Integer(editForm.getG()), // int argSectG,
				new Integer(editForm.getH()), // int argSectH,
				editForm.getNfsId(), // java.lang.String argNFSId,
				new Integer(editForm.getCodenri()), // int argCodeNRI
				theVoltageVal, // java.math.BigDecimal argVoltage,
				new Integer(editForm.getSect_o900()), // int argSect_o900,
				new Integer(editForm.getSect_o900()) // int argSect_o1800,
				
			);
			Iterator it = findAllRS.listIterator();
			if (it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				String foundIdStr = ro.getColumn("id").asString();
				if (foundIdStr != null) {
					outIdObject = new Integer(foundIdStr);
				}
			}
		/*		
		} catch (Exception e) {
			editForm.setIsSave(EditBaseStationConfForm.FALSE_STR);
			editForm.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		*/
		return outIdObject;
	}

	private void deleteAction(EditBaseStationConfForm editForm) throws RemoteException, RemoveException, CreateException, FinderException, NamingException {
		ConfBSNfsAccessBean confBSNfsAccessBean = new ConfBSNfsAccessBean();
		try {
			confBSNfsAccessBean.setInitKey_id(Integer.parseInt(editForm.getId())); 
			confBSNfsAccessBean.refreshCopyHelper();
			confBSNfsAccessBean.getEJBRef().remove();
		} catch (Exception e) {
			editForm.setIsSave(EditBaseStationConfForm.FALSE_STR);
			editForm.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}

	}

	private void addAction(EditBaseStationConfForm editForm) throws NumberFormatException, RemoteException, CreateException, FinderException, NamingException {
		if (checkTheSameConfig(editForm) != null) {
			editForm.setIsSave(EditBaseStationConfForm.FALSE_STR);
			editForm.setErrorMsg(THIS_CONFOG_ALREADY_EXIST);
			return;
		}	 
		// try {
			KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
			int newConfbsnfs = keyGen.getNextKey("tables.confbsnfs");
			ConfBSNfsAccessBean confBSNfsAccessBean = new ConfBSNfsAccessBean(
				newConfbsnfs, // int argId,
				Integer.parseInt(editForm.getCodenri()), // int argCodeNri,
				Integer.parseInt(editForm.getA()), // int argSectorA,
				Integer.parseInt(editForm.getB()), // int argSectorB,
				Integer.parseInt(editForm.getC()), // int argSectorC,
				Integer.parseInt(editForm.getD()), // int argSectorD,
				Integer.parseInt(editForm.getE()), // int argSectorE,
				Integer.parseInt(editForm.getF()), // int argSectorF,
				Integer.parseInt(editForm.getG()), // int argSectorG,
				Integer.parseInt(editForm.getH()), // int argSectorH,
				editForm.getNfsId(),               // java.lang.String argNfsItemId,
			    editForm.getConftype(),			   // java.lang.String argConfType
				Integer.parseInt(editForm.getSect_o900()),
				Integer.parseInt(editForm.getSect_o1800())
			);
			if ((editForm.getVoltage() != null) && (editForm.getVoltage().length() > 0)) {
				confBSNfsAccessBean.setVoltage(new BigDecimal(editForm.getVoltage()));
			}
			//
			confBSNfsAccessBean.commitCopyHelper();
			editForm.setId(new Integer(newConfbsnfs).toString());
		/*	
		} catch (Exception e) {
			editForm.setIsSave(EditBaseStationConfForm.FALSE_STR);
			editForm.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		*/
	}

}
