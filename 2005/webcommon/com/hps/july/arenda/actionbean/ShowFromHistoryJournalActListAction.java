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
 * ƒействие дл€ "журнал актов из истории контракта".
 * Creation date: (10.01.2003 17:02:51)
 * @author: Sergey Gourov
 */
public class ShowFromHistoryJournalActListAction extends ShowJournalActListAction {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.FROMHISTORY_JOURNAL_ACT_LIST);
		return mapping.findForward("main");
	}
}
