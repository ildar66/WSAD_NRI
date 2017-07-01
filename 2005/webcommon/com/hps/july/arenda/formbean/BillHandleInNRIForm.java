package com.hps.july.arenda.formbean;

import com.hps.july.arenda.billing.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import java.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
/**
 * Form-Bean.
 * —чет обработанный в NRI
 * Creation date: (22.04.2003 15:20:49)
 * @author: Sergey Gourov
 */
public class BillHandleInNRIForm extends com.hps.july.web.util.EditForm {
	private java.lang.String doHandle;
	private int leaseBill;
	private boolean isA;
	private boolean isB;
	private int taskcode;
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 15:36:13)
 */
public BillHandleInNRIForm() {
	setAction("Add");
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	boolean isError = false;
	try {
		AbonentBillAccessBean abBean = new AbonentBillAccessBean();
		abBean.setInitKey_leasebill(getLeaseBill());
		abBean.refreshCopyHelper();
		
		abBean.setFlagworknri(false);
		Boolean initUseinnri = abBean.getUseinnri();
		
		if (getDoHandle().equals("A")) {
			abBean.setUseinnri(new Boolean(true));
		} else if (getDoHandle().equals("B")) {
			abBean.setUseinnri(new Boolean(false));
		}
		
		if (!abBean.getUseinnri().equals(initUseinnri)) {
			abBean.setChangeuseinnri("H");
		}
		
		abBean.commitCopyHelper();
		
		int operator = 1; // only for wte!!! set operator = 0 for ws!!!
		try {
			operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Pie2NriAccessBean processor = new Pie2NriAccessBean();
		setTaskcode(processor.taskStart(operator, "6"));
		isError = !new BufferNri2NriAccessBean().moveOneBillBufferNri2Nri(getTaskcode(), new Integer(getLeaseBill()));
		processor.taskEnd(getTaskcode());
	} catch (Exception e) {
		e.printStackTrace();
		isError = true;
	}
	
	if (isError) {
		throw new UpdateValidationException("error.invalid.handleinnr.general.bill");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 15:20:49)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 15:20:49)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 15:20:49)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 15:35:37)
 * @return java.lang.String
 */
public java.lang.String getDoHandle() {
	return doHandle;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 16:39:28)
 * @return boolean
 */
public boolean getIsA() {
	return isA;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 16:40:18)
 * @return boolean
 */
public boolean getIsB() {
	return isB;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 15:56:23)
 * @return int
 */
public int getLeaseBill() {
	return leaseBill;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2003 12:57:18)
 * @return java.util.Map
 */
public Map getParams() {
	Hashtable h = new Hashtable();
	h.put("taskStartcode", new Integer(getTaskcode()));
	h.put("leaseBill", new Integer(getLeaseBill()));
	return h;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 15:20:49)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_BILL_HANDLE_INNRI;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2003 19:02:07)
 * @return int
 */
public int getTaskcode() {
	return taskcode;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setTaskcode(0);
	setIsA(true);
	setIsB(true);
	
	AbonentBillAccessBean abBean = new AbonentBillAccessBean();
	abBean.setInitKey_leasebill(getLeaseBill());
	abBean.refreshCopyHelper();
	
	if (abBean.getFlagworknri()) {
		if (abBean.getUseinnri() != null && abBean.getUseinnri().booleanValue()) {
			setDoHandle("B");
			setIsA(false);
		} else {
			setDoHandle("A");
			setIsB(false);
		}
	} else {
		setDoHandle("A");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 15:35:37)
 * @param newDoHandle java.lang.String
 */
public void setDoHandle(java.lang.String newDoHandle) {
	doHandle = newDoHandle;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 16:39:28)
 * @param newIsA boolean
 */
public void setIsA(boolean newIsA) {
	isA = newIsA;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 16:40:18)
 * @param newIsB boolean
 */
public void setIsB(boolean newIsB) {
	isB = newIsB;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 15:56:23)
 * @param newLeaseBill int
 */
public void setLeaseBill(int newLeaseBill) {
	leaseBill = newLeaseBill;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2003 19:02:07)
 * @param newTaskcode int
 */
public void setTaskcode(int newTaskcode) {
	taskcode = newTaskcode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	AbonentBillAccessBean bean = new AbonentBillAccessBean();
	bean.setInitKey_leasebill(getLeaseBill());
	bean.refreshCopyHelper();
	
	GregorianCalendar c = new GregorianCalendar();
	
	Enumeration e = new LeaseSaldoAccessBean().findByQBE(new Integer(bean.getLeaseabonentbanKey().leaseDocument), new Boolean(false), null, null, new Integer(2));
	if (e.hasMoreElements()) {
		LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) e.nextElement();
		c.setTime(lsBean.getSalDate());
	} else {
		c.clear();
	}
	
	if (bean.getBilldate() == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.handleinnri.billdate"));
	} else if (bean.getBilldate().compareTo(c.getTime()) <= 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.handleinnri.dates.bill"));
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
