package com.hps.july.basestation.valueobject;

import java.util.Enumeration;
import com.hps.july.persistence.*;

/**
 * Служебный класс-контейнер с параметрами антенны
 * Используется при выводе списка антенн
 */
public class AntenaValue {
	private AntennaResourceAccessBean o;
	private String ranges;
	private String amps;
	private String horzwidth;
	private String vertwidth;
	private String ea800 = "";
	private String ea900 = "";
	private String ea1800 = "";
	private String ea2000 = "";
public AntenaValue(AntennaResourceAccessBean ar) {
    o = ar;
    ranges = "";
    amps = "";
    vertwidth = "";
    horzwidth = "";
    try {
        AntennaResourceBandAccessBean b = new AntennaResourceBandAccessBean();
        Enumeration en =
            b.findAntennaResourceBandsByResource(new ResourceKey(o.getResource()));
        while (en.hasMoreElements()) {
            AntennaResourceBandAccessBean arb =
                (AntennaResourceBandAccessBean) en.nextElement();
            if (ranges.length() < 1) {
                ranges = "" + arb.getBand();
            } else {
                ranges += "/" + arb.getBand();
            }
            if (amps.length() < 1) {
                amps = "" + (arb.getAmplification()!=null?arb.getAmplification().toString():"");
            } else {
                amps += "/" + (arb.getAmplification()!=null?arb.getAmplification().toString():"");
            }
            if (horzwidth.length() < 1) {
                horzwidth = arb.getHorzwidth() != null ? arb.getHorzwidth().toString() : "";
            } else {
                horzwidth += "/" + (arb.getHorzwidth() != null
                    ? arb.getHorzwidth().toString()
                    : "");
            }
            if (vertwidth.length() < 1) {
                vertwidth = (arb.getVertwidth() != null ? arb.getVertwidth().toString() : "");
            } else {
                vertwidth += "/" + (arb.getVertwidth() != null
                    ? arb.getVertwidth().toString()
                    : "");
            }
			java.math.BigDecimal ea = arb.getElectricangle();
			
			switch((int)arb.getBand()) {
			case 800:
				ea800 = (ea == null)?"":String.valueOf(ea);
				break;
			case 900:
				ea900 = (ea == null)?"":String.valueOf(ea);
				break;
			case 1800:
				ea1800 = (ea == null)?"":String.valueOf(ea);
				break;
			case 2000:
				ea2000 = (ea == null)?"":String.valueOf(ea);
				break;
			}
        }
    } catch (Exception e) {
	    e.printStackTrace(System.out);
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
 * @return java.lang.String
 */
public java.lang.String getEa1800() {
	return ea1800;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEa2000() {
	return ea2000;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEa800() {
	return ea800;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEa900() {
	return ea900;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 19:28:15)
 * @return java.lang.String
 */
public java.lang.String getHorzwidth() {
	return horzwidth;
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
 * Insert the method's description here.
 * Creation date: (20.05.2003 19:28:15)
 * @return java.lang.String
 */
public java.lang.String getVertwidth() {
	return vertwidth;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 19:28:15)
 * @return java.lang.String
 */
public java.lang.String getWidthStr() {
	if(horzwidth == null || horzwidth.length() < 1) {
		if(vertwidth == null || vertwidth.length() < 1) {
			return "";
		} else {
		    return "V:" + vertwidth;
		}
	} else {
		if(vertwidth == null || vertwidth.length() < 1) {
			return "H:" + horzwidth;
		} else {
		    return "H:" + horzwidth + "<br>V:" + vertwidth;
		}
	}
}
/**
 * 
 * @param newAmps java.lang.String
 */
public void setAmps(java.lang.String newAmps) {
	amps = newAmps;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 19:28:15)
 * @param newHorzwidth java.lang.String
 */
public void setHorzwidth(java.lang.String newHorzwidth) {
	horzwidth = newHorzwidth;
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
/**
 * Insert the method's description here.
 * Creation date: (20.05.2003 19:28:15)
 * @param newVertwidth java.lang.String
 */
public void setVertwidth(java.lang.String newVertwidth) {
	vertwidth = newVertwidth;
}
}
