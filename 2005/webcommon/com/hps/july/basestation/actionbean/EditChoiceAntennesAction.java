package com.hps.july.basestation.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
import com.hps.july.basestation.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик входа в форму выбора антенн для сектора базовой станции
 */
public class EditChoiceAntennesAction
	extends com.hps.july.web.util.NavigatedAction
{
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	super.perform(mapping, form, request, response);
    AntennesChoiceForm editForm = (AntennesChoiceForm) form;
    if (editForm != null) {
        editForm.setReturnPage("");
        if (mapping.findForward("errorgoback") != null)
            editForm.setReturnPage(mapping.findForward("errorgoback").getPath());
        try {
            editForm.setAction("Edit");
            editForm.initEditRecord(request);
            ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
        } catch (Exception e) {
            DebugSupport.printlnError(e);
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
            saveErrors(request, errors);
            return mapping.findForward("errorgoback");
        }

    } else {
        ActionErrors errors = new ActionErrors();
        DebugSupport.println("editForm==null");
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.init"));
        saveErrors(request, errors);

        /* DD
        if (StateManager.hasReturnHref(request)) {
            StateManager.redirectToReturnPage(request, response);
            return null;
        }
        */
        return mapping.findForward("errorgoback");
    }
    return mapping.findForward("main");
}
}
