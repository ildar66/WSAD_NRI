package com.hps.july.arenda.actionbean;

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
 * Creation date: (03.04.2003 17:45:21)
 * @author: Sergey Gourov
 */
public class MutactEqualReportAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	MutactEqualReportForm oform = (MutactEqualReportForm) form;
	String actstate = "";
		
	try {
		LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean();
		lmanBean.setInitKey_leaseDocument(oform.getLeaseDocument());
		lmanBean.refreshCopyHelper();
		
		actstate = lmanBean.getLeaseMutualReglament().getActType();
	} catch (Exception e) {
		e.printStackTrace();
	}

	String f = "";
	if (actstate.equals("A")) {
		f = "../crystalclear/AktMutual.rpt?dll=pdsactmutual.dll&" + "prompt0=" + oform.getLeaseDocument();
	} else if (actstate.equals("M")) {
		f = "../crystalclear/AktAccMutual.rpt?dll=pdsactaccmutual.dll&" + "prompt0=" + oform.getLeaseDocument();
	} else if (actstate.equals("S")) {
		f = "MutactCalcReport.do?leaseDocument=" + oform.getLeaseDocument();
	} else {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.MUTACTS_EQUAL_REPORT);
		return mapping.findForward("main");
	}

	return new ActionForward(f, true);
}
}
