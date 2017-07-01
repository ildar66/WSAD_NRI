package com.hps.july.project.actionbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications; //Заменить BeanName
import com.hps.july.project.APPStates;
import com.hps.july.project.formbean.*;
import com.hps.july.project.*;
import com.hps.july.persistence.*;
import java.io.IOException;

/**
 * Обработчик списка событий типа проектов.
 * Creation date: (25.09.2002 18:01:10)
 * @author: Maksim Gerasimov
 */
public class ShowActionsProjectListAction
    extends com.hps.july.web.util.BrowseAction {
public Object constructRowModelBean(Object o) {
    ProtoActionAccessBean bean = (ProtoActionAccessBean) o;
    try {

        return new com.hps.july.project.ProtoActionAdv(bean);
    } catch (Exception e) {
        Util_Alex.pr(e, "constructRowModelBean",this);
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ProtoActionAccessBean";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    super.perform(mapping, form, request, response);
    ActionsProjectListForm listForm = (ActionsProjectListForm) form;
    int projecttype = listForm.getProjecttype();
    try {
        ProjectTypeAccessBean bean = new ProjectTypeAccessBean();
        bean.setInitKey_projecttype(projecttype);
        bean.refreshCopyHelper();
        request.getSession().setAttribute("projecttypeBean", bean);
    } catch (Exception e) {
        throw new ServletException(e);
    }

    ParamsParser.setState(
        request,
        Applications.PROJECT,
        APPStates.ACTIONSPROJECTLIST);
    return mapping.findForward("main");
}
}
