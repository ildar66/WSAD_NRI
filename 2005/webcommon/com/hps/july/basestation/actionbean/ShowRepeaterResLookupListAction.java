package com.hps.july.basestation.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик формы выбора оборудования репитеров
 */
public class ShowRepeaterResLookupListAction
	extends com.hps.july.web.util.LookupBrowseAction
{
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.RepiterResAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  	ParamsParser.setState(request, Applications.BASESTATION, APPStates.REPEATERRES_LOOKUP);
  	RepeaterResLookupList oform = (RepeaterResLookupList) form;
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
