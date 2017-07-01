package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * —лужебный класс дл€ вывода данных списка строк документа "¬нутренн€€ расходна€ накладна€"
 */
public class InternalRPosValue {
	private com.hps.july.persistence.DocumentPositionAccessBean o;
	private String serialnumber;
public InternalRPosValue(Object oo) {
	serialnumber = "";
	if(oo instanceof DocumentPositionAccessBean) {
		o = (DocumentPositionAccessBean)oo;
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
 * @return com.hps.july.persistence.DocumentPositionAccessBean
 */
public com.hps.july.persistence.DocumentPositionAccessBean getO() {
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
 * @param newO com.hps.july.persistence.DocumentPositionAccessBean
 */
public void setO(com.hps.july.persistence.DocumentPositionAccessBean newO) {
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
