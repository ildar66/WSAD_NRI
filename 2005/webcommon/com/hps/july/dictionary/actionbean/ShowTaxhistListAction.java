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
 * Обработчик формы списка истории налогов
 */
public class ShowTaxhistListAction extends BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.ResourceTaxeAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.DICTIONARY, APPStates.TAXHLIST);

    TaxhistListForm oform = (TaxhistListForm) form;
    if(oform.getDate() == null) {
	    oform.setDate(new java.sql.Date(System.currentTimeMillis()));
    }
    try {
        ResourceAccessBean bean = new ResourceAccessBean();
        bean.setInitKey_resource((oform.getResource() != null)?oform.getResource().intValue():0);
        bean.refreshCopyHelper();
        oform.setResourcename(bean.getName());
        oform.setResourcemodel(bean.getModel());
    }
    catch (Exception e) {
        oform.setResource(new Integer(0));
        oform.setResourcename("");
        oform.setResourcemodel("");
    }
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
