package com.hps.july.valueobject;

/**
 * Bean-wrapper "Валюта".
 * Creation date: (29.03.2004 10:42:32)
 * @author: Shafigullin Ildar
 */
public class Currency_VO {
	private java.lang.Integer currency;//код валюты
	private java.lang.String name;//Наименование
	private java.lang.String shortname;//Короткое имя
/**
 * CurrencyVO constructor comment.
 */
public Currency_VO(Integer currency) {
	super();
	this.currency= currency;
}
/**
 * CurrencyVO constructor comment.
 */
public Currency_VO(Integer aCurrency, String aName, String aShortname) {
	super();
	setCurrency(aCurrency);
	setName(aName);
	setShortname(aShortname);
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 10:45:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 10:46:12)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 10:47:02)
 * @return java.lang.String
 */
public java.lang.String getShortname() {
	return shortname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.11.2004 17:08:56)
 * @param newCurrency java.lang.Integer
 */
public void setCurrency(java.lang.Integer newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 10:46:12)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 10:47:02)
 * @param newShortname java.lang.String
 */
public void setShortname(java.lang.String newShortname) {
	shortname = newShortname;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	// Insert code to print the receiver here.
	// This implementation forwards the message to super. You may replace or supplement this.
	return super.toString();
}
}
