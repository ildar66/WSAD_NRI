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
/**
 * Action-class.
 * действие для "Оплаты начислений"  
 */
public class ShowChargeDnopListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	LeaseDNOPAccessBean bean = (LeaseDNOPAccessBean) o;
	LeaseDNOPValueObject valueObject = new LeaseDNOPValueObject(bean);
	
	try {
		LeaseCalcRateAccessBean lcrBean = new LeaseCalcRateAccessBean();
		lcrBean.setInitKey_currency_currency(new Integer(bean.getLeaseCharge().getCurrencyKey().currency));
		lcrBean.setInitKey_docposition_leaseDocPosition(new Integer(bean.getLeasePaymentKey().leaseDocPosition));
		lcrBean.refreshCopyHelper();
		
		valueObject.setRate(lcrBean.getRate());
	} catch (Exception e) {
		e.printStackTrace();
		valueObject.setRate(null);
	}
	
	return valueObject;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 14:23:58)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseDNOPAccessBean";
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
		ParamsParser.setState(request, Applications.ARENDA, APPStates.CHARGE_DNOP_LIST);
		
		ChargeDnopListForm oform = (ChargeDnopListForm) form;

		/*
		ChargesListForm chargeListForm = (ChargesListForm) request.getSession().getAttribute(getListForm());
		oform.setDocumentNumber(chargeListForm.getDocumentNumber());
		oform.setStartDate(chargeListForm.getStartDate());
		oform.setEndDate(chargeListForm.getEndDate());
		oform.setOrgCustomer(chargeListForm.getOrgCustomer());
		oform.setOrgExecutor(chargeListForm.getOrgExecutor());
		oform.setCurrency1(chargeListForm.getCurrency1());
		oform.setCurrency2(chargeListForm.getCurrency2());
		oform.setCurr1(chargeListForm.getCurr1());
		oform.setCurr2(chargeListForm.getCurr2());
		*/

		try {
			LeaseChargesAccessBean abean = new LeaseChargesAccessBean();
			abean.setInitKey_leaseDocPosition(oform.getLeaseDocPosition());
			abean.refreshCopyHelper();
			try {
				LeaseContractAccessBean cbean = abean.getLeaseContract();
				
				oform.setDocumentNumber(cbean.getDocumentNumber());
				oform.setStartDate(cbean.getStartDate());
				oform.setEndDate(cbean.getEndDate());
				if (cbean.getOrgCustomer() != null)
					oform.setOrgCustomer(cbean.getOrgCustomer().getName());
				if (cbean.getOrgExecutor() != null)
					oform.setOrgExecutor(cbean.getOrgExecutor().getName());
				if (cbean.getCurrency1() != null) {
					oform.setCurrency1(cbean.getSumm1());
					oform.setCurr1(cbean.getCurrency1().getShortname());
				}
				if (cbean.getCurrency2() != null) {
					oform.setCurrency2(cbean.getSumm2());
					oform.setCurr2(cbean.getCurrency2().getShortname());
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			oform.setChargedate(abean.getDate());
			oform.setResourcename(abean.getResource().getName());
			oform.setSum(abean.getSumm());
			oform.setChargecurrency(abean.getCurrency().getShortname());
			oform.setNotremaindersum(abean.getSumm().subtract(abean.getRemaindersum()));
			oform.setRemaindersum(abean.getRemaindersum());
			oform.setRemainderratetorur(abean.getRemainderrate2rur());
			oform.setChargeBeginDate(abean.getBegindate());
			oform.setChargeEndDate(abean.getEnddate());
		} catch (Exception e) {
			e.printStackTrace();
			oform.setChargedate(null);
			oform.setResourcename("");
			oform.setSum(null);
			oform.setChargecurrency("");
			oform.setNotremaindersum(null);
			oform.setRemaindersum(null);
			oform.setRemainderratetorur(null);
			oform.setChargeBeginDate(null);
			oform.setChargeEndDate(null);
		}
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
