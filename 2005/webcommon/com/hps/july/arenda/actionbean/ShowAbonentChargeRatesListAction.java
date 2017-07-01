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
 * действие для "список ставок начислений"
 * Creation date: (12.06.2003 13:29:36)
 * @author: Sergey Gourov
 */
public class ShowAbonentChargeRatesListAction extends ShowChargeRatesListAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 17:31:34)
 * @return java.lang.String
 */
protected String getListForm() {
	return "AbonentChargesListForm";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_CHARGE_RATES_LIST);
	return mapping.findForward("main");
}
}
