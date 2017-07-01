package com.hps.july.dictionary.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.dictionary.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.dictionary.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик формы списка групп отдела
 */
public class ShowDGroupLookupListAction
	extends LookupBrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.GroupAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.DICTIONARY, APPStates.DGRPLOOKUP );
	  	DGroupLookupListForm oform = (DGroupLookupListForm) form;
	  	try {	  		
	  		DepartmentAccessBean bean = new DepartmentAccessBean();
	  		bean.setInitKey_division( oform.getDepartment().intValue() );
	  		bean.refreshCopyHelper();
		    //request.getSession().setAttribute( "department", bean );
		    oform.setDepartmentname(bean.getName());
	  	} catch (Exception e) {
		    oform.setDepartment(new Integer(0));
		    oform.setDepartmentname("");
			//throw new ServletException( e );
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
