package com.hps.july.platinum.valueobject;

import java.util.*;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.*;

/**
 * Insert the type's description here.
 * Creation date: (18.02.2002 10:42:32)
 * @author: Oleg Gashnikov
 */
public class StorageValue {
	
 
	private int storageplace;
	private java.lang.String name;		//from platinum table 100 chars
	private java.lang.Integer ownercode;	//from combo-box
	private java.lang.String mxranPlatinum;	//from platinum table
	private java.lang.String p_status;	//from platinum table
	private java.lang.String namePlatinum;
	private java.util.Map url;
	private java.lang.String stateoutput;
	private java.lang.String jspriznak;
	private java.lang.String equipmentname;
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 12:15:58)
 * @return java.lang.String
 */
public java.lang.String getEquipmentname() {
	return equipmentname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:36:20)
 * @return java.lang.String
 */
public java.lang.String getJspriznak() {
	return jspriznak;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 11:22:56)
 * @return java.lang.String
 */
public java.lang.String getMxranPlatinum() {
	return mxranPlatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 9:30:53)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:25:57)
 * @return java.lang.String
 */
public java.lang.String getNamePlatinum() {
	return namePlatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 10:44:21)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwnercode() {
	return ownercode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 18:21:45)
 * @return java.lang.String
 */
public java.lang.String getP_status() {
	return p_status;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 15:03:29)
 * @return java.lang.String
 */
public java.lang.String getStateoutput() {
	return stateoutput;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 9:24:07)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:05:09)
 * @return java.util.Map
 */
public java.util.Map getUrl() {	
	return url;
	}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 12:15:58)
 * @param newEquipmentname java.lang.String
 */
public void setEquipmentname(java.lang.String newEquipmentname) {
	equipmentname = newEquipmentname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:36:20)
 * @param newJspriznak java.lang.String
 */
public void setJspriznak(java.lang.String newJspriznak) {
	jspriznak = newJspriznak;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 11:22:56)
 * @param newMxranPlatinum java.lang.String
 */
public void setMxranPlatinum(java.lang.String newMxranPlatinum) {
	mxranPlatinum = newMxranPlatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 9:30:53)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:25:57)
 * @param newNamePlatinum java.lang.String
 */
public void setNamePlatinum(java.lang.String newNamePlatinum) {
	namePlatinum = newNamePlatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 10:44:21)
 * @param newOwnewcode java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwnercode) {
	ownercode = newOwnercode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.12.2002 18:21:45)
 * @param newP_status java.lang.String
 */
public void setP_status(java.lang.String newP_status) {
	p_status = newP_status;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 15:03:29)
 * @param newStateoutput java.lang.String
 */
public void setStateoutput(java.lang.String newStateoutput) {
	stateoutput = newStateoutput;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 9:24:07)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:05:09)
 * @param newUrl java.util.Map
 */
public void setUrl(java.util.Map newUrl) {	
	url = newUrl;
	}
}
