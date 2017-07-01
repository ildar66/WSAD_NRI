package com.hps.july.arenda.valueobject;

import java.math.*;
/**
* Контейнер "Задолженности для актов"
* Creation date: (30.01.2004 15:41:01)
* @author: Shofigullin Ildar
*/
public class MutTempDebtValueObject extends MutualEndDebtValueObject {
	private java.lang.String debitor;
	private java.lang.String creditor;
	private BigDecimal sumMain;
	private java.math.BigDecimal ndsMain;
	private java.lang.String currMain;
	private java.lang.Integer headerId;
/**
 * MutTempDebtValueObject constructor comment.
 */
public MutTempDebtValueObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:42:33)
 * @return java.lang.String
 */
public java.lang.String getCreditor() {
	return creditor;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:44:21)
 * @return java.lang.String
 */
public java.lang.String getCurrMain() {
	return currMain;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:41:42)
 * @return java.lang.String
 */
public java.lang.String getDebitor() {
	return debitor;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:45:21)
 * @return java.lang.Integer
 */
public java.lang.Integer getHeaderId() {
	return headerId;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:43:51)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNdsMain() {
	return ndsMain;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:43:16)
 * @return java.math.BigDecimal
 */
public BigDecimal getSumMain() {
	return sumMain;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:42:33)
 * @param newCreditor java.lang.String
 */
public void setCreditor(java.lang.String newCreditor) {
	creditor = newCreditor;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:44:21)
 * @param newCurrMain java.lang.String
 */
public void setCurrMain(java.lang.String newCurrMain) {
	currMain = newCurrMain;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:41:42)
 * @param newDebitor java.lang.String
 */
public void setDebitor(java.lang.String newDebitor) {
	debitor = newDebitor;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:45:21)
 * @param newHeaderId java.lang.Integer
 */
public void setHeaderId(java.lang.Integer newHeaderId) {
	headerId = newHeaderId;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:43:51)
 * @param newNdsMain java.math.BigDecimal
 */
public void setNdsMain(java.math.BigDecimal newNdsMain) {
	ndsMain = newNdsMain;
}
/**
 * Insert the method's description here.
 * Creation date: (30.01.2004 15:43:16)
 * @param newSumMain java.math.BigDecimal
 */
public void setSumMain(BigDecimal newSumMain) {
	sumMain = newSumMain;
}
}
