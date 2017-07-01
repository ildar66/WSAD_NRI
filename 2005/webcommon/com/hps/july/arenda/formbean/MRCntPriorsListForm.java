package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import java.sql.Date;
/**
 * Bean-form
 * Форма "Приоритеты зачета между договорами из контракта"(лист).
 * Creation date: (19.12.2002 5:10:52)
 * @author: Sergey Gourov
 */
public class MRCntPriorsListForm extends com.hps.july.web.util.BrowseForm {
	private Date documentDate;
	private java.lang.String documentNumber;
	private java.lang.String mutualPeriod;
	private Boolean commonRate;
	private java.lang.String actType;
	private java.lang.String calcRateType;
	private java.lang.String mainCurrency;
	private java.lang.String additionalCurrency;
	private java.lang.String state;
	private int reglamentcode;
/**
 * MRCntPriorsListForm constructor comment.
 */
public MRCntPriorsListForm() {
	super();
	setFinderMethodName("findLeaseMRCntPriorsByReglament");
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @return java.lang.String
 */
public java.lang.String getActType() {
	return actType;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @return java.lang.String
 */
public java.lang.String getAdditionalCurrency() {
	return additionalCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @return java.lang.String
 */
public java.lang.String getCalcRateType() {
	return calcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCommonRate() {
	return commonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @return java.sql.Date
 */
public java.sql.Date getDocumentDate() {
	return documentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
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
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:10:52)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new LeaseDocumentKey(getReglamentcode()) };
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @return java.lang.String
 */
public java.lang.String getMainCurrency() {
	return mainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @return java.lang.String
 */
public java.lang.String getMutualPeriod() {
	return mutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:54:38)
 * @return int
 */
public int getReglamentcode() {
	return reglamentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @param newActType java.lang.String
 */
public void setActType(java.lang.String newActType) {
	actType = newActType;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @param newAdditionalCurrency java.lang.String
 */
public void setAdditionalCurrency(java.lang.String newAdditionalCurrency) {
	additionalCurrency = newAdditionalCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @param newCalcRateType java.lang.String
 */
public void setCalcRateType(java.lang.String newCalcRateType) {
	calcRateType = newCalcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @param newCommonRate java.lang.Boolean
 */
public void setCommonRate(java.lang.Boolean newCommonRate) {
	commonRate = newCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @param newDocumentDate java.sql.Date
 */
public void setDocumentDate(java.sql.Date newDocumentDate) {
	documentDate = newDocumentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @param newMainCurrency java.lang.String
 */
public void setMainCurrency(java.lang.String newMainCurrency) {
	mainCurrency = newMainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @param newMutualPeriod java.lang.String
 */
public void setMutualPeriod(java.lang.String newMutualPeriod) {
	mutualPeriod = newMutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:54:38)
 * @param newReglamentcode int
 */
public void setReglamentcode(int newReglamentcode) {
	reglamentcode = newReglamentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:53:51)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
}
}
