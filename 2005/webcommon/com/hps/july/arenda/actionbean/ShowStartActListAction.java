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
 * Действие для "начало акта".
 * Creation date: (10.01.2003 16:42:32)
 * @author: Sergey Gourov
 */
public class ShowStartActListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (10.01.2003 16:42:32)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseTaskStartAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.START_ACT_LIST);

		StartActListForm oform = (StartActListForm) form;
    	try {
			LeaseMutualActNewAccessBean bean = new LeaseMutualActNewAccessBean();
			bean.setInitKey_leaseDocument(oform.getDocument().intValue());
 	 		bean.refreshCopyHelper();
			
 	 		oform.setActCode(bean.getLeaseDocument());
			oform.setActNumber(bean.getDocumentNumber());
			oform.setActDate(bean.getDocumentDate());
			oform.setActStartDate(bean.getActstartdate());
			oform.setActEndDate(bean.getActenddate());
 	 	} catch (Exception e) {
		    e.printStackTrace();
 	 		oform.setActCode(0);
			oform.setActNumber("");
			oform.setActDate(null);
			oform.setActStartDate(null);
			oform.setActEndDate(null);
    	}
		
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
