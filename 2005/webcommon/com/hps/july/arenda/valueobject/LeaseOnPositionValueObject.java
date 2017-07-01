package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
/**
 * Контейнер "Связь между договорами и позициями"
 * Creation date: (14.08.2002 15:37:50)
 * @author: Sergey Gourov
 */
public class LeaseOnPositionValueObject {
	private com.hps.july.persistence.LeaseOnPositionAccessBean o;
	private java.lang.String mainManager;
/**
 * LeaseOnPosition constructor comment.
 */
public LeaseOnPositionValueObject(LeaseOnPositionAccessBean bean) {
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 15:49:06)
 * @return java.lang.String
 */
public java.lang.String getMainManager() {
	return mainManager;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 15:46:20)
 * @return com.hps.july.persistence.LeaseOnPositionAccessBean
 */
public com.hps.july.persistence.LeaseOnPositionAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 15:49:06)
 * @param newMainManager java.lang.String
 */
public void setMainManager(java.lang.String newMainManager) {
	mainManager = newMainManager;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 15:46:20)
 * @param newO com.hps.july.persistence.LeaseOnPositionAccessBean
 */
public void setO(com.hps.july.persistence.LeaseOnPositionAccessBean newO) {
	o = newO;
}
}
