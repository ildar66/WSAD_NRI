package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
import java.math.*;
import java.util.*;
/**
 * Bean-Wrapper 
 * "ѕлатежи по абонентским договорам из биллинга"
 */
public class AbonentPayValue {
	private AbonentPaymentAccessBean o;
	private int leasedocument;
	private BigDecimal payrate;
	private java.math.BigDecimal payed;
public AbonentPayValue(AbonentPaymentAccessBean bean) {
	o = bean;
   	try {
		leasedocument = o.getLeaseabonentban().getLeaseDocument();
		try {
			payrate = o.getSumpayrur().divide(o.getSumpayusd(),4,BigDecimal.ROUND_CEILING);
		} catch(Exception e) {
			payrate = null;
		}
	} catch (Exception e) {
		leasedocument = 0;
	}

	payed = new BigDecimal(0);
	try {
		Enumeration e = new LeaseAbonentDNOPAccessBean().findLeaseAbonentDNOPsByAbonentpayment(new AbonentPaymentKey(bean.getPaypos()));
		while (e.hasMoreElements()) {
			LeaseAbonentDNOPAccessBean ladBean = (LeaseAbonentDNOPAccessBean) e.nextElement();
			if (ladBean.getRecordstatus().equals("A")) {
				payed = payed.add(ladBean.getSumlinkusd()).setScale(2, BigDecimal.ROUND_HALF_UP);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
		payed = new BigDecimal(0);
	}
}
/**
 * 
 * @return int
 */
public int getLeasedocument() {
	return leasedocument;
}
/**
 * 
 * @return com.hps.july.persistence.AbonentPaymentAccessBean
 */
public com.hps.july.persistence.AbonentPaymentAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2003 12:16:29)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPayed() {
	return payed;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 13:03:24)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPayrate() {
	return payrate;
}
/**
 * 
 * @param newLeasedocument int
 */
public void setLeasedocument(int newLeasedocument) {
	leasedocument = newLeasedocument;
}
/**
 * 
 * @param newO com.hps.july.persistence.AbonentPaymentAccessBean
 */
public void setO(com.hps.july.persistence.AbonentPaymentAccessBean newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2003 12:16:29)
 * @param newPayed java.math.BigDecimal
 */
public void setPayed(java.math.BigDecimal newPayed) {
	payed = newPayed;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 13:03:24)
 * @param newPayrate java.math.BigDecimal
 */
public void setPayrate(java.math.BigDecimal newPayrate) {
	payrate = newPayrate;
}
}
