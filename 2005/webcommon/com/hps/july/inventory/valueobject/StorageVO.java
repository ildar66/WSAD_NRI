package com.hps.july.inventory.valueobject;

import javax.ejb.EJBObject;
import java.util.Enumeration;
import com.hps.july.persistence.*;
import java.math.BigDecimal;

/**
 * —лужебный класс дл€ вывода данных по карточке хранени€
 * »спользуетс€ в форме выборе оборудовани€
 */
public class StorageVO {
	private Integer storageplace;
	private String name;
public StorageVO(Object o, String name)
{
	if(o instanceof Number) {
		storageplace = new Integer(((Number)o).intValue());
	} else {
		storageplace = new Integer(-1);
	}
	this.name = name;
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
 * @return java.lang.Integer
 */
public java.lang.Integer getStorageplace() {
	return storageplace;
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
 * @param newStorageplace java.lang.Integer
 */
public void setStorageplace(java.lang.Integer newStorageplace) {
	storageplace = newStorageplace;
}
}
