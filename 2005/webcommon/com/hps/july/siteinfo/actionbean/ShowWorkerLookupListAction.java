package com.hps.july.siteinfo.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.siteinfo.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик формы выбора сотрудника
 */
public class ShowWorkerLookupListAction extends com.hps.july.web.util.LookupBrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.WorkerAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    WorkerLookupListForm f = (WorkerLookupListForm) form;
    if (request.getParameter("photographerId") != null) {
        try {
            int id = Integer.parseInt(request.getParameter("photographerId"));
            if (id != 0) {
                WorkerAccessBean ab = new WorkerAccessBean();
                ab.setInitKey_worker(id);
                ab.refreshCopyHelper();
                f.setLastname(ab.getMan().getLastname());
            }
        } catch (Exception ex) {
            f.setLastname("");
        }
    }

    super.perform(mapping, form, request, response);
    ParamsParser.setState(request, Applications.SITEINFO, APPStates.WRKLOOKUP);
    return mapping.findForward("main");
}
}
