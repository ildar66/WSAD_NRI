package com.hps.july.sitedoc.actionbean;

import java.lang.reflect.*;
import java.util.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.sitedoc.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.sitedoc.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик формы списка оборудования
 */
public class ShowEquipmentListAction extends BrowsePageAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.sitedoc.valueobject.EquipmentObject";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
{
    SiteDocEquipmentListForm pForm = (SiteDocEquipmentListForm) form;
    pForm.checkRequest(request);
	super.perform(mapping, form, request, response);

    ParamsParser.setState(request, Applications.SITEDOC, APPStates.SiteDocEquipmentListForm);

    return mapping.findForward("main");
}
}
