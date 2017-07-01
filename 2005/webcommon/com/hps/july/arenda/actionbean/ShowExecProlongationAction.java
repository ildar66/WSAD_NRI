package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
/**
 * Action-class.
 * действие для "продлений".
 * Creation date: (20.08.2002 17:23:10)
 * @author: Sergey Gourov
 */
public class ShowExecProlongationAction extends com.hps.july.web.util.NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	com.hps.july.web.util.ParamsParser.setState(request, Applications.ARENDA, APPStates.EXEC_PROLONGATION_FORM);
	return mapping.findForward("main");
}
}
