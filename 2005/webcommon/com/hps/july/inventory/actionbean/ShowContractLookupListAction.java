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
 * Обработчик формы выбора контрактов
 */
public class ShowContractLookupListAction
	extends LookupBrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ContractAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.CONTLOOKUP );
		ContractLookupListForm oform = (ContractLookupListForm)form;
		if(oform.getContragent() != null) {
		  	try {
		  		OrganizationAccessBean bean = new OrganizationAccessBean();
		  		bean.setInitKey_organization(oform.getContragent().intValue());
		  		bean.refreshCopyHelper();
			    oform.setContragentname(bean.getName());
		  	} catch (Exception e) {
			  	oform.setContragent(new Integer(0));
			    oform.setContragentname("");
		  	}
		}
		if(oform.getOwner() != null) {
			try {
		  		OrganizationAccessBean bean = new OrganizationAccessBean();
		  		bean.setInitKey_organization(oform.getOwner().intValue());
		  		bean.refreshCopyHelper();
			    oform.setOwnername(bean.getName());
		  	} catch (Exception e) {
			    oform.setOwnername("");
			}
		}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
