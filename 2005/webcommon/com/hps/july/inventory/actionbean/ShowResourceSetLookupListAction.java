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
 * ���������� ����� ������ ������ ������������
 */
public class ShowResourceSetLookupListAction
	extends LookupBrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ResourceSetAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.RESSETLOOKUP );
	  	ResourceSetLookupListForm oform = (ResourceSetLookupListForm)form;
	  	try {
	  		ResourceTypeAccessBean bean = new ResourceTypeAccessBean();
	  		bean.setInitKey_resourcetype(oform.getResourcetype().intValue());
	  		bean.refreshCopyHelper();
		    oform.setResourcetypename(bean.getName());
	  	} catch (Exception e) {
		    oform.setResourcetypename("");
	  	}
	  	try {
	  		ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean();
	  		bean.setInitKey_resourcesubtype(oform.getResourcesubtype().intValue());
	  		bean.refreshCopyHelper();
		    oform.setResourcesubtypename(bean.getName());
	  	} catch (Exception e) {
		    oform.setResourcesubtypename("");
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
