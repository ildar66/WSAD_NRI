package com.hps.july.arenda.actionbean;

import com.hps.july.platinum.sessionbean.*;
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
 * действие для "список Банков."
 * Creation date: (09.04.2003 11:39:10)
 * @author: Sergey Gourov
 */
public class GetBanksResultAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	GetBanksResultForm resultForm = (GetBanksResultForm) form;
	resultForm.setIsSuccess(null);
	
	try {
		if (new ArendaPlatinumProcessorAccessBean().isProcessingEnabled()) {
			resultForm.setIsSuccess(new Boolean(false));
			
			int operator = 1; // only for wte!!! set operator = 0 for ws!!!
			try {
				operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			GetBanksForm gbForm = (GetBanksForm) request.getSession().getAttribute("GetBanksForm");
			if (new ArendaPlatinumProcessorAccessBean().makeQryGetBanks(operator, gbForm.getIsAllBanks().booleanValue() ? null : gbForm.getBankCode()) == 0) {
				resultForm.setIsSuccess(new Boolean(true));
			}
		}
	} catch(Exception e) {
		e.printStackTrace();
		resultForm.setIsSuccess(new Boolean(false));
	}
	
	ParamsParser.setState(request, Applications.ARENDA, APPStates.GET_BANKS_RESULT);
	return mapping.findForward("main");
}
}
