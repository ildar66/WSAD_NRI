package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * Действие для "фактура из истории контракта".
 * Creation date: (22.05.2003 15:19:05)
 * @author: Sergey Gourov
 */
public class ShowFromHistoryFacturaMutactListAction extends ShowFacturaMutactListAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMHISTORY_FACTURA_MUTACT_LIST);
	return mapping.findForward("main");
}
}
