package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * Action-class.
 * Действие для "Поиск платежей".
 * Creation date: (27.01.2003 10:00:51)
 * @author: Sergey Gourov
 */
public class ShowPaymentLookupListAction extends com.hps.july.web.util.LookupBrowseAction {
	private int currencycode;
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	LeasePaymentAccessBean bean = (LeasePaymentAccessBean) o;
	LeasePaymentValueObject valueObject = new LeasePaymentValueObject(bean);

	try {
		if (bean.getPaymentType().equals("O")) {
			LeasePayOrderAccessBean lpoBean = new LeasePayOrderAccessBean();
			lpoBean.setInitKey_leaseDocPosition(bean.getLeaseDocPosition());
			lpoBean.refreshCopyHelper();
			
			//valueObject.setOrgExecutor(lpoBean.getOrgAcc().getOrganization());
			OrganizationNfsAccessBean orgNfs = new OrganizationNfsAccessBean();
			orgNfs.setInitKey_organization(lpoBean.getOrgAcc().getIdVendorSite().intValue());
			valueObject.setOrgExecutor(orgNfs);
			
			valueObject.setOrgAcc(lpoBean.getOrgAcc());
			valueObject.setPayPurpose(lpoBean.getPayPurpose());
			valueObject.setBillDate(lpoBean.getBillDate());
			valueObject.setBillNumber(lpoBean.getBillNumber());
			valueObject.setPptype(lpoBean.getPpType());
		} else {
			valueObject.setOrgExecutor(bean.getLeaseContract().getOrgExecutor());
			valueObject.setOrgAcc(null);
			valueObject.setPayPurpose("");
			valueObject.setBillDate(null);
			valueObject.setBillNumber("");
			valueObject.setPptype("");
		}
	} catch (Exception ex) {
		ex.printStackTrace();
		valueObject.setOrgExecutor(null);
		valueObject.setOrgAcc(null);
		valueObject.setPayPurpose("");
		valueObject.setBillDate(null);
		valueObject.setBillNumber("");
		valueObject.setPptype("");
	}

	try {
		LeaseCalcRateAccessBean lcrBean = new LeaseCalcRateAccessBean();
		lcrBean.setInitKey_docposition_leaseDocPosition(new Integer(bean.getLeaseDocPosition()));
		lcrBean.setInitKey_currency_currency(new Integer(currencycode));
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
 * Creation date: (27.01.2003 10:00:51)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeasePaymentAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.PAYMENT_LOOKUP);

		PaymentLookupListForm oform = (PaymentLookupListForm) form;
		currencycode = oform.getCurrencycode();
	    
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
