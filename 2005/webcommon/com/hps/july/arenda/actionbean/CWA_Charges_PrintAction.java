package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.formbean.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
/**
 * Insert the type's description here.
 * Creation date: (16.11.2004 12:09:00)
 * @author: Shafigullin Ildar
 */
public class CWA_Charges_PrintAction extends com.hps.july.web.util.NavigatedAction {
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
/**
 * Process the specified HTTP request, and create the corresponding HTTP
 * response (or forward to another web component that will create it).
 * Return an <code>ActionForward</code> instance describing where and how
 * control should be forwarded, or <code>null</code> if the response has
 * already been completed.
 *
 * @param mapping The ActionMapping used to select this instance
 * @param actionForm The optional ActionForm bean for this request (if any)
 * @param request The HTTP request we are processing
 * @param response The HTTP response we are creating
 *
 * @exception IOException if an input/output error occurs
 * @exception ServletException if a servlet exception occurs
 */
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	
	CWA_Charges_PrintForm printForm = (CWA_Charges_PrintForm) form;
	ActionErrors errors = new ActionErrors();
	
	try {
		printForm.init();
	} catch (Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
		if (e.getMessage() != null)
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e.getMessage()));
		e.printStackTrace(System.out);
	}
	//process errors
	if (!errors.empty()) {
		saveErrors(request, errors);
	}
	
	ParamsParser.setState(request, Applications.ARENDA, APPStates.CWA_CHARGES__PRINT);
	return  mapping.findForward("main");
}
}
