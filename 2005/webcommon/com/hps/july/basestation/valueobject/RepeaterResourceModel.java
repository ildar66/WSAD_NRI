package com.hps.july.basestation.valueobject;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Модель оборудования репитера
 */
public class RepeaterResourceModel
	extends Model
{
	private StringAndIntegerProperty key = new StringAndIntegerProperty();
	private String name;
	private String model;
	private String fullname;
	private StringAndBigDecimalProperty power = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty bandwidth = new StringAndBigDecimalProperty();
public RepeaterResourceModel() {
	super();
}
public RepiterResAccessBean getAccessBean() {
	if(key.getInteger() == null) {
		return null;
	} else {
		try {
			RepiterResAccessBean p = new RepiterResAccessBean();
			p.setInitKey_resource(key.getInteger().intValue());
			p.refreshCopyHelper();
			return p;
		} catch(Exception e) {
			return null;
		}
	}
}
public Integer getKey() {
	return key.getInteger();
}
public String getKeyFrm() {
	return key.getString();
}
public java.lang.String getName() {
	return name;
}
public void refresh() {
	RepiterResAccessBean b = getAccessBean();
	refresh(b);
}
public void refresh(RepiterResAccessBean b) {
	if(b == null) {
		name = "";
		model = "";
		fullname = "";
		power.setString("");
		bandwidth.setString("");
		setNotExist(true);
		setEmpty(key.isEmpty());
		setFormatError(!key.isOk());
	} else {
		try {
			key.setInteger(new Integer(b.getResource()));
			name = b.getName();
			model = b.getModel();
			fullname = name + " " + model;
			power.setBigDecimal(b.getReppower());
			bandwidth.setBigDecimal(b.getBandwidth());
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
public void setKey(Integer newKey) {
	key.setInteger(newKey);
}
public void setKeyFrm(String newKey) {
	key.setString(newKey);
}
protected void setName(java.lang.String newName) {
	name = newName;
}
}
