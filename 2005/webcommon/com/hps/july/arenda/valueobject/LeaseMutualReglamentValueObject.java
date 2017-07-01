package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
/**
 * Контейнер "Доп. соглашение о взаимозачете"
 * Creation date: (20.12.2002 15:20:28)
 * @author: Sergey Gourov
 */
public class LeaseMutualReglamentValueObject {
	private com.hps.july.persistence.LeaseMutualReglamentAccessBean o;
	private java.lang.String contractList;
	private java.lang.String resourceList;
/**
 * LeaseMutualReglamentValueObject constructor comment.
 */
public LeaseMutualReglamentValueObject(LeaseMutualReglamentAccessBean bean) {
	super();
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 15:28:33)
 * @return java.lang.String
 */
public java.lang.String getContractList() {
	return contractList;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 15:20:54)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 */
public com.hps.july.persistence.LeaseMutualReglamentAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (03.02.2003 19:44:51)
 * @return java.lang.String
 */
public java.lang.String getResourceList() {
	return resourceList;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 15:28:33)
 * @param newContractList java.lang.String
 */
public void setContractList(java.lang.String newContractList) {
	contractList = newContractList;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 15:20:54)
 * @param newO com.hps.july.persistence.LeaseMutualReglamentAccessBean
 */
public void setO(com.hps.july.persistence.LeaseMutualReglamentAccessBean newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (03.02.2003 19:44:51)
 * @param newResourceList java.lang.String
 */
public void setResourceList(java.lang.String newResourceList) {
	resourceList = newResourceList;
}
}
