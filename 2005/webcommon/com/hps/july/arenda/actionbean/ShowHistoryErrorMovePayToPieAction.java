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
 * ƒействие дл€ "истории ошибок движени€ платежей"(лист).
 * Creation date: (07.04.2003 18:30:15)
 * @author: Sergey Gourov
 */
public class ShowHistoryErrorMovePayToPieAction extends com.hps.july.web.util.NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.PLATINUM_ERROR_HISTORY_MOVEPAYTOPIE);
    return mapping.findForward("main");
}
}
