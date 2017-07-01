package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка документов "Внешние расходные накладные"
 */
public class ExternalRValue {
	private com.hps.july.persistence.OutWayBillAccessBean so;
	private String expedition;
	private String type;
public ExternalRValue(Object o) {
	expedition = "?";
	type = "?";
	if(o instanceof OutWayBillAccessBean) {
		so = (OutWayBillAccessBean)o;
		try {
			so.refreshCopyHelper();
			ExpeditionAccessBean exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(so.getTo().getStorageplace());
			exp.refreshCopyHelper();
			if(exp.getExpeditor() != null) {
				expedition = exp.getExpeditor().getMan().getFullName();
				type = "W";
			} else 
			if(exp.getOrganization() != null) {
				expedition = exp.getOrganization().getName();
				type = "P";
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
public com.hps.july.persistence.OutWayBillAccessBean getSo() {
	return so;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 21:03:36)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 20:41:51)
 * @param newExpedition java.lang.String
 */
public void setExpedition(java.lang.String newExpedition) {
	expedition = newExpedition;
}
public void setSo(com.hps.july.persistence.OutWayBillAccessBean newSo) {
	so = newSo;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 21:03:36)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
