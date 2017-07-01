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
 * действие для "печать фактуры(history)"
 * Creation date: (18.05.2003 15:38:33)
 * @author: Sergey Gourov
 */
public class PrintHistoryFacturaAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.HISTORY_PRINT_FACTURA);
	return mapping.findForward("main");
}
}
