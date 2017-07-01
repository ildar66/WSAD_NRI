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
 * Действие для "История ставок платежей"(лист).
 * Creation date: (17.01.2003 10:43:37)
 * @author: Sergey Gourov
 */
public class ShowHistoryPaymentRatesListAction extends ShowPaymentRatesListAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 17:24:14)
 * @return java.lang.String
 */
protected String getListForm() {
	return "HistoryPaymentsListForm";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.HISTORY_PAYMENT_RATES_LIST);
		return mapping.findForward("main");
	}
}
