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
 * действие для "журнал из контракта"(лист).
 * Creation date: (10.01.2003 17:01:24)
 * @author: Sergey Gourov
 */
public class ShowFromContractJournalActListAction extends ShowJournalActListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMCONTRACT_JOURNAL_ACT_LIST);
		return mapping.findForward("main");
	}
}
