package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.arenda.formbean.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.math.*;
/**
 * Action-class.
 * действие для "ставок начислений(лист)"  
 * Creation date: (09.01.2003 15:56:26)
 * @author: Sergey Gourov
 */
public class ShowChargeRatesListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	LeaseCalcRateAccessBean bean = (LeaseCalcRateAccessBean) o;
	LeaseCalcRateValueObject valueObject = new LeaseCalcRateValueObject(bean);
	
	try {
		LeaseChargesAccessBean lcBean = new LeaseChargesAccessBean();
		lcBean.setInitKey_leaseDocPosition(bean.getDocpositionKey().leaseDocPosition);
		lcBean.refreshCopyHelper();
		
		valueObject.setSum(lcBean.getSumm().multiply(bean.getRate()).setScale(2, BigDecimal.ROUND_HALF_UP));
	} catch (Exception e) {
		e.printStackTrace();
		valueObject.setSum(null);
	}
	
	return valueObject;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 15:56:26)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseCalcRateAccessBean";
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 17:31:34)
 * @return java.lang.String
 */
protected String getListForm() {
	return "ChargesListForm";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.CHARGE_RATES_LIST);

			
		ChargeRatesListForm oform = (ChargeRatesListForm) form;

		/*
		ChargesListForm payListForm = (ChargesListForm) request.getSession().getAttribute(getListForm());
		oform.setDocumentNumber(payListForm.getDocumentNumber());
		oform.setStartDate(payListForm.getStartDate());
		oform.setEndDate(payListForm.getEndDate());
		oform.setOrgCustomer(payListForm.getOrgCustomer());
		oform.setOrgExecutor(payListForm.getOrgExecutor());
		oform.setCurrency1(payListForm.getCurrency1());
		oform.setCurrency2(payListForm.getCurrency2());
		oform.setCurr1(payListForm.getCurr1());
		oform.setCurr2(payListForm.getCurr2());
		*/

		try {
			LeaseChargesAccessBean bean = new LeaseChargesAccessBean();
			bean.setInitKey_leaseDocPosition(oform.getDocpositioncode());
			bean.refreshCopyHelper();

			oform.setChargedate(bean.getDate());
			oform.setResourcename(bean.getResource().getName());
			oform.setSum(bean.getSumm());
			oform.setChargecurrency(bean.getCurrency().getShortname());

			// Fill header fields
			LeaseContractAccessBean acontr = bean.getLeaseContract();
			oform.setDocumentNumber(acontr.getDocumentNumber());
			oform.setStartDate(acontr.getStartDate());
			oform.setEndDate(acontr.getEndDate());
			if (acontr.getOrgCustomer() != null)
				oform.setOrgCustomer(acontr.getOrgCustomer().getName());
			if (acontr.getOrgExecutor() != null)
				oform.setOrgExecutor(acontr.getOrgExecutor().getName());
			if (acontr.getCurrency1() != null) {
				oform.setCurrency1(acontr.getSumm1());
				oform.setCurr1(acontr.getCurrency1().getShortname());
			}
			if (acontr.getCurrency2() != null) {
				oform.setCurrency2(acontr.getSumm2());
				oform.setCurr2(acontr.getCurrency2().getShortname());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			oform.setChargedate(null);
			oform.setResourcename("");
			oform.setSum(null);
			oform.setChargecurrency("");
		}
		
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
