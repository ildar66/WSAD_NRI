package com.hps.july.basestation.valueobject;

/**
 * Служебный класс-контейнер с параметрами донорной БС
 * Используется в соответствующей форме выбора
 */
public class BasestationLookupObject {
	private int key;
	
	private Integer number;
	private String type;
	private String name;
	private String address;
	private String netzone;
	private Boolean onair;
public BasestationLookupObject() {
	super();
}
public BasestationLookupObject(int key) {
	this.key = key;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * 
 * @return int
 */
public int getKey() {
	return key;
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
 * @return java.lang.String
 */
public java.lang.String getNetzone() {
	return netzone;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getNumber() {
	return number;
}
public Boolean getOnair() {
	return onair;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * 
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * 
 * @param newKey int
 */
public void setKey(int newKey) {
	key = newKey;
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
 * @param newNetzone java.lang.String
 */
public void setNetzone(java.lang.String newNetzone) {
	netzone = newNetzone;
}
/**
 * 
 * @param newNumber java.lang.Integer
 */
public void setNumber(java.lang.Integer newNumber) {
	number = newNumber;
}
public void setOnair(Boolean newOnair) {
	onair = newOnair;
}
/**
 * 
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
