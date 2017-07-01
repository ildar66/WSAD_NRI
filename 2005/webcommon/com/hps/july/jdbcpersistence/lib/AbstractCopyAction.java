package com.hps.july.jdbcpersistence.lib;

import org.apache.struts.action.ActionForward;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
 
/**
 * Action, используемый при копировании записи.
 * Creation date: (22.03.2003 18:30:14)
 * @author: Alexander Shrago
 */
public class AbstractCopyAction extends com.hps.july.web.util.AbstractEditAction {
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

    EditCopyForm bsForm = (EditCopyForm) form;
    bsForm.setAction("Edit");
    bsForm.setPath(mapping.getPath());
    bsForm.prepareCopy(request);
    ActionForward frw = super.perform(mapping, form, request, response);

    /*
    if (frw.equals(mapping.findForward("errorgoback"))
        && StateManager.hasReturnHref(request)) {

        StateManager.redirectToReturnPage(request, response);
        return null;
    }
    //bsForm.prepareCopy(request);
    */
    
    bsForm.setAction("Add");
    return frw;

}
}
