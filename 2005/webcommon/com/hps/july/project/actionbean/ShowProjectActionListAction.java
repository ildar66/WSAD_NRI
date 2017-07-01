package com.hps.july.project.actionbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications; //Заменить BeanName
import com.hps.july.project.APPStates;
import com.hps.july.project.formbean.*;
import com.hps.july.project.*;
import com.hps.july.project.valueobject.*;
import com.hps.july.persistence.*;
import java.io.IOException;

/**
 * Обработчик списка событий проекта.
 * Creation date: (25.09.2002 18:01:10)
 * @author: Maksim Gerasimov
 */
public class ShowProjectActionListAction
    extends com.hps.july.web.util.BrowseAction {
public Object constructRowModelBean(Object o) {
	if (o instanceof ProjectActionAccessBean) {
	    ProjectActionAccessBean bean = (ProjectActionAccessBean) o;
	    try {
	    	bean.refreshCopyHelper();
	        return new com.hps.july.project.ProjectActionAdv(bean);
	    } catch (Exception e) {
	        Util_Alex.pr(e, "constructRowModelBean",this);
	    }
	    return null;
	} else {
		return o;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.project.formbean.ProjectActionListForm";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {

	    
	request.setAttribute("resources",getServlet().getResources());   

    ActionErrors errors = new ActionErrors();
    ProjectActionListForm pform = (ProjectActionListForm)form;

    // Check for accept request
    if (request.getParameter("accept.x") != null) {
	    // Accept new plan date
	    System.out.println("PROJECT: accepting date for prjaction=" + pform.getAcceptcode());
	    try {
		    ProjectActionObject.changePlanDate(pform.getAcceptcode(), true);
	    } catch (Exception e) {
		    e.printStackTrace(System.out);
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.projectaction.accept"));
	    }
    }
    
    // Check for accept all dates request
    if (request.getParameter("acceptall.x") != null) {
	    // Accept all new plan dates
	    System.out.println("PROJECT: accepting all dates");
	    try {
		    ProjectActionObject.changeAllPlanDates(true, new Integer(pform.getProjectParameter()));
	    } catch (Exception e) {
		    e.printStackTrace(System.out);
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.projectaction.acceptall"));
	    }
    }
    
    // Check for reject request
    if (request.getParameter("reject.x") != null) {
	    // Reject new plan date
	    System.out.println("PROJECT: rejecting date for prjaction=" + pform.getAcceptcode());
	    try {
		    ProjectActionObject.changePlanDate(pform.getRejectcode(), false);
	    } catch (Exception e) {
		    e.printStackTrace(System.out);
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.projectaction.reject"));
	    }
    }
    
    // Check for reject all dates request
    if (request.getParameter("rejectall.x") != null) {
	    // Reject all new plan dates
	    System.out.println("PROJECT: rejecting all dates");
	    try {
		    ProjectActionObject.changeAllPlanDates(false, new Integer(pform.getProjectParameter()));
	    } catch (Exception e) {
		    e.printStackTrace(System.out);
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.projectaction.rejectall"));
	    }
    }
    
    if (!errors.empty()) 
       saveErrors(request, errors);
       
    super.perform(mapping, form, request, response);
    ParamsParser.setState(request, Applications.PROJECT, APPStates.PROJECTACTIONLIST);
    
    return mapping.findForward("main");
}
}
