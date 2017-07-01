package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка документов "Акты инвентаризации на складе"
 */
public class I13nActSValue {
	private I13nActAccessBean d;
	private String storagemanager;
public I13nActSValue(I13nActAccessBean argDocument) {
	d = argDocument;
	try {
		d.refreshCopyHelper();
		PeopleAccessBean peo = d.getStorageManager().getMan();
		storagemanager = peo.getLastname();
		if(peo.getFirstname() != null && peo.getFirstname().length() > 0) {
			storagemanager += " "+peo.getFirstname().substring(0,1)+".";
			if(peo.getMiddlename() != null && peo.getMiddlename().length() > 0) {
				storagemanager += " "+peo.getMiddlename().substring(0,1)+".";
			}
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
}
/**
 * 
 * @return com.hps.july.persistence.I13nActAccessBean
 */
public com.hps.july.persistence.I13nActAccessBean getD() {
	return d;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragemanager() {
	return storagemanager;
}
/**
 * 
 * @param newD com.hps.july.persistence.I13nActAccessBean
 */
public void setD(com.hps.july.persistence.I13nActAccessBean newD) {
	d = newD;
}
/**
 * 
 * @param newStoragemanager java.lang.String
 */
public void setStoragemanager(java.lang.String newStoragemanager) {
	storagemanager = newStoragemanager;
}
}
