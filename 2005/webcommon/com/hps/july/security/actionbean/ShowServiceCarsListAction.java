package com.hps.july.security.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.security.*;
import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import com.hps.july.security.formbean.*;
/**
 * Автомашины службы.
 * Creation date: (21.07.2003 18:52:06)
 * @author: Sergey Gourov
 */
public class ShowServiceCarsListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (21.07.2003 18:20:19)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.CarAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	
	ServiceCarsList oform = (ServiceCarsList) form;
	try {
		ServiceAccessBean bean = new ServiceAccessBean();
		bean.setInitKey_division(oform.getDivision());
		bean.refreshCopyHelper();
		
		request.getSession().setAttribute("service", bean);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	ParamsParser.setState(request, Applications.SECURITY, APPStates.SERVICE_CARS_LIST);
	return mapping.findForward("main");
}
}
