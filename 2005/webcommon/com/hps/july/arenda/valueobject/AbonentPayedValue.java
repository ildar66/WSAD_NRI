package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
import java.math.*;
import java.util.*;
/**
 * Bean-Wrapper "Связь между платежами и счетами"
 */
public class AbonentPayedValue {
	private LeaseAbonentDNOPAccessBean o;
	private java.sql.Date billdate;
	private String billnumber;
	private BigDecimal billsumm;
	private String billcurrency;
	private BigDecimal payed;
public AbonentPayedValue(LeaseAbonentDNOPAccessBean bean) {
	o = bean;
   	try {
		billcurrency = "USD?";
		billdate = o.getAbonentbill().getBilldate();
		billnumber = o.getAbonentbill().getBillnumber();
		AbonentBillPosAccessBean bposl = new AbonentBillPosAccessBean();
		AbonentBillPosAccessBean bpos;
		Enumeration ebp = bposl.findAbonentBillPosesByPos2bill(new AbonentBillKey(o.getAbonentbill().getLeasebill()));
		billsumm = new BigDecimal("0.00");
		payed = new BigDecimal("0.00");
		while(ebp.hasMoreElements()) {
			bpos = (AbonentBillPosAccessBean)ebp.nextElement();
			billsumm = billsumm.add(bpos.getSumm());
			billsumm.setScale(2,BigDecimal.ROUND_HALF_UP);
			payed = payed.add(bpos.getSummnri());
			payed.setScale(2,BigDecimal.ROUND_HALF_UP);
		}
	} catch (Exception e) {
		billcurrency = "?";
		billdate = new java.sql.Date(System.currentTimeMillis());
		billnumber = "?";
		billsumm = new BigDecimal("0.00");
		payed = new BigDecimal("0.00");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @return java.lang.String
 */
public java.lang.String getBillcurrency() {
	return billcurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @return java.sql.Date
 */
public java.sql.Date getBilldate() {
	return billdate;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @return java.lang.String
 */
public java.lang.String getBillnumber() {
	return billnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getBillsumm() {
	return billsumm;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @return com.hps.july.persistence.LeaseAbonentDNOPAccessBean
 */
public com.hps.july.persistence.LeaseAbonentDNOPAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPayed() {
	return payed;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @param newBillcurrency java.lang.String
 */
public void setBillcurrency(java.lang.String newBillcurrency) {
	billcurrency = newBillcurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @param newBilldate java.sql.Date
 */
public void setBilldate(java.sql.Date newBilldate) {
	billdate = newBilldate;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @param newBillnumber java.lang.String
 */
public void setBillnumber(java.lang.String newBillnumber) {
	billnumber = newBillnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @param newBillsumm java.math.BigDecimal
 */
public void setBillsumm(java.math.BigDecimal newBillsumm) {
	billsumm = newBillsumm;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @param newO com.hps.july.persistence.LeaseAbonentDNOPAccessBean
 */
public void setO(com.hps.july.persistence.LeaseAbonentDNOPAccessBean newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 14:01:02)
 * @param newPayed java.math.BigDecimal
 */
public void setPayed(java.math.BigDecimal newPayed) {
	payed = newPayed;
}
}
