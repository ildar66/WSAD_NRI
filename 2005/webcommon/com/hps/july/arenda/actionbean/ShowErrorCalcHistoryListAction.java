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
 * действие для "Лист истории вычислений.".
 * Creation date: (06.06.2003 16:31:59)
 * @author: Sergey Gourov
 */
public class ShowErrorCalcHistoryListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (06.06.2003 16:31:59)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseTaskJournalAccessBean";
}
/**
 * Shows if to add current URL to history.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.ERROR_CALC_HISTORY);
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
