/*
 * Created on 08.06.2007
 *
 * Форма списка ролей пользователей NRI.
 */
package com.hps.july.security.formbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.constants.Applications;
import com.hps.july.security.APPStates;
import com.hps.july.web.util.BrowseForm;
import com.hps.july.web.util.ParamsParser;

/**
 * @author IShaffigulin
 *
 * Форма списка ролей пользователей NRI.
 */
public class RoleListForm extends BrowseForm {
	private java.lang.String orderBy;
	private java.lang.String searchStr;
	/**
	 * 
	 */
	public RoleListForm() {
		super();
		setOrderBy("rolename");
		setSearchStr("*");
		setLastVisited(true);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		return new Object[] { getSearchStr() ,getOrderBy() };
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getBrowseBeanName()
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBC_Role_Object";
	}

	/**
	 * @return
	 */
	public java.lang.String getOrderBy() {
		return orderBy;
	}

	/**
	 * @param string
	 */
	public void setOrderBy(java.lang.String string) {
		orderBy = string;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFinderMethodName()
	 */
	public String getFinderMethodName() {
		return "findListRoles";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState( request, Applications.SECURITY, APPStates.ROLE_LIST );
		return null;
	}

	/**
	 * @return
	 */
	public java.lang.String getSearchStr() {
		return searchStr;
	}

	/**
	 * @param string
	 */
	public void setSearchStr(java.lang.String string) {
		searchStr = string;
	}

}
