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
 * действие для "получить платежи"
 * Creation date: (10.04.2003 11:46:21)
 * @author: Sergey Gourov
 */
public class GetPaysResultAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	GetPaysResultForm resultForm = (GetPaysResultForm) form;
	resultForm.setIsSuccess(null);
	
	try {
		if (new ArendaPlatinumProcessorAccessBean().isProcessingEnabled()) {
			resultForm.setIsSuccess(new Boolean(false));
			
			int operator = 0; // only for wte!!! set operator = 0 for ws!!!
			try {
				operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			GetPaysForm gpForm = (GetPaysForm) request.getSession().getAttribute("GetPaysForm");
			
			// int operator, Integer contract, Integer payment, Date payDateStart, Date payDateFinish
			if (new ArendaPlatinumProcessorAccessBean().makeQryGetPays(operator, 
				gpForm.getIsAllContracts().booleanValue() ? null : gpForm.getContractcode(), null, gpForm.getDateFrom(), gpForm.getDateTo()) == 0) {
				resultForm.setIsSuccess(new Boolean(true));
			}
		}
	} catch(Exception e) {
		e.printStackTrace();
		resultForm.setIsSuccess(new Boolean(false));
	}
	
	ParamsParser.setState(request, Applications.ARENDA, APPStates.GET_PAYS_RESULT);
	return mapping.findForward("main");
}
}
