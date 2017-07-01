package com.hps.july.basestation.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (25.07.2005 15:55:11)
 * @author: Shafigullin Ildar
 */
public class Equipdet_TO {
	private StorageCard_VO scard;
	private java.lang.String name;//из resources
	private java.lang.String manucode;//из resources
	private java.lang.String model;//из resources
	private java.lang.String isAgregate;
/**
 * EquipdetTO constructor comment.
 */
public Equipdet_TO(StorageCard_VO aScard) {
	super();
	setScard(aScard);
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 20:08:07)
 * @return java.lang.String
 */
public java.lang.String getIsAgregate() {
	return isAgregate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:59:09)
 * @return java.lang.String
 */
public java.lang.String getManucode() {
	return manucode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 16:06:02)
 * @return java.lang.String
 */
public java.lang.String getModel() {
	return model;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:58:23)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:56:57)
 * @return com.hps.july.basestation.valueobject.StorageCard_VO
 */
public StorageCard_VO getScard() {
	return scard;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 20:08:07)
 * @param newIsAgregate java.lang.String
 */
public void setIsAgregate(java.lang.String newIsAgregate) {
	isAgregate = newIsAgregate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:59:09)
 * @param newManucode java.lang.String
 */
public void setManucode(java.lang.String newManucode) {
	manucode = newManucode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 16:06:02)
 * @param newModel java.lang.String
 */
public void setModel(java.lang.String newModel) {
	model = newModel;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:58:23)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:56:57)
 * @param newScard com.hps.july.basestation.valueobject.StorageCard_VO
 */
private void setScard(StorageCard_VO newScard) {
	scard = newScard;
}
}
