package com.hps.july.arenda.formbean;

import java.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.sql.Date;
/**
 * Form-Bean.
 * Расчет контракта - шаг 1
 * Creation date: (26.12.2002 11:54:23)
 * @author: Sergey Gourov
 */
public class CalcContractStep1Form extends com.hps.july.web.util.EditForm {
	private java.lang.String documentNumber;
	private StringAndSqlDateProperty startDate;
	private StringAndSqlDateProperty endDate;
	private java.lang.String orgCustomerContract;
	private java.lang.String orgExecutorContract;
	private String costcurrency1;
	private String costcurrency2;
	private java.lang.String curr1;
	private java.lang.String curr2;
	private int leaseContract;
	private int resource;
	private com.hps.july.web.util.StringAndSqlDateProperty begindate;
	private com.hps.july.web.util.StringAndSqlDateProperty enddate;
	private java.sql.Date userbegindate;
	private java.sql.Date userenddate;
	private java.sql.Date lastsaldodate;
	protected java.lang.String listForm;
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 12:53:39)
 */
public CalcContractStep1Form() {
	super();
	endDate = new StringAndSqlDateProperty();
	startDate = new StringAndSqlDateProperty();
	begindate = new StringAndSqlDateProperty();
	enddate = new StringAndSqlDateProperty();
	listForm = "WeArendaForm";
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:54:23)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:54:23)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:49:03)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getBegindate() {
	return begindate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:49:03)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getBegindateFrm() {
	return begindate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @return java.lang.String
 */
public java.lang.String getCostcurrency1() {
	return costcurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @return java.lang.String
 */
public java.lang.String getCostcurrency2() {
	return costcurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:54:23)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 12:52:10)
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
public Date getEnddate() {
	return enddate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:56:33)
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
public String getEnddateFrm() {
	return enddate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:56:33)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEndDateFrm() {
	return endDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 20:42:21)
 * @return java.sql.Date
 */
public java.sql.Date getLastsaldodate() {
	return lastsaldodate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 14:44:51)
 * @return int
 */
public int getLeaseContract() {
	return leaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomerContract() {
	return orgCustomerContract;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutorContract() {
	return orgExecutorContract;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 16:11:51)
 * @return int
 */
public int getResource() {
	return resource;
}
public java.util.Enumeration getResources() {
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();

		return new ResourceAccessBean().findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}	
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
 * Creation date: (26.12.2002 11:54:23)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CALC_CONTRACT_STEP1;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:45:17)
 * @return java.sql.Date
 */
public java.sql.Date getUserbegindate() {
	return userbegindate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:46:48)
 * @return java.sql.Date
 */
public java.sql.Date getUserenddate() {
	return userenddate;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    WeArendaForm form = (WeArendaForm) request.getSession().getAttribute(listForm);
    setDocumentNumber(form.getDocumentNumber());
    setOrgCustomerContract(form.getOrgCustomer().getName());
    setOrgExecutorContract(form.getOrgExecutor().getName());
    setStartDate(form.getStartDate());
    setEndDate(form.getEndDate());
	if (form.getCurrency1() != null) {
	    setCostcurrency1(form.getSumm1Frm());
	    setCurr1(form.getCurrency1().getShortname());
	} else {
		setCostcurrency1("");
		setCurr1("");
	}
	if (form.getCurrency2() != null) {
	    setCostcurrency2(form.getSumm2Frm());
	    setCurr2(form.getCurrency2().getShortname());
	} else {
		setCostcurrency2("");
		setCurr2("");
	}
	//setLeaseContractcode(new Integer(form.getLeaseContract()));
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:49:03)
 * @param newBegindate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBegindate(Date newBegindate) {
	begindate.setSqlDate(newBegindate);
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:49:03)
 * @param newBegindate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setBegindateFrm(String newBegindate) {
	begindate.setString(newBegindate);
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @param newCostcurrency1 java.lang.String
 */
public void setCostcurrency1(java.lang.String newCostcurrency1) {
	costcurrency1 = newCostcurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @param newCostcurrency2 java.lang.String
 */
public void setCostcurrency2(java.lang.String newCostcurrency2) {
	costcurrency2 = newCostcurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 12:52:10)
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
public void setEnddate(Date newEndDate) {
	enddate.setSqlDate(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:56:33)
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
public void setEnddateFrm(String newEndDate) {
	enddate.setString(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (13.12.2002 14:56:33)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDateFrm(String newEndDate) {
	endDate.setString(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 20:42:21)
 * @param newLastsaldodate java.sql.Date
 */
public void setLastsaldodate(java.sql.Date newLastsaldodate) {
	lastsaldodate = newLastsaldodate;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 14:44:51)
 * @param newLeaseContract int
 */
public void setLeaseContract(int newLeaseContract) {
	leaseContract = newLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @param newOrgCustomerContract java.lang.String
 */
public void setOrgCustomerContract(java.lang.String newOrgCustomerContract) {
	orgCustomerContract = newOrgCustomerContract;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 13:01:20)
 * @param newOrgExecutorContract java.lang.String
 */
public void setOrgExecutorContract(java.lang.String newOrgExecutorContract) {
	orgExecutorContract = newOrgExecutorContract;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 16:11:51)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
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
 * Creation date: (27.12.2002 14:45:17)
 * @param newUserbegindate java.sql.Date
 */
public void setUserbegindate(java.sql.Date newUserbegindate) {
	userbegindate = newUserbegindate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:46:48)
 * @param newUserenddate java.sql.Date
 */
public void setUserenddate(java.sql.Date newUserenddate) {
	userenddate = newUserenddate;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	setUserbegindate(null);
	setUserenddate(getEnddate());
	
	Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateAsc(
		new Integer(getLeaseContract()), new Integer(getResource()));
	if (e.hasMoreElements()) {
		LeaseSaldoAccessBean bean = (LeaseSaldoAccessBean) e.nextElement();
		if (bean.getSalDate().compareTo(getBegindate()) <= 0) {
			setUserbegindate(bean.getSalDate());
		}
	}

	if (getUserbegindate() == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.calccontract.begindate"));
	}

	e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
		new Integer(getLeaseContract()), new Integer(getResource()));
	if (e.hasMoreElements()) {
		LeaseSaldoAccessBean bean = (LeaseSaldoAccessBean) e.nextElement();
		setLastsaldodate(bean.getSalDate());
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.calccontract.nosaldo"));
	}

	e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
		new Integer(getLeaseContract()), new Integer(getResource()));
	if (e.hasMoreElements()) {
		LeaseSaldoAccessBean bean = (LeaseSaldoAccessBean) e.nextElement();
		if (bean.getSalDate().compareTo(getEnddate()) >= 0) {
			setUserenddate(bean.getSalDate());
		}
	}

	if (getLastsaldodate() != null && getUserenddate() != null) {
		GregorianCalendar start = new GregorianCalendar();
		start.setTime(getLastsaldodate());
		start.add(Calendar.DAY_OF_MONTH, 1);
		
		if (start.getTime().compareTo(getUserenddate()) >= 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.calccontract.act"));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.calccontract.noperiodact"));
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
