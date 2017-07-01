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
 * Действие для "История начислений"(лист).
 * Creation date: (07.08.2002 16:17:36)
 * @author: Sergey Gourov
 */
public class ShowHistoryChargesListAction extends ShowChargesListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.HISTORY_CHARGES_LIST);
		return mapping.findForward("main");
	}
}
