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
 * действие для "вычисление истории"
 * Creation date: (05.06.2003 13:53:30)
 * @author: Sergey Gourov
 */
public class ShowCalcHistoryAction extends com.hps.july.web.util.NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.CALC_HISTORY);
	return mapping.findForward("main");
}
}
