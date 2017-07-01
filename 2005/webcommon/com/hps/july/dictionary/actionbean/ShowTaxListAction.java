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
 * Обработчик формы списка налогов
 */
public class ShowTaxListAction extends BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ResourceTaxeAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.DICTIONARY, APPStates.TAXLIST);

    TaxListForm oform = (TaxListForm) form;
    if(oform.getFilterdate() == null) {
	    oform.setFilterdate(new java.sql.Date(System.currentTimeMillis()));
    }
    try {
        ResourceTypeAccessBean bean = new ResourceTypeAccessBean();
        bean.setInitKey_resourcetype((oform.getResourcetype() != null)?oform.getResourcetype().intValue():0);
        bean.refreshCopyHelper();
        oform.setResourcetypename(bean.getName());
    }
    catch (Exception e) {
        oform.setResourcetype(new Integer(0));
        oform.setResourcetypename("");
    }
    if ( (oform.getResourcesubtype() != null) && (oform.getResourcesubtype() != new Integer(0)) )
	    try {
	        ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean();
	        bean.setInitKey_resourcesubtype((oform.getResourcesubtype() != null)?oform.getResourcesubtype().intValue():0);
	        bean.refreshCopyHelper();
	        oform.setResourcetype(new Integer(bean.getResourcetype().getResourcetype()));
	        oform.setResourcetypename(bean.getResourcetype().getName());
	        oform.setResourcesubtypename(bean.getName());
	    }
	    catch (Exception e) {
	        oform.setResourcesubtype(new Integer(0));
	        oform.setResourcesubtypename("");
	    }
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
