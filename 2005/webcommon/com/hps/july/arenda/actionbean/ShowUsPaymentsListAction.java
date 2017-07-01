package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.valueobject.*;
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
 * Действие для "платежи".
 * Creation date: (08.08.2002 18:13:46)
 * @author: Sergey Gourov
 */
public class ShowUsPaymentsListAction extends BrowseAction {
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
	
	return valueObject;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 17:15:17)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeasePaymentAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.US_PAYMENTS_LIST);
		
		PaymentsListForm oform = (PaymentsListForm) form;
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
 	 		//oform.setOrgCustomercode(bean.getOrgCustomer().getOrganization());
 	 		oform.setOrgExecutor(bean.getOrgExecutor().getName());
 	 		oform.setCurrency1(bean.getSumm1());
 	 		oform.setCurrency2(bean.getSumm2());
 	 		oform.setCurr1(bean.getCurrency1().getShortname());
 	 		if (bean.getCurrency2() != null) {
	 	 		oform.setCurr2(bean.getCurrency2().getShortname());
 	 		} else {
	 	 		oform.setCurr2("");
 	 		}
 	 	} catch (Exception e) {
		    e.printStackTrace();
 	 		oform.setDocumentNumber("");
 	 		oform.setDocumentDate(null);
 	 		oform.setStateOfContract("");
 	 		oform.setStartDate(null);
 	 		oform.setEndDate(null);
 	 		oform.setOrgCustomer("");
 	 		//oform.setOrgCustomercode(0);
 	 		oform.setOrgExecutor("");
 	 		oform.setCurrency1(null);
 	 		oform.setCurrency2(null);
 	 		oform.setCurr1("");
 	 		oform.setCurr2("");
    	}
		
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
