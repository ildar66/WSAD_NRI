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
 * Обработчик формы выбора оборудования на позиции
 */
public class ShowEquipmentLookupListAction
	extends LookupBrowseAction
{
public Object constructRowModelBean(Object o) {
	return super.constructRowModelBean(o);
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.StorageCardAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.EQUIPLOOKUP );
		EquipmentLookupListForm oform = (EquipmentLookupListForm)form;
		if(oform.getRestype() != null) {
		  	try {
		  		ResourceTypeAccessBean bean = new ResourceTypeAccessBean();
		  		bean.setInitKey_resourcetype(oform.getRestype().intValue());
		  		bean.refreshCopyHelper();
			    oform.setRestypename(bean.getName());
		  	} catch (Exception e) {
			    oform.setRestypename("");
		  	}
		}
		if(oform.getRessbtype() != null) {
		  	try {
		  		ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean();
		  		bean.setInitKey_resourcesubtype(oform.getRessbtype().intValue());
		  		bean.refreshCopyHelper();
			    oform.setRessbtypename(bean.getName());
		  	} catch (Exception e) {
			    oform.setRessbtypename("");
		  	}
		}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
