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
 * Обработчик формы выбора типа оборудования по указанному виду
 * Используется для указания типа оборудования включаемого в отчёт "Наличие оборудования"
 */
public class ShowReport1rstLookupListAction
	extends BrowseAction
{
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ResourceSubTypeAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.RPT1RSTLOOKUP );
	  	Report1rstLookupListForm oform = (Report1rstLookupListForm)form;
	  	try {
	  		ResourceTypeAccessBean bean = new ResourceTypeAccessBean();
	  		bean.setInitKey_resourcetype(oform.getResourcetype());
	  		bean.refreshCopyHelper();
		    oform.setResourcetypename(bean.getName());
	  	} catch (Exception e) {
		    oform.setResourcetype(0);
		    oform.setResourcetypename("");
	  	}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
