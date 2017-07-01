package com.hps.july.arenda.actionbean;

import java.util.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Action-class.
 * действие для "список связей абонентских счетов"
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowAbonentBillLinksListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseResBil2NRIAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_BILL_LINKS_LIST);
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
