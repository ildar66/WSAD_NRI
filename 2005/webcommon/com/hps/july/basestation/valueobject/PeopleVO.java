package com.hps.july.basestation.valueobject;

/**
 * контейнер "Справочник физических лиц".
 * Creation date: (23.07.2004 12:27:28)
 * @author: Shafigullin Ildar
 */
public class PeopleVO {
	private java.lang.Integer man;
	private java.lang.String name;
	private java.lang.String phone;
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 18:35:09)
 */
public PeopleVO() {}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 12:29:22)
 * @param man java.lang.Integer
 */
public PeopleVO(Integer man) {
	this.man = man;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 12:27:52)
 * @return java.lang.Integer
 */
public java.lang.Integer getMan() {
	return man;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 12:30:07)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (14.09.2004 13:48:01)
 * @return java.lang.String
 */
public java.lang.String getPhone() {
	return phone;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 17:52:06)
 * @param newMan java.lang.Integer
 */
public void setMan(java.lang.Integer newMan) {
	man = newMan;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 12:30:07)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (14.09.2004 13:48:01)
 * @param newPhone java.lang.String
 */
public void setPhone(java.lang.String newPhone) {
	phone = newPhone;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 12:40:23)
 * @return java.lang.String
 */
public String toString() {
	return "PeopleVO:man="+man + " name=" + getName();
}
}
