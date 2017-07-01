package com.hps.july.security.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.security.formbean.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.security.*;
import com.hps.july.web.util.*;
/**
 * Список машин подразделения.
 * Creation date: (21.07.2003 18:52:22)
 * @author: Sergey Gourov
 */
public class ShowDepartmentCarsListAction extends com.hps.july.web.util.BrowseAction {
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
	
	DepartmentCarsList oform = (DepartmentCarsList) form;
	try {
		DepartmentAccessBean bean = new DepartmentAccessBean();
		bean.setInitKey_division(oform.getDivision());
		bean.refreshCopyHelper();
		
		request.getSession().setAttribute("department", bean);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	ParamsParser.setState(request, Applications.SECURITY, APPStates.DEPARTMENT_CARS_LIST);
	return mapping.findForward("main");
}
}
