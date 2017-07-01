package com.hps.july.siteinfo.valueobject;

import com.hps.july.persistence.*;
import java.util.*;

/**
 * Класс-контейнер содержащий расширенную информацию по карточке хранения оборудования
 * Используется в списках выбора карточек
 * @author: Dmitry Dneprov
 */
public class StoragecardObject {
	private com.hps.july.persistence.StorageCardAccessBean scard;
	private boolean haveContents;
public StoragecardObject() {
	super();
}
public StoragecardObject(StorageCardAccessBean argScard) {
	super();
	setScard(argScard);
	setHaveContents(false);
	try {
		// Check if we have contents
		Enumeration en = new StorageCardAccessBean().findByMainAgregateOrderByResourceAsc(new Integer(argScard.getStoragecard()));
		if (en.hasMoreElements())
			setHaveContents(true);
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}
public com.hps.july.persistence.StorageCardAccessBean getScard() {
	return scard;
}
public boolean isHaveContents() {
	return haveContents;
}
public void setHaveContents(boolean newHaveContents) {
	haveContents = newHaveContents;
}
public void setScard(com.hps.july.persistence.StorageCardAccessBean newScard) {
	scard = newScard;
}
}
