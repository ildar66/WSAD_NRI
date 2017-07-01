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
 * Действие для "История ставок платежей"(лист).
 * Creation date: (07.08.2002 11:16:43)
 * @author: Sergey Gourov
 */
public class ShowHistoryPaymentsListAction extends ShowPaymentsListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.HISTORY_PAYMENTS_LIST);
		return mapping.findForward("main");
	}
}
