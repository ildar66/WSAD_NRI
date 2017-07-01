package com.hps.july.inventory.valueobject;

import java.util.Enumeration;
import com.hps.july.persistence.*;
import java.math.*;

/**
 * Служебный класс для вывода данных списка документов "Акты рассогласования"
 */
public class MismatchValue {
	private Boolean fileFlag;
	private com.hps.july.persistence.InwayBillAccessBean o;
public MismatchValue(Object oo) {
	fileFlag = null;
	if(oo instanceof InwayBillAccessBean) {
		o = (InwayBillAccessBean)oo;
		try {
			o.refreshCopyHelper();
			InWayBillBLOBAccessBean blob = new InWayBillBLOBAccessBean();
			blob.setInitKey_document(o.getDocument());
			blob.refreshCopyHelper();
			if(blob.getDActTextFileName() != null && !"".equals(blob.getDActTextFileName().trim())) {
				fileFlag = Boolean.TRUE;
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	} else {
		o = null;
	}
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getFileFlag() {
	return fileFlag;
}
/**
 * 
 * @return com.hps.july.persistence.InwayBillAccessBean
 */
public com.hps.july.persistence.InwayBillAccessBean getO() {
	return o;
}
/**
 * 
 * @param newFileFlag java.lang.Boolean
 */
public void setFileFlag(java.lang.Boolean newFileFlag) {
	fileFlag = newFileFlag;
}
/**
 * 
 * @param newO com.hps.july.persistence.InwayBillAccessBean
 */
public void setO(com.hps.july.persistence.InwayBillAccessBean newO) {
	o = newO;
}
}
