package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.sessionbean.*;
import com.hps.july.persistence.*;
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
 * действие для "отчетов аренды"
 * Creation date: (04.04.2003 12:48:54)
 * @author: Sergey Gourov
 */
public class MutactCalcReportAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	MutactCalcReportForm mcrForm = (MutactCalcReportForm) request.getAttribute("MutactCalcReportForm");
	
	int operator = 0; // only for wte!!! set operator = 0 for ws!!!
	try {
		operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
	try {
		int idTask = new ArendaDocumentProcessorAccessBean().makeCalcForReport(mcrForm.getLeaseDocument(), operator);
		if (idTask > 0) {
			String f = "../crystalclear/AktSverkaHeader.rpt?dll=pdactsverka.dll&" + "prompt0=" + mcrForm.getLeaseDocument() + "&prompt1=" + idTask;
			return new ActionForward(f, true);
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	ParamsParser.setState(request, Applications.ARENDA, APPStates.MUTACTS_CALC_REPORT);
	return mapping.findForward("main");
}
}
