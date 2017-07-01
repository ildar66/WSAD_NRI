package com.hps.july.arenda.valueobject;

/**
 * Контейнер организации.
 * Creation date: (26.03.2004 21:16:03)
 * @author: Shafigullin Ildar
 */
public class OrganizationVO {
	private java.lang.Integer organization;//Уникальный код организации
	private java.lang.String name;//Наименование организациий
	private java.lang.String shortname;//Короткое название организации
	private java.lang.String inn;//ИНН
	private java.lang.String directorfio;//ФИО директора
	private java.lang.String legaladdress;//Юридический адрес
	private java.lang.String phone;
	private java.lang.String kpp;
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 14:41:27)
 */
public OrganizationVO() {}
/**
 * OrganizationVO constructor
 */
public OrganizationVO(Integer org) {
	super();
	organization = org;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 11:33:19)
 * @return java.lang.String
 */
public java.lang.String getDirectorfio() {
	return directorfio;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2004 11:18:27)
 * @return java.lang.String
 */
public java.lang.String getInn() {
	return inn;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2005 12:49:18)
 * @return java.lang.String
 */
public java.lang.String getKpp() {
	return kpp;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 11:33:45)
 * @return java.lang.String
 */
public java.lang.String getLegaladdress() {
	return legaladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2004 21:20:35)
 * @return java.lang.String
 */
public java.lang.String getName() {
	if (shortname != null && !shortname.equals(""))
		return shortname;
	else
		return name;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 12:41:45)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrganization() {
	return organization;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2005 18:22:49)
 * @return java.lang.String
 */
public java.lang.String getPhone() {
	return phone;
}
/**
 * Insert the method's description here.
 * Creation date: (01.04.2005 18:20:18)
 */
public String getRealName() {
    return name;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2004 21:21:21)
 * @return java.lang.String
 */
public java.lang.String getShortname() {
	return shortname;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 11:33:19)
 * @param newDirectorfio java.lang.String
 */
public void setDirectorfio(java.lang.String newDirectorfio) {
	directorfio = newDirectorfio;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2004 11:18:27)
 * @param newInn java.lang.String
 */
public void setInn(java.lang.String newInn) {
	inn = newInn;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2005 12:49:18)
 * @param newKpp java.lang.String
 */
public void setKpp(java.lang.String newKpp) {
	kpp = newKpp;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 11:33:45)
 * @param newLegaladdress java.lang.String
 */
public void setLegaladdress(java.lang.String newLegaladdress) {
	legaladdress = newLegaladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2004 21:20:35)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 12:41:45)
 * @param newOrganization java.lang.Integer
 */
public void setOrganization(java.lang.Integer newOrganization) {
	organization = newOrganization;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2005 18:22:49)
 * @param newPhone java.lang.String
 */
public void setPhone(java.lang.String newPhone) {
	phone = newPhone;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2004 21:21:21)
 * @param newShortname java.lang.String
 */
public void setShortname(java.lang.String newShortname) {
	shortname = newShortname;
}
}
