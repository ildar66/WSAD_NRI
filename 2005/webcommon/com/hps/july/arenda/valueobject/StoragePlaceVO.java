package com.hps.july.arenda.valueobject;

import java.sql.*;
/**
* контейнер "Места хранения".
* Creation date: (14.07.2004 14:58:07)
* @author: Shafigullin Ildar
*/
public class StoragePlaceVO {
	private java.lang.String address; //Адрес
	private Date closedate; //Дата закрытия
	private java.lang.String name; //Наименование
	private int storageplace; //ключ Место хранения
	private java.lang.String fullName;
/**
 * StoragePlaceVO constructor comment.
 */
public StoragePlaceVO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 15:07:39)
 * @param storagePlace int
 */
public StoragePlaceVO(int key) {
	this.storageplace = key;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:58:40)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:59:08)
 * @return java.sql.Date
 */
public Date getClosedate() {
	return closedate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.09.2004 14:48:48)
 * @return java.lang.String
 */
public java.lang.String getFullName() {
	return fullName;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:59:27)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:59:43)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:58:40)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:59:08)
 * @param newClosedate java.sql.Date
 */
public void setClosedate(Date newClosedate) {
	closedate = newClosedate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.09.2004 14:48:48)
 * @param newFullName java.lang.String
 */
public void setFullName(java.lang.String newFullName) {
	fullName = newFullName;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:59:27)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:59:43)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
}
