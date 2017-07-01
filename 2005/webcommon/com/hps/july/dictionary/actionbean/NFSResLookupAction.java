/*
 * Created on 24.11.2006
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

import com.hps.july.dictionary.formbean.NFSResLookupForm;
import com.hps.july.web.util.ParamsParser;

/**
 * @author irogachev
 */
public class NFSResLookupAction extends Action // NFSRes2NRIResAction 
												{

	public NFSResLookupAction() {
		super();
	}
	
	public ActionForward perform(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response) 
									throws IOException, ServletException
	{
		NFSResLookupForm editForm = (NFSResLookupForm)form;
		ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
		return mapping.findForward("main");	
	}
 
}
