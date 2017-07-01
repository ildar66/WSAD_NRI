package com.hps.july.arenda.actionbean;

import java.util.Hashtable;
import com.hps.july.arenda.valueobject.*;
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
 * �������� ��� "�����������(����)".
 * Creation date: (11.07.2002 10:13:53)
 * @author: Sergey Gourov
 */
public class ShowContractsMutReglmntListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	LeaseMutualContractsAccessBean bean = (LeaseMutualContractsAccessBean) o;
	LeaseMutualContractsValueObject valueObject = new LeaseMutualContractsValueObject(bean);
	
	try {
		Hashtable hashtable = new Hashtable(2);
		hashtable.put("contractcode", new Integer(bean.getContractKey().leaseDocument));
		hashtable.put("resourcecode", new Integer(bean.getResourceKey().resource));
		valueObject.setParams(hashtable);
	} catch (Exception ex) {
		ex.printStackTrace();
		valueObject.setParams(new Hashtable(2));
	}
	
	return valueObject;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 10:13:53)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.persistence.LeaseMutualContractsAccessBean";
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState( request, Applications.ARENDA, APPStates.CONTRACTS_MUTREGLMNT_LIST );

		ContractsMutReglmntListForm oform = (ContractsMutReglmntListForm) form;
    	try {
 	 		LeaseMutualReglamentAccessBean bean = new LeaseMutualReglamentAccessBean();
 	 		bean.setInitKey_leaseDocument(oform.getMainLeaseDocument());
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
