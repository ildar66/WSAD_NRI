/*
 * Created on 19.12.2006
 *
 * "Чем оплачено начисление" BrowseForm.
 */
package com.hps.july.arenda.formbean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.hps.july.arenda.APPStates;
import com.hps.july.cdbc.objects.CDBCLeaseChargesObject;
import com.hps.july.constants.Applications;
import com.hps.july.valueobject.LeaseCharge_TO;
import com.hps.july.web.util.*;

/**
 * @author IShaffigulin
 *
 * "Чем оплачено начисление" BrowseForm.
 */
public class DnopForChargeListForm extends BrowseForm {
	private int leaseCharge = -1;
	private java.lang.String sortBy = "datePay";
	private LeaseCharge_TO leaseChargeTO = null;

	/**
	 * 
	 */
	public DnopForChargeListForm() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		return new Object[] { new Integer(getLeaseCharge()), getSortBy()};
	}

	/**
	 * @return
	 */
	public int getLeaseCharge() {
		return leaseCharge;
	}

	/**
	 * @param i
	 */
	public void setLeaseCharge(int i) {
		leaseCharge = i;
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
		return "getListForCharge";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		setLeaseChargeTO(CDBCLeaseChargesObject.findTO(getLeaseCharge()));
		ParamsParser.setState(request, Applications.ARENDA, APPStates.DNOP_FOR_CHARGES_LIST);
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
	 */
	public LeaseCharge_TO getLeaseChargeTO() {
		return leaseChargeTO;
	}

	/**
	 * @param charge_TO
	 */
	private void setLeaseChargeTO(LeaseCharge_TO charge_TO) {
		leaseChargeTO = charge_TO;
	}

}
