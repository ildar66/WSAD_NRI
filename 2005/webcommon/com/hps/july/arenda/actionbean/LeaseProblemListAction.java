/*
 * Created on 03.07.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.arenda.formbean.LeaseProblemListForm;
import com.hps.july.web.util.BrowseAction;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeaseProblemListAction extends BrowseAction {
	//константы operation:
	public final static String PRINT_XLS = "printXLS";
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#perform(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LeaseProblemListForm iForm = (LeaseProblemListForm) form;
		if (LeaseProblemListAction.PRINT_XLS.equals(iForm.getOperation())) {
			super.perform(mapping, form, request, response);
			iForm.setOperation("");
			return mapping.findForward(LeaseProblemListAction.PRINT_XLS);
		} else {
			return super.perform(mapping, form, request, response);
		}

	}

}
