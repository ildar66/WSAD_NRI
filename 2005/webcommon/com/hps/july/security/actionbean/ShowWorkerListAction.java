package com.hps.july.security.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.security.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.security.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;


/**
 * Список работников.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowWorkerListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.WorkerAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.SECURITY, APPStates.WRKLIST );
	  	WorkerListForm oform = (WorkerListForm) form;
	  	try {	  		
	  		PeopleAccessBean bean = new PeopleAccessBean();
	  		bean.setInitKey_man( oform.getMan() );
	  		bean.refreshCopyHelper();
		    request.getSession().setAttribute( "people", bean );
	  	} catch (Exception e) {
			throw new ServletException( e );
	  	}
		return mapping.findForward( "main" );
	}
}
