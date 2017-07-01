package com.hps.july.arenda.actionbean;

import java.sql.*;
import com.hps.july.persistence.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * Действие для "Журнал платежей"(лист).
 * Creation date: (26.09.2002 11:55:01)
 * @author: Sergey Gourov
 */
public class ShowJournalPaymentsListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 11:55:01)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseTaskJournalAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.JOURNAL_PAYMENTS_LIST);
		
		JournalPaymentsListForm oform = (JournalPaymentsListForm) form;
    	try {
 	 		LeaseTaskStartAccessBean bean = new LeaseTaskStartAccessBean();
 	 		bean.setInitKey_taskstart(oform.getTaskStartcode());
 	 		bean.refreshCopyHelper();
 	 		
 	 		oform.setFirstDate(bean.getDate1());
			oform.setSecondDate(bean.getDate2());
			oform.setStartDate(new Date(bean.getStartdate().getTime()));
			if (bean.getEnddate() != null) {
				oform.setEndDate(new Date(bean.getEnddate().getTime()));
			}
			oform.setOperatorname(bean.getStartOperator().getMan().getFullName());
	    } catch (Exception e) {
		    e.printStackTrace();
 	 		oform.setFirstDate(null);
			oform.setSecondDate(null);
			oform.setStartDate(null);
			oform.setEndDate(null);
			oform.setOperatorname("");
    	}
		
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
