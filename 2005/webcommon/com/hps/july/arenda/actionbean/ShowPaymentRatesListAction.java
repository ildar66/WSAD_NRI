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
 * Действие для "Ставки платежей".
 * Creation date: (09.01.2003 15:56:26)
 * @author: Sergey Gourov
 */
public class ShowPaymentRatesListAction extends com.hps.july.web.util.BrowseAction {
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
		LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
		lpBean.setInitKey_leaseDocPosition(bean.getDocpositionKey().leaseDocPosition);
		lpBean.refreshCopyHelper();

		if(bean.getRate() != null && bean.getRate().doubleValue() != 0.0d && lpBean.getSumRub() != null) {
			valueObject.setSum(lpBean.getSumRub().divide(bean.getRate(), 2, BigDecimal.ROUND_HALF_UP));
		} else {
			valueObject.setSum(null);
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("PAY_RATE_L.ROW: Exception("+e.getClass().getName()+")");
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
 * Creation date: (22.01.2003 17:24:14)
 * @return java.lang.String
 */
protected String getListForm() {
	return "PaymentsListForm";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.PAYMENT_RATES_LIST);

		PaymentRatesListForm oform = (PaymentRatesListForm) form;
		/*
		PaymentsListForm payListForm = (PaymentsListForm) request.getSession().getAttribute(getListForm());
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
			LeasePaymentAccessBean bean = new LeasePaymentAccessBean();
			bean.setInitKey_leaseDocPosition(oform.getDocpositioncode());
			bean.refreshCopyHelper();

			oform.setDocumentNumber(bean.getDocNumber());

			oform.setUsedinact(bean.getUsedinact() != null);

			if(bean.getLeaseContract() != null) {
				LeaseArendaAgreementNewAccessBean lbean = new LeaseArendaAgreementNewAccessBean();
				lbean.setInitKey_leaseDocument(bean.getLeaseContract().getLeaseDocument());
				lbean.refreshCopyHelper();

				oform.setStartDate(lbean.getStartDate());
				oform.setEndDate(lbean.getEndDate());
				if(lbean.getOrgCustomer() != null) {
					oform.setOrgCustomer(lbean.getOrgCustomer().getName());
				} else {
					oform.setOrgCustomer("");
				}
				if(lbean.getOrgExecutor() != null) {
					oform.setOrgExecutor(lbean.getOrgExecutor().getName());
				} else {
					oform.setOrgExecutor("");
				}
				oform.setCurrency1(lbean.getSumm1());
				oform.setCurrency2(lbean.getSumm2());
				if(lbean.getCurrency1() != null) {
					oform.setCurr1(lbean.getCurrency1().getShortname());
				} else {
					oform.setCurr1("");
				}
				if(lbean.getCurrency2() != null) {
					oform.setCurr2(lbean.getCurrency2().getShortname());
				} else {
					oform.setCurr2("");
				}
			}

			oform.setSumrub(bean.getSumRub());
			oform.setSum(bean.getSumm());
			oform.setPaycurrency(bean.getCurrency().getShortname());
			oform.setPayrate(bean.getPayrate());
			oform.setPaymentState(bean.getPaymentstate());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			oform.setSumrub(null);
			oform.setSum(null);
			oform.setPaycurrency("");
			oform.setPayrate(null);
			oform.setPaymentState("");
		}
		
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
