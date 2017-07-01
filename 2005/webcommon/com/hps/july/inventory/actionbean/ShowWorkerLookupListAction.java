package com.hps.july.inventory.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;


/**
 * Обработчик формы выбора работника по фамилии
 */
public class ShowWorkerLookupListAction
	extends LookupBrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:35:12)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
/*
	if(o instanceof PeopleAccessBean) {
		PeopleAccessBean ab = (PeopleAccessBean)o;
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			Enumeration en = bean.findWorkersByMan(new PeopleKey(ab.getMan()));
			if(en.hasMoreElements()) {
				return (WorkerAccessBean)en.nextElement();
			}
		} catch(Exception e) {
		}
	}
*/
	return super.constructRowModelBean(o);
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.persistence.PeopleAccessBean";
	return "com.hps.july.cdbc.objects.CDBCWorkerObject";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.WRKLOOKUP );
		return mapping.findForward( "main" );
	}
}
