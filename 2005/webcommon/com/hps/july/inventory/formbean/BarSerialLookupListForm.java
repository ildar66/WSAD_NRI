package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;

/**
 * Форма выбора серии штрих кодов
 */
public class BarSerialLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String serial;
	private java.lang.String serparty;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public BarSerialLookupListForm() {
	this.setFinderMethodName( "findBySerialMaskOrderBySerialAsc" );
	serial="";
	serparty="S";
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { getSerial() };
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 17:45:54)
 * @return java.lang.String
 */
public java.lang.String getSerial() {
	return serial;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 17:46:26)
 * @return java.lang.String
 */
public java.lang.String getSerparty() {
	return serparty;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 17:45:54)
 * @param newSerial java.lang.String
 */
public void setSerial(java.lang.String newSerial) {
	serial = newSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 17:46:26)
 * @param newSerparty java.lang.String
 */
public void setSerparty(java.lang.String newSerparty) {
	serparty = newSerparty;
}
}
