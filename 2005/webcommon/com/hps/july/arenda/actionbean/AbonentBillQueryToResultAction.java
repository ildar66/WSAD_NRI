package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.billing.*;
import com.hps.july.arenda.sessionbean.*;
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
 * "Запрос абонентских счетов(к результату)"
 * Creation date: (15.04.2003 17:34:55)
 * @author: Sergey Gourov
 */
public class AbonentBillQueryToResultAction extends NavigatedAction {
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ResultForm resultForm = (ResultForm) form;
	resultForm.setIsSuccess(new Boolean(false));
	
	try {
		Pie2NriAccessBean processor = new Pie2NriAccessBean();
		int idtask = processor.taskStart(1, "6");	
		if (processor.moveAllNri2PIE(idtask)) {
			resultForm.setIsSuccess(new Boolean(true));
		}
		processor.taskEnd(idtask);
	} catch(Exception e) {
		e.printStackTrace();
	}
		
	ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_BILL_QUERY_TO_RESULT);
	return mapping.findForward("main");
}
}
