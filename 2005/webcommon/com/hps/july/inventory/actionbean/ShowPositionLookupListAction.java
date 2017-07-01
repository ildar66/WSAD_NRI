package com.hps.july.inventory.actionbean;

import java.lang.reflect.*;
import java.util.*;
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
import com.hps.july.jdbcpersistence.lib.DebugSupport;

/**
 * Обработчик формы выбора позиции
 */
public class ShowPositionLookupListAction 
	extends LookupBrowseAction
{
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.siteinfo.valueobject.Position";
	return "com.hps.july.cdbc.objects.CDBCPositionObject";
}
public int getRowsOnPage() {
	try {
		NamedValueAccessBean v = new NamedValueAccessBean();
		v.setInitKey_id("SiteListPageLenght");
		v.refreshCopyHelper();
		return v.getIntvalue();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return super.getRowsOnPage();
	}
}
public ActionForward perform(ActionMapping mapping, ActionForm form,HttpServletRequest request,HttpServletResponse response)
    throws IOException, ServletException
{
    PositionLookupListForm pForm = (PositionLookupListForm)form;
	pForm.setRequestData(request); 
    super.perform(mapping, form, request, response);
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.POSLOOKUP);
    return mapping.findForward("main");
}
}
