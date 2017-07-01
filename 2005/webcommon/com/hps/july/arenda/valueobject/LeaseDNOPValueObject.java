package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
/**
 * Bean-Wrapper "Оплаты начислений"
 * Creation date: (25.01.2003 12:56:24)
 * @author: Sergey Gourov
 */
public class LeaseDNOPValueObject {
	private com.hps.july.persistence.LeaseDNOPAccessBean o;
	private java.math.BigDecimal rate;
	private String payPurpose;
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 12:57:32)
 * @param bean com.hps.july.persistence.LeaseDNOPAccessBean
 */
public LeaseDNOPValueObject(com.hps.july.persistence.LeaseDNOPAccessBean bean) {
	super();
	o = bean;
	try {
		LeasePaymentAccessBean lpab = o.getLeasePayment();
		if(lpab != null && lpab.getEJBRef() instanceof LeasePayOrder) {
			LeasePayOrderAccessBean lpoab = new LeasePayOrderAccessBean(lpab.getEJBRef());
			lpoab.refreshCopyHelper();
			payPurpose = lpoab.getPayPurpose();
		} else {
			payPurpose = null;
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 12:57:01)
 * @return com.hps.july.persistence.LeaseDNOPAccessBean
 */
public com.hps.july.persistence.LeaseDNOPAccessBean getO() {
	return o;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPayPurpose() {
	return payPurpose;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 12:58:42)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRate() {
	return rate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 12:57:01)
 * @param newO com.hps.july.persistence.LeaseDNOPAccessBean
 */
public void setO(com.hps.july.persistence.LeaseDNOPAccessBean newO) {
	o = newO;
}
/**
 * 
 * @param newPayPurpose java.lang.String
 */
public void setPayPurpose(java.lang.String newPayPurpose) {
	payPurpose = newPayPurpose;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 12:58:42)
 * @param newRate java.math.BigDecimal
 */
public void setRate(java.math.BigDecimal newRate) {
	rate = newRate;
}
}
