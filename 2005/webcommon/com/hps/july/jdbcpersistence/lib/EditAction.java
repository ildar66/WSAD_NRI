package com.hps.july.jdbcpersistence.lib;

import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Стандартный EditAction с небольшими отличиями.
 * Creation date: (05.07.2003 17:19:42)
 * @author: Alexander Shrago
 */
public class EditAction extends com.hps.july.web.util.AbstractEditAction {
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

	navigate(mapping, form, request, response);
	    
    EditForm editForm = (EditForm) form;
    if (editForm != null) {
        editForm.setReturnPage("");
        if (mapping.findForward("errorgoback") != null)
            editForm.setReturnPage(mapping.findForward("errorgoback").getPath());
        try {
            editForm.initCollections(request);
        } catch (Exception e) {
	        DebugSupport.printlnError(e);
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
            saveErrors(request, errors);
            return mapping.findForward("errorgoback");
        }
        if ("Add".equals(editForm.getAction())) {
            try {
                editForm.initRecord(request);
                ParamsParser.setState(request, editForm.getApplication(), editForm.getState());

            } catch (Exception e) {
                DebugSupport.printlnError(e);
                ActionErrors errors = new ActionErrors();
                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
                saveErrors(request, errors);
                return mapping.findForward("errorgoback");
            }
        } else if (
            "Edit".equals(editForm.getAction())
                || "Delete".equals(editForm.getAction())
                || "View".equals(editForm.getAction())) {
            try {
                AbstractEntityAccessBean bean = editForm.getDataBean(request);
                com.hps.july.util.BeanUtils.copyProperties(editForm, bean);
                editForm.fillRecord(bean);
                ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
            } catch (Exception e) {
	            DebugSupport.printlnError(e);
                ActionErrors errors = new ActionErrors();
                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.absent"));
                saveErrors(request, errors);
                return mapping.findForward("errorgoback");
            }
        } else {
            System.out.println("Unknown action=" + editForm.getAction());
            ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
        }
    } else {
        ActionErrors errors = new ActionErrors();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
        saveErrors(request, errors);
        return mapping.findForward("errorgoback");
    }
    return mapping.findForward("main");
}
}
