package com.hps.july.arenda.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.arenda.formbean.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * Действие для "начало платежей".
 * Creation date: (25.09.2002 10:43:01)
 * @author: Sergey Gourov
 */
public class ShowStartPaymentsListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseTaskStartAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.START_PAYMENTS_LIST);
		
		StartPaymentsListForm oform = (StartPaymentsListForm) form;
    	try {
	    	OperatorAccessBean bean = new OperatorAccessBean();
 	 		bean.setInitKey_operator(oform.getWorkercode().intValue());
 	 		bean.refreshCopyHelper();
 	 		oform.setWorkername(bean.getMan().getFullName());
	    } catch (Exception e) {
		    e.printStackTrace();
		    oform.setWorkercode(new Integer(0));
 	 		oform.setWorkername("");
    	}

		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
