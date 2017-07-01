/*
 * Created on 22.05.2006
 *
 * Список доп.соглашений договора аренды(Lookup).
 * Логика перенесена из ShowHistoryListAction
 */
package com.hps.july.arenda.formbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.constants.Applications;
import com.hps.july.logic.DocumentLogic;
import com.hps.july.persistence.LeaseArendaAgreementNewAccessBean;
import com.hps.july.web.util.ParamsParser;

/**
 * @author IShaffigulin
 *
 * Список доп.соглашений договора аренды(Lookup).
 * Логика перенесена из ShowHistoryListAction
 */
public class HistoryLookupListForm extends HistoryListForm {
	private java.lang.String formname;
	private java.lang.String fieldnames;
	
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, com.hps.july.arenda.APPStates.HISTORY_LOOKUP_LIST);
		//Логика перенесена из ShowHistoryListAction:
		//System.out.println("HistoryLookupListForm.init"); //tmp
		//HistoryListForm oform = (HistoryListForm) form;
		try {
/**			
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(getLeaseDocument());
			bean.refreshCopyHelper();

			if (bean.getMainDocument() != null) {
				int leaseDocument = bean.getMainDocument().intValue();
				bean = new LeaseArendaAgreementNewAccessBean();
				bean.setInitKey_leaseDocument(leaseDocument);
				bean.refreshCopyHelper();
			}
*/
  			LeaseArendaAgreementNewAccessBean beanMain = DocumentLogic.getMainDocument(getLeaseDocument());
			setDocNumber(beanMain.getDocumentNumber());
			setStateOfContract(beanMain.getContractState());
			setCustomer(beanMain.getOrgCustomer().getName());
			setCustomercode(new Integer(beanMain.getOrgCustomer().getOrganization()));
			setExecutor(beanMain.getOrgExecutor().getName());
			setExecutorcode(new Integer(beanMain.getOrgExecutor().getOrganization()));
		} catch (Exception e) {
			e.printStackTrace();
			setDocNumber("");
			setStateOfContract("");
			setCustomer("");
			setCustomercode(null);
			setExecutor("");
			setExecutorcode(null);
		}

		//super.perform(mapping, form, request, response);
		return null;
	}

	/**
	 * @return
	 */
	public java.lang.String getFieldnames() {
		return fieldnames;
	}

	/**
	 * @return
	 */
	public java.lang.String getFormname() {
		return formname;
	}

	/**
	 * @param string
	 */
	public void setFieldnames(java.lang.String string) {
		fieldnames = string;
	}

	/**
	 * @param string
	 */
	public void setFormname(java.lang.String string) {
		formname = string;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getBrowseBeanName()
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCArendaAgreementObject";
	}

}
