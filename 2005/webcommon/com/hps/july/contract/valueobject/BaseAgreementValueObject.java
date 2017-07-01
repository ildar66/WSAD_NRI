package com.hps.july.contract.valueobject;

/**
 * Класс-контейнер с информацией по основному соглашению.
 * Используется для вывода списков соглашений
 */
public class BaseAgreementValueObject {
	private java.lang.Integer baseagreement;
	private java.lang.String name;
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 15:39:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getBaseagreement() {
	return baseagreement;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 15:39:38)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 15:39:38)
 * @param newBaseagreement java.lang.Integer
 */
public void setBaseagreement(java.lang.Integer newBaseagreement) {
	baseagreement = newBaseagreement;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 15:39:38)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
}
