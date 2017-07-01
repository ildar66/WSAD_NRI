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
 * Обработчик формы списка счетов компании
 */
public class ShowAccountListCAction
	extends BrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.AccountAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	AccountListCForm oform = (AccountListCForm) form;
	  	try {	  		
	  		OrganizationAccessBean bean = new OrganizationAccessBean();
	  		bean.setInitKey_organization( oform.getOrganization() );
	  		bean.refreshCopyHelper();
		    oform.setOrgname(bean.getName());
	  	} catch (Exception e) {
			throw new ServletException( e );
	  	}
		CompanyAccessBean bean = (CompanyAccessBean)request.getSession().getAttribute( "company" );
		if (bean != null) {
	  		try {	  		
				oform.setCompcode(bean.getCompany());
				oform.setCompname(bean.getName());
		  	} catch (Exception e) {
				throw new ServletException( e );
		  	}
		}
	  	
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.DICTIONARY, APPStates.ACCLISTC );
		return mapping.findForward( "main" );
	}
}
