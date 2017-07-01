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
 * Обработчик формы выбора оборудования
 */
public class ShowResourceLookupListAction extends LookupBrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCResourcesObject";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.DICTIONARY, APPStates.RESLOOKUP );
	  	ResourceLookupListForm oform = (ResourceLookupListForm)form;
	  	if(oform.getResourcesubtype() != null) {
		  	try {
		  		ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean();
		  		bean.setInitKey_resourcesubtype(oform.getResourcesubtype().intValue());
		  		bean.refreshCopyHelper();
			    oform.setResourcesubtypename(bean.getName());
			    ResourceTypeAccessBean restype = bean.getResourcetype();
			    oform.setResourcetype(new Integer(restype.getResourcetype()));
			    oform.setResourcetypename(restype.getName());
		  	} catch (Exception e) {
			    oform.setResourcesubtypename("");
		  	}
		} else {
		  	try {
		  		ResourceTypeAccessBean bean = new ResourceTypeAccessBean();
		  		bean.setInitKey_resourcetype(oform.getResourcetype().intValue());
		  		bean.refreshCopyHelper();
			    oform.setResourcetypename(bean.getName());
		  	} catch (Exception e) {
			    oform.setResourcetypename("");
		  	}
		}
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(oform.getManufacturer().intValue());
			bean.refreshCopyHelper();
			oform.setManufacturername(bean.getName());
		} catch (Exception e) {
		    oform.setManufacturername("");
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
