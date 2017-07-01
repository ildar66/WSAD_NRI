package com.hps.july.arenda.valueobject;


import java.math.*;/**
 * Позиция счет-фактуры.
 * Creation date: (27.04.2004 11:38:32)
 * @author: Shafigullin Ildar
 */
public class SchetFactPositionValueObject {
	private java.lang.Integer posOrder;
	private java.lang.String nameResource;
	private java.lang.String edizm;
	private BigDecimal qty;
	private java.math.BigDecimal price;
	private java.math.BigDecimal sumFreeTax;
	private java.math.BigDecimal excise;
	private java.math.BigDecimal rateNds;
	private java.math.BigDecimal sumNds;
	private java.math.BigDecimal sumWithTax;
	private java.lang.String country;
	private java.lang.String numGTD;
	private java.lang.Integer idCurrency;
/**
 * SchetFactPositionValueObject constructor comment.
 */
public SchetFactPositionValueObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:57:55)
 * @return java.lang.String
 */
public java.lang.String getCountry() {
	return country;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:52:05)
 * @return java.lang.String
 */
public java.lang.String getEdizm() {
	return edizm;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:56:10)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getExcise() {
	return excise;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:58:48)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdCurrency() {
	return idCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:51:39)
 * @return java.lang.String
 */
public java.lang.String getNameResource() {
	return nameResource;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:58:17)
 * @return java.lang.String
 */
public java.lang.String getNumGTD() {
	return numGTD;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:51:17)
 * @return java.lang.Integer
 */
public java.lang.Integer getPosOrder() {
	return posOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:55:15)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPrice() {
	return price;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:52:33)
 * @return java.math.BigDecimal
 */
public BigDecimal getQty() {
	return qty;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:56:43)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRateNds() {
	return rateNds;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:55:48)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumFreeTax() {
	return sumFreeTax;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:57:11)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumNds() {
	return sumNds;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:57:36)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumWithTax() {
	return sumWithTax;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:57:55)
 * @param newCountry java.lang.String
 */
public void setCountry(java.lang.String newCountry) {
	country = newCountry;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:52:05)
 * @param newEdizm java.lang.String
 */
public void setEdizm(java.lang.String newEdizm) {
	edizm = newEdizm;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:56:10)
 * @param newExcise java.math.BigDecimal
 */
public void setExcise(java.math.BigDecimal newExcise) {
	excise = newExcise;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:58:48)
 * @param newIdCurrency java.lang.Integer
 */
public void setIdCurrency(java.lang.Integer newIdCurrency) {
	idCurrency = newIdCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:51:39)
 * @param newNameResource java.lang.String
 */
public void setNameResource(java.lang.String newNameResource) {
	nameResource = newNameResource;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:58:17)
 * @param newNumGTD java.lang.String
 */
public void setNumGTD(java.lang.String newNumGTD) {
	numGTD = newNumGTD;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:51:17)
 * @param newPosOrder java.lang.Integer
 */
public void setPosOrder(java.lang.Integer newPosOrder) {
	posOrder = newPosOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:55:15)
 * @param newPrice java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newPrice) {
	price = newPrice;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:52:33)
 * @param newQty java.math.BigDecimal
 */
public void setQty(BigDecimal newQty) {
	qty = newQty;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:56:43)
 * @param newRateNds java.math.BigDecimal
 */
public void setRateNds(java.math.BigDecimal newRateNds) {
	rateNds = newRateNds;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:55:48)
 * @param newSumFreeTax java.math.BigDecimal
 */
public void setSumFreeTax(java.math.BigDecimal newSumFreeTax) {
	sumFreeTax = newSumFreeTax;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:57:11)
 * @param newSumNds java.math.BigDecimal
 */
public void setSumNds(java.math.BigDecimal newSumNds) {
	sumNds = newSumNds;
}
/**
 * Insert the method's description here.
 * Creation date: (27.04.2004 11:57:36)
 * @param newSumWithTax java.math.BigDecimal
 */
public void setSumWithTax(java.math.BigDecimal newSumWithTax) {
	sumWithTax = newSumWithTax;
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
