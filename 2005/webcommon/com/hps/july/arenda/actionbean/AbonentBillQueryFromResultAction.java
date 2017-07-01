package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.billing.*;
import java.sql.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.persistence.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * "Запрос абонентских счетов(из результата)"
 * Creation date: (15.04.2003 17:35:18)
 * @author: Sergey Gourov
 */
public class AbonentBillQueryFromResultAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ResultForm resultForm = (ResultForm) form;
	resultForm.setIsSuccess(new Boolean(false));
	
	int operator = 0; // only for wte!!! set operator = 0 for ws!!!
	try {
		operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
	try {
		Object[] o = new TransferAccessBean().moveAllPie2Nri(operator);
		if (o[1] != null && o[3] != null && ((Boolean) o[1]).booleanValue() && ((Boolean) o[3]).booleanValue()) {
			resultForm.setIsSuccess(new Boolean(true));
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
		
	ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_BILL_QUERY_FROM_RESULT);
	return mapping.findForward("main");
}
}
