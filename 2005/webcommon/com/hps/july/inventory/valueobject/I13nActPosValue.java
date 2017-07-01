package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка строк документа "Акт инвентаризации на складе"
 */
public class I13nActPosValue {
	private I13nActPositionAccessBean o;
	private String serialnumber;
	private String newplace;
	private String oldplace;
public I13nActPosValue(Object docpos) {
	o = null;
	newplace = null;
	oldplace = null;
	if(docpos instanceof DocumentPositionAccessBean) {
		DocumentPositionAccessBean ab = (DocumentPositionAccessBean)docpos;
		try {
			ab.refreshCopyHelper();
			I13nActPositionAccessBean bean = new I13nActPositionAccessBean();
			bean.setInitKey_docposition( ab.getDocposition() );
			bean.refreshCopyHelper();
			o = bean;
			oldplace = o.getOldplace();
			newplace = o.getNewplace();
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
		}
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNewplace() {
	return newplace;
}
/**
 * 
 * @return com.hps.july.persistence.I13nActPositionAccessBean
 */
public com.hps.july.persistence.I13nActPositionAccessBean getO() {
	return o;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOldplace() {
	return oldplace;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPlace() {
	return null;// place;
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
 * @param newNewplace java.lang.String
 */
public void setNewplace(java.lang.String newNewplace) {
	newplace = newNewplace;
}
/**
 * 
 * @param newO com.hps.july.persistence.I13nActPositionAccessBean
 */
public void setO(com.hps.july.persistence.I13nActPositionAccessBean newO) {
	o = newO;
}
/**
 * 
 * @param newOldplace java.lang.String
 */
public void setOldplace(java.lang.String newOldplace) {
	oldplace = newOldplace;
}
/**
 * 
 * @param newSerialnumber java.lang.String
 */
public void setSerialnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
}
