package com.hps.july.dictionary.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.dictionary.*;
import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import com.hps.july.dictionary.formbean.*;

/**
 * Обработчик формы списка автомобилей дирекции
 */
public class ShowCarsListAction
	extends BrowseAction
{
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
	
	CarsList oform = (CarsList) form;
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		bean.setInitKey_organization(oform.getOrganization());
		bean.refreshCopyHelper();
		
		oform.setOrganizationname(bean.getName());
	} catch (Exception e) {
		e.printStackTrace();
		oform.setOrganizationname("");
	}
	
	ParamsParser.setState(request, Applications.DICTIONARY, APPStates.CARS_LIST);
	return mapping.findForward("main");
}
}
