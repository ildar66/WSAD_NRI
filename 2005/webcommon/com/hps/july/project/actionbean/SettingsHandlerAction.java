package com.hps.july.project.actionbean;

import java.util.*;
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
 * Обработчик сохранения параметров настроек.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class SettingsHandlerAction extends org.apache.struts.action.Action {
public void handler(HttpServletRequest request, SettingListForm settingsList, HttpServletResponse response)
    throws IOException, ServletException {

    Integer projecttype =
        new Integer(Integer.parseInt(request.getParameter("projecttype")));
    Integer divcode =
        new Integer(Integer.parseInt(request.getParameter("divcode")));
        
    try {

        java.util.Vector fvec = new Vector();
        fvec.add(settingsList.makeName("plandate"));
        fvec.add(settingsList.makeName("plandateend"));
        fvec.add(settingsList.makeName("comment"));
        fvec.add(settingsList.makeName("posnotes"));
        fvec.add(settingsList.makeName("prjnotes"));
        fvec.add(settingsList.makeName("vc"));
        fvec.add(settingsList.makeName("vccontr"));

        Enumeration en = new ProtoActionAccessBean().findByProjecttypeOrderByOrderAsc(projecttype);
        while (en.hasMoreElements()) {
	        ProtoActionAccessBean pact = (ProtoActionAccessBean)en.nextElement();
            fvec.add(settingsList.makeName("proto" + pact.getProjectActionType().getProjectactiontype()));
        }
        
    	Enumeration ren = new ResponsibilityTypeAccessBean().findAllOrderByCodeAsc();
        while (ren.hasMoreElements()) {
	        ResponsibilityTypeAccessBean renab = (ResponsibilityTypeAccessBean)ren.nextElement();
            fvec.add(settingsList.makeName("resp" + renab.getResponsibilityType()));
        }
        
        Enumeration enum = fvec.elements();
        String name = null;
        String cookieVal = "";
        while (enum.hasMoreElements()) {
            name = (String) enum.nextElement();
            if (request.getParameter(name) == null) {
	            cookieVal = cookieVal + "&" + name + "=1";
            }
        }
        System.out.println("BEFORE CREATE COOKIE: value=" + cookieVal);
        Util_Alex.createCookie(settingsList.makeName("prjparams"), cookieVal, request, response);
        return;
    } catch (Exception e) {
        throw new ServletException(e);
    }
}
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
	    
	    super.perform(mapping, form, request, response);
	    handler(request, (SettingListForm)form, response);
	    return mapping.findForward("success");
    
}
}
