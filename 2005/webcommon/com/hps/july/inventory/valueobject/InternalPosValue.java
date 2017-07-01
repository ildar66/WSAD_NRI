package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка строк документа "Внутренний приходный ордер"
 */
public class InternalPosValue {
	private com.hps.july.persistence.InternalWayBillPositionAccessBean o;
	private String serialnumber;
public InternalPosValue(Object oo) {
	serialnumber = "";
	if(oo instanceof InternalWayBillPositionAccessBean) {
		o = (InternalWayBillPositionAccessBean)oo;
		try {
			o.refreshCopyHelper();
			if("S".equals(o.getResource().getCountpolicy())) {
				serialnumber = o.getSerialnumber();
				if(serialnumber == null) serialnumber = "";
				if(o.getManufserial() != null && !serialnumber.equals(o.getManufserial()) ) {
					serialnumber += " ("+o.getManufserial()+")";
				}
			} else
			if("P".equals(o.getResource().getCountpolicy())) {
				serialnumber = o.getParty();
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
 * @return com.hps.july.persistence.InternalWayBillPositionAccessBean
 */
public com.hps.july.persistence.InternalWayBillPositionAccessBean getO() {
	return o;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSerialnumber() {
	return serialnumber;
}
/**
 * 
 * @param newO com.hps.july.persistence.InternalWayBillPositionAccessBean
 */
public void setO(com.hps.july.persistence.InternalWayBillPositionAccessBean newO) {
	o = newO;
}
/**
 * 
 * @param newSerialnumber java.lang.String
 */
public void setSerialnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
}
