package com.hps.july.arenda.actionbean;

import javax.transaction.*;
import javax.naming.*;
import java.math.*;
import java.util.*;
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
 * Creation date: (07.10.2002 16:23:09)
 * @author: Sergey Gourov
 */
public class ShowAbonentPayedListAction extends com.hps.july.web.util.BrowseAction {
public Object constructRowModelBean(Object o) {
	LeaseAbonentDNOPAccessBean bean = (LeaseAbonentDNOPAccessBean) o;
	AbonentBilledValue valueObject = new AbonentBilledValue(bean);
	valueObject.setBillsumm(new BigDecimal(0));
	
	try {
		Enumeration e = new AbonentBillPosAccessBean().findByLeaseBill(new Integer(bean.getAbonentbillKey().leasebill));
		while (e.hasMoreElements()) {
			AbonentBillPosAccessBean abpBean = (AbonentBillPosAccessBean) e.nextElement();
			valueObject.setBillsumm(valueObject.getBillsumm().add(abpBean.getSumm()));
		}
	} catch (Exception ex) {
		ex.printStackTrace();
		valueObject.setBillsumm(new BigDecimal(0));
	}
	
	return valueObject;
}
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseAbonentDNOPAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_PAYED_LIST);

		AbonentPayedListForm oform = (AbonentPayedListForm) form;
    	try {
 	 		AbonentPaymentAccessBean bean = new AbonentPaymentAccessBean();
 	 		bean.setInitKey_paypos(oform.getPay());
 	 		bean.refreshCopyHelper();
 	 		oform.setPaydate(bean.getPaydate());
 	 		oform.setPaynumber(bean.getPaynumber());
 	 		oform.setPaysumm(bean.getSumpayusd());
 	 		oform.setPaytype(bean.getTypename());
 	 		AbonentForm aform = (AbonentForm)request.getSession().getAttribute("AbonentForm");
 	 		oform.setBan(aform.getBanFrm());
 	 		oform.setCustomername(aform.getOrgCustomername());
 	 		oform.setCustomerinn(aform.getOrgCustomerInn());
 	 		oform.setCustomernameBill(aform.getBil_contrstname());
 	 		oform.setCustomerinnBill(aform.getBil_inn());
	    } catch (Exception e) {
		    e.printStackTrace();
 	 	}
	  	
	    super.perform(mapping, form, request, response);	
		return mapping.findForward("main");
	}
}
