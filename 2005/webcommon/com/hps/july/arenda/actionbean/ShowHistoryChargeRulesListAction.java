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
 * Действие для "История ставок начислений"(лист).
 * Creation date: (08.08.2002 9:42:10)
 * @author: Sergey Gourov
 */
public class ShowHistoryChargeRulesListAction extends ShowChargeRulesListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.HISTORY_CHARGE_RULES_LIST);
		return mapping.findForward("main");
	}
}
