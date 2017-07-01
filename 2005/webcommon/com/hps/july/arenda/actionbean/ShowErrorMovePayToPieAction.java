package com.hps.july.arenda.actionbean;

import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * действие для "обработки ошибок в PIE".
 * Creation date: (07.04.2003 18:27:49)
 * @author: Sergey Gourov
 */
public class ShowErrorMovePayToPieAction extends com.hps.july.web.util.NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.PLATINUM_ERROR_MOVEPAYTOPIE);
	return mapping.findForward("main");
}
}
