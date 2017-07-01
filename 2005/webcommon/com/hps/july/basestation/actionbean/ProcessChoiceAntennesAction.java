package com.hps.july.basestation.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
import com.hps.july.basestation.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик выбора антенн для сектора базовой станции
 */
public class ProcessChoiceAntennesAction
	extends org.apache.struts.action.Action
{
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    DebugSupport.println("ProcessChoiceAntennesAction perform started");
    ActionForward retVal = null;
    ActionErrors errors = new ActionErrors();

    //is canceled
    if (isCancelled(request)) {
        return mapping.findForward("success");
    }

    //process actions
    AbstractEntityAccessBean bean = null;
    AntennesChoiceForm editForm = (AntennesChoiceForm) form;
    if (editForm != null) {
        editForm.setReturnPage("");
        if (mapping.findForward("success") != null)
            editForm.setReturnPage(mapping.findForward("success").getPath());

        try {
            DebugSupport.println("editForm.proccess() started");
            editForm.initProcessRecord(request);
            editForm.proccess();
            DebugSupport.println("editForm.proccess() finished");
            if (retVal == null)
                retVal = mapping.findForward("success");
        } catch (ValidationException e) {
            DebugSupport.printlnError(e);
            if (e instanceof UpdateValidationException)
                ErrorProcessor.processException(errors, e);
            // do nothing 
            ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
            retVal = mapping.findForward("main");
        } catch (Exception e) {
            DebugSupport.printlnError(e);
            e.printStackTrace(System.out);
            ErrorProcessor.processException(errors, e);
            ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
            retVal = mapping.findForward("main");
            retVal = processException(errors, e, editForm, bean, retVal);
        }

        //process errors
        if (!errors.empty()) {
            saveErrors(request, errors);
            ParamsParser.setState(request, editForm.getApplication(), editForm.getState());
            retVal = mapping.findForward("main");
        }
    } else {
        System.out.println("WEB.UTIL.ERROR: edit form is NULL");
        retVal = mapping.findForward("success");

        /* DD
        if (StateManager.hasReturnHref(request)) {

            StateManager.redirectToReturnPage(request, response);
            return null;
        }
        */
    }

    return retVal;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processException( ActionErrors errors, Exception e, EditForm editForm, 
	AbstractEntityAccessBean bean, ActionForward retVal ) {
	return retVal;
}
}
