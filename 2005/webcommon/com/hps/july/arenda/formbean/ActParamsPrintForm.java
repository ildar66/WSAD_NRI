package com.hps.july.arenda.formbean;

/**
 * Форма для печати параметров акта.
 * Creation date: (18.07.2002 11:50:43)
 * @author: Dmitry Dneprov
 */
public class ActParamsPrintForm extends org.apache.struts.action.ActionForm {
	private java.lang.String header1;
	private java.lang.String header2;
	private java.lang.String header3;
	private java.lang.String header4;
	private java.lang.String header5;
	private java.lang.String acttype;
	private boolean commonRate;
	private int reglament;
	private java.util.ArrayList table1;
	private java.util.ArrayList table2;
	private java.util.ArrayList table3;

public ActParamsPrintForm() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 12:05:56)
 * @return java.lang.String
 */
public java.lang.String getActtype() {
	return acttype;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 16:06:01)
 * @return java.lang.String
 */
public java.lang.String getHeader1() {
	return header1;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 16:06:15)
 * @return java.lang.String
 */
public java.lang.String getHeader2() {
	return header2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 16:06:28)
 * @return java.lang.String
 */
public java.lang.String getHeader3() {
	return header3;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 16:06:41)
 * @return java.lang.String
 */
public java.lang.String getHeader4() {
	return header4;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 16:06:57)
 * @return java.lang.String
 */
public java.lang.String getHeader5() {
	return header5;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 15:03:55)
 * @return int
 */
public int getReglament() {
	return reglament;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ACT_PARAMS_PRINT;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 15:13:29)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getTable1() {
	return table1;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 15:13:51)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getTable2() {
	return table2;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 15:14:13)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getTable3() {
	return table3;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 12:06:43)
 * @return boolean
 */
public boolean isCommonRate() {
	return commonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 12:05:56)
 * @param newActtype java.lang.String
 */
public void setActtype(java.lang.String newActtype) {
	acttype = newActtype;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 12:06:43)
 * @param newCommonRate boolean
 */
public void setCommonRate(boolean newCommonRate) {
	commonRate = newCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 16:06:01)
 * @param newHeader1 java.lang.String
 */
public void setHeader1(java.lang.String newHeader1) {
	header1 = newHeader1;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 16:06:15)
 * @param newHeader2 java.lang.String
 */
public void setHeader2(java.lang.String newHeader2) {
	header2 = newHeader2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 16:06:28)
 * @param newHeader3 java.lang.String
 */
public void setHeader3(java.lang.String newHeader3) {
	header3 = newHeader3;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 16:06:41)
 * @param newHeader4 java.lang.String
 */
public void setHeader4(java.lang.String newHeader4) {
	header4 = newHeader4;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2003 16:06:57)
 * @param newHeader5 java.lang.String
 */
public void setHeader5(java.lang.String newHeader5) {
	header5 = newHeader5;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 15:03:55)
 * @param newReglament int
 */
public void setReglament(int newReglament) {
	reglament = newReglament;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 15:13:29)
 * @param newTable1 java.util.ArrayList
 */
public void setTable1(java.util.ArrayList newTable1) {
	table1 = newTable1;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 15:13:51)
 * @param newTable2 java.util.ArrayList
 */
public void setTable2(java.util.ArrayList newTable2) {
	table2 = newTable2;
}
/**
 * Insert the method's description here.
 * Creation date: (08.12.2003 15:14:13)
 * @param newTable3 java.util.ArrayList
 */
public void setTable3(java.util.ArrayList newTable3) {
	table3 = newTable3;
}
}
