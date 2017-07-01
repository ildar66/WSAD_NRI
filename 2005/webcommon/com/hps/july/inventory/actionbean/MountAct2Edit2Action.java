package com.hps.july.inventory.actionbean;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.PropertyUtils;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.objects.CDBCInventoryDocumentError;
import com.hps.july.constants.Applications;
import com.hps.july.inventory.APPStates;
import com.hps.july.inventory.formbean.MountAct2Form2;
import com.hps.july.inventory.formbean.MountActBean;
import com.hps.july.inventory.formbean.MountActControlButtonBean;
import com.hps.july.inventory.formbean.MountActDocPositionBean;
import com.hps.july.inventory.formbean.MountActDocPositionListBean;
import com.hps.july.inventory.service.MountActService;
import com.hps.july.inventory.service.MountActServiceImpl;
import com.hps.july.inventory.service.MountActVisualTypeService;
import com.hps.july.inventory.service.MountActVisualTypeServiceImpl;
import com.hps.july.inventory.sessionbean.DocumentProcessingException;
import com.hps.july.inventory.valueobject.Resource;
import com.hps.july.persistence.AssemblingActAccessBean;
import com.hps.july.persistence.EquipmentSetAccessBean;
import com.hps.july.persistence.InternalWayBillAccessBean;
import com.hps.july.util.AppUtils;
import com.hps.july.utils.Logger;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.FormatUtils;
import com.hps.july.web.util.JulyNavigateTool;
import com.hps.july.web.util.NavigatedAction;
import com.hps.july.web.util.ParamsParser;
import com.hps.july.web.util.ValidateUtils;

/**
 * @author dimitry
 * Created 10.04.2006
 */
public class MountAct2Edit2Action extends NIDocumentProcessAction {
	
	// singleton
	protected MountActService mountActService = new MountActServiceImpl();
	protected MountActVisualTypeService mountActVisualTypeService = new MountActVisualTypeServiceImpl();
	
	protected Logger logger = new Logger(this.getClass());
	
