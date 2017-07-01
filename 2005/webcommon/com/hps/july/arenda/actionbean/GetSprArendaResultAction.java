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
 * "получение справочников аренды."
 * Creation date: (08.04.2003 18:37:15)
 * @author: Sergey Gourov
 */
public class GetSprArendaResultAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	super.perform(mapping, form, request, response);
	
	GetSprArendaResultForm resultForm = (GetSprArendaResultForm) form;
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
			
			if (new ArendaPlatinumProcessorAccessBean().makeQryGetSprArenda(operator) == 0) {
				resultForm.setIsSuccess(new Boolean(true));
			}
		}
	} catch(Exception e) {
		e.printStackTrace();
		resultForm.setIsSuccess(new Boolean(false));
	}
	
	ParamsParser.setState(request, Applications.ARENDA, APPStates.GET_SPR_ARENDA_RESULT);
	return mapping.findForward("main");
}
}
