package com.hps.july.project;

import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.*;

/**
 *  ласс дл€ отображени€ различных типов оборудовани€.
 * Creation date: (16.01.2002 15:02:14)
 * @author: Administrator
 */
public class EquipmentValue {
	private EquipmentSetAccessBean equipmentSet;
	private BaseStationAccessBean baseStation;
	private ComEquipmentAccessBean comEquipment;
	private ControllerAccessBean controller;
	private SwitchAccessBean switchequ;
	private OtherEquipmentAccessBean other;
	private java.lang.String equipmentType;
	private int equipmentTypeName;
	private String equipmentName;
	private String number;
	private String name;
	private int storageplace;
public EquipmentValue() {
	super();
}
public EquipmentValue( EquipmentSetAccessBean argEquipmentSet ) {
	super();
	EquipmentSetAccessBean ebean = new EquipmentSetAccessBean();
	try {
		setStorageplace(argEquipmentSet.getStorageplace());
		ebean.setInitKey_storageplace(argEquipmentSet.getStorageplace());
		ebean.refreshCopyHelper();
		ebean.getName();
		equipmentSet = ebean;
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	setEquipmentType("N");
	try {
		if (ebean.getEJBRef() instanceof BaseStation) {
			baseStation = new BaseStationAccessBean(argEquipmentSet.getEJBRef());
			setEquipmentType("A");
			number = "" + baseStation.getNumber();
			name = baseStation.getName();
		}
		if (ebean.getEJBRef() instanceof ComEquipment) {
			comEquipment = new ComEquipmentAccessBean(argEquipmentSet.getEJBRef());
			setEquipmentType("B");
			number = "";
			name = comEquipment.getName();
		}
		if (ebean.getEJBRef() instanceof Controller) {
			controller = new ControllerAccessBean(argEquipmentSet.getEJBRef());
			setEquipmentType("C");
			number = "" + controller.getNumber();
			name = controller.getName();
		}
		if (ebean.getEJBRef() instanceof Switch) {
			switchequ = new SwitchAccessBean(argEquipmentSet.getEJBRef());
			setEquipmentType("D");
			number = "" + switchequ.getNumber();
			name = "" + switchequ.getName();
		}
		if (ebean.getEJBRef() instanceof OtherEquipment) {
			other = new OtherEquipmentAccessBean(argEquipmentSet.getEJBRef());
			setEquipmentType("E");
			number = "";
			name = other.getName();
		}
		equipmentName = EquipmentObject.getEquipmentSetName(ebean);
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEquipmentName() {
	return equipmentName;
}
public EquipmentSetAccessBean getEquipmentSet() {
	return equipmentSet;
}
public java.lang.String getEquipmentType() {
	return equipmentType;
}
public int getEquipmentTypeName() {
	return equipmentTypeName;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2003 17:05:00)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * 
 * @param newEquipmentName java.lang.String
 */
public void setEquipmentName(java.lang.String newEquipmentName) {
	equipmentName = newEquipmentName;
}
public void setEquipmentSet(EquipmentSetAccessBean newEquipmentSet) {
	equipmentSet = newEquipmentSet;
}
public void setEquipmentType(java.lang.String newEquipmentType) {
	equipmentType = newEquipmentType;
}
public void setEquipmentTypeName(int newEquipmentTypeName) {
	equipmentTypeName = newEquipmentTypeName;
}
/**
 * 
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * 
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2003 17:05:00)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
}
