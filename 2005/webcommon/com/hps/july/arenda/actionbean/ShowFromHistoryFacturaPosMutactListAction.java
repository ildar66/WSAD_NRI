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
 * ƒействие дл€ "позиции фактуры из истории контракта".
 * Creation date: (25.05.2003 15:29:18)
 * @author: Sergey Gourov
 */
public class ShowFromHistoryFacturaPosMutactListAction extends ShowFacturaPosMutactListAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMHISTORY_FACTURA_POS_MUTACT_LIST);
	return mapping.findForward("main");
}
}
