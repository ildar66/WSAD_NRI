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
 * ���������� ����� ������ ��. ��� ��������
 */
public class ShowOrganizationListCAction extends BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.OrganizationAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.DICTIONARY, APPStates.ORGLISTC );
	  	OrganizationListCForm oform = (OrganizationListCForm) form;
	  	try {	  		
	  		CompanyAccessBean bean = new CompanyAccessBean();
	  		bean.setInitKey_company( oform.getCompany() );
	  		bean.refreshCopyHelper();
		    request.getSession().setAttribute( "company", bean );
	  	} catch (Exception e) {
			throw new ServletException( e );
	  	}
	  	if(oform.getGroup() != null) {
		  	try {
				SearchGroupAccessBean bean = new SearchGroupAccessBean();
				bean.setInitKey_searchgroup(oform.getGroup().intValue());
		  		bean.refreshCopyHelper();
			    oform.setGroupname(bean.getName());
		  	} catch (Exception e) {
			    oform.setGroup(new Integer(0));
			    oform.setGroupname("");
		  	}
	  	}

	  	if(oform.getGroupping() != null) {
		  	try {
			  	SearchGrouppingAccessBean bean = new SearchGrouppingAccessBean();
			  	bean.setInitKey_searchGroupping(oform.getGroupping().intValue());
		  		bean.refreshCopyHelper();
			    oform.setGrouppingname(bean.getName());
		  	} catch(Exception e) {
			  	oform.setGroupping(new Integer(0));
			  	oform.setGrouppingname("");
		  	}
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}