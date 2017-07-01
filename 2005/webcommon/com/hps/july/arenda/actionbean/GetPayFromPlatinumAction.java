package com.hps.july.arenda.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.arenda.formbean.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
/**
 * Action-class.
 * действие для "платежи из Platinum."
 * Creation date: (08.04.2003 9:37:43)
 * @author: Sergey Gourov
 */
public class GetPayFromPlatinumAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	super.perform(mapping, form, request, response);
	int operator = 0; // only for wte!!! set operator = 0 for ws!!!
	try {
		operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
	GetPayFromPlatinumForm pForm = (GetPayFromPlatinumForm) form;
	pForm.setIsSuccess(new Boolean(false));
	
	try {
		// int operator, int contract, int payment
		if (new ArendaDocumentProcessorAccessBean().makeQryGetPays(operator, null, new Integer(pForm.getLeaseDocPosition()), null, null) == 0) {
			pForm.setIsSuccess(new Boolean(true));
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	ParamsParser.setState(request, Applications.ARENDA, APPStates.PLATINUM_GETPAYFROMPLATINUM);
	return mapping.findForward("main");
}
}
