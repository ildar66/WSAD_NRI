/*
 * Created on 20.09.2006
 *
 * ‘орма дл€ всех позиций по договору аренды.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.constants.Applications;
import com.hps.july.web.util.BrowseForm;
import com.hps.july.web.util.ParamsParser;

/**
 * @author IShaffigulin
 *
 * ‘орма дл€ всех позиций по договору аренды.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PositionsDialogListForm extends BrowseForm {
	private Integer mainLeaseContractKey = null;
	private java.lang.String sortBy = null; //признак сортировки

	/**
	 * 
	 */
	public PositionsDialogListForm() {
		super();
		setSortBy("docNumber");
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		return new Object[] { getMainLeaseContractKey(), getSortBy()};
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getBrowseBeanName()
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.arenda.cdbcobjects.CDBC_LeaseOnPosition_Object";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFinderMethodName()
	 */
	public String getFinderMethodName() {
		return "findAllPositionsByMainDog";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, com.hps.july.arenda.APPStates.POSITIONS_DIALOG_LIST);
		return null;
	}

	/**
	 * @return
	 */
	public Integer getMainLeaseContractKey() {
		return mainLeaseContractKey;
	}

	/**
	 * @param integer
	 */
	public void setMainLeaseContractKey(Integer integer) {
		mainLeaseContractKey = integer;
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
	public ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}

}
