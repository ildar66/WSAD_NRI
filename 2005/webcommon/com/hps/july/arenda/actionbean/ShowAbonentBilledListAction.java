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
 * действие для "список абонентских счетов"
 */
public class ShowAbonentBilledListAction extends com.hps.july.web.util.BrowseAction {
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseAbonentDNOPAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_BILLED_LIST);
		AbonentBilledListForm oform = (AbonentBilledListForm) form;
    	try {
 	 		AbonentBillAccessBean bean = new AbonentBillAccessBean();
 	 		bean.setInitKey_leasebill(oform.getLeaseBill());
 	 		bean.refreshCopyHelper();
 	 		oform.setBan(""+bean.getLeaseabonentban().getBan());
 	 		oform.setCustomername(bean.getLeaseabonentban().getOrgCustomer().getName());
 	 		oform.setCustomerinn(bean.getLeaseabonentban().getOrgCustomer().getInn());
 	 		oform.setCustomernameBill(bean.getLeaseabonentban().getBil_name());
 	 		oform.setCustomerinnBill(bean.getLeaseabonentban().getBil_inn());
 	 		oform.setBillDate(bean.getBilldate());
 	 		oform.setBillNumber(bean.getBillnumber());
 	 		AbonentBillValueObject vo = new AbonentBillValueObject(bean);
 	 		oform.setSum(vo.getSum());
 	 		oform.setSumnds(vo.getSumnds());
 	 		oform.setSumnsp(vo.getSumnsp());
	    } catch (Exception e) {
		    e.printStackTrace();
 	 	}
	    super.perform(mapping, form, request, response);	
		return mapping.findForward("main");
	}
}
