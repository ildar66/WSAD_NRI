package com.hps.july.security.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author dkrivenko
 */
public class SwitchOperatorForm extends ActionForm {

	private String operatorLogin;

	/**
	 * @return
	 */
	public String getOperatorLogin() {
		return operatorLogin;
	}

	/**
	 * @param string
	 */
	public void setOperatorLogin(String string) {
		operatorLogin = string;
	}
	
	public ActionErrors validate(ActionMapping action, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		if (operatorLogin == null || operatorLogin.equals(""))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.login"));
		
		return errors;
	}


}
