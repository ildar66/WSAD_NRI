package com.hps.july.basestation.valueobject;

import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Модель коммутатора
 */
public class SwitchModel
	extends Model
{
	private StringAndInteger key = new StringAndInteger();
	private String name;
public SwitchModel() {
	super();
}
public SwitchAccessBean getAccessBean() {
	if(key.getInteger() == null) {
		return null;
	} else {
		try {
			SwitchAccessBean p = new SwitchAccessBean();
			p.setInitKey_storageplace(key.getInt());
			p.refreshCopyHelper();
			return p;
		} catch(Exception e) {
			return null;
		}
	}
}
public static SwitchAccessBean getFromIdAndNumber(int id, Integer number)
	throws Exception
{
	SwitchAccessBean res = null;
	SwitchAccessBean byId = getSwitchById(id);
	SwitchAccessBean byNumber = getSwitchByNumber(number);
	if(number == null) {
		return res;
	}
	if(byId != null) {
		if(byNumber != null) {
			if(byId.getNumber() == byNumber.getNumber()) {
				res = byId;
			} else {
				res = byNumber;
			}
		} else {
			res = byId;
		}
	} else {
		if(byNumber != null) {
			res = byNumber;
		}
		else {
			// res = null; // Null yet
		}
	}
	return res;
}
public java.lang.Integer getKey() {
	return key.getInteger();
}
public String getKeyFrm() {
	return key.getString();
}
public java.lang.String getName() {
	return name;
}
public static SwitchAccessBean getSwitchById(int switchId) {
	try {
		SwitchAccessBean switchById = new SwitchAccessBean();
		switchById.setInitKey_storageplace(switchId);
		switchById.refreshCopyHelper();
		return switchById;
	} catch(Exception e) {
		// no switch with this id
		
		// @ DEBUG
		System.out.println("SWITCH BY ID:"+switchId+" not found");
		return null;
	}
}
public static SwitchAccessBean getSwitchByNumber(Integer switchCode) {
	SwitchAccessBean switchByNumber = null;
	try {
		Enumeration en = new SwitchAccessBean().findByQBE2(
			Boolean.TRUE, (switchCode == null)?new Integer(0):switchCode,
			Boolean.TRUE, "2",
			Boolean.FALSE,"",
			new Integer(1)
		);

		if(en.hasMoreElements()) {
			switchByNumber = (SwitchAccessBean)en.nextElement();
		}
	} catch(Exception e) {
		// no switch with this id
		// oops occured
	}
	return switchByNumber;
}
public static SwitchAccessBean getSwitchByNumber(Integer switchCode, String planstate) {
	SwitchAccessBean switchByNumber = null;
	try {
		Boolean useplanstate = (planstate != null && !SearchConstants.SEARCH_ALL.equals(planstate))?Boolean.TRUE:Boolean.FALSE;
			
		Enumeration en = new SwitchAccessBean().findByQBE2(
			Boolean.TRUE, (switchCode == null)?new Integer(0):switchCode,
			Boolean.TRUE, "2",
			useplanstate,(planstate != null)?planstate:"",
			new Integer(1)
		);

		if(en.hasMoreElements()) {
			switchByNumber = (SwitchAccessBean)en.nextElement();
		}
	} catch(Exception e) {
		// no switch with this id
		// oops occured
	}
	return switchByNumber;
}
public void refresh() {
	SwitchAccessBean b = getAccessBean();
	refresh(b);
}
public void refresh(SwitchAccessBean b) {
	if(b == null) {
		name = "";
		setNotExist(true);
		setEmpty(key.isEmpty());
		setFormatError(!key.isOk());
	} else {
		try {
			name = b.getName();
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
