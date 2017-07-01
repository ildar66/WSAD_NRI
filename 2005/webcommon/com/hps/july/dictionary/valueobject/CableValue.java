package com.hps.july.dictionary.valueobject;

import java.util.Enumeration;
import com.hps.july.persistence.*;

/**
 * Служебный класс с данными по кабелю.
 * Используется при выводе списка кабелей.
 * @deprecated
 */
public class CableValue {
	private static java.text.DecimalFormat format = new java.text.DecimalFormat("#.####");
	private CableResourceAccessBean o;
	private String lostfactor;
public CableValue(CableResourceAccessBean cr) {
	o = cr;
	lostfactor = "";
	try {
		CableResourceBandAccessBean b = new CableResourceBandAccessBean();
		Enumeration en = b.findCableResourceBandsByResource(new ResourceKey(o.getResource()));
		while(en.hasMoreElements()) {
			CableResourceBandAccessBean arb = (CableResourceBandAccessBean)en.nextElement();
			if(arb.getLostfactor() != null) {
				if(lostfactor.length() < 1) { lostfactor = ""; }
				else { lostfactor += "<br>"; }
				lostfactor += arb.getBand()+"-"+format.format(arb.getLostfactor());
			}
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLostfactor() {
	return lostfactor;
}
/**
 * 
 * @return com.hps.july.persistence.CableResourceAccessBean
 */
public com.hps.july.persistence.CableResourceAccessBean getO() {
	return o;
}
/**
 * 
 * @param newLostfactor java.lang.String
 */
public void setLostfactor(java.lang.String newLostfactor) {
	lostfactor = newLostfactor;
}
/**
 * 
 * @param newO com.hps.july.persistence.CableResourceAccessBean
 */
public void setO(com.hps.july.persistence.CableResourceAccessBean newO) {
	o = newO;
}
}
