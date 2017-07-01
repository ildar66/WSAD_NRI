package com.hps.july.dictionary.valueobject;

import java.sql.*;
import java.math.*;
import com.hps.july.cdbc.lib.*;
/**
* Справочник "Person from Organization base".
* Creation date: (03.10.2005 18:39:55)
* @author: Shafigullin Ildar
*/
public class Person_VO extends OrganizationVO {
    private java.lang.String lastname; //Фамилия
    private java.lang.String firstname; //Имя
    private java.lang.String middlename; //Отчество
    private java.lang.String passportser; //серия паспорта
    private java.lang.String passportnum; //номер паспорта
    private java.sql.Date passportdate; //когда выдан
    private java.lang.String passportwhom; //кем выдан
/**
 * Person_VO constructor comment.
 */
public Person_VO(CDBCRowObject ro) {
    super((Integer) ro.getColumn("organization").asObject());
    setLastname(ro.getColumn("lastname").asString());
    setFirstname(ro.getColumn("firstname").asString());
    setMiddlename(ro.getColumn("middlename").asString());
    setPassportser(ro.getColumn("passportser").asString());
    setPassportnum(ro.getColumn("passportnum").asString());
    setPassportdate((Date)ro.getColumn("passportdate").asObject());
    setPassportwhom(ro.getColumn("passportwhom").asString());
    setTypeOrg(PersonType);
}
/**
 * Insert the method's description here.
 * Creation date: (05.10.2005 14:47:00)
 * @param organizationID java.lang.Integer
 */
public Person_VO(Integer organizationID) {
    super(organizationID);
    setTypeOrg(PersonType);
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:52:21)
 * @return java.lang.String
 */
public java.lang.String getFirstname() {
	return firstname;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:51:43)
 * @return java.lang.String
 */
public java.lang.String getLastname() {
	return lastname;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:52:34)
 * @return java.lang.String
 */
public java.lang.String getMiddlename() {
	return middlename;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:54:15)
 * @return java.sql.Date
 */
public java.sql.Date getPassportdate() {
	return passportdate;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:53:34)
 * @return java.lang.String
 */
public java.lang.String getPassportnum() {
	return passportnum;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:53:21)
 * @return java.lang.String
 */
public java.lang.String getPassportser() {
	return passportser;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:54:32)
 * @return java.lang.String
 */
public java.lang.String getPassportwhom() {
	return passportwhom;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:52:21)
 * @param newFirstname java.lang.String
 */
public void setFirstname(java.lang.String newFirstname) {
	firstname = newFirstname;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:51:43)
 * @param newLastname java.lang.String
 */
public void setLastname(java.lang.String newLastname) {
	lastname = newLastname;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:52:34)
 * @param newMiddlename java.lang.String
 */
public void setMiddlename(java.lang.String newMiddlename) {
	middlename = newMiddlename;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:54:15)
 * @param newPassportdate java.sql.Date
 */
public void setPassportdate(java.sql.Date newPassportdate) {
	passportdate = newPassportdate;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:53:34)
 * @param newPassportnum java.lang.String
 */
public void setPassportnum(java.lang.String newPassportnum) {
	passportnum = newPassportnum;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:53:21)
 * @param newPassportser java.lang.String
 */
public void setPassportser(java.lang.String newPassportser) {
	passportser = newPassportser;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2005 18:54:32)
 * @param newPassportwhom java.lang.String
 */
public void setPassportwhom(java.lang.String newPassportwhom) {
	passportwhom = newPassportwhom;
}
}
