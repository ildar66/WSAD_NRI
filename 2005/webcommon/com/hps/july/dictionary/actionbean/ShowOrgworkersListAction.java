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
 * Обработчик формы списка служащих организации
 */
public class ShowOrgworkersListAction extends BrowseAction {
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.WorkerAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState( request, Applications.DICTIONARY, APPStates.ORGWLIST );
	  	OrgworkersListForm oform = (OrgworkersListForm) form;
	  	try {
	  		OrganizationAccessBean bean = new OrganizationAccessBean();
	  		bean.setInitKey_organization(oform.getOrganization());
	  		bean.refreshCopyHelper();
		    oform.setOrganizationname(bean.getName()+", "+bean.getInn());
	  	} catch (Exception e) {
		    oform.setOrganization(0);
		    oform.setOrganizationname("");
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
