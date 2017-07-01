package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка документов "Внутренние приходные ордера"
 */
public class InternalValue {
	private com.hps.july.persistence.InternalWayBillAccessBean so;
	private String expedition;
	private String expeditioncode;
	private String type;
public InternalValue(Object o) {
	expedition = "?";
	expeditioncode = "";
	type = "";
	if(o instanceof InternalWayBillAccessBean) {
		so = (InternalWayBillAccessBean)o;
		try {
			so.refreshCopyHelper();
			ExpeditionAccessBean exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(so.getFrom().getStorageplace());
			exp.refreshCopyHelper();
			if(exp.getExpeditor() != null) {
				expedition = exp.getExpeditor().getMan().getFullName();
				expeditioncode = ""+exp.getExpeditor().getWorker();
				type = "W";
			} else if(exp.getOrganization() != null) {
				expedition = exp.getOrganization().getName();
				expeditioncode = ""+exp.getOrganization().getOrganization();
				type = "P";
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
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
 * Creation date: (13.08.2002 12:14:18)
 * @return java.lang.String
 */
public java.lang.String getExpeditioncode() {
	return expeditioncode;
}
public com.hps.july.persistence.InternalWayBillAccessBean getSo() {
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
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 12:14:18)
 * @param newExpeditioncode java.lang.String
 */
public void setExpeditioncode(java.lang.String newExpeditioncode) {
	expeditioncode = newExpeditioncode;
}
public void setSo(com.hps.july.persistence.InternalWayBillAccessBean newSo) {
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
