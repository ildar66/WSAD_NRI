package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * —лужебный класс дл€ вывода данных списка документов "¬нутренн€€ расходна€ накладна€"
 */
public class InternalRValue {
	private com.hps.july.persistence.InternalOutBillAccessBean so;
	private String expedition;
	private String expeditioncode;
	private String type;
public InternalRValue(Object o) {
	expedition = "?";
	type = "?";
	if(o instanceof InternalOutBillAccessBean) {
		so = (InternalOutBillAccessBean)o;
		try {
			so.refreshCopyHelper();
			ExpeditionAccessBean exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(so.getTo().getStorageplace());
			exp.refreshCopyHelper();
			if(exp.getExpeditor() != null) {
				expedition = exp.getExpeditor().getMan().getFullName();
				expeditioncode = ""+exp.getExpeditor().getWorker();
				type = "W";
			} else 
			if(exp.getOrganization() != null) {
				expedition = exp.getOrganization().getName();
				expeditioncode = ""+exp.getOrganization().getOrganization();
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
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 17:29:46)
 * @return java.lang.String
 */
public java.lang.String getExpeditioncode() {
	return expeditioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 20:41:51)
 * @return com.hps.july.persistence.InternalOutBillAccessBean
 */
public com.hps.july.persistence.InternalOutBillAccessBean getSo() {
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
 * Creation date: (14.08.2002 17:29:46)
 * @param newExpeditioncode java.lang.String
 */
public void setExpeditioncode(java.lang.String newExpeditioncode) {
	expeditioncode = newExpeditioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 20:41:51)
 * @param newSo com.hps.july.persistence.InternalOutBillAccessBean
 */
public void setSo(com.hps.july.persistence.InternalOutBillAccessBean newSo) {
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
