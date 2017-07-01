package com.hps.july.siteinfo.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма выбора линии связи
 */
public class ComlineLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String posname;
	private StringAndIntegerProperty poscode;
	private java.lang.String posid;
	private java.lang.String postype;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ComlineLookupListForm() {
	//this.setFinderMethodName( "findByFromAndTo" );
	this.setFinderMethodName( "findByPosType" );
	poscode = new StringAndIntegerProperty();
	poscode.setInteger(new Integer(0));
	posname = "";
	postype = "R";	
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { poscode.getInteger(), poscode.getInteger(), getPostype() };
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
 * Creation date: (05.07.2002 17:05:22)
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
 * Creation date: (12.07.2002 17:08:48)
 * @return java.lang.String
 */
public java.lang.String getPostype() {
	return postype;
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
 * Creation date: (05.07.2002 17:05:22)
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
/**
 * Insert the method's description here.
 * Creation date: (12.07.2002 17:08:48)
 * @param newPostype java.lang.String
 */
public void setPostype(java.lang.String newPostype) {
	postype = newPostype;
}
}
