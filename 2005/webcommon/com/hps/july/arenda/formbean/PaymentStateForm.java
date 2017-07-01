package com.hps.july.arenda.formbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.*;
import com.hps.july.platinum.sessionbean.*;
import com.ibm.ivj.ejb.runtime.*;
import java.util.Enumeration;
import org.apache.struts.action.*;
import java.sql.Date;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.math.*;
import com.hps.july.arenda.*;
/**
 * Bean-form
 * Форма "Состояние платежа".
 * Creation date: (18.12.2002 22:34:36)
 * @author: Sergey Gourov
 */
public class PaymentStateForm extends com.hps.july.web.util.EditForm {
	private int leaseDocPosition;
	private java.lang.String paymentstate;
	private java.lang.String documentNumber;
	private StringAndSqlDateProperty endDate;
	private StringAndSqlDateProperty startDate;
	private java.lang.String orgCustomerContract;
	private java.lang.String orgExecutorContract;
	private String costcurrency1;
	private String costcurrency2;
	private java.lang.String curr1;
	private java.lang.String curr2;
	protected String listForm;
	private java.lang.Integer leaseContractcode;
	protected java.lang.String initialState;
	protected java.lang.String forMove2pie;
	private String certainValue1;
	private String certainValue2;
	private java.lang.String tempState;

	private Integer usedinact;

	private Boolean isProcError;
	private String procError;
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:32:05)
 */
public PaymentStateForm() {
	startDate = new StringAndSqlDateProperty();
	endDate = new StringAndSqlDateProperty();
	setPaystate("G");
	listForm = "PaymentsListForm";
	forMove2pie = "wepaystate";
	setTempState("");
	setCertainValue1("true");
	setCertainValue2("true");
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	changePaymentState();
	
	if (getState() == com.hps.july.arenda.APPStates.STATE_PAYMENT_EDIT || getState() == com.hps.july.arenda.APPStates.HISTORY_STATE_PAYMENT_EDIT) {
		request.getSession().setAttribute(forMove2pie, new Object[] { new Integer(getLeaseDocPosition()), getInitialState(), getPaystate() });
	}
}
public void changePaymentState()
	throws ValidationException, UpdateValidationException
{
	JdbcConnection jcon = new JdbcConnection();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		con = jcon.getConnection();
		ps = con.prepareStatement("execute procedure changeStatePay(?,?,?)");
		ps.setInt(1,getLeaseDocPosition());
		ps.setString(2,getInitialState());
		ps.setString(3,getPaystate());
System.out.println("EXEC PAYSTATE CHANGE("+getLeaseDocPosition()+","+getInitialState()+","+getPaystate()+")");
		rs = ps.executeQuery();
System.out.println("EXEC PAYSTATE CHANGE: GOT RESULTSET");
		if (rs.next()) {
System.out.println("EXEC PAYSTATE CHANGE: "+rs.getInt(1));
			if(rs.getInt(1) == 0) {
				setIsProcError(Boolean.FALSE);
			} else {
System.out.println("EXEC PAYSTATE CHANGE: ERROR:"+getProcError());
				setIsProcError(Boolean.TRUE);
				setProcError(rs.getString(2));
			}
		}
	}
	catch(SQLException se) {
		se.printStackTrace(System.out);
		throw new UpdateValidationException("error.payment.state.sqlexception");
	}
	catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.payment.state.exception");
	}
	finally {
		try { if(rs != null) rs.close(); } catch(Exception e) { e.printStackTrace(System.out); }
		try { if(ps != null) ps.close(); } catch(Exception e) { e.printStackTrace(System.out); }
		try { if(con != null) con.close(); } catch(Exception e) { e.printStackTrace(System.out); }
	}
	if(getIsProcError() != null && getIsProcError().booleanValue()) {
		throw new ValidationException();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 19:11:33)
 * @exception java.lang.Exception The exception description.
 */
private boolean checkLink2Pay() throws java.lang.Exception {
	Enumeration e = new LeaseDNOPAccessBean().findLeaseDNOPByLeaseCharge(new LeaseDocPositionKey(getLeaseDocPosition()));
	if (e.hasMoreElements()) {
		return false;
	}
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 16:34:54)
 * @return boolean
 */
private boolean checkOpenPeriod() throws Exception {
	LeasePaymentAccessBean bean = new LeasePaymentAccessBean();
	bean.setInitKey_leaseDocPosition(getLeaseDocPosition());
	bean.refreshCopyHelper();

	Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
		getLeaseContractcode(), new Integer(bean.getResourceKey().resource));
	if (e.hasMoreElements()) {
		LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) e.nextElement();
		return bean.getDate().after(lsBean.getSalDate()) ? true : false;
	}
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 22:34:36)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	setPaystate(initialState);
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 22:34:36)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2003 16:45:59)
 * @return boolean
 */
public String getCertainValue1() {
	return certainValue1;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2003 17:01:32)
 * @return java.lang.String
 */
public java.lang.String getCertainValue2() {
	return certainValue2;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:28:00)
 * @return java.lang.String
 */
