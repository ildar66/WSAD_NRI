package com.hps.july.basestation.valueobject;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Модель сектора
 */
public class SectorModel
	extends Model
{
	private StringAndIntegerProperty key = new StringAndIntegerProperty();
	private String fullname;
public SectorModel() {
	super();
}
public SectorAccessBean getAccessBean() {
	if(key.getInteger() == null) {
		return null;
	} else {
		try {
			SectorAccessBean p = new SectorAccessBean();
			p.setInitKey_idsect(key.getInteger().intValue());
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
	SectorAccessBean b = getAccessBean();
	refresh(b);
}
public void refresh(SectorAccessBean b) {
	if(b == null) {
		fullname = "";
		setNotExist(true);
		setEmpty(key.isEmpty());
		setFormatError(!key.isOk());
	} else {
		try {
			key.setInteger(new Integer(b.getIdsect()));
			fullname = "№ " + b.getNumsect()+ " " + b.getNamesect();
			setNotExist(false);
			setEmpty(false);
			setFormatError(false);
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
	//System.out.println("SectorModel setKeyFrm(String newKey)=" +newKey);//temp
	key.setString(newKey);
}
}
