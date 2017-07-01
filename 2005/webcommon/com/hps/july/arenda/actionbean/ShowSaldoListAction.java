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
 * Äויסעגטו הכÿ "סאכüהמ".
 * Creation date: (23.12.2002 10:12:18)
 * @author: Sergey Gourov
 */
public class ShowSaldoListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	LeaseSaldoAccessBean bean = (LeaseSaldoAccessBean) o;
	LeaseSaldoValueObject valueObject = new LeaseSaldoValueObject(bean);

	try {
		java.util.Hashtable h = new java.util.Hashtable(2);
		h.put("resourcecode", new Integer(bean.getResource().getResource()));
		StringAndSqlDateProperty date = new StringAndSqlDateProperty();
		date.setSqlDate(bean.getSalDate());
		h.put("salDateFrm", date.getString());
		valueObject.setParams(h);
	} catch (Exception e) {
		e.printStackTrace();
		valueObject.setParams(new java.util.Hashtable());
	}
	
	return valueObject;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 10:12:18)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseSaldoAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.SALDO_LIST);

		SaldoListForm oform = (SaldoListForm) form;
    	try {
 	 		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
 	 		bean.setInitKey_leaseDocument(oform.getLeaseContract());
 	 		bean.refreshCopyHelper();
			
			if (bean.getMainDocument() != null) {
				oform.setLeaseContract(bean.getMainDocument().intValue());
				bean = new LeaseArendaAgreementNewAccessBean();
				bean.setInitKey_leaseDocument(oform.getLeaseContract());
				bean.refreshCopyHelper();
 	 		}
			
 	 		oform.setDocumentNumber(bean.getDocumentNumber());
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
 	 	} catch (Exception e) {
		    e.printStackTrace();
 	 		oform.setDocumentNumber("");
 	 		oform.setStartDate(null);
 	 		oform.setEndDate(null);
 	 		oform.setOrgCustomer("");
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
