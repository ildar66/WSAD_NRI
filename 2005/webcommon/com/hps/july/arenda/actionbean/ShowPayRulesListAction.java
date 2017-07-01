package com.hps.july.arenda.actionbean;

import java.math.*;
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
 * Действие для "Правила платежа".
 * Creation date: (27.06.2002 17:15:17)
 * @author: Sergey Gourov
 */
public class ShowPayRulesListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 17:15:17)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeasePayRuleAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.PAY_RULES_LIST);

		PayRulesListForm oform = (PayRulesListForm) form;
    	try {
 	 		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
 	 		bean.setInitKey_leaseDocument(oform.getLeaseDocument());
 	 		bean.refreshCopyHelper();
 	 		
 	 		oform.setDocumentNumber(bean.getDocumentNumber());
 	 		oform.setStateOfContract(bean.getContractState());
 	 		oform.setStartDate(bean.getStartDate());
 	 		oform.setEndDate(bean.getEndDate());
 	 		oform.setOrgCustomer(bean.getOrgCustomer().getName());
 	 		oform.setOrgExecutor(bean.getOrgExecutor().getName());
 	 		oform.setOrgExecutorcode(bean.getOrgExecutor().getOrganization());
 	 		oform.setCurrency1(bean.getSumm1());
 	 		oform.setCurrency2(bean.getSumm2());
 	 		oform.setCurr1(bean.getCurrency1().getShortname());
 	 		oform.setCurrencyCode1(new Integer(bean.getCurrency1().getCurrency()));
 	 		if (bean.getCurrency2() != null) {
	 	 		oform.setCurr2(bean.getCurrency2().getShortname());
 	 		} else {
	 	 		oform.setCurr2("");
 	 		}
 	 		oform.setRateCalcRule(bean.getRatecalcrule());
 	 		oform.setRateCalcRuleDay(bean.getRatecalcruleday());
 	 		oform.setRateDelta(bean.getRatedelta());
	    } catch (Exception e) {
		    e.printStackTrace();
 	 		oform.setDocumentNumber("");
 	 		oform.setStateOfContract("");
 	 		oform.setStartDate(null);
 	 		oform.setEndDate(null);
 	 		oform.setOrgCustomer("");
 	 		oform.setOrgExecutor("");
 	 		oform.setOrgExecutorcode(0);
 	 		oform.setCurrency1(null);
 	 		oform.setCurrency2(null);
 	 		oform.setCurrencyCode1(null);
 	 		oform.setCurr1("");
 	 		oform.setCurr2("");
 	 		oform.setRateCalcRule("");
 	 		oform.setRateCalcRuleDay(null);
 	 		oform.setRateDelta(null);
    	}

		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
