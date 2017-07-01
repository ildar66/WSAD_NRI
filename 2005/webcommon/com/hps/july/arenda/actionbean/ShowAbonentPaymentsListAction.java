package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.*;
/**
 * Action-class.
 * действие для "список платежей"
 * Creation date: (12.06.2003 12:21:02)
 * @author: Sergey Gourov
 */
public class ShowAbonentPaymentsListAction extends com.hps.july.web.util.BrowseAction {
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
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeasePaymentAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_PAYMENTS_LIST);

		AbonentPaymentsListForm oform = (AbonentPaymentsListForm) form;
    	try {
 	 		LeaseAbonentBANAccessBean bean = new LeaseAbonentBANAccessBean();
 	 		bean.setInitKey_leaseDocument(oform.getLeaseContract());
 	 		bean.refreshCopyHelper();

 	 		oform.setDocumentNumber(bean.getDocumentNumber());
 	 		oform.setDocumentDate(bean.getDocumentDate());
 	 		oform.setStateOfContract(bean.getContractState());
 	 		oform.setStartDate(bean.getStartDate());
 	 		oform.setEndDate(bean.getEndDate());
 	 		oform.setOrgCustomer(bean.getOrgCustomer().getName());
 	 		oform.setOrgExecutor(bean.getOrgExecutor().getName());
			oform.setOrgExecutorcode(bean.getOrgExecutor().getOrganization());
 	 		oform.setCurrency1(bean.getSumm1());
 	 		oform.setCurrency2(bean.getSumm2());
 	 		if(bean.getCurrency1() != null) {
	 	 		oform.setCurr1(bean.getCurrency1().getShortname());
 	 		}
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
 	 		oform.setOrgExecutor("");
 	 		oform.setOrgExecutorcode(0);
 	 		oform.setCurrency1(null);
 	 		oform.setCurrency2(null);
 	 		oform.setCurr1("");
 	 		oform.setCurr2("");
    	}
	    
		super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
