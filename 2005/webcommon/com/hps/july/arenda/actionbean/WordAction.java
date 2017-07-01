package com.hps.july.arenda.actionbean;

import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hps.july.arenda.formbean.*;
/**
 * Базовый класс(Action) для формирования документов WORD.
 * Creation date: (11.11.2005 15:34:17)
 * @author: Shafigullin Ildar
 */
public class WordAction extends com.hps.july.web.util.NavigatedAction {
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
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

    super.perform(mapping, form, request, response);

    WordForm wordForm = (WordForm) form;
    ActionErrors errors = new ActionErrors();
    try {
        wordForm.init(request);
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
    return mapping.findForward("printWord");

}
}
