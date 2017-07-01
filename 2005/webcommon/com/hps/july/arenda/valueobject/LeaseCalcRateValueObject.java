package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
/**
 * Bean-Wrapper "Курсы зачета при расчете акта".
 * Creation date: (18.01.2003 14:19:48)
 * @author: Sergey Gourov
 */
public class LeaseCalcRateValueObject {
	private com.hps.july.persistence.LeaseCalcRateAccessBean o;
	private java.math.BigDecimal sum;
/**
 * LeaseCalcRateValueObject constructor comment.
 */
public LeaseCalcRateValueObject(LeaseCalcRateAccessBean bean) {
	super();
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2003 14:20:19)
 * @return com.hps.july.persistence.LeaseCalcRateAccessBean
 */
public com.hps.july.persistence.LeaseCalcRateAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2003 14:22:10)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSum() {
	return sum;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2003 14:20:19)
 * @param newO com.hps.july.persistence.LeaseCalcRateAccessBean
 */
public void setO(com.hps.july.persistence.LeaseCalcRateAccessBean newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2003 14:22:10)
 * @param newSum java.math.BigDecimal
 */
public void setSum(java.math.BigDecimal newSum) {
	sum = newSum;
}
}
