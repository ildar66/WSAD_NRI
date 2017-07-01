package com.hps.july.basestation.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (28.07.2005 17:41:32)
 * @author: Shafigullin Ildar
 */
public class EquipmentName_TO {
	private int equipment;
	private java.lang.String storageName;
/**
 * EquipmentName_TO constructor comment.
 */
public EquipmentName_TO(int aEquipment,  String aStorageName) {
	super();
	equipment = aEquipment;
	storageName = aStorageName;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 17:41:56)
 * @return int
 */
public int getEquipment() {
	return equipment;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 17:43:14)
 * @return java.lang.String
 */
public java.lang.String getStorageName() {
	return storageName;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 17:41:56)
 * @param newEquipment int
 */
public void setEquipment(int newEquipment) {
	equipment = newEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 17:43:14)
 * @param newStorageName java.lang.String
 */
public void setStorageName(java.lang.String newStorageName) {
	storageName = newStorageName;
}
}
