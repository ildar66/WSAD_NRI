package com.hps.july.inventory.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик формы выбора оборудования
 */
public class ShowResourceLookupBySerialListAction
	extends LookupBrowseAction
{
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.persistence.ResourceAccessBean";
	return "com.hps.july.cdbc.objects.CDBCResourcesObject";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.RESLOOKUPSER );
	  	ResourceLookupBySerialListForm oform = (ResourceLookupBySerialListForm)form;

	  	String sn = request.getParameter("snumber");
	  	if(sn!=null && !sn.equals("")){	  	
	  		oform.setSerial(request.getParameter("snumber"));
	  		
	  		oform.setIsManucode(Boolean.FALSE);
	  		oform.setIsManufid(Boolean.FALSE);
	  		oform.setIsName(Boolean.FALSE);
	  		oform.setIsResourcetype(Boolean.FALSE);
	  		oform.setIsManucode(Boolean.FALSE);
	  		oform.setIsSign(Boolean.FALSE);
	  		oform.setIsSerial(Boolean.TRUE);
	  			  		
	  	}else{


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
			/*
			try {
				OrganizationAccessBean bean = new OrganizationAccessBean();
				bean.setInitKey_organization(oform.getManufacturer().intValue());
				bean.refreshCopyHelper();
				oform.setManufacturername(bean.getName());
			} catch (Exception e) {
		    	oform.setManufacturername("");
	  		}
	  		*/
			oform.setManufacturername(CDBCResourcesObject.getManufnameByManufid(oform.getManufid()));
		  	
	  	}
	  	
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
