package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка документов "Акты замены/модернизации на складе"
 */
public class ChangeValue {
	private com.hps.july.persistence.ChangeActAccessBean so;
	private String expedition;
public ChangeValue(Object o) {
	expedition = "?";
	if(o instanceof ChangeActAccessBean) {
		so = (ChangeActAccessBean)o;
		try {
			so.refreshCopyHelper();
			ExpeditionAccessBean exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(so.getFrom().getStorageplace());
			exp.refreshCopyHelper();
			if(exp.getExpeditor() != null) {
				expedition = exp.getExpeditor().getMan().getFullName();
			} else if(exp.getOrganization() != null) {
				expedition = exp.getOrganization().getName();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} else {
		so = null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 20:41:51)
 * @return java.lang.String
 */
public java.lang.String getExpedition() {
	return expedition;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 16:03:25)
 * @return com.hps.july.persistence.ChangeActAccessBean
 */
public com.hps.july.persistence.ChangeActAccessBean getSo() {
	return so;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 20:41:51)
 * @param newExpedition java.lang.String
 */
public void setExpedition(java.lang.String newExpedition) {
	expedition = newExpedition;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 16:03:25)
 * @param newSo com.hps.july.persistence.ChangeActAccessBean
 */
public void setSo(com.hps.july.persistence.ChangeActAccessBean newSo) {
	so = newSo;
}
}
