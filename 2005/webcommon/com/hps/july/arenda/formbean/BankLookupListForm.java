package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * поиск списка "Банков".
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class BankLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String bankname;
	private java.lang.Boolean isname;
	private java.lang.Boolean isbik;
	private java.lang.String bankbik;
	private java.lang.String legaladdress;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public BankLookupListForm() {
	this.setFinderMethodName( "findBanksByQBE" );
	isname = java.lang.Boolean.FALSE;
	bankname = "";
	isbik = java.lang.Boolean.TRUE;
	bankbik = "";
	}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:41:44)
 * @return java.lang.String
 */
public java.lang.String getBankbik() {
	return bankbik;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 16:35:20)
 * @return java.lang.String
 */
public java.lang.String getBankname() {
	return bankname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { isname.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, bankname, 
		isbik.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, bankbik, new java.lang.Integer(1) };
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:41:24)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsbik() {
	return isbik;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:39:55)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsname() {
	return isname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 16:39:54)
 * @return java.lang.String
 */
public java.lang.String getLegaladdress() {
	return legaladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:41:44)
 * @param newBankbik java.lang.String
 */
public void setBankbik(java.lang.String newBankbik) {
	bankbik = newBankbik;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 16:35:20)
 * @param newName java.lang.String
 */
public void setBankname(java.lang.String newName) {
	bankname = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:41:24)
 * @param newIsbik java.lang.Boolean
 */
public void setIsbik(java.lang.Boolean newIsbik) {
	isbik = newIsbik;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 17:39:55)
 * @param newIsname java.lang.Boolean
 */
public void setIsname(java.lang.Boolean newIsname) {
	isname = newIsname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 16:39:54)
 * @param newLegaladdress java.lang.String
 */
public void setLegaladdress(java.lang.String newLegaladdress) {
	legaladdress = newLegaladdress;
}
}
