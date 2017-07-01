package com.hps.july.arenda.formbean;

/**
 * Подбор начислений/платежей учавствующих в формировании акта.
 * Creation date: (18.07.2002 11:50:43)
 * @author: Dmitry Dneprov
 */
public class ActContentsListForm extends org.apache.struts.action.ActionForm {
	private int actcode;
	private int[] selchrgd;
	private int[] selchrga;
	private int[] selpayd;
	private int[] selpaya;
	private java.lang.String action;
	private int action_process;
	private java.lang.String actnumber;
	private java.sql.Date actdate;

public ActContentsListForm() {
	super();
	action_process = 0;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 10:59:46)
 * @return int
 */
public int getActcode() {
	return actcode;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 14:09:06)
 * @return java.sql.Date
 */
public java.sql.Date getActdate() {
	return actdate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:34:19)
 * @return java.lang.String
 */
public java.lang.String getAction() {
	return action;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 12:03:13)
 * @return int
 */
public int getAction_process() {
	return action_process;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 14:08:47)
 * @return java.lang.String
 */
public java.lang.String getActnumber() {
	return actnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:06:12)
 * @return int[]
 */
public int[] getSelchrga() {
	return selchrga;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:05:56)
 * @return int[]
 */
public int[] getSelchrgd() {
	return selchrgd;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:06:39)
 * @return int[]
 */
public int[] getSelpaya() {
	return selpaya;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:06:25)
 * @return int[]
 */
public int[] getSelpayd() {
	return selpayd;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 10:59:46)
 * @param newActcode int
 */
public void setActcode(int newActcode) {
	actcode = newActcode;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 14:09:06)
 * @param newActdate java.sql.Date
 */
public void setActdate(java.sql.Date newActdate) {
	actdate = newActdate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:34:19)
 * @param newAction java.lang.String
 */
public void setAction(java.lang.String newAction) {
	action = newAction;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 12:03:13)
 * @param newAction_process int
 */
public void setAction_process(int newAction_process) {
	action_process = newAction_process;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 14:08:47)
 * @param newActnumber java.lang.String
 */
public void setActnumber(java.lang.String newActnumber) {
	actnumber = newActnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:06:12)
 * @param newSelchrga int[]
 */
public void setSelchrga(int[] newSelchrga) {
	selchrga = newSelchrga;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:05:56)
 * @param newSelchrgd int[]
 */
public void setSelchrgd(int[] newSelchrgd) {
	selchrgd = newSelchrgd;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:06:39)
 * @param newSelpaya int[]
 */
public void setSelpaya(int[] newSelpaya) {
	selpaya = newSelpaya;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 11:06:25)
 * @param newSelpayd int[]
 */
public void setSelpayd(int[] newSelpayd) {
	selpayd = newSelpayd;
}
}
