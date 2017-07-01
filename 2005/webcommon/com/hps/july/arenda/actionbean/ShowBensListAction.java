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
 * действие для "списка "BEN"-ов"
 */
public class ShowBensListAction extends BrowseAction {
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseAbonentBENAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.BENS_LIST);

		BensListForm oform = (BensListForm) form;
    	try {
	    	LeaseAbonentBANAccessBean ban = new LeaseAbonentBANAccessBean();
	    	ban.setInitKey_leaseDocument(oform.getLeaseDocument());
 	 		ban.refreshCopyHelper();

 	 		oform.setBan(ban.getDocumentNumber());
	    } catch (Exception e) {
		    e.printStackTrace();
 	 		oform.setBan("");
 	 	}
	  	
	    super.perform(mapping, form, request, response);	
		return mapping.findForward("main");
	}
}
