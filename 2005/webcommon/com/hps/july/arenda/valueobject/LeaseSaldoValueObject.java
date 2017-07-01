package com.hps.july.arenda.valueobject;

/**
 * Контейнер "Сальдо по договорам".
 * Creation date: (23.12.2002 21:13:21)
 * @author: Sergey Gourov
 */
public class LeaseSaldoValueObject {
	private com.hps.july.persistence.LeaseSaldoAccessBean o;
	private java.util.Map params;
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 21:14:24)
 * @param bean com.hps.july.persistence.LeaseSaldoAccessBean
 */
public LeaseSaldoValueObject(com.hps.july.persistence.LeaseSaldoAccessBean bean) {
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 21:13:45)
 * @return com.hps.july.persistence.LeaseSaldoAccessBean
 */
public com.hps.july.persistence.LeaseSaldoAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 21:15:09)
 * @return java.util.Map
 */
public java.util.Map getParams() {
	return params;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 21:13:45)
 * @param newO com.hps.july.persistence.LeaseSaldoAccessBean
 */
public void setO(com.hps.july.persistence.LeaseSaldoAccessBean newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 21:15:09)
 * @param newParams java.util.Map
 */
public void setParams(java.util.Map newParams) {
	params = newParams;
}
}
