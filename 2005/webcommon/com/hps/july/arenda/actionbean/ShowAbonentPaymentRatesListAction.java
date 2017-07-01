package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * действие для "список ставок платежей"
 * Creation date: (12.06.2003 12:21:02)
 * @author: Sergey Gourov
 */
public class ShowAbonentPaymentRatesListAction extends ShowPaymentRatesListAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 17:24:14)
 * @return java.lang.String
 */
protected String getListForm() {
	return "AbonentPaymentsListForm";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    super.perform(mapping, form, request, response);
    ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_PAYMENT_RATES_LIST);
    return mapping.findForward("main");
}
}
