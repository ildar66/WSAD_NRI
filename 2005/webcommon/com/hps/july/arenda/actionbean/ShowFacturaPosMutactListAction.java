package com.hps.july.arenda.actionbean;

import java.math.*;
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
 * действие для "позиций фактур акта".
 * Creation date: (25.05.2003 15:19:21)
 * @author: Sergey Gourov
 */
public class ShowFacturaPosMutactListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (25.05.2003 15:19:21)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeasePosSchetFaktAccessBean";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.FACTURA_POS_MUTACT_LIST);
	
	FacturaPosMutactList oform = (FacturaPosMutactList) form;
	try {
		LeaseSchetFaktAccessBean bean = new LeaseSchetFaktAccessBean();
		bean.setInitKey_idSchetFakt(oform.getIdSchetFact());
		bean.refreshCopyHelper();
		
		oform.setNumberSchetFakt(bean.getNumberSchetFakt());
		oform.setDateSchetFakt(bean.getDateSchetFakt());
		oform.setExecutor(bean.getIdContract().getOrgExecutor().getName());
		oform.setCustomer(bean.getIdContract().getOrgCustomer().getName());
		oform.setSum(new BigDecimal(0));
		
		java.util.Enumeration e = new LeasePosSchetFaktAccessBean().findByIdSchetFaktOrderByPosorderAsc(new Integer(oform.getIdSchetFact()));
		while (e.hasMoreElements()) {
			LeasePosSchetFaktAccessBean lpsfBean = (LeasePosSchetFaktAccessBean) e.nextElement();
			if (lpsfBean.getSumWithTax() != null) {
				oform.setSum(oform.getSum().add(lpsfBean.getSumWithTax()));
			}
		}
		
		oform.setCurrency(bean.getIdCurrency().getShortname());
	} catch (Exception e) {
		e.printStackTrace();
		oform.setNumberSchetFakt("");
		oform.setDateSchetFakt(null);
		oform.setExecutor("");
		oform.setCustomer("");
		oform.setCurrency("");
	}

	super.perform(mapping, form, request, response);
	return mapping.findForward("main");
}
}
