/*
 * Created on 19.12.2006
 *
 * "Какие начисления закрывает платеж." BrowseForm.
 */
package com.hps.july.arenda.formbean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.hps.july.arenda.APPStates;
import com.hps.july.cdbc.objects.CDBCLeasePaymentObject;
import com.hps.july.constants.Applications;
//import com.hps.july.valueobject.LeasePayment_TO;
import com.hps.july.persistence.LeasePaymentAccessBean;
import com.hps.july.web.util.*;

/**
 * @author IShaffigulin
 *
 * "Какие начисления закрывает платеж." BrowseForm.
 */
public class DnopForPaymentListForm extends BrowseForm {
	private int leasePayment = -1;
	private java.lang.String sortBy = "dateCharge";
	//private LeasePayment_TO leasePaymentTO = null;
	private LeasePaymentAccessBean leasePaymentTO = null;

	/**
	 * 
	 */
	public DnopForPaymentListForm() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		return new Object[] { new Integer(getLeasePayment()), getSortBy()};
	}

	/**
	 * @return
	 */
	public int getLeasePayment() {
		return leasePayment;
	}

	/**
	 * @param i
	 */
	public void setLeasePayment(int i) {
		leasePayment = i;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#constructRowModelBean(java.lang.Object)
	 */
	public Object constructRowModelBean(Object o) {
		return o;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getBrowseBeanName()
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.arenda.cdbcobjects.CDBC_DnopObject";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFinderMethodName()
	 */
	public String getFinderMethodName() {
		return "getListForPayment";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//setLeasePaymentTO(CDBCLeasePaymentsObject.findTO(getLeasePayment()));
		LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
		lpBean.setInitKey_leaseDocPosition(getLeasePayment());
		setLeasePaymentTO(lpBean);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.DNOP_FOR_PAYMENTS_LIST);
		return null;
	}

	/**
	 * @return
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}

	/**
	 * @param string
	 */
	public void setSortBy(java.lang.String string) {
		sortBy = string;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getEditRoles()
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}

	/**
	 * @return
	
	public LeasePayment_TO getLeasePaymentTO() {
		return leasePaymentTO;
	}
	 */
	/**
	 * @param Payment_TO
	
	private void setLeasePaymentTO(LeasePayment_TO payment_TO) {
		leasePaymentTO = payment_TO;
	}
	 */
	/**
	 * @return
	 */
	public LeasePaymentAccessBean getLeasePaymentTO() {
		return leasePaymentTO;
	}

	/**
	 * @param bean
	 */
	public void setLeasePaymentTO(LeasePaymentAccessBean bean) {
		leasePaymentTO = bean;
	}

}
