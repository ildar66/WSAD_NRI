package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
/**
 * Контейнер "Счета-фактуры по аренде"
 * Creation date: (22.05.2003 17:54:34)
 * @author: Sergey Gourov
 */
public class LeaseSchetFaktValueObject {
	private com.hps.july.persistence.LeaseSchetFaktAccessBean o;
	private java.math.BigDecimal sumwithtax;
/**
 * LeaseSchetFaktValueObject constructor comment.
 */
public LeaseSchetFaktValueObject(LeaseSchetFaktAccessBean bean) {
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 17:55:34)
 * @return com.hps.july.persistence.LeaseSchetFaktAccessBean
 */
public com.hps.july.persistence.LeaseSchetFaktAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 17:56:52)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumwithtax() {
	return sumwithtax;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 17:55:34)
 * @param newO com.hps.july.persistence.LeaseSchetFaktAccessBean
 */
public void setO(com.hps.july.persistence.LeaseSchetFaktAccessBean newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 17:56:52)
 * @param newSumwithtax java.math.BigDecimal
 */
public void setSumwithtax(java.math.BigDecimal newSumwithtax) {
	sumwithtax = newSumwithtax;
}
}
