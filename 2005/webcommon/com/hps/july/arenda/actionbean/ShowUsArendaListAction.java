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
 * Действие для "у нас арендуют".
 * Creation date: (02.07.2002 15:35:43)
 * @author: Sergey Gourov
 */
public class ShowUsArendaListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:35:43)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseContractAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.US_ARENDA_LIST);

		UsArendaListForm oform = (UsArendaListForm) form;
    	try {
 	 		OrganizationAccessBean bean = new OrganizationAccessBean();
 	 		bean.setInitKey_organization(oform.getCustomercode().intValue());
 	 		bean.refreshCopyHelper();
 	 		if (bean.getBank().booleanValue()) {
			    oform.setCustomercode(new Integer(0));
 		 		oform.setCustomername("");
 	 		} else {
	 	 		oform.setCustomername(bean.getName());
 	 		}
	    } catch (Exception e) {
		    e.printStackTrace();
		    oform.setCustomercode(new Integer(0));
 	 		oform.setCustomername("");
    	}

	    try {
 	 		WorkerAccessBean beanWorker = new WorkerAccessBean();
 	 		beanWorker.setInitKey_worker(oform.getEconomistcode().intValue());
 	 		beanWorker.refreshCopyHelper();
 	 		oform.setEconomistname(beanWorker.getMan().getFullName());
	    } catch (Exception e) {
		    e.printStackTrace();
		    oform.setEconomistcode(new Integer(0));
 	 		oform.setEconomistname("");
    	}

	    super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
