package com.hps.july.arenda.formbean;

import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
/**
 *  Form-Bean.
 * "—писок св€зей счетов по абоненстским договорам".
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class AbonentBillLinksList extends com.hps.july.web.util.BrowseForm {
	private Boolean isName;
	private String name;
	private java.lang.String state;
	private java.lang.Boolean isCode;
	private java.lang.String code;
public AbonentBillLinksList() {
	setFinderMethodName("findByQBE2");
	setIsName(new Boolean(true));
	setName("");
	setIsCode(new Boolean(true));
	setCode("");
	setState("1");
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2003 17:30:08)
 * @return java.lang.String
 */
public java.lang.String getCode() {
	return code;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("ArendaMainEconomist");
	roles.add("ArendaEconomist");
	roles.add("administrator");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	int connected = 1;
	if ("2".equals(getState())) connected = 2;
	else if ("3".equals(getState())) connected = 3;
	
	return new Object[] {
		isCode.booleanValue() ? new Boolean(false) : new Boolean(true), getCode(),	// Boolean isIdresbilling, String idresbilling
		isName.booleanValue() ? new Boolean(false) : new Boolean(true), getName(),	// Boolean isBillresname, String billresname
		new Integer(connected), new Integer(1) };	// Integer connected, Integer order
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2003 17:29:49)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsCode() {
	return isCode;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsName() {
	return isName;
}
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 10:52:23)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getOurOrganizations() {
	try {
		OrganizationAccessBean bean=new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {		return (new java.util.Vector()).elements();		}	
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 16:32:59)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2003 17:30:08)
 * @param newCode java.lang.String
 */
public void setCode(java.lang.String newCode) {
	code = newCode;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2003 17:29:49)
 * @param newIsCode java.lang.Boolean
 */
public void setIsCode(java.lang.Boolean newIsCode) {
	isCode = newIsCode;
}
/**
 * 
 * @param newIsName java.lang.Boolean
 */
public void setIsName(java.lang.Boolean newIsName) {
	isName = newIsName;
}
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 16:32:59)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
}
}
