package com.hps.july.arenda.formbean;

import com.hps.july.arenda.billing.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import java.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
/**
 * Bean-form
 * Форма "Платежи обработанные в NRI".
 * Creation date: (23.04.2003 11:09:15)
 * @author: Sergey Gourov
 */
public class PayHandleInNRIForm extends BillHandleInNRIForm {
	private int paypos;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	boolean isError = false;
	try {
		AbonentPaymentAccessBean apBean = new AbonentPaymentAccessBean();
		apBean.setInitKey_paypos(getPaypos());
		apBean.refreshCopyHelper();
		
		apBean.setFlagworknri(false);
		boolean initNeedpay = apBean.getNeedpay();
		
		if (getDoHandle().equals("A")) {
			apBean.setNeedpay(true);
		} else if (getDoHandle().equals("B")) {
			apBean.setNeedpay(false);
		}
		
		if (apBean.getNeedpay() != initNeedpay) {
			apBean.setChangeneedpay("H");
		}
		apBean.commitCopyHelper();
		
		int operator = 1; // only for wte!!! set operator = 0 for ws!!!
		try {
			operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Pie2NriAccessBean processor = new Pie2NriAccessBean();
		setTaskcode(processor.taskStart(operator, "6"));
		isError = !new BufferNri2NriAccessBean().moveOnePaymentBufferNri2Nri(getTaskcode(), new Integer(getPaypos()), true);
		processor.taskEnd(getTaskcode());
	} catch (Exception e) {
		e.printStackTrace();
		isError = true;
	}
	
	if (isError) {
		throw new UpdateValidationException("error.invalid.handleinnr.general.pay");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2003 12:57:18)
 * @return java.util.Map
 */
public Map getParams() {
	Hashtable h = new Hashtable();
	h.put("taskStartcode", new Integer(getTaskcode()));
	h.put("paypos", new Integer(getPaypos()));
	return h;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2003 11:14:18)
 * @return int
 */
public int getPaypos() {
	return paypos;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 15:20:49)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_PAY_HANDLE_INNRI;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setTaskcode(0);
	setIsA(true);
	setIsB(true);
	
	AbonentPaymentAccessBean apBean = new AbonentPaymentAccessBean();
	apBean.setInitKey_paypos(getPaypos());
	apBean.refreshCopyHelper();
	
	if (apBean.getFlagworknri()) {
		if (apBean.getNeedpay()) {
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
 * Creation date: (23.04.2003 11:14:18)
 * @param newPaypos int
 */
public void setPaypos(int newPaypos) {
	paypos = newPaypos;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
/**
 * 16.04.04 по заявке Борцова
	AbonentPaymentAccessBean bean = new AbonentPaymentAccessBean();
	bean.setInitKey_paypos(getPaypos());
	bean.refreshCopyHelper();
	
	GregorianCalendar c = new GregorianCalendar();
	
	Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
		new Integer(bean.getLeaseabonentbanKey().leaseDocument), bean.getResource());
	if (e.hasMoreElements()) {
		LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) e.nextElement();
		c.setTime(lsBean.getSalDate());
	} else {
		c.clear();
	}
	
	if (bean.getPaydate().compareTo(c.getTime()) <= 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.handleinnri.dates.pay"));
	}
	if (!errors.empty()) {
		throw new ValidationException();
	}
*/		
}
}
