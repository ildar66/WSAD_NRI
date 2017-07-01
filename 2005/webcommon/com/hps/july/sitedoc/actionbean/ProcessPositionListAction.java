package com.hps.july.sitedoc.actionbean;

import java.lang.reflect.*;
import java.util.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.sitedoc.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.sitedoc.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик добавления связей документа с позициями
 */
public class ProcessPositionListAction
	extends com.hps.july.web.util.BrowseAction
{
	private static int rowsOnPage = 0;
/**
 * Insert the method's description here.
 * Creation date: (06.07.2003 18:58:21)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 */
private void addPositions(HttpServletRequest request)
	throws Exception
{
    Sitedoc2SplaceAccessBean bean = null;
    SiteDocForm docForm = (SiteDocForm) request.getSession().getAttribute("SiteDocForm");
    int sitedoc = docForm.getSitedoc();
    String[] params = request.getParameterValues("check_add");
    if (params == null) {
        return;
    }
    for (int i = 0; i < params.length; i++) {
        bean = new Sitedoc2SplaceAccessBean(sitedoc, Integer.parseInt(params[i]));
    }
    //ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocForm);
    //return mapping.findForward("main");
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.siteinfo.valueobject.Position";
	return "com.hps.july.cdbc.objects.CDBCPositionObject";
}
public int getRowsOnPage() {
	if(rowsOnPage < 1) {
		rowsOnPage = com.hps.july.util.AppUtils.getNamedValueInt("SiteListPageLenght");
		if(rowsOnPage < 1) {
			rowsOnPage = super.getRowsOnPage();
		}
	}
	return rowsOnPage;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2003 18:58:21)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 */
private boolean isAddPositions(HttpServletRequest request) {

    Enumeration enum = request.getParameterNames();
    String submitName = "submit_add";
    String name = null;
    while (enum.hasMoreElements()) {
        name = (String) enum.nextElement();
//        DebugSupport.println("parameter " + name);
        if (name.length() > submitName.length() && name.substring(0, submitName.length()).equals(submitName)) {
//            DebugSupport.println("isAddPosition true");
            return true;
        }
    }
//    DebugSupport.println("isAddPosition false");
    return false;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
    try {
		TimeCounter tc = new TimeCounter("PERF.SITEDOC.POSLIST");
		tc.start();
        if (isAddPositions(request)) {
			tc.finish("isAddPositions");
            addPositions(request);
			tc.finish("addPositions");
            ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocForm);
			tc.finish("setState");
        	return mapping.findForward("success");
        } else {
			tc.finish("isAddPositions");
			SiteDocPositionListForm pForm = (SiteDocPositionListForm) form;
			pForm.checkRequest(request);
			tc.finish("checkRequest");
			super.perform(mapping, form, request, response);
			tc.finish("super.perorm");
			ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocPositionListForm);
			tc.finish("setState");
//            navigate(mapping, form, request, response);
        }

		tc.finish("action");
        return mapping.findForward("main");
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw new ServletException(e);
    }
}
}
