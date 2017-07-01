package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import java.sql.*;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
/**
 * Bean-form
 * Форма"начало продления".
 * Creation date: (20.08.2002 15:44:04)
 * @author: Sergey Gourov
 */
public class StartProlongationForm extends com.hps.july.web.util.EditForm {
	private com.hps.july.web.util.StringAndSqlDateProperty date2;
	private com.hps.july.web.util.StringAndSqlDateProperty date1;
	private com.hps.july.web.util.StringAndIntegerProperty leaseDocumentcode;
	private java.lang.String documentNumber;
	private com.hps.july.web.util.StringAndSqlDateProperty documentDate;
	private com.hps.july.web.util.StringAndIntegerProperty economistcode;
	private java.lang.String economistname;
	private java.lang.String condition;
	private boolean isEconomistRole;
	private int operator;
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:47:57)
 */
public StartProlongationForm() {
	super();
	date1 = new StringAndSqlDateProperty();
	date2 = new StringAndSqlDateProperty();
	leaseDocumentcode = new StringAndIntegerProperty();
	documentDate = new StringAndSqlDateProperty();
	setDocumentDate(null);
	economistcode = new StringAndIntegerProperty();

	setCondition("A");
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 15:44:04)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 15:44:04)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2002 15:18:56)
 * @return java.lang.String
 */
public java.lang.String getCondition() {
	return condition;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 15:44:04)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:27:36)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDate1() {
	return date1.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:27:36)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDate1Frm() {
	return date1.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:27:36)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDate2() {
	return date2.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:27:36)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDate2Frm() {
	return date2.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:35:00)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDocumentDate() {
	return documentDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:35:00)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDocumentDateFrm() {
	return documentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:33:35)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:38:17)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getEconomistcode() {
	return economistcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:38:17)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getEconomistcodeFrm() {
	return economistcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:50:58)
 * @return java.lang.String
 */
public java.lang.String getEconomistname() {
	return economistname;
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
 * Creation date: (20.06.2003 15:16:56)
 * @return boolean
 */
public boolean getIsEconomistRole() {
	return isEconomistRole;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:30:52)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getLeaseDocumentcode() {
	return leaseDocumentcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:30:52)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getLeaseDocumentcodeFrm() {
	return leaseDocumentcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2003 15:33:47)
 * @return int
 */
public int getOperator() {
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 15:44:04)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.START_PROLONGATION_FORM;
}
/**
 * Форма для продления договора.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setIsEconomistRole(request.isUserInRole("ArendaEconomist"));
	if (getIsEconomistRole()) {
		try {
			setOperator(new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Lookup document name & date
	if (leaseDocumentcode.isOk() && !leaseDocumentcode.isEmpty()) {
		try {
			LeaseArendaAgreementNewAccessBean lab = new LeaseArendaAgreementNewAccessBean();
			lab.setInitKey_leaseDocument(getLeaseDocumentcode().intValue());
			lab.refreshCopyHelper();
			setDocumentDate(lab.getDocumentDate());
			setDocumentNumber(lab.getDocumentNumber());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2002 15:18:56)
 * @param newCondition java.lang.String
 */
public void setCondition(java.lang.String newCondition) {
	condition = newCondition;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:27:36)
 * @param newDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDate1(Date newDate) {
	date1.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:27:36)
 * @param newDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDate1Frm(String newDate) {
	date1.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:27:36)
 * @param newDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDate2(Date newDate) {
	date2.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:27:36)
 * @param newDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDate2Frm(String newDate) {
	date2.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:35:00)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDate(Date newDocumentDate) {
	documentDate.setSqlDate(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:35:00)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDateFrm(String newDocumentDate) {
	documentDate.setString(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:33:35)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:38:17)
 * @param newEconomistcode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setEconomistcode(Integer newEconomistcode) {
	economistcode.setInteger(newEconomistcode);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:38:17)
 * @param newEconomistcode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setEconomistcodeFrm(String newEconomistcode) {
	economistcode.setString(newEconomistcode);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:50:58)
 * @param newEconomistname java.lang.String
 */
public void setEconomistname(java.lang.String newEconomistname) {
	economistname = newEconomistname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2003 15:16:56)
 * @param newIsEconomistRole boolean
 */
public void setIsEconomistRole(boolean newIsEconomistRole) {
	isEconomistRole = newIsEconomistRole;
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:30:52)
 * @param newLeaseDocumentcode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setLeaseDocumentcode(Integer newLeaseDocumentcode) {
	leaseDocumentcode.setInteger(newLeaseDocumentcode);
}
/**
 * Insert the method's description here.
 * Creation date: (20.08.2002 16:30:52)
 * @param newLeaseDocumentcode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setLeaseDocumentcodeFrm(String newLeaseDocumentcode) {
	leaseDocumentcode.setString(newLeaseDocumentcode);
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2003 15:33:47)
 * @param newOperator int
 */
public void setOperator(int newOperator) {
	operator = newOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (getCondition().equals("E")) {
		if (economistcode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.prolongation.economist"));
		} else if (!economistcode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.prolongation.economist"));
		} else {
			try {
				WorkerAccessBean economist = new WorkerAccessBean();
				economist.setInitKey_worker(getEconomistcode().intValue());
				economist.refreshCopyHelper();
				
				try {
					if (getIsEconomistRole()) {
						OperatorAccessBean operatorBean = new OperatorAccessBean();
						operatorBean.setInitKey_operator(getOperator());
						operatorBean.refreshCopyHelper();
						
						boolean isExistWorker = false;
						java.util.Enumeration e = new WorkerAccessBean().findWorkersByMan(operatorBean.getManKey());
						while (e.hasMoreElements()) {
							WorkerAccessBean workerBean = (WorkerAccessBean) e.nextElement();
							if (workerBean.getWorker() == getEconomistcode().intValue()) {
								isExistWorker = true;
								break;
							}
						}
						
						if (!isExistWorker) {
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.prolongation.economist.notinrole"));
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} catch(Exception ex) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.prolongation.economist"));
				}
			}
		}
	} else if (getCondition().equals("C")) {
		if (leaseDocumentcode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.prolongation.leasedocument"));
		} else if (!leaseDocumentcode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.prolongation.leasedocument"));
		} else {
			try {
				LeaseArendaAgreementNewAccessBean lease = new LeaseArendaAgreementNewAccessBean();
				lease.setInitKey_leaseDocument(getLeaseDocumentcode().intValue());
				lease.refreshCopyHelper();
			} catch(Exception ex) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.prolongation.leasedocument"));
				}
			}
		}
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
