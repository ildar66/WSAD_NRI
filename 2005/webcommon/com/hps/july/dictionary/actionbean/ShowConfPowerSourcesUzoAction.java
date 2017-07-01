/*
 * Created on 28.12.2006
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.dictionary.formbean.ConfPowerSourcesForm;

/**
 * @author irogachev
 */
public class ShowConfPowerSourcesUzoAction extends ShowConfPowerSourcesAction {

	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {
		request.getSession().setAttribute(ConfPowerSourcesForm.POWER_SOURCE_TYPE_VAR, 
			ConfPowerSourcesForm.UZO_POWER_SOURCE_TYPE);
		return super.perform(mapping, form, request, response);
	}    	

}
