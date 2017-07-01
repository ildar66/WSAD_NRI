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
 * Обработчик отображения текщих параметров настройки задачи.
 * Creation date: (25.09.2002 18:01:10)
 * @author: Maksim Gerasimov
 */
public class ShowSettingsListAction
    extends com.hps.july.web.util.BrowseAction {
public Object constructRowModelBean(Object o) {
	try {
		((ProtoActionAccessBean)o).refreshCopyHelper();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	ProtoObject ob = new ProtoObject();
	//ob.setPosition(getPosition());
	ob.setProto((ProtoActionAccessBean)o);
	return ob; 
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

	    
    request.setAttribute("resources", getServlet().getResources());

    // Show responsible list
    java.util.Enumeration en = null;
    try {
    	en = new ResponsibilityTypeAccessBean().findAllOrderByCodeAsc();
    } catch (Exception e) {
	    e.printStackTrace(System.out);
    }
    request.setAttribute("respList", en);
    
    super.perform(mapping, form, request, response);

    ParamsParser.setState(request, Applications.PROJECT, APPStates.SETTINGSLIST);
    return mapping.findForward("main");
}
}
