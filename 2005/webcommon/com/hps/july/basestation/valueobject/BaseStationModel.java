package com.hps.july.basestation.valueobject;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Модель базовой станции
 */
public class BaseStationModel
	extends Model
{
	private StringAndIntegerProperty key = new StringAndIntegerProperty();
	private String fullname;
public BaseStationModel() {
	super();
}
public BaseStationAccessBean getAccessBean() {
	if(key.getInteger() == null) {
		return null;
	} else {
		try {
			BaseStationAccessBean p = new BaseStationAccessBean();
			p.setInitKey_storageplace(key.getInteger().intValue());
			p.refreshCopyHelper();
			return p;
		} catch(Exception e) {
			e.printStackTrace(System.out);
			return null;
		}
	}
}
public String getFullname() {
	return fullname;
}
public Integer getKey() {
	return key.getInteger();
}
public String getKeyFrm() {
	return key.getString();
}
public void refresh() {
	BaseStationAccessBean b = getAccessBean();
	refresh(b);
}
public void refresh(BaseStationAccessBean b) {
	if(b == null) {
		fullname = "";
		setNotExist(true);
		setEmpty(key.isEmpty());
		setFormatError(!key.isOk());
	} else {
		try {
			key.setInteger(new Integer(b.getStorageplace()));
			String stype = b.getStationType();
			String stationType = "";
			if(stype != null) {
				if("D".equals(stype)) {
					stationType = "DAMPS ";
				} else
				if("S".equals(stype)) {
					stationType = "GSM 900 ";
				} else
				if("C".equals(stype)) {
					stationType = "DCS 1800 ";
				} else
				if("G".equals(stype)) {
					stationType = "GSM 900/1800 ";
				}
			}
			setFullname(stationType + "№ " + b.getNumber() + " " + b.getStationName());
			setFormatError(false);
			setEmpty(false);
			setNotExist(false);
		} catch(Exception e) {
			setNotExist(true);
			setEmpty(key.isEmpty());
			setFormatError(!key.isOk());
			e.printStackTrace(System.out);
		}
	}
}
protected void setFullname(String newFullname) {
	fullname = newFullname;
}
public void setKey(Integer newKey) {
	key.setInteger(newKey);
}
public void setKeyFrm(String newKey) {
	key.setString(newKey);
}
}
