package com.hps.july.dictionary.valueobject;

import java.util.Enumeration;
import com.hps.july.persistence.*;

/**
 * Служебный класс с данными по антенне.
 * Используется при выводе списка антенн.
 * @deprecated
 */
public class AntenaValue {
	private AntennaResourceAccessBean o;
	private String ranges;
	private String amps;
public AntenaValue(AntennaResourceAccessBean ar) {
	o = ar;
	ranges = "";
	amps = "";
	try {
		AntennaResourceBandAccessBean b = new AntennaResourceBandAccessBean();
		Enumeration en = b.findAntennaResourceBandsByResource(new ResourceKey(o.getResource()));
		while(en.hasMoreElements()) {
			AntennaResourceBandAccessBean arb = (AntennaResourceBandAccessBean)en.nextElement();
			if(ranges.length() < 1) {
				ranges = "" + arb.getBand();
			} else {
				ranges += " / " + arb.getBand();
			}
			if(arb.getAmplification() != null) {
				if(amps.length() < 1) {
					amps = "" + arb.getAmplification();
				} else {
					amps += " / " + arb.getAmplification();
				}
			}
		}
	} catch(Exception e) {
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAmps() {
	return amps;
}
/**
 * 
 * @return com.hps.july.persistence.AntennaResourceAccessBean
 */
public com.hps.july.persistence.AntennaResourceAccessBean getO() {
	return o;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRanges() {
	return ranges;
}
/**
 * 
 * @param newAmps java.lang.String
 */
public void setAmps(java.lang.String newAmps) {
	amps = newAmps;
}
/**
 * 
 * @param newO com.hps.july.persistence.AntennaResourceAccessBean
 */
public void setO(com.hps.july.persistence.AntennaResourceAccessBean newO) {
	o = newO;
}
/**
 * 
 * @param newRanges java.lang.String
 */
public void setRanges(java.lang.String newRanges) {
	ranges = newRanges;
}
}
