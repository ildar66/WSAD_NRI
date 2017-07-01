/*
 * Created on 09.01.2007
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

import com.hps.july.dictionary.formbean.ShowConfBaseStationForm;
import com.hps.july.web.util.NavigatedAction;
import com.hps.july.web.util.ParamsParser;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowConfBaseStationAction extends NavigatedAction {

	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ShowConfBaseStationForm theForm = (ShowConfBaseStationForm)form;
		theForm.setupIsAdminRole(request);
		if (ShowConfBaseStationForm.TRUE_STR.equals(theForm.getIsStandPrepareProcess())) {
			theForm.prepareStandList();
			theForm.setIsStandPrepareProcess(ShowConfBaseStationForm.FALSE_STR);
		}
		if (ShowConfBaseStationForm.TRUE_STR.equals(theForm.getIsBaseStationCurComplectPrepareProcess())) {
			theForm.prepareBaseStationCurComplectList();
			theForm.setIsBaseStationCurComplectPrepareProcess(ShowConfBaseStationForm.FALSE_STR);
		}
		ParamsParser.setState(request, theForm.getApplication(), theForm.getState());
		return mapping.findForward("main");
	}    	

}
