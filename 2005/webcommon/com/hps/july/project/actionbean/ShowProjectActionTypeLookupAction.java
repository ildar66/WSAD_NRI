package com.hps.july.project.actionbean;

import javax.servlet.*; 
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.project.APPStates;
import com.hps.july.project.formbean.*;

/**
 * Обработчик lookup по выбору типа событий проектов.
 * Creation date: (25.09.2002 18:01:10)
 * @author: Maksim Gerasimov
 */
public class ShowProjectActionTypeLookupAction extends com.hps.july.web.util.LookupBrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ProjectActionTypeAccessBean";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws java.io.IOException, ServletException {

    try {
        ActionsProjectForm form1 =
            (ActionsProjectForm) request.getSession().getAttribute("actionsProjectEdit");
        ActionsProjectListForm form2 =
            (ActionsProjectListForm) request.getSession().getAttribute(
                "actionsProjectForm");

        ProjectActionTypeLookupForm myForm = (ProjectActionTypeLookupForm) form;

        myForm.setProjecttype(form2.getProjecttype());
        myForm.setProjectactiontype(form1.getProjectActionType_Code());
    } catch (Exception e) {
        throw new ServletException(e);
    }

    super.perform(mapping, form, request, response);

    ParamsParser.setState(
        request,
        Applications.PROJECT,
        APPStates.PROJECTACTIONTYPELOOKUP);
    return mapping.findForward("main");
}
}
