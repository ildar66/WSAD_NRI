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
 * Действие для "журнала актов"(лист).
 * Creation date: (10.01.2003 16:58:34)
 * @author: Sergey Gourov
 */
public class ShowJournalActListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (10.01.2003 16:58:35)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseTaskJournalAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.JOURNAL_ACT_LIST);
		
		JournalActListForm oform = (JournalActListForm) form;
		StartActListForm fromForm = (StartActListForm) request.getSession().getAttribute(oform.getListForm());
		oform.setActCode(fromForm.getActCode());
		oform.setActNumber(fromForm.getActNumber());
		oform.setActDate(fromForm.getActDate());
		oform.setActStartDate(fromForm.getActStartDate());
		oform.setActEndDate(fromForm.getActEndDate());
		
    	try {
			LeaseTaskStartAccessBean bean = new LeaseTaskStartAccessBean();
			bean.setInitKey_taskstart(oform.getTaskStart().intValue());
			bean.refreshCopyHelper();
			
 	 		oform.setTaskType(bean.getTasktype());
 	 		oform.setOperatorname(bean.getStartOperator().getMan().getFullName());
 	 		oform.setStartDate(bean.getStartdate());
 	 		oform.setEndDate(bean.getEnddate());
 	 	} catch (Exception e) {
		    e.printStackTrace();
 	 		oform.setTaskType("");
 	 		oform.setOperatorname("");
 	 		oform.setStartDate(null);
 	 		oform.setEndDate(null);
    	}
		
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
