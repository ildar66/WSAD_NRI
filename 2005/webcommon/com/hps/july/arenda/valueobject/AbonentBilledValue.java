package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
import java.math.*;
import java.util.*;
/**
 * Bean-Wrapper
 * "Связь между платежами и счетами"
 */
public class AbonentBilledValue {
	private LeaseAbonentDNOPAccessBean o;
	private BigDecimal billsumm;
public AbonentBilledValue(LeaseAbonentDNOPAccessBean bean) {
	o = bean;
}
/**
 * Creation date: (24.04.2003 17:14:35)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getBillsumm() {
	return billsumm;
}
/**
 * Creation date: (04.03.2003 14:29:31)
 * @return com.hps.july.persistence.LeaseAbonentDNOPAccessBean
 */
public com.hps.july.persistence.LeaseAbonentDNOPAccessBean getO() {
	return o;
}
/**
 * Creation date: (24.04.2003 17:14:35)
 * @param newBillsumm java.math.BigDecimal
 */
public void setBillsumm(java.math.BigDecimal newBillsumm) {
	billsumm = newBillsumm;
}
/**
 * Creation date: (04.03.2003 14:29:31)
 * @param newO com.hps.july.persistence.LeaseAbonentDNOPAccessBean
 */
public void setO(com.hps.july.persistence.LeaseAbonentDNOPAccessBean newO) {
	o = newO;
}
}
