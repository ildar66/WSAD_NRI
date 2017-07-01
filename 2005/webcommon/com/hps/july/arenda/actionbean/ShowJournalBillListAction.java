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
 * Действие для "Журнал счетов"(лист).
 * Creation date: (16.04.2003 12:16:19)
 * @author: Sergey Gourov
 */
public class ShowJournalBillListAction extends ShowJournalProlongationsListAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_BILL_JOURNAL_LIST);
	return mapping.findForward("main");
}
}
