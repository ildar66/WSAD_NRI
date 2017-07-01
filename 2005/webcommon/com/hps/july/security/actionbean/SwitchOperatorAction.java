package com.hps.july.security.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.constants.Applications;
import com.hps.july.security.APPStates;
import com.hps.july.security.formbean.SwitchOperatorForm;
import com.hps.july.security.service.JulySecurityException;
import com.hps.july.security.service.JulySecurityService;
import com.hps.july.security.service.JulySecurityServiceImpl;
import com.hps.july.web.util.NavigatedAction;
import com.hps.july.web.util.ParamsParser;

/**
 * @author dkrivenko
 */
public class SwitchOperatorAction extends NavigatedAction {

	protected JulySecurityService securityService = new JulySecurityServiceImpl();

	public ActionForward perform(ActionMapping mapping, ActionForm actionForm,
		HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		SwitchOperatorForm form = (SwitchOperatorForm) actionForm;	
		
		System.out.println(request.getParameter("action"));	
			
		if (request.getParameter("action") != null && 
			request.getParameter("action").equals("Enter"))
			return switchOperator(mapping, actionForm, request, response);
		
		return show(mapping, actionForm, request, response);
	}
	
	

	public ActionForward show(ActionMapping mapping, ActionForm actionForm,
		HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ParamsParser.setState(request, Applications.SECURITY, APPStates.SWITCH_OPERATOR);
		super.perform(mapping, actionForm, request, response);

		return mapping.findForward("main");
	}
	
	
		
	public ActionForward switchOperator(ActionMapping mapping, ActionForm actionForm,
		HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		SwitchOperatorForm form = (SwitchOperatorForm) actionForm;
		ActionErrors errors = form.validate(mapping, request);
		
		if (errors.empty()){
			String operatorLogin = form.getOperatorLogin();
			
			try {
				request.getSession().invalidate();
				securityService.switchOperator(operatorLogin);
				return success(mapping, form, request, response);	
			} catch (JulySecurityException e){
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.switchOperator.JulySecurityException"));
			}
		}

		saveErrors(request, errors);
		return show(mapping, form, request, response);
	}



	public ActionForward success(ActionMapping mapping, ActionForm actionForm,
		HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ParamsParser.setState(request, Applications.SECURITY, APPStates.MAIN);
		super.perform(mapping, actionForm, request, response);

		return mapping.findForward("main");
	}


}
