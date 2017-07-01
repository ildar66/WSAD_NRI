package com.hps.july.arenda.actionbean;

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
 * Действие для "истории"(лист).
 * Creation date: (09.07.2002 10:25:49)
 * @author: Sergey Gourov
 */
public class ShowHistoryListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 10:25:50)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	//return "com.hps.july.arenda.formbean.HistoryListForm";
	//return "com.hps.july.persistence.LeaseArendaAgreementAccessBean";
	return "com.hps.july.cdbc.objects.CDBCArendaAgreementObject";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.HISTORY_LIST);

		HistoryListForm oform = (HistoryListForm) form;
    	try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
 	 		bean.setInitKey_leaseDocument(oform.getLeaseDocument());
 	 		bean.refreshCopyHelper();

			if (bean.getMainDocument() != null) {
				int leaseDocument = bean.getMainDocument().intValue();
				bean = new LeaseArendaAgreementNewAccessBean();
				bean.setInitKey_leaseDocument(leaseDocument);
 	 			bean.refreshCopyHelper();
			}

			oform.setDocNumber(bean.getDocumentNumber());
			oform.setStateOfContract(bean.getContractState());
			oform.setCustomer(bean.getOrgCustomer().getName());
			oform.setCustomercode(new Integer(bean.getOrgCustomer().getOrganization()));
 	 		oform.setExecutor(bean.getOrgExecutor().getName());
 	 		oform.setExecutorcode(new Integer(bean.getOrgExecutor().getOrganization()));
	    } catch (Exception e) {
		    e.printStackTrace();
			oform.setDocNumber("");
			oform.setStateOfContract("");
			oform.setCustomer("");
			oform.setCustomercode(null);
 	 		oform.setExecutor("");
 	 		oform.setExecutorcode(null);
    	}

		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
