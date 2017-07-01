package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import java.sql.Date;
/**
 * Bean-form
 * Форма "получение платежей".
 * Creation date: (10.04.2003 9:59:36)
 * @author: Sergey Gourov
 */
public class GetPaysForm extends com.hps.july.web.util.EditForm {
	private com.hps.july.web.util.StringAndSqlDateProperty dateFrom;
	private com.hps.july.web.util.StringAndSqlDateProperty dateTo;
	private java.lang.Boolean isAllContracts;
	private com.hps.july.web.util.StringAndIntegerProperty contractcode;
	private java.lang.String docnumber;
	private java.lang.String docdate;
	private java.lang.String sum2;
	private java.lang.String sum1;
	private java.lang.String orgExecutor;
	private java.lang.String orgCustomer;
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:04:30)
 */
public GetPaysForm() {
	dateFrom = new StringAndSqlDateProperty();
	dateTo = new StringAndSqlDateProperty();
	contractcode = new StringAndIntegerProperty();
	setAction("Add");
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 9:59:36)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 9:59:36)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:08:06)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getContractcode() {
	return contractcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:08:06)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getContractcodeFrm() {
	return contractcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 9:59:36)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:02:43)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDateFrom() {
	return dateFrom.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:02:43)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDateFromFrm() {
	return dateFrom.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:05:15)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDateTo() {
	return dateTo.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:05:15)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDateToFrm() {
	return dateTo.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:11:23)
 * @return java.lang.String
 */
public java.lang.String getDocdate() {
	return docdate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:11:09)
 * @return java.lang.String
 */
public java.lang.String getDocnumber() {
	return docnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:07:03)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAllContracts() {
	return isAllContracts;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:12:29)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:12:13)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 9:59:36)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.GET_PAYS;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 13:06:33)
 * @return java.lang.String
 */
public java.lang.String getSum1() {
	return sum1;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 13:06:33)
 * @return java.lang.String
 */
public java.lang.String getSum2() {
	return sum2;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:08:06)
 * @param newContractcode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setContractcode(Integer newContractcode) {
	contractcode.setInteger(newContractcode);
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:08:06)
 * @param newContractcode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setContractcodeFrm(String newContractcode) {
	contractcode.setString(newContractcode);
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:02:43)
 * @param newDateFrom com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateFrom(Date newDateFrom) {
	dateFrom.setSqlDate(newDateFrom);
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:02:43)
 * @param newDateFrom com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateFromFrm(String newDateFrom) {
	dateFrom.setString(newDateFrom);
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:05:15)
 * @param newDateTo com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateTo(Date newDateTo) {
	dateTo.setSqlDate(newDateTo);
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:05:15)
 * @param newDateTo com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateToFrm(String newDateTo) {
	dateTo.setString(newDateTo);
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:11:23)
 * @param newDocdate java.lang.String
 */
public void setDocdate(java.lang.String newDocdate) {
	docdate = newDocdate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:11:09)
 * @param newDocnumber java.lang.String
 */
public void setDocnumber(java.lang.String newDocnumber) {
	docnumber = newDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:07:03)
 * @param newIsAllContracts java.lang.Boolean
 */
public void setIsAllContracts(java.lang.Boolean newIsAllContracts) {
	isAllContracts = newIsAllContracts;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:12:29)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 10:12:13)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 13:06:33)
 * @param newSum1 java.lang.String
 */
public void setSum1(java.lang.String newSum1) {
	sum1 = newSum1;
}
/**
 * Insert the method's description here.
 * Creation date: (10.04.2003 13:06:33)
 * @param newSum2 java.lang.String
 */
public void setSum2(java.lang.String newSum2) {
	sum2 = newSum2;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (!getIsAllContracts().booleanValue()) {
		if (contractcode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.getpays.contractcode"));
		} else if (!contractcode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.getpays.contractcode"));
		} else {
			try {
				LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
				laanBean.setInitKey_leaseDocument(getContractcode().intValue());
				laanBean.refreshCopyHelper();
				
				if (laanBean.getMainDocument() != null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.getpays.contractcode"));
				}
			} catch (Exception ex) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.getpays.contractcode"));
				}
			}
		}
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
