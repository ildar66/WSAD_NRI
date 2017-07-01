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
 * Действие для "поиск ресурсов".
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowResourceLookupListAction extends com.hps.july.web.util.LookupBrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ResourceAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.RESOURCE_LOOKUP);
	  	
	  	ResourceLookupListForm oform = (ResourceLookupListForm) form;
	  	if (oform.getRestype() != 0) {
		  	try {
		  		ResourceTypeAccessBean bean = new ResourceTypeAccessBean();
		  		bean.setInitKey_resourcetype(oform.getRestype());
		  		bean.refreshCopyHelper();
			    oform.setRestypename(bean.getName()); 
		  	} catch (Exception e) {
			    oform.setRestypename("");
			    oform.setRestype(0);
		  	}
	  	} else {
		  	oform.setRestypename("");
	  	}
	  	if (oform.getRessbtype() != 0) {
		  	try {
		  		ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean();
		  		bean.setInitKey_resourcesubtype(oform.getRessbtype());
		  		bean.refreshCopyHelper();
		    	oform.setRestype(bean.getResourcetype().getResourcetype());
		    	oform.setRestypename(bean.getResourcetype().getName());
			    oform.setRessbtypename(bean.getName());
		  	} catch (Exception e) {
			    oform.setRessbtypename("");
			    oform.setRessbtype(0);
		  	}
	  	} else {
		  	oform.setRessbtypename("");
	  	}
	  	
	  	super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
