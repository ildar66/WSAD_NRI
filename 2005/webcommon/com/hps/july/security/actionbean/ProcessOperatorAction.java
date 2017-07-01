/*
 * Created on 24.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.security.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.security.formbean.OperatorForm;
import com.hps.july.web.util.AbstractProcessAction;
import com.hps.july.web.util.ParamsParser;

/**
 * @author dkrivenko
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProcessOperatorAction extends AbstractProcessAction {


	public ActionForward perform(ActionMapping mapping, ActionForm actionForm, 
		HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		OperatorForm form = (OperatorForm) actionForm;
				
		// call generatePassword	
		if (request.getParameter("generatePassword.x") != null)
			return generatePassword(mapping, actionForm, request, response);
			
		form.setValidated(true);	
		return super.perform(mapping, actionForm, request, response);	
	}

	public ActionForward generatePassword(ActionMapping mapping, ActionForm actionForm, 
		HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			try {
				OperatorForm form = (OperatorForm) actionForm;
				form.generatePassword();
				// изврат с переменной сохранения статуса
				form.setValidated(false);
				// почему-то коллекции не инициализируеюся когда выброшен 
				// ValidateException и коллекция errors не содержит записей.  
				form.initCollections(request);
				
				return super.perform(mapping, actionForm, request, response);
			} catch (Exception e){
				throw new ServletException(e);
			}
	} 

}
