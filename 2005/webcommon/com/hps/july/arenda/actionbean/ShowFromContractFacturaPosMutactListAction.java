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
 * действие для "позиции фактуры из контракта"(лист).
 * Creation date: (25.05.2003 15:28:54)
 * @author: Sergey Gourov
 */
public class ShowFromContractFacturaPosMutactListAction extends ShowFacturaPosMutactListAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMCONTRACT_FACTURA_POS_MUTACT_LIST);
	return mapping.findForward("main");
}
}
