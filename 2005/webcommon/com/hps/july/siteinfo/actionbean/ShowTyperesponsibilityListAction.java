package com.hps.july.siteinfo.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.siteinfo.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * ���������� ������ ����� ���������������
 */
public class ShowTyperesponsibilityListAction
	extends com.hps.july.web.util.BrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ResponsibilityTypeAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		super.perform( mapping, form, request, response );
		
		HttpSession session = request.getSession();
		session.setAttribute("mapState", "0");
		session.setAttribute("mapbyPositionState", "0");
	  	ParamsParser.setState( request, Applications.SITEINFO, APPStates.TRSPLIST );
		return mapping.findForward( "main" );
	}
}
