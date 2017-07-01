package com.hps.july.project.actionbean;

import com.hps.july.project.formbean.DivisionListForm;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.project.*;
import java.io.IOException;
import com.hps.july.persistence.*;

/**
 * Обработчик lookup выбора событий типа проектов.
 * Creation date: (25.09.2002 18:01:10)
 * @author: Maksim Gerasimov
 */
public class ShowActionsProjectLookupAction
    extends com.hps.july.web.util.LookupBrowseAction {
    public Object constructRowModelBean(Object o) {
        ProtoActionAccessBean bean = (ProtoActionAccessBean) o;
        try {

            return new com.hps.july.project.ProtoActionAdv(bean);
        } catch (Exception e) {
            Util_Alex.pr(e, "constructRowModelBean", this);
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
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.PROJECT, APPStates.ACTIONSPROJECTLOOKUP );
		return mapping.findForward( "main" );
}
}
