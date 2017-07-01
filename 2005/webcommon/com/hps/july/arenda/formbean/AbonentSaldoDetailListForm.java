/*
 * Created on 19.02.2007
 *
 * "Сальдо для абонентских договоров" BrowseForm.
 */
package com.hps.july.arenda.formbean;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.hps.july.arenda.APPStates;
import com.hps.july.constants.Applications;
import com.hps.july.persistence.LeaseContractAccessBean;
import com.hps.july.web.util.*;

/**
 * @author IShaffigulin
 *
 * "Сальдо для абонентских договоров" BrowseForm.
 */
public class AbonentSaldoDetailListForm extends BrowseForm {
	private int idContract;
	private String docNumber;
	private Date docDate;
	private java.lang.String sortBy = "salDate desc";

	/**
	 * 
	 */
	public AbonentSaldoDetailListForm() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		return new Object[] { new Integer(getIdContract()), getSortBy()};
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
		return "com.hps.july.arenda.cdbcobjects.CDBC_SaldoDetailsObject";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFinderMethodName()
	 */
	public String getFinderMethodName() {
		return "getList";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.ABONENT_SALDO_DETAIL_LIST);
		initAbonentInfo();
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
	public Date getDocDate() {
		return docDate;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		return docNumber;
	}

	/**
	 * @param date
	 */
	public void setDocDate(Date date) {
		docDate = date;
	}

	/**
	 * @param string
	 */
	public void setDocNumber(String string) {
		docNumber = string;
	}

	/**
	 * @return
	 */
	public int getIdContract() {
		return idContract;
	}

	/**
	 * @param i
	 */
	public void setIdContract(int i) {
		idContract = i;
	}
	/**
	 * 
	 *
	 */
	private void initAbonentInfo(){
		try {
			LeaseContractAccessBean bean = new LeaseContractAccessBean();
			bean.setInitKey_leaseDocument(getIdContract());
			bean.refreshCopyHelper();
			//если нужна доп инфо сделать как CompletWorkActsListForm:
			setDocNumber(bean.getDocumentNumber());
			setDocDate(bean.getDocumentDate());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка initAbonentInfo для getIdContract =" + getIdContract());
		}
	}
}
