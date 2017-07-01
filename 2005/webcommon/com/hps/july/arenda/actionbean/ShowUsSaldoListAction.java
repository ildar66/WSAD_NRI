package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.persistence.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.web.util.*;
/**
 * Action-class.
 * Действие для "Сальдо".
 * Creation date: (23.12.2002 10:25:12)
 * @author: Sergey Gourov
 */
public class ShowUsSaldoListAction extends BrowseAction {
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
		ParamsParser.setState(request, Applications.ARENDA, APPStates.US_SALDO_LIST);

		SaldoListForm oform = (SaldoListForm) form;
    	try {
 	 		LeaseContractAccessBean bean = new LeaseContractAccessBean();
 	 		bean.setInitKey_leaseDocument(oform.getLeaseContract());
 	 		bean.refreshCopyHelper();
			
 	 		oform.setDocumentNumber(bean.getDocumentNumber());
 	 		oform.setStartDate(bean.getStartDate());
 	 		oform.setEndDate(bean.getEndDate());
 	 		oform.setOrgCustomer(bean.getOrgCustomer().getName());
 	 		oform.setOrgExecutor(bean.getOrgExecutor().getName());
 	 		oform.setCurrency1(bean.getSumm1());
 	 		oform.setCurrency2(bean.getSumm2());
 	 		oform.setCurr1(bean.getCurrency1() != null ? bean.getCurrency1().getShortname() : "");
			oform.setCurr2(bean.getCurrency2() != null ? bean.getCurrency2().getShortname() : "");
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
