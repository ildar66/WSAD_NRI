package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * Форма списка истории курсов валюты
 */
public class CurrateHListForm extends com.hps.july.web.util.BrowseForm {
	private int currency;
	private java.lang.String currencyname;
	private int ratetype;
	private java.lang.String ratetypename;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public CurrateHListForm() {
	this.setFinderMethodName( "findByTypeAndCurrencyOrderByDateDesc" );
	currency = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:25:56)
 * @return int
 */
public int getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:25:24)
 * @return java.lang.String
 */
public java.lang.String getCurrencyname() {
	return currencyname;
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictResAdmin");
	//roles.add("dictResOperator");
	roles.add("dictCurrateOperator");
	roles.add("ArendaMainEconomist");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(ratetype), new Integer(currency) };
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2002 9:50:25)
 * @return int
 */
public int getRatetype() {
	return ratetype;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2002 9:51:01)
 * @return java.lang.String
 */
public java.lang.String getRatetypename() {
	return ratetypename;
}
/**
 * Insert the method's description here.
 */
public void setCurrency(int newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 */
public void setCurrencyname(java.lang.String newCurrencyname) {
	currencyname = newCurrencyname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2002 9:50:25)
 * @param newRatetype int
 */
public void setRatetype(int newRatetype) {
	ratetype = newRatetype;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2002 9:51:01)
 * @param newRatetypename java.lang.String
 */
public void setRatetypename(java.lang.String newRatetypename) {
	ratetypename = newRatetypename;
}
}
