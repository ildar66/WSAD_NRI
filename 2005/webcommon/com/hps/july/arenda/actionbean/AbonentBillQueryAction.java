package com.hps.july.arenda.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.web.util.*;
/**
 * Action-class "Запрос абонентских счетов"
 * Creation date: (15.04.2003 16:52:47)
 * @author: Sergey Gourov
 */
public class AbonentBillQueryAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_BILL_QUERY);
	return mapping.findForward("main");
}
}
