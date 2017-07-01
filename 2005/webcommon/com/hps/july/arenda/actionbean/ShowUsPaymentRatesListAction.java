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
 * Действие для "Ставки платежей".
 * Creation date: (17.01.2003 10:45:54)
 * @author: Sergey Gourov
 */
public class ShowUsPaymentRatesListAction extends ShowPaymentRatesListAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 17:24:14)
 * @return java.lang.String
 */
protected String getListForm() {
	return "UsPaymentsListForm";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.US_PAYMENT_RATES_LIST);
		return mapping.findForward("main");
	}
}
