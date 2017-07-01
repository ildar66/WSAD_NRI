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
 * действие для "фактура из контракта"(лист).
 * Creation date: (22.05.2003 15:17:09)
 * @author: Sergey Gourov
 */
public class ShowFromContractFacturaMutactListAction extends ShowFacturaMutactListAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMCONTRACT_FACTURA_MUTACT_LIST);
	return mapping.findForward("main");
}
}
