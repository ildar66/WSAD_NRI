package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
/**
 * Action-class.
 * действие для "получить платежи из Platinum"
 * Creation date: (08.04.2003 9:59:01)
 * @author: Sergey Gourov
 */
public class HistoryGetPayFromPlatinumAction extends GetPayFromPlatinumAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	ParamsParser.setState(request, Applications.ARENDA, APPStates.PLATINUM_HISTORY_GETPAYFROMPLATINUM);
	return mapping.findForward("main");
}
}
