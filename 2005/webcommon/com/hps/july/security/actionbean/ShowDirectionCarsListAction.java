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
 * ������ ����� ��������.
 * Creation date: (21.07.2003 18:20:19)
 * @author: Sergey Gourov
 */
public class ShowDirectionCarsListAction extends com.hps.july.web.util.BrowseAction {
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
	
	DirectionCarsList oform = (DirectionCarsList) form;
	try {
		DirectionAccessBean bean = new DirectionAccessBean();
		bean.setInitKey_division(oform.getDivision());
		bean.refreshCopyHelper();
		
		request.getSession().setAttribute("direction", bean);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	ParamsParser.setState(request, Applications.SECURITY, APPStates.DIRECTION_CARS_LIST);	
	return mapping.findForward("main");
}
}
