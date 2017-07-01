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
 * действие для канала "начислений"(лист) 
 * Creation date: (08.08.2002 18:21:52)
 * @author: Sergey Gourov
 */
public class ShowChannelChargesListAction extends BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 17:15:17)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseChargesAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.CHANNEL_CHARGES_LIST);
		
		ChannelChargesListForm oform = (ChannelChargesListForm) form;
    	try {
 	 		LeaseContractAccessBean bean = new LeaseContractAccessBean();
 	 		bean.setInitKey_leaseDocument(oform.getLeaseContract());
 	 		bean.refreshCopyHelper();
 	 		
 	 		oform.setDocumentNumber(bean.getDocumentNumber());
 	 		oform.setDocumentDate(bean.getDocumentDate());
 	 		oform.setStateOfContract(bean.getContractState());
 	 		oform.setStartDate(bean.getStartDate());
 	 		oform.setEndDate(bean.getEndDate());
 	 		oform.setOrgCustomer(bean.getOrgCustomer().getName());
 	 		oform.setOrgExecutor(bean.getOrgExecutor().getName());
 	 		oform.setCurrency1(bean.getSumm1());
 	 		oform.setCurrency2(bean.getSumm2());
 	 		oform.setCurr1(bean.getCurrency1().getShortname());
 	 		if (bean.getCurrency2() != null) {
	 	 		oform.setCurr2(bean.getCurrency2().getShortname());
 	 		} else {
	 	 		oform.setCurr2("");
 	 		}
 	 		oform.setOrgCustomercode(new Integer(bean.getOrgCustomer().getOrganization()));
 	 		oform.setOrgExecutorcode(new Integer(bean.getOrgExecutor().getOrganization()));
	    } catch (Exception e) {
		    e.printStackTrace();
 	 		oform.setDocumentNumber("");
 	 		oform.setDocumentDate(null);
 	 		oform.setStateOfContract("");
 	 		oform.setStartDate(null);
 	 		oform.setEndDate(null);
 	 		oform.setOrgCustomer("");
 	 		oform.setOrgExecutor("");
 	 		oform.setCurrency1(null);
 	 		oform.setCurrency2(null);
 	 		oform.setCurr1("");
 	 		oform.setCurr2("");
 	 		oform.setOrgCustomercode(null);
 	 		oform.setOrgExecutorcode(null);
    	}
		
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
