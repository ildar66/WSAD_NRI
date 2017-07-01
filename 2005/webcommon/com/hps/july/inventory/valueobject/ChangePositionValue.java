package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка строк документов:
 * "Акт замены/модернизации на позиции", 
 * "Акт замены/модернизации на складе",
 * "Акт замены при ремонте"
 */
public class ChangePositionValue {
	private com.hps.july.persistence.ChangeActPositionAccessBean so;
	private String resourcename;
	private String resourcemodel;
	private String oldserial;
	private String newserial;
	private int resourcecode;
	private int ores;
	private String oresname;
	private String oresmodel;
public ChangePositionValue(Object o) {
	resourcename = "";
	resourcemodel = "";
	resourcecode = 0;
	ores = 0;
	oresname = "";
	oresmodel = "";
	if(o instanceof ChangeActPositionAccessBean) {
		so = (ChangeActPositionAccessBean)o;
		try {
			so.refreshCopyHelper();
			try {
				resourcemodel = so.getNewresource().getModel();
				resourcename = so.getNewresource().getName();
				resourcecode = so.getNewresource().getResource();
				newserial = so.getNewSerial();
				String newmanuf = so.getManufserial();
				if(newmanuf != null && !newserial.equals(newmanuf)) {
					newserial += " ("+newmanuf+")";
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			try {
				oldserial = so.getOldSerial();
				if(so.getOldresource() != null) {
					ResourceAccessBean or = new ResourceAccessBean();
					or.setInitKey_resource(so.getOldresource().intValue());
					or.refreshCopyHelper();
					oresmodel = or.getModel();
					oresname = or.getName();
					ores = or.getResource();
				}
				String oldmanuf = so.getOldmanufserial();
				if(oldmanuf != null && !oldserial.equals(oldmanuf)) {
					oldserial += " ("+oldmanuf+")";
				}
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		} catch(Throwable t) {
			t.printStackTrace(System.out);
		}
	} else {
		so = null;
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNewserial() {
	return newserial;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOldserial() {
	return oldserial;
}
/**
 * 
 * @return int
 */
public int getOres() {
	return ores;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOresmodel() {
	return oresmodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOresname() {
	return oresname;
}
/**
 * 
 * @return int
 */
public int getResourcecode() {
	return resourcecode;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * 
 * @return com.hps.july.persistence.ChangeActPositionAccessBean
 */
public com.hps.july.persistence.ChangeActPositionAccessBean getSo() {
	return so;
}
/**
 * 
 * @param newNewserial java.lang.String
 */
public void setNewserial(java.lang.String newNewserial) {
	newserial = newNewserial;
}
/**
 * 
 * @param newOldserial java.lang.String
 */
public void setOldserial(java.lang.String newOldserial) {
	oldserial = newOldserial;
}
/**
 * 
 * @param newOres int
 */
public void setOres(int newOres) {
	ores = newOres;
}
/**
 * 
 * @param newOresmodel java.lang.String
 */
public void setOresmodel(java.lang.String newOresmodel) {
	oresmodel = newOresmodel;
}
/**
 * 
 * @param newOresname java.lang.String
 */
public void setOresname(java.lang.String newOresname) {
	oresname = newOresname;
}
/**
 * 
 * @param newResourcecode int
 */
public void setResourcecode(int newResourcecode) {
	resourcecode = newResourcecode;
}
/**
 * 
 * @param newResourcemodel java.lang.String
 */
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * 
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * 
 * @param newSo com.hps.july.persistence.ChangeActPositionAccessBean
 */
public void setSo(com.hps.july.persistence.ChangeActPositionAccessBean newSo) {
	so = newSo;
}
}