public java.lang.String getCostcurrency1() {
	return costcurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:28:00)
 * @return java.lang.String
 */
public java.lang.String getCostcurrency2() {
	return costcurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:28:00)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:28:00)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 22:34:36)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
{
	try {
		LeasePaymentAccessBean bean = new LeasePaymentAccessBean();
		bean.setInitKey_leaseDocPosition(getLeaseDocPosition());
		bean.refreshCopyHelper();
		initialState = bean.getPaymentstate();
		setTempState(initialState);
		return bean;
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:22:55)
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
 * Creation date: (20.12.2002 13:10:07)
 * @return java.lang.String
 */
public java.lang.String getInitialState() {
	return initialState;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsProcError() {
	return isProcError;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:58:27)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseContractcode() {
	return leaseContractcode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 22:38:32)
 * @return int
 */
public int getLeaseDocPosition() {
	return leaseDocPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:26:50)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomerContract() {
	return orgCustomerContract;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:27:05)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutorContract() {
	return orgExecutorContract;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 22:41:18)
 * @return java.lang.String
 */
public java.lang.String getPaystate() {
	return paymentstate;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getProcError() {
	return procError;
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
 * Creation date: (18.12.2002 22:34:36)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.STATE_PAYMENT_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2003 18:45:13)
 * @return java.lang.String
 */
public java.lang.String getTempState() {
	return tempState;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getUsedinact() {
	return usedinact;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    PaymentsListForm form = (PaymentsListForm) request.getSession().getAttribute(listForm);
    setDocumentNumber(form.getDocumentNumber());
    setOrgCustomerContract(form.getOrgCustomer());
    setOrgExecutorContract(form.getOrgExecutor());
    setStartDate(form.getStartDate());
    setEndDate(form.getEndDate());
	if (form.getCurrency1() != null) {
	    setCostcurrency1(form.getCurrency1().toString());
	    setCurr1(form.getCurr1());
	} else {
		setCostcurrency1("");
	}
	if (form.getCurrency2() != null) {
	    setCostcurrency2(form.getCurrency2().toString());
	    setCurr2(form.getCurr2());
	} else {
		setCostcurrency2("");
	}
	setLeaseContractcode(new Integer(form.getLeaseContract()));
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2003 16:45:59)
 * @param newCertainValue boolean
 */
public void setCertainValue1(String newCertainValue1) {
	certainValue1 = newCertainValue1;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2003 17:01:32)
 * @param newCertainValue2 java.lang.String
 */
public void setCertainValue2(java.lang.String newCertainValue2) {
	certainValue2 = newCertainValue2;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:28:00)
 * @param newCostcurrency1 java.lang.String
 */
public void setCostcurrency1(java.lang.String newCostcurrency1) {
	costcurrency1 = newCostcurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:28:00)
 * @param newCostcurrency2 java.lang.String
 */
public void setCostcurrency2(java.lang.String newCostcurrency2) {
	costcurrency2 = newCostcurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:28:00)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:28:00)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:22:55)
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
 * Creation date: (20.12.2002 13:10:07)
 * @param newInitialState java.lang.String
 */
public void setInitialState(java.lang.String newInitialState) {
	initialState = newInitialState;
}
/**
 * 
 * @param newIsProcError java.lang.Boolean
 */
public void setIsProcError(java.lang.Boolean newIsProcError) {
	isProcError = newIsProcError;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:58:27)
 * @param newLeaseContractcode java.lang.Integer
 */
public void setLeaseContractcode(java.lang.Integer newLeaseContractcode) {
	leaseContractcode = newLeaseContractcode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 22:38:32)
 * @param newLeaseDocPosition int
 */
public void setLeaseDocPosition(int newLeaseDocPosition) {
	leaseDocPosition = newLeaseDocPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:26:50)
 * @param newOrgCustomerContract java.lang.String
 */
public void setOrgCustomerContract(java.lang.String newOrgCustomerContract) {
	orgCustomerContract = newOrgCustomerContract;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 23:27:05)
 * @param newOrgExecutorContract java.lang.String
 */
public void setOrgExecutorContract(java.lang.String newOrgExecutorContract) {
	orgExecutorContract = newOrgExecutorContract;
}
/**
 * Insert the method's description here.
 * Creation date: (18.12.2002 22:41:18)
 * @param newPaymentstate java.lang.String
 */
public void setPaystate(java.lang.String newPaymentstate) {
	paymentstate = newPaymentstate;
}
/**
 * 
 * @param newProcError java.lang.String
 */
public void setProcError(java.lang.String newProcError) {
	procError = newProcError;
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
 * Creation date: (11.07.2003 18:45:13)
 * @param newTempState java.lang.String
 */
public void setTempState(java.lang.String newTempState) {
	tempState = newTempState;
}
/**
 * 
 * @param newUsedinact java.lang.Integer
 */
public void setUsedinact(java.lang.Integer newUsedinact) {
	usedinact = newUsedinact;
}
public void validateValues(ActionErrors errors)
	throws Exception
{
}
}
