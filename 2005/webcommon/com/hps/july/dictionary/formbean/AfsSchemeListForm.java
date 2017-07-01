/*
 * Created on 02.04.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import java.util.Vector;
import java.util.Enumeration;
import com.hps.july.web.util.BrowseForm;
import com.hps.july.web.util.StringAndIntegerProperty;

/**
 * @author AAErmolov
 *
 * Форма списка схем АФС
 *
 */
public class AfsSchemeListForm extends BrowseForm {
	public AfsSchemeListForm(){
		super();
		setLastVisited(true);
	}
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList(2);
		roles.add("administrator");
		roles.add("confResAdmin");
		roles.add("confResOperator");
		return roles;
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getFilterParams()
	 */
	public Object[] getFilterParams() {
		return new Object[] { };
	}
	public java.lang.String getFinderMethodName() {
		return "findAfsSchemes";
	}
}