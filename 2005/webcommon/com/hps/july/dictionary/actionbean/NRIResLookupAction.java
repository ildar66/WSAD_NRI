/*
 * Created on 04.12.2006
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.dictionary.formbean.NRIResLookupForm;
import com.hps.july.web.util.ParamsParser;

/**
 * @author irogachev
 */
public class NRIResLookupAction extends Action {

	public NRIResLookupAction() {
		super();
	}

	public ActionForward perform(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response) 
									throws IOException, ServletException
	{
		NRIResLookupForm editForm = (NRIResLookupForm)form;
		ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
		return mapping.findForward("main");	
	}

}
