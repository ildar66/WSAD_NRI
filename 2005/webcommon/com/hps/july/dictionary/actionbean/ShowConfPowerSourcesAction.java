/*
 * Created on 20.11.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.constants.Applications;
import com.hps.july.dictionary.formbean.ConfPowerSourcesForm;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.NavigatedAction;
import com.hps.july.web.util.ParamsParser;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class ShowConfPowerSourcesAction extends NavigatedAction {

	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ConfPowerSourcesForm theForm = (ConfPowerSourcesForm)form;
		theForm.setupIsAdminRole(request);
		if (ConfPowerSourcesForm.TRUE_STR.equals(theForm.getIsModelFiltersProcess())) {
			theForm.prepareModelList();
			theForm.setIsModelFiltersProcess(ConfPowerSourcesForm.FALSE_STR);
		}
		if (ConfPowerSourcesForm.TRUE_STR.equals(theForm.getIsComplectSelectProcess())) {
			System.out.println("@@@ ComplectSelectProcess");
			theForm.prapareCurComplectList();
			theForm.setIsComplectSelectProcess(ConfPowerSourcesForm.FALSE_STR);
		}
		ParamsParser.setState(request, theForm.getApplication(), theForm.getState());
		return mapping.findForward("main");
	}    	

}
