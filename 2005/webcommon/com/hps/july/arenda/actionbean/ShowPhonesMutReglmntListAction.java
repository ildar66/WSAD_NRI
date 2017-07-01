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
 * �������� ��� "����������(��������)".
 * Creation date: (10.07.2002 12:07:32)
 * @author: Sergey Gourov
 */
public class ShowPhonesMutReglmntListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:07:32)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseMutualPhoneAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState( request, Applications.ARENDA, APPStates.PHONES_MUTREGLMNT_LIST );

		PhonesMutReglmntListForm oform = (PhonesMutReglmntListForm) form;
    	try {
 	 		LeaseMutualReglamentAccessBean bean = new LeaseMutualReglamentAccessBean();
 	 		bean.setInitKey_leaseDocument(oform.getLeaseDocument());
 	 		bean.refreshCopyHelper();
 	 		
 	 		oform.setDocumentNumber(bean.getDocumentNumber());
			oform.setDocumentDate(bean.getDocumentDate());
			oform.setMutualPeriod(bean.getMutualPeriod());
			oform.setCommonRate(bean.getCommonRate());
			oform.setActType(bean.getActType());
			oform.setCalcRateType(bean.getCalcRateType());
			oform.setMainCurrency(bean.getMaincurrency().getName());
			if (bean.getAdditionalCurrency() != null) {
				oform.setAdditionalCurrency(bean.getAdditionalCurrency().getName());
			} else {
				oform.setAdditionalCurrency(null);
			}
			oform.setState(bean.getMutState());
	    } catch (Exception e) {
		    e.printStackTrace();
 	 		oform.setDocumentNumber("");
			oform.setDocumentDate(null);
			oform.setMutualPeriod("");
			oform.setCommonRate(null);
			oform.setActType("");
			oform.setCalcRateType("");
			oform.setMainCurrency("");
			oform.setAdditionalCurrency(null);
			oform.setState("");
    	}
			
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
