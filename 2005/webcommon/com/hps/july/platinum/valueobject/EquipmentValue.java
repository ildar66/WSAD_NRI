package com.hps.july.platinum.valueobject;

import java.util.*;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.*;

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
	private java.util.Map url;
	private java.lang.String mxranPlatinum;
	private java.lang.String namePlatinum;
	private java.lang.String p_status;
	private java.lang.String stateoutput;
	private java.lang.String jspriznak;
	private int storageplace;
	
	private java.lang.Integer ownercode;
public EquipmentValue() {
	super();
}
public EquipmentValue( EquipmentSetAccessBean argEquipmentSet ) {
	super();

	EquipmentSetAccessBean ebean = new EquipmentSetAccessBean();
	try {
   		setStorageplace(argEquipmentSet.getStorageplace());	//-da

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
		equipmentName = EquipmentObject.getEquipmentSetNameOnly(ebean);
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
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:36:15)
 * @return java.lang.String
 */
public java.lang.String getJspriznak() {
	return jspriznak;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:32:29)
 * @return java.lang.String
 */
public java.lang.String getMxranPlatinum() {
	return mxranPlatinum;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:34:33)
 * @return java.lang.String
 */
public java.lang.String getNamePlatinum() {
	return namePlatinum;
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
 * Creation date: (27.12.2002 15:52:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwnercode() {
	return ownercode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:35:11)
 * @return java.lang.String
 */
public java.lang.String getP_status() {
	return p_status;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:35:38)
 * @return java.lang.String
 */
public java.lang.String getStateoutput() {
	return stateoutput;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:44:56)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:47:44)
 * @return java.util.Map
 */
public java.util.Map getUrl() {
	return url;
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
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:36:15)
 * @param newJspriznak java.lang.String
 */
public void setJspriznak(java.lang.String newJspriznak) {
	jspriznak = newJspriznak;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:32:29)
 * @param newMxranPlatinum java.lang.String
 */
public void setMxranPlatinum(java.lang.String newMxranPlatinum) {
	mxranPlatinum = newMxranPlatinum;
}
/**
 * 
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:34:33)
 * @param newNamePlatinum java.lang.String
 */
public void setNamePlatinum(java.lang.String newNamePlatinum) {
	namePlatinum = newNamePlatinum;
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
 * Creation date: (27.12.2002 15:52:12)
 * @param newOwnercode java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwnercode) {
	ownercode = newOwnercode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:35:11)
 * @param newP_status java.lang.String
 */
public void setP_status(java.lang.String newP_status) {
	p_status = newP_status;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:35:38)
 * @param newStateoutput java.lang.String
 */
public void setStateoutput(java.lang.String newStateoutput) {
	stateoutput = newStateoutput;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 15:44:56)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 14:47:44)
 * @param newUrl java.util.Map
 */
public void setUrl(java.util.Map newUrl) {
	url = newUrl;
}
}
