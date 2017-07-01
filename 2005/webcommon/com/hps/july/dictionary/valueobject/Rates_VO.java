package com.hps.july.dictionary.valueobject;

/**
* Служебный класс с данными по Курсам валют.
* Creation date: (04.04.2005 16:19:26)
* @author: Shafigullin Ildar
*/
public class Rates_VO {
    private CurrencyVO currency; //Ссылка на валюту
    private java.lang.Integer ratetype; //Тип курса
    private java.sql.Date date; //Дата установки курса
    private java.math.BigDecimal value; //Значение курса
/**
 * Rates_VO constructor comment.
 */
public Rates_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:23:39)
 * @param iCurrency java.lang.Integer
 * @param iRtetype java.lang.Integer
 */
public Rates_VO(CurrencyVO iCurrency, Integer iRatetype) {
    this.currency = iCurrency;
    this.ratetype = iRatetype;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:20:53)
 * @return java.lang.Integer
 */
public CurrencyVO getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:22:01)
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:21:26)
 * @return java.lang.Integer
 */
public java.lang.Integer getRatetype() {
	return ratetype;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:22:35)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getValue() {
	return value;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:20:53)
 * @param newCurrency java.lang.Integer
 */
public void setCurrency(CurrencyVO newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:22:01)
 * @param newDate java.sql.Date
 */
public void setDate(java.sql.Date newDate) {
	date = newDate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:21:26)
 * @param newRatetype java.lang.Integer
 */
public void setRatetype(java.lang.Integer newRatetype) {
	ratetype = newRatetype;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:22:35)
 * @param newValue java.math.BigDecimal
 */
public void setValue(java.math.BigDecimal newValue) {
	value = newValue;
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
