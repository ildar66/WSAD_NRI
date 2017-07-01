/*
 * Created on 01.12.2006
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.dictionary.formbean.ConfPowerSourcesForm;
import com.hps.july.dictionary.formbean.EditPowerResourceForm;
import com.hps.july.persistence.ResourceSetPartAccessBean;
import com.hps.july.util.ErrorProcessor;
import com.hps.july.web.util.ParamsParser;

/**
 * @author irogachev
 */
public class EditPowerResourceAction extends Action {

	public EditPowerResourceAction() {
		super();
	}

	public ActionForward perform(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response) 
									throws IOException, ServletException
	{
		ActionErrors errors = new ActionErrors();
		//
		EditPowerResourceForm editForm = (EditPowerResourceForm)form;
		ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
		try {
			if (ConfPowerSourcesForm.TRUE_STR.equals(editForm.getIsSave())) {
				System.out.println("### EditPowerResourceAction isSave");
				doAction(editForm, request);
			}
			if (ConfPowerSourcesForm.TRUE_STR.equals(editForm.getIsLoadFromDB())) {
				editForm.loadFromDB();
				editForm.setIsLoadFromDB(ConfPowerSourcesForm.FALSE_STR);
			}
		} catch (Exception e) {
			editForm.setIsSave(EditPowerResourceForm.FALSE_STR);
			ErrorProcessor.processException(errors, e);
		}
		//process errors
		if( !errors.empty() ) {
			saveErrors(request, errors);
		}
		return mapping.findForward("main");	
	}

	private void doAction(EditPowerResourceForm editForm, HttpServletRequest request) throws RemoteException, RemoveException, CreateException, FinderException, NamingException {
		if (EditPowerResourceForm.ACTION_ADD.equals(editForm.getAction())) {
			addAction(editForm, request);
		} else if (EditPowerResourceForm.ACTION_EDIT.equals(editForm.getAction())) {
			updateAction(editForm, request);
		} else if (EditPowerResourceForm.ACTION_DELETE.equals(editForm.getAction())) {
			deleteAction(editForm);
		}
	}

	private void updateAction(EditPowerResourceForm editForm, HttpServletRequest request) throws RemoteException, CreateException, FinderException, NamingException {
		ResourceSetPartAccessBean resourceSetPartAccessBean = 
			new ResourceSetPartAccessBean();
		System.out.println("### editForm.getResourceSet() = " + editForm.getResourceSet());	
		resourceSetPartAccessBean.setInitKey_set_resourceset(new Integer(editForm.getResourceSet()));	
		resourceSetPartAccessBean.setInitKey_part_resource(new Integer(editForm.getNriCode()));	
		// try {
			resourceSetPartAccessBean.refreshCopyHelper();
			resourceSetPartAccessBean.setQty(new BigDecimal(editForm.getQuantity()));
			resourceSetPartAccessBean.commitCopyHelper();
			//
			HttpSession theSession = request.getSession();
			ConfPowerSourcesForm confPowerSourcesForm = 
				(ConfPowerSourcesForm)theSession.getAttribute(
					ConfPowerSourcesForm.getFormString(request.getSession()));
			confPowerSourcesForm.setCurResourceSelectedID(editForm.getNriCode());
		/*		
		} catch (Exception e) {
			editForm.setIsSave(ConfPowerSourcesForm.FALSE_STR);
			editForm.setErrorMsg(e.getMessage());
			// System.out.println("### e.getMessage() = " + e.getMessage());	
			e.printStackTrace();
		}
		*/
	}

	private void deleteAction(EditPowerResourceForm editForm) throws RemoteException, RemoveException, CreateException, FinderException, NamingException {
		// try {
			deletePowerResourceRoutine(editForm.getResourceSet(), editForm.getNriCode());
		/*	
		} catch (Exception e) {
			editForm.setIsSave(ConfPowerSourcesForm.FALSE_STR);
			editForm.setErrorMsg(e.getMessage());
			// System.out.println("### e.getMessage() = " + e.getMessage());	
			e.printStackTrace();
		}
		*/
	}

	public static void deletePowerResourceRoutine(String resourceSet, String nriCode) throws RemoteException, RemoveException, CreateException, FinderException, NamingException {
		ResourceSetPartAccessBean resourceSetPartAccessBean = 
			new ResourceSetPartAccessBean();
		resourceSetPartAccessBean.setInitKey_set_resourceset(new Integer(resourceSet));	
		resourceSetPartAccessBean.setInitKey_part_resource(new Integer(nriCode));	
		resourceSetPartAccessBean.refreshCopyHelper();
		resourceSetPartAccessBean.getEJBRef().remove();
	}

	private void addAction(EditPowerResourceForm editForm, HttpServletRequest request) throws NumberFormatException, RemoteException, CreateException, FinderException, NamingException {
		ResourceSetPartAccessBean resourceSetPartAccessBean = 
			new ResourceSetPartAccessBean();
		resourceSetPartAccessBean.setInitKey_set_resourceset(new Integer(editForm.getResourceSet()));	
		resourceSetPartAccessBean.setInitKey_part_resource(new Integer(editForm.getNriCode()));	
		try {
			resourceSetPartAccessBean.refreshCopyHelper();
			// Если нашли, то это уже есть			
			editForm.setIsSave(ConfPowerSourcesForm.FALSE_STR);
			editForm.setErrorMsg("Такой ресурс уже находится в комплекте!");
		} catch (Exception e) {
			// если не нашли, то создаем
			// try {
				ResourceSetPartAccessBean newResourceSetPartAccessBean = 
					new ResourceSetPartAccessBean(
						new Integer(editForm.getResourceSet()), 
						new Integer(editForm.getNriCode()), 
						new BigDecimal(editForm.getQuantity()));
				newResourceSetPartAccessBean.commitCopyHelper();
				HttpSession theSession = request.getSession();
				ConfPowerSourcesForm confPowerSourcesForm = 
					(ConfPowerSourcesForm)theSession.getAttribute(
						ConfPowerSourcesForm.getFormString(request.getSession()));
				confPowerSourcesForm.setCurResourceSelectedID(editForm.getNriCode());
			/*		
			} catch (Exception innerEx) {
				editForm.setIsSave(ConfPowerSourcesForm.FALSE_STR);
				editForm.setErrorMsg(innerEx.getMessage());
				innerEx.printStackTrace();
			}
			*/	
		}
	}

}

