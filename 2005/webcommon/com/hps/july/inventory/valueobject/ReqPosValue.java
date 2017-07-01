package com.hps.july.inventory.valueobject;

import java.util.Enumeration;
import com.hps.july.persistence.*;
import java.math.*;

/**
 * Служебный класс для вывода данных списка строк документа "Требование"
 */
public class ReqPosValue {
	private BigDecimal sendqty;
	private com.hps.july.persistence.DocumentPositionAccessBean so;
public ReqPosValue(Object o) {
	sendqty = null;
	if(o instanceof DocumentPositionAccessBean) {
		so = (DocumentPositionAccessBean)o;
		try {
			BigDecimal qty = new BigDecimal("0");
			so.refreshCopyHelper();
			Enumeration en = so.findByRequestResource(new Integer(so.getDocument().getDocument()),new Integer(so.getResource().getResource()));
			while(en.hasMoreElements()) {
				DocumentPositionAccessBean d = (DocumentPositionAccessBean)en.nextElement();
				if("2".equals(d.getDocument().getDocumentState())) {
					if(d.getQty() != null) {
						qty = qty.add(d.getQty());
					}
				}
			}
			if(qty != null && qty.doubleValue() > 0) {
				sendqty = qty;
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	} else {
		so = null;
	}
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSendqty() {
	return sendqty;
}
/**
 * 
 * @return com.hps.july.persistence.DocumentPositionAccessBean
 */
public com.hps.july.persistence.DocumentPositionAccessBean getSo() {
	return so;
}
/**
 * 
 * @param newSendqty java.math.BigDecimal
 */
public void setSendqty(java.math.BigDecimal newSendqty) {
	sendqty = newSendqty;
}
/**
 * 
 * @param newSo com.hps.july.persistence.DocumentPositionAccessBean
 */
public void setSo(com.hps.july.persistence.DocumentPositionAccessBean newSo) {
	so = newSo;
}
}
