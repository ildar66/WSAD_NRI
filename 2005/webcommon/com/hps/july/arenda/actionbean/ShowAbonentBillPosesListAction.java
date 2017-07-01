package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.valueobject.AbonentBillValueObject;
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
 * действие для "список позиций абонентских счетов"
 * Creation date: (08.10.2002 14:09:56)
 * @author: Sergey Gourov
 */
public class ShowAbonentBillPosesListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (08.10.2002 14:09:56)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.AbonentBillPosAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  	ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_BILL_POSES_LIST);

		AbonentBillPosesListForm oform = (AbonentBillPosesListForm) form;
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
 	 		oform.setFlagworknri(bean.getFlagworknri());
 	 		oform.setContractState(bean.getLeaseabonentban().getContractState());
 	 		oform.setUseallben(bean.getLeaseabonentban().getUseallben());
 	 		
 	 		AbonentBillValueObject vo = new AbonentBillValueObject(bean);
 	 		oform.setSum(vo.getNrisum());
 	 		oform.setSumnds(vo.getNrisumnds());
 	 		oform.setSumnsp(vo.getNrisumnsp());

 	 		com.hps.july.arenda.valueobject.LeaseAbonentBANValue labvo = new com.hps.july.arenda.valueobject.LeaseAbonentBANValue(bean.getLeaseabonentban());
 	 		oform.setBensList(labvo.getBens());
 	 		oform.initCurrencyVO(labvo.getO());
 	 		
	    } catch (Exception e) {
		    e.printStackTrace();
 	 		oform.setBan("");
 	 		oform.setCustomername("");
 	 		oform.setCustomerinn("");
 	 		oform.setCustomernameBill("");
 	 		oform.setCustomerinnBill("");
 	 		oform.setBillDate(null);
 	 		oform.setBillNumber("");
 	 		oform.setFlagworknri(false);
 	 		oform.setUseallben(false);
 	 	}
	  	
	    super.perform(mapping, form, request, response);	
		return mapping.findForward("main");
	}
}
