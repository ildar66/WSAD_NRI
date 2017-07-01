package com.hps.july.siteinfo.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
/**
 * Форма списка линий связи
 */
public class ComlineListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String posname;
	private StringAndIntegerProperty poscode;
	private java.lang.String posid;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ComlineListForm() {
	this.setFinderMethodName( "findByFromAndTo" );
	poscode = new StringAndIntegerProperty();
	poscode.setInteger(new Integer(0));
	posname = "";
	}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteTransport");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { poscode.getInteger(), poscode.getInteger() };
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 11:38:53)
 * @return java.lang.Integer
 */
public java.lang.Integer getPoscode() {
	return poscode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 11:39:10)
 * @return java.lang.String
 */
public java.lang.String getPoscodeFrm() {
	return poscode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:06:40)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 11:38:53)
 * @param newPoscode java.lang.Integer
 */
public void setPoscode(java.lang.Integer newPoscode) {
	poscode.setInteger(newPoscode);
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 11:39:10)
 * @param newPoscodeFrm java.lang.String
 */
public void setPoscodeFrm(java.lang.String newPoscodeFrm) {
	poscode.setString(newPoscodeFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:06:40)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
}
