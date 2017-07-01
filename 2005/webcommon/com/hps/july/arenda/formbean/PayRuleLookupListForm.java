/*
 * Created on 03.05.2006
 *
 * Lookup "ѕравила платежа(лист)" дл€ активного док-та аренды.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
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
import com.hps.july.web.util.ParamsParser;

/**
 * @author IShaffigulin
 *
 * Lookup "ѕравила платежа(лист)" дл€ активного док-та аренды.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PayRuleLookupListForm extends com.hps.july.web.util.BrowseForm {
	private int leaseDocument;

	private java.lang.String formname;
	private java.lang.String fieldnames;
	/**
	 * 
	 */
	public PayRuleLookupListForm() {
		super();
		setFinderMethodName("findByLeaseDocument");
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		return new Object[] { DocumentLogic.getCodeActiveDocument(getLeaseDocument()), new Boolean(false), new Integer(1)};
	}

	/**
	 * @return
	 */
	public int getLeaseDocument() {
		return leaseDocument;
	}

	/**
	 * @param i
	 */
	public void setLeaseDocument(int i) {
		leaseDocument = i;
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
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, com.hps.july.arenda.APPStates.PAY_RULE_LOOKUP_LIST);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getBrowseBeanName()
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.persistence.LeasePayRuleAccessBean";
	}
}
