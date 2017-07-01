package com.hps.july.basestation.valueobject;

import com.hps.july.persistence.*;
import java.util.*;

/**
 * Служебный класс контейнер содержащий информацию о карточке хранения и наличии неё составных частей
 */
public class StoragecardObject {
	private com.hps.july.persistence.StorageCardAccessBean scard;
	private boolean haveContents;
/**
 * StoragecardObject constructor comment.
 */
public StoragecardObject() {
	super();
}
/**
 * StoragecardObject constructor comment.
 */
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
/**
 * Insert the method's description here.
 * Creation date: (13.01.2003 11:18:37)
 * @return com.hps.july.persistence.StorageCardAccessBean
 */
public com.hps.july.persistence.StorageCardAccessBean getScard() {
	return scard;
}
/**
 * Insert the method's description here.
 * Creation date: (13.01.2003 11:21:40)
 * @return boolean
 */
public boolean isHaveContents() {
	return haveContents;
}
/**
 * Insert the method's description here.
 * Creation date: (13.01.2003 11:21:40)
 * @param newHaveContents boolean
 */
public void setHaveContents(boolean newHaveContents) {
	haveContents = newHaveContents;
}
/**
 * Insert the method's description here.
 * Creation date: (13.01.2003 11:18:37)
 * @param newScard com.hps.july.persistence.StorageCardAccessBean
 */
public void setScard(com.hps.july.persistence.StorageCardAccessBean newScard) {
	scard = newScard;
}
}
