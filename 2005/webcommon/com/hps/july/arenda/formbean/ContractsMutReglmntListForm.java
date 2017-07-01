package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import java.sql.*;
/**
 * bean-form
 * Контракты-регламенты.(лист)
 * Creation date: (10.07.2002 12:18:22)
 * @author: Sergey Gourov
 */
public class ContractsMutReglmntListForm extends com.hps.july.web.util.BrowseForm {
	private int mainLeaseDocument;
	private Date documentDate;
	private java.lang.String documentNumber;
	private java.lang.String mutualPeriod;
	private Boolean commonRate;
	private java.lang.String actType;
	private java.lang.String calcRateType;
	private java.lang.String mainCurrency;
	private java.lang.String additionalCurrency;
	private java.lang.String state;
/**
 * PhonesMutReglmntListForm constructor comment.
 */
public ContractsMutReglmntListForm() {
	super();
	setFinderMethodName("findLeaseMutualContractsByReglament");
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @return java.lang.String
 */
public java.lang.String getActType() {
	return actType;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 16:53:51)
 * @return java.lang.String
 */
public java.lang.String getAdditionalCurrency() {
	return additionalCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @return java.lang.String
 */
public java.lang.String getCalcRateType() {
	return calcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @return java.lang.String
 */
public Boolean getCommonRate() {
	return commonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @return Date
 */
public Date getDocumentDate() {
	return documentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
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
 * Creation date: (10.07.2002 12:18:22)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new LeaseDocumentKey(getMainLeaseDocument()) };
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 16:50:00)
 * @return java.lang.String
 */
public java.lang.String getMainCurrency() {
	return mainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 11:27:11)
 * @return int
 */
public int getMainLeaseDocument() {
	return mainLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @return java.lang.String
 */
public java.lang.String getMutualPeriod() {
	return mutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 18:59:13)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @param newActType java.lang.String
 */
public void setActType(java.lang.String newActType) {
	actType = newActType;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 16:53:51)
 * @param newAdditionalCurrency java.lang.String
 */
public void setAdditionalCurrency(java.lang.String newAdditionalCurrency) {
	additionalCurrency = newAdditionalCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @param newCalcRateType java.lang.String
 */
public void setCalcRateType(java.lang.String newCalcRateType) {
	calcRateType = newCalcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @param newCommonRate java.lang.String
 */
public void setCommonRate(Boolean newCommonRate) {
	commonRate = newCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @param newDocumentDate Date
 */
public void setDocumentDate(Date newDocumentDate) {
	documentDate = newDocumentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 16:50:00)
 * @param newMainCurrency java.lang.String
 */
public void setMainCurrency(java.lang.String newMainCurrency) {
	mainCurrency = newMainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 11:27:11)
 * @param newMainLeaseDocument int
 */
public void setMainLeaseDocument(int newMainLeaseDocument) {
	mainLeaseDocument = newMainLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:37:08)
 * @param newMutualPeriod java.lang.String
 */
public void setMutualPeriod(java.lang.String newMutualPeriod) {
	mutualPeriod = newMutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 18:59:13)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
}
}
