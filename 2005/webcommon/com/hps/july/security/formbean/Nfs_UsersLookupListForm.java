/*
 * Created on 06.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.security.formbean;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.security.*;
import com.hps.july.constants.*;

/**
 * @author IShaffigulin
 *
 * Справочник Пользователей системы NFS (BrowseForm)
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Nfs_UsersLookupListForm extends BrowseForm {
	private java.lang.String name;
	private String orderBy;
	private java.lang.String activestate;
	private java.lang.String formname;
	private java.lang.String fieldnames;
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 13:30:34)
	 */
	public Nfs_UsersLookupListForm() {
		name = "";
		setActivestate("A");
		setOrderBy("fullName desc");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.07.2003 15:40:58)
	 * @return java.lang.String
	 */
	public java.lang.String getActivestate() {
		return activestate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 12:02:58)
	 * @return java.lang.String
	 */
	public java.lang.String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBC_Nfs_Users_Object";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 12:00:34)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] {
			new Boolean(true),
			getName(),
			"ALL".equals(getActivestate()) ? new Boolean(false) : new Boolean(true),
			getActivestate(),
			getOrderBy()};
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 11:20:35)
	 * @return java.lang.String
	 */
	public java.lang.String getFinderMethodName() {
		return "findList";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.02.2002 16:35:20)
	 * @return java.lang.String
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 16:25:07)
	 * @return java.lang.String
	 */
	public java.lang.String getOrderBy() {
		return orderBy;
	}
	/**
	 * Для каждой строки броуза можно переопределить возвращаемый объект.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		ParamsParser.setState(request, Applications.SECURITY, APPStates.NFS_USERS_LOOKUP_LIST);
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.07.2003 15:40:58)
	 * @param newActivestate java.lang.String
	 */
	public void setActivestate(java.lang.String newActivestate) {
		activestate = newActivestate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.02.2002 16:35:20)
	 * @param newName java.lang.String
	 */
	public void setName(java.lang.String newName) {
		name = newName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 16:25:07)
	 * @param newOrderBy java.lang.String
	 */
	public void setOrderBy(java.lang.String newOrderBy) {
		orderBy = newOrderBy;
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

}
