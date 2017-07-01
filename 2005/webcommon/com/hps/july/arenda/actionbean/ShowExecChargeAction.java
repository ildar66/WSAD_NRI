package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
/**
 * Action-class.
 * действие для "начислений".
 * Creation date: (29.08.2002 12:23:45)
 * @author: Sergey Gourov
 */
public class ShowExecChargeAction extends com.hps.july.web.util.NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	com.hps.july.web.util.ParamsParser.setState(request, Applications.ARENDA, APPStates.EXEC_CHARGE_FORM);
	return mapping.findForward("main");
}
}
