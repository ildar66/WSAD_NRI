package com.hps.july.arenda.formbean;

import com.hps.july.web.util.*;
import java.sql.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.arenda.valueobject.*;
/**
 * Bean-form
 * Форма "Для создания отчетов по актам"(лист).
 * Creation date: (26.07.2002 11:12:31)
 * @author: Sergey Gourov
 */
public class MutualActsListForm extends com.hps.july.web.util.BrowseForm {
	private int mutualReglament;
	private java.lang.Boolean isDocdate;
	private com.hps.july.web.util.StringAndSqlDateProperty fromDate;
	private com.hps.july.web.util.StringAndSqlDateProperty toDate;
	private Boolean commonRate;
	private java.lang.String calcRateType;
	private java.lang.String period;
	private java.lang.String acttype;
	private java.lang.String documentNumber;
	private java.sql.Date documentDate;
	private java.lang.String mainCurrency;
	private java.lang.String additionalCurrency;
	private java.lang.String reglamentState;
	private int order;
/**
 * MutualActsListForm constructor comment.
 */
public MutualActsListForm() {
	super();
	setFinderMethodName("4");
	order = 4;

	toDate = new StringAndSqlDateProperty();
	fromDate = new StringAndSqlDateProperty();

	java.util.GregorianCalendar c = new java.util.GregorianCalendar();
	toDate.setSqlDate(new Date(c.getTime().getTime()));
	c.add(java.util.Calendar.YEAR, -1);
	fromDate.setSqlDate(new Date(c.getTime().getTime()));

	isDocdate = new Boolean(true);
}
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
    if (o == null) {
        return o;
    }
    if (!(o instanceof CDBCRowObject)) {
        System.out.println("MutualActListForm: CLASS_CAST: " + o.getClass().getName());
        return o;
    }
    CDBCRowObject ro = (CDBCRowObject) o;
    LeaseMutualActVO vo = new LeaseMutualActVO(ro);
    vo.setFlagOldSystem(ro.getColumn("flagoldsystem").asString());
    return vo;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:45:39)
 * @return java.lang.String
 */
public java.lang.String getActtype() {
	return acttype;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 15:30:53)
 * @return java.lang.String
 */
public java.lang.String getAdditionalCurrency() {
	return additionalCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 15:52:32)
 * @return java.lang.String
 */
public java.lang.String getCalcRateType() {
	return calcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 15:49:35)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCommonRate() {
	return commonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.11.2002 11:18:57)
 * @return java.sql.Date
 */
public java.sql.Date getDocumentDate() {
	return documentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.11.2002 11:18:08)
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
 * Creation date: (26.07.2002 11:12:31)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	try {
		order = Integer.parseInt(super.getFinderMethodName());
	} catch (NumberFormatException e) {}
	
	return new Object[] { Boolean.TRUE, new Integer(getMutualReglament()),	// Boolean isMutualReglament, Integer mutualReglament
		getIsDocdate().booleanValue() ? Boolean.FALSE : Boolean.TRUE, getFromDate(), getToDate(),	// Boolean isDocDate, Date fromDocDate, Date toDocDate
		new Integer(order) };													// Integer order
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findListLeaseMutualAct";
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:28:36)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getFromDate() {
	return fromDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:28:36)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getFromDateFrm() {
	return fromDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:23:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDocdate() {
	return isDocdate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 15:30:53)
 * @return java.lang.String
 */
public java.lang.String getMainCurrency() {
	return mainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:22:41)
 * @return int
 */
public int getMutualReglament() {
	return mutualReglament;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:45:21)
 * @return java.lang.String
 */
public java.lang.String getPeriod() {
	return period;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 13:14:22)
 * @return java.lang.String
 */
public java.lang.String getReglamentState() {
	return reglamentState;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:32:20)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getToDate() {
	return toDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:32:20)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getToDateFrm() {
	return toDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:45:39)
 * @param newActtype java.lang.String
 */
public void setActtype(java.lang.String newActtype) {
	acttype = newActtype;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 15:30:53)
 * @param newAdditionalCurrency java.lang.String
 */
public void setAdditionalCurrency(java.lang.String newAdditionalCurrency) {
	additionalCurrency = newAdditionalCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 15:52:32)
 * @param newCalcRateType java.lang.String
 */
public void setCalcRateType(java.lang.String newCalcRateType) {
	calcRateType = newCalcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 15:49:35)
 * @param newCommonRate java.lang.Boolean
 */
public void setCommonRate(java.lang.Boolean newCommonRate) {
	commonRate = newCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.11.2002 11:18:57)
 * @param newDocumentDate java.sql.Date
 */
public void setDocumentDate(java.sql.Date newDocumentDate) {
	documentDate = newDocumentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.11.2002 11:18:08)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:28:36)
 * @param newFromDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setFromDate(Date newFromDate) {
	fromDate.setSqlDate(newFromDate);
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:28:36)
 * @param newFromDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setFromDateFrm(String newFromDate) {
	fromDate.setString(newFromDate);
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:23:45)
 * @param newIsDocdate java.lang.Boolean
 */
public void setIsDocdate(java.lang.Boolean newIsDocdate) {
	isDocdate = newIsDocdate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 15:30:53)
 * @param newMainCurrency java.lang.String
 */
public void setMainCurrency(java.lang.String newMainCurrency) {
	mainCurrency = newMainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:22:41)
 * @param newMutualReglament int
 */
public void setMutualReglament(int newMutualReglament) {
	mutualReglament = newMutualReglament;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:45:21)
 * @param newPeriod java.lang.String
 */
public void setPeriod(java.lang.String newPeriod) {
	period = newPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (12.12.2002 13:14:22)
 * @param newReglamentState java.lang.String
 */
public void setReglamentState(java.lang.String newReglamentState) {
	reglamentState = newReglamentState;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:32:20)
 * @param newToDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setToDate(Date newToDate) {
	toDate.setSqlDate(newToDate);
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 11:32:20)
 * @param newToDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setToDateFrm(String newToDate) {
	toDate.setString(newToDate);
}
}
