package com.hps.july.arenda.actionbean;

import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.arenda.APPStates;
import com.hps.july.constants.Applications;
/**
 * Insert the type's description here.
 * Creation date: (02.11.2004 15:57:08)
 * @author: Shafigullin Ildar
 */
public class CompletWorkAktWordAction extends NavigatedAction {
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
public ActionForward perform(
	ActionMapping mapping,
	ActionForm form,
	HttpServletRequest request,
	HttpServletResponse response)
	throws IOException, ServletException {

	super.perform(mapping, form, request, response);

	CompletWorkAktWordForm wordForm = (CompletWorkAktWordForm) form;
	ActionErrors errors = new ActionErrors();
	try {
		wordForm.init();
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
	//return mapping.findForward("print" + wordForm.getWordType());
	return mapping.findForward("print");

}
}
