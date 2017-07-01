package com.hps.july.arenda.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * �������� ��� "����� ������"
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowAccountLookupListAction extends com.hps.july.web.util.LookupBrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.AccountAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	AccountLookupListForm oform = (AccountLookupListForm) form;
	  	try {	  		
	  		OrganizationAccessBean bean = new OrganizationAccessBean();
	  		bean.setInitKey_organization( oform.getOrganization() );
	  		bean.refreshCopyHelper();
		    oform.setOrgname(bean.getName());
	  	} catch (Exception e) {
		  	e.printStackTrace();
		  	oform.setOrgname("");
			//throw new ServletException( e );
	  	}
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.ACCOUNT_LOOKUP);
		return mapping.findForward( "main" );
	}
}
