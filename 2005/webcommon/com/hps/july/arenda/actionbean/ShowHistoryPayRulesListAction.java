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
 * Действие для "История правил платежей"(лист).
 * Creation date: (08.08.2002 9:39:40)
 * @author: Sergey Gourov
 */
public class ShowHistoryPayRulesListAction extends ShowPayRulesListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.HISTORY_PAY_RULES_LIST);
		return mapping.findForward("main");
	}
}