	/**
	 * ћетод по умолчанию. «агрузка документа, если передан documentId (form.document)
	 */
	public ActionForward perform(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// добавление оборудовани€ в форму
		if (request.getParameter("addResourceAction.x") != null)
			return addDocPosition(mapping, actionForm, request, response);
		// delete docPositions
		if (request.getParameter("deleteResourceAction.x") != null)
			return deleteDocPosition(mapping, actionForm, request, response);
		// save document
		if (request.getParameter("saveAction.x") != null)
			return saveOrUpdateMountAct(mapping, actionForm, request, response);
		// update page
		if (request.getParameter("updateAction.x") != null)
			return show(mapping, actionForm, request, response);
		// document counting
		if (request.getParameter("documentCountingAction.x") != null)
			return documentCounting(mapping, actionForm, request, response, false);
		// document counting with auto correct
		if (request.getParameter("documentCountingWithAutoCorrectAction.x") != null)
			return documentCounting(mapping, actionForm, request, response, true);
		// document counting with auto correct
		if (request.getParameter("cancelDocumentCountingAction.x") != null)
			return cancelDocumentCounting(mapping, actionForm, request, response);
		// for delete
		MountAct2Form2 editForm = (MountAct2Form2)actionForm;
		if ((editForm.getAction().equals("Delete")) && (editForm.isDeleteConfirm())) {
			// System.out.println("### delete performs ");
			editForm.setDeleteConfirm(false);
			ActionErrors actionErrors = new ActionErrors();
			try {
				return processDelete(mapping, request, actionErrors, editForm);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
			
		return loadMountAct(mapping, actionForm, request, response);  
	}
	
	protected ActionForward loadMountAct(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// set default values
		MountAct2Form2 form = (MountAct2Form2) actionForm;
		int defaultOwner = AppUtils.getNamedValueInt("INVENTORY_DEFOWNER");
		if (defaultOwner != 0) form.getMountAct().setOwnerCode(new Integer(defaultOwner));

		// TODO preValidate
		ActionErrors errors = new ActionErrors();
		
		// load
		if (form.getDocument() != null){
			try {
				form.setMountAct(mountActService.loadMountActBean(form.getDocument()));
			} catch (Exception e) {
				logger.error("Exception while loading mountActDocument: (documentId=" + form.getDocument() + ") :" + e.getMessage(),e);
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mountAct2.load", e.getClass().getName()));
			}
		}
		
		return show(mapping, form, request, response);
	}
	

	/**
	 * «апускает обсчет документа 
	 * @param isAutoCorrect - признак обсчета с автоматическим исправлением несоответствий
	 */
	protected ActionForward documentCounting(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response, boolean isAutoCorrect) throws IOException, ServletException {
		
		MountAct2Form2 form = (MountAct2Form2) actionForm;
		saveOrUpdateMountAct(mapping, actionForm, request, response);
		ActionErrors errors = (ActionErrors) request.getAttribute(ERROR_KEY);
		if (errors == null) errors = new ActionErrors();
		
		if (errors.empty()) {
			try {
				// ”далим старые ошибки обсчета оборудовани€
				CDBCInventoryDocumentError cdbcIDER= new CDBCInventoryDocumentError();
				cdbcIDER.clearDocumentErrors(form.getMountAct().getDocumentId());
				
				mountActService.startDocumentCounting(form.getDocument(), isAutoCorrect);
				return loadMountAct(mapping, form, request, response); 
			} catch (DocumentProcessingException e) {
				if (e.getErrorCode() == 7){
					request.setAttribute("IS_COUNTING_WARNING_PRESENT", new Boolean(true));
				}
				translateDocumentProcessingErrors(errors, e, form.getDocument());
			} catch (Exception e) {
				logger.error("Exception while document counting: (documentId=" + form.getDocument() + ") :" + e.getMessage(),e);
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mountAct2.startCounting", e.getClass().getName()));
			}
		}

		saveErrors(request, errors);
		return show(mapping, form, request, response);
	}
	
	/**
	 * —н€тие обсчета с документа 
	 */
	protected ActionForward cancelDocumentCounting(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		MountAct2Form2 form = (MountAct2Form2) actionForm;
		ActionErrors errors = new ActionErrors();
		
		try {
			// ”далим старые ошибки обсчета оборудовани€
			CDBCInventoryDocumentError cdbcIDER= new CDBCInventoryDocumentError();
			cdbcIDER.clearDocumentErrors(form.getMountAct().getDocumentId());
			
			mountActService.cancelDocumentCounting(form.getDocument());
			return loadMountAct(mapping, form, request, response);
		} catch (DocumentProcessingException e) {
			translateDocumentProcessingErrors(errors, e, form.getDocument());
		} catch (Exception e) {
			logger.error("Exception while document counting: (documentId=" + form.getDocument() + ") :" + e.getMessage(),e);
		}
		
		saveErrors(request, errors);
		return show(mapping, form, request, response);
	}	
	

	
	
	/**
	 * —охранение или обновление документа
	 */
	protected ActionForward saveOrUpdateMountAct(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		MountAct2Form2 form = (MountAct2Form2) actionForm;
		ActionErrors errors = form.validate(mapping, request);
		
		if (errors.empty()){
			// TODO где должна быть валидаци€ логики перед сохранением? 
			// нужно подумать над системой обработки ошибок дл€ ejb
			MountActBean mountAct = form.getMountAct();
			if (!validateMountActComplectCode(mountAct.getComplectCode()))
				errors.add("mountAct.complectCode", new ActionError("error.mountact2.bad.complectCode"));
			
			
// TODO validate logic:

//			 TODO
//					CDBCComProjectsObject cpob = new CDBCComProjectsObject();
//					if (cpob.checkProject(getComplectcode())) {
//						setProjectid(cpob.getProjectid());
//						setProjectname(cpob.getProjectname());
//						setNeedapprove(cpob.isNeedapprove());
//					} else {
//						setProjectid(cpob.getProjectid());
//						setProjectname(cpob.getProjectname());
//						setNeedapprove(cpob.isNeedapprove());
//						errors.add("head", new ActionError("error.mountact2.invalid.project"));
//					}

					
//			 TODO валидаци€ ресурсов перед сохранением		
			//
//					String policy = "";
//					// ѕроверим ресурс			
//					try {
//						int bi = argResource.intValue();
//						ResourceAccessBean res = new ResourceAccessBean();
//						res.setInitKey_resource(bi);
//						res.refreshCopyHelper();
//						policy = res.getCountpolicy();
//					} catch (Exception e) {
//						errors.add(editPos, new ActionError("error.mountact2.bad.resource"));
//					}

//			 TODO validate providerCode		
//					try {
//						OrganizationAccessBean org = new OrganizationAccessBean();
//						org.setInitKey_organization(si.getInteger().intValue());
//						org.refreshCopyHelper();
//						setProvidername(org.getName());
//					} catch (Exception ee) {
//						errors.add("podr", new ActionError("error.mountact2.bad.podrcode"));
//					}

//			 TODO workerCode		
//					try {
//						WorkerAccessBean wrk = new WorkerAccessBean();
//						wrk.setInitKey_worker(si.getInteger().intValue());
//						wrk.refreshCopyHelper();
//						PeopleAccessBean ppl = wrk.getMan();
//						setWorkername(ppl.getLastname() + " " + ppl.getFirstname() + " " + ppl.getMiddlename());
//						setWorkertitle(wrk.getPosition().getName());
//					} catch (Exception ee) {
//						errors.add("worker", new ActionError("error.mountact2.bad.worker"));
//					}

			if (errors.empty())
				try {
					mountActService.saveOrUpdateMountActBean(form.getMountAct());
					return show(mapping, actionForm, request, response);
				} catch (Exception e) {
					logger.error("Exception while save mountActDocument: " + e.getMessage(),e);
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mountAct2.save", e.getClass().getName()));
					form.getMountAct().setDocumentId(null);
				}
		}

		saveErrors(request, errors);
		return show(mapping, actionForm, request, response);
	}

	protected boolean validateMountActComplectCode(Integer complectCode){
		if (complectCode == null) return false;
		
		try {
			EquipmentSetAccessBean eab = new EquipmentSetAccessBean();
			eab.setInitKey_storageplace(FormatUtils.toInt(complectCode));
			eab.refreshCopyHelper();
		} catch (FinderException e) {
			return false;
		} catch (Exception e) {
			logger.error("Exception while found complect: " + e.getMessage(),e);
			return false;
		}
		
		return true;
	}



	/**
	 * ƒобавление в форму строки docPosition
	 */
	protected ActionForward addDocPosition(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		MountAct2Form2 form = (MountAct2Form2) actionForm;
		ActionErrors errors = new ActionErrors();
		
		MountActControlButtonBean controlBean = form.getControlButton(form.getControlButtonIndex());

		if (ValidateUtils.isEmpty(controlBean.getResourceId()))
			errors.add("controlButton[" + form.getControlButtonIndex() + "].resourceId", 
					new ActionError("error.mountact2.bad.resourceId"));
		
		if (errors.empty()){
			Resource resource = mountActService.getResource(controlBean.getResourceId());
			
			MountActDocPositionBean bean = new MountActDocPositionBean();
			bean.setResource(resource);
			bean.setCategoryId(controlBean.getCategoryId());
			// set default values
			bean.setSubdivisionInventoryNumberExist(true);
			
			try {
				MountActDocPositionListBean beanList = (MountActDocPositionListBean) PropertyUtils.getProperty(form, controlBean.getParentPath() + "docPositions");
				beanList.add(bean);
			} catch (Exception e) {
				// TODO add error?
				logger.error("Exception while add docPosition: " + e.getLocalizedMessage(),e);
			}
		} else {
			saveErrors(request, errors);
		}
		
		return show(mapping, actionForm, request, response);
	}

	/**
	 * ”даление из формы строки docPosition
	 */
	protected ActionForward deleteDocPosition(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		MountAct2Form2 form = (MountAct2Form2) actionForm;
		// TODO validate
		MountActControlButtonBean controlBean = form.getControlButton(form.getControlButtonIndex());

		try {
			MountActDocPositionListBean beanList = (MountActDocPositionListBean) PropertyUtils.getProperty(form, controlBean.getParentPath() + "docPositions");
			beanList.remove(controlBean.getPositionIndex().intValue());
		} catch (Exception e) {
			// TODO add error message
			logger.error("Exception while remove docPosition: " + e.getMessage() + 
					" [positionIndex=" + controlBean.getPositionIndex() + ",parentPath=" + controlBean.getParentPath() + "]",e);
		}
		
		return show(mapping, actionForm, request, response);
	}

	/**
	 * ѕодготовка к отображению формы
	 */
	protected ActionForward show(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ParamsParser.setState(request, Applications.INVENTORY, APPStates.MOUNT_ACT2_FORM);
		JulyNavigateTool.executeNavigate(mapping, actionForm, request, getServlet());

		MountAct2Form2 form = (MountAct2Form2) actionForm;
		
		List bcResourceCategories = mountActService.prepareRootCategoryList();
		request.setAttribute("rootCategoryList", bcResourceCategories);

		request.setAttribute("SERIAL_STOCK_TAKING_TYPE", Resource.SERIAL_STOCK_TAKING_TYPE);
		request.setAttribute("QUANTITY_STOCK_TAKING_TYPE", Resource.QUANTITY_STOCK_TAKING_TYPE);
		
		MountActBean actBean = form.getMountAct();
		
		// if parameter "positioncode" defined:
		if (actBean.getPositionCode() != null){
			List BSResSetList = mountActService.getBSResSetFromPosition(form.getMountAct().getPositionCode());
			request.setAttribute("bsResSetList", BSResSetList);
		}
		
		// initialize complects
		else {
			// if posNumber changed
//			if (actBean.getPosNumber() != null && !actBean.getPosNumber().equals(form.getOldPosNumber())) {
//				actBean.setComplectCode(null);
//				actBean.setComplectName("");
//			} 
			
			List complects = mountActService.getComplects(actBean.getPosNumber(), 
					request.getRemoteUser(), request.isUserInRole("administrator") ? Boolean.TRUE : Boolean.FALSE);

			if (!complects.isEmpty() && complects.size() == 1)
				request.setAttribute("complect", complects.get(0));
			else request.setAttribute("complects", complects);
			
			
		}
	
		Enumeration owners = mountActService.getOwnerList();
		request.setAttribute("owners", owners);
		request.setAttribute("visualType", mountActVisualTypeService.getVisualType(actBean.getVisualType()));

		if (form.getMountAct().isCountingState()){
			// set DISABLED_MODE for old july tags
			form.setAction("View");
		}
		
		request.setAttribute("form", actionForm);
	    return mapping.findForward("main");
	}

	public ActionForward processDelete( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	// public ActionForward processDelete(HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
		// System.out.println("### processDelete 001");
		MountAct2Form2 meditForm = (MountAct2Form2)editForm;
		/*
		// AssemblingActAccessBean bean = new AssemblingActAccessBean();
		InternalWayBillAccessBean bean = new InternalWayBillAccessBean();
		// AssemblingActAccessBean
		System.out.println("### processDelete meditForm.getDocument().intValue() = " + meditForm.getDocument().intValue());
		bean.setInitKey_document(meditForm.getDocument().intValue());
		bean.refreshCopyHelper();
		bean.getEJBRef().remove();
		*/
		
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery("EXECUTE PROCEDURE DeleteDocument(?)", new Object[] {meditForm.getDocument()});

		// System.out.println("### processDelete 003");
		return mapping.findForward("success");
	}

}
