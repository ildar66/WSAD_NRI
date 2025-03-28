package com.hps.july.project.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.project.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.project.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * ���������� lookup �� ������ �����������.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowOrganizationLookupListAction extends com.hps.july.web.util.LookupBrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.OrganizationAccessBean";
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    try {
        super.perform(mapping, form, request, response);
        ParamsParser.setState(request, Applications.PROJECT, APPStates.ORGLOOKUP);
    } catch (Exception e) {
        Util_Alex.pr(e, "perform", this);
        throw new ServletException(e);
    }

    return mapping.findForward("main");
}
}
