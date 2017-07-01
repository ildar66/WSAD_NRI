package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
/**
 * Контейнер "Договора и услуги для акта взаимозачета"
 * Creation date: (05.12.2002 10:29:54)
 * @author: Sergey Gourov
 */
public class LeaseMutualContractsValueObject {
	private com.hps.july.persistence.LeaseMutualContractsAccessBean o;
	private java.util.Map params;
/**
 * LeaseMutualContracts constructor comment.
 */
public LeaseMutualContractsValueObject(LeaseMutualContractsAccessBean bean) {
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 10:30:53)
 * @return com.hps.july.persistence.LeaseMutualContractsAccessBean
 */
public com.hps.july.persistence.LeaseMutualContractsAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 10:32:43)
 * @return java.util.Map
 */
public java.util.Map getParams() {
	return params;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 10:30:53)
 * @param newO com.hps.july.persistence.LeaseMutualContractsAccessBean
 */
public void setO(com.hps.july.persistence.LeaseMutualContractsAccessBean newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 10:32:43)
 * @param newParams java.util.Map
 */
public void setParams(java.util.Map newParams) {
	params = newParams;
}
}
