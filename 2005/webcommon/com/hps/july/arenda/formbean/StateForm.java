package com.hps.july.arenda.formbean;

import java.util.*;
import com.hps.july.arenda.sessionbean.*;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import com.hps.july.web.util.*;
import java.sql.Date;
import java.math.*;
/**
 * Bean-form
 * Форма"состояния".
 * Creation date: (05.07.2002 14:02:29)
 * @author: Sergey Gourov
 */
abstract public class StateForm extends com.hps.july.web.util.EditForm {
	private int leaseDocument;
	private java.lang.String documentNumber;
	private StringAndSqlDateProperty startDate;
	private StringAndSqlDateProperty endDate;
	private OrganizationNfsAccessBean orgCustomer;
	private OrganizationNfsAccessBean orgExecutor;
	private java.lang.String contractState;
	private StringAndBigDecimalProperty summ1;
	private StringAndBigDecimalProperty summ2;
	private java.lang.String orgCustomername;
	private java.lang.String orgExecutorname;
	private java.lang.String curr1;
	private java.lang.String curr2;
	private CurrencyAccessBean currency1;
	private CurrencyAccessBean currency2;
	protected java.lang.String initialState;
	private StringAndSqlDateProperty dateclose;
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:03:45)
 */
public StateForm() {

	Date date = new Date(System.currentTimeMillis());

	startDate = new StringAndSqlDateProperty();
	startDate.setSqlDate(date);
	
	endDate = new StringAndSqlDateProperty();
	endDate.setSqlDate(date);

	summ1 = new StringAndBigDecimalProperty();
	summ1.setString("");
	summ2 = new StringAndBigDecimalProperty();
	summ2.setString("");

	contractState = "A";
	
	dateclose = new StringAndSqlDateProperty();
	dateclose.setSqlDate(date);
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	initialState = getContractState();
	if (initialState == null) {
		initialState = "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 10:45:50)
 * @return java.lang.String
 */
public java.lang.String getContractState() {
	return contractState;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 17:12:07)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 17:12:36)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 17:25:20)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public com.hps.july.persistence.CurrencyAccessBean getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 17:26:08)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public com.hps.july.persistence.CurrencyAccessBean getCurrency2() {
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseContractAccessBean bean = new LeaseContractAccessBean();
	bean.setInitKey_leaseDocument(getLeaseDocument());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (21.03.2005 11:43:54)
 */
public Date getDateclose() {
	return dateclose.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (21.03.2005 11:47:11)
 */
public String getDatecloseFrm() {
	return dateclose.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 15:38:36)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getEndDate() {
	return endDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEndDateFrm() {
	return endDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.10.2002 17:53:37)
 * @return java.lang.String
 */
public java.lang.String getInitialState() {
	return initialState;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 10:51:17)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:43:55)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomername() {
	return orgCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:44:29)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutorname() {
	return orgExecutorname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getStartDate() {
	return startDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getStartDateFrm() {
	return startDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:13:59)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumm1() {
	return summ1.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:13:59)
 * @return java.math.BigDecimal
 */
public String getSumm1Frm() {
	return summ1.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:14:26)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumm2() {
	return summ2.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:14:26)
 * @return java.math.BigDecimal
 */
public String getSumm2Frm() {
	return summ2.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 10:45:50)
 * @param newContractState java.lang.String
 */
public void setContractState(java.lang.String newContractState) {
	contractState = newContractState;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 17:12:07)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 17:12:36)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 17:25:20)
 * @param newCurrency1 com.hps.july.persistence.CurrencyAccessBean
 */
public void setCurrency1(com.hps.july.persistence.CurrencyAccessBean newCurrency1) {
	currency1 = newCurrency1;
	try {
		setCurr1(newCurrency1.getShortname());
	} catch (Exception e) {
		setCurr1("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 17:26:08)
 * @param newCurrency2 com.hps.july.persistence.CurrencyAccessBean
 */
public void setCurrency2(com.hps.july.persistence.CurrencyAccessBean newCurrency2) {
	currency2 = newCurrency2;
	try {
		setCurr2(newCurrency2.getShortname());
	} catch (Exception e) {
		setCurr2("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (21.03.2005 11:48:01)
 */
public void setDateclose(Date newDate) {
	dateclose.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (21.03.2005 11:49:31)
 */
public void setDatecloseFrm(String newDateStr) {
	dateclose.setString(newDateStr);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 15:38:36)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDate(Date newEndDate) {
	endDate.setSqlDate(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDateFrm(String newEndDate) {
	endDate.setString(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (10.10.2002 17:53:37)
 * @param newInitialState java.lang.String
 */
public void setInitialState(java.lang.String newInitialState) {
	initialState = newInitialState;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 10:51:17)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:47:45)
 * @param newOrgCustomer com.hps.july.persistence.OrganizationNfsAccessBean
 */
public void setOrgCustomer(com.hps.july.persistence.OrganizationNfsAccessBean newOrgCustomer) throws Exception {
	if (newOrgCustomer == null) {
		orgCustomername = "";
	} else {
		orgCustomername = newOrgCustomer.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:43:55)
 * @param newOrgCustomername java.lang.String
 */
public void setOrgCustomername(java.lang.String newOrgCustomername) {
	orgCustomername = newOrgCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:47:45)
 * @param newOrgExecutor com.hps.july.persistence.OrganizationNfsAccessBean
 */
public void setOrgExecutor(com.hps.july.persistence.OrganizationNfsAccessBean newOrgExecutor) throws Exception {
	if (newOrgExecutor == null) {
		orgExecutorname = "";
	} else {
		orgExecutorname = newOrgExecutor.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:44:29)
 * @param newOrgExecutorname java.lang.String
 */
public void setOrgExecutorname(java.lang.String newOrgExecutorname) {
	orgExecutorname = newOrgExecutorname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDate(Date newStartDate) {
	startDate.setSqlDate(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDateFrm(String newStartDate) {
	startDate.setString(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:13:59)
 * @param newSumm1 java.math.BigDecimal
 */
public void setSumm1(java.math.BigDecimal newSumm1) {
	summ1.setBigDecimal(newSumm1);
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:13:59)
 * @param newSumm1 java.math.BigDecimal
 */
public void setSumm1Frm(String newSumm1) {
	summ1.setString(newSumm1);
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:14:26)
 * @param newSumm2 java.math.BigDecimal
 */
public void setSumm2(java.math.BigDecimal newSumm2) {
	summ2.setBigDecimal(newSumm2);
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 11:14:26)
 * @param newSumm2 java.math.BigDecimal
 */
public void setSumm2Frm(String newSumm2) {
	summ2.setString(newSumm2);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (initialState.equals("B") && getContractState().equals("A")) {
		Enumeration e = new LeaseDocPositionAccessBean().findLeaseDocPositionByLeaseContract(new LeaseDocumentKey(getLeaseDocument()));
		if (e.hasMoreElements()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.contract.hasdocpositions"));
		}
	}
}
}
