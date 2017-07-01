package com.hps.july.arenda.valueobject;

/**
 * Контейнер "Приоритеты зачета между договорами"
 * Creation date: (19.12.2002 11:04:12)
 * @author: Sergey Gourov
 */
public class LeaseMRCntPriorValueObject {
	private com.hps.july.persistence.LeaseMRCntPriorAccessBean o;
	private java.util.Map params;
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 11:04:55)
 * @param bean com.hps.july.persistence.LeaseMRCntPriorAccessBean
 */
public LeaseMRCntPriorValueObject(com.hps.july.persistence.LeaseMRCntPriorAccessBean bean) {
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 11:04:30)
 * @return com.hps.july.persistence.LeaseMRCntPriorAccessBean
 */
public com.hps.july.persistence.LeaseMRCntPriorAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 11:06:36)
 * @return java.util.Map
 */
public java.util.Map getParams() {
	return params;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 11:04:30)
 * @param newO com.hps.july.persistence.LeaseMRCntPriorAccessBean
 */
public void setO(com.hps.july.persistence.LeaseMRCntPriorAccessBean newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 11:06:36)
 * @param newParams java.util.Map
 */
public void setParams(java.util.Map newParams) {
	params = newParams;
}
}
