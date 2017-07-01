package com.hps.july.arenda.valueobject;

import com.hps.july.cdbc.lib.*;
/**
* Bean-Wraper "Телефоны абонентского договора".
* Creation date: (01.09.2004 11:30:26)
* @author: Shafigullin Ildar
*/
public class LeaseAbonentPhone_VO {
	private java.lang.Integer leasedocument; //Код документа (договора)
	private java.lang.String phonenumber; //Номер телефона
	private java.lang.String phonestatus; //Статус телефона
	private java.lang.String netstandard; //Стандарт сети
	private  java.lang.String imsi; //S_N SIM_карты или телефона
	private java.lang.Short ben; //BEN для информации
	private java.lang.String soc;//Код тарифного плана.
	private java.lang.String socdescription;//Наименование тарифного плана.
	private java.sql.Date socstartdate;//дата начала действия тарифного плана.
/**
 * LeaseAbonentPhone_VO constructor comment.
 */
public LeaseAbonentPhone_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:37:18)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LeaseAbonentPhone_VO(CDBCRowObject ro) {
	leasedocument = (Integer) ro.getColumn("leasedocument").asObject();
	phonenumber = ro.getColumn("phonenumber").asString();
	phonestatus  = ro.getColumn("phonestatus").asString();
	netstandard = ro.getColumn("netstandard").asString();
	imsi = ro.getColumn("imsi").asString();
	ben = (Short)ro.getColumn("ben").asObject();
	soc = ro.getColumn("soc").asString();
	socdescription = ro.getColumn("socdescription").asString();
	socstartdate = (java.sql.Date)ro.getColumn("socstartdate").asObject();
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:34:56)
 * @return java.lang.Integer
 */
public java.lang.Short getBen() {
	return ben;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:33:56)
 * @return  java.lang.String
 */
public  java.lang.String getImsi() {
	return imsi;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:31:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeasedocument() {
	return leasedocument;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:33:30)
 * @return java.lang.String
 */
public java.lang.String getNetstandard() {
	return netstandard;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:32:24)
 * @return java.lang.String
 */
public java.lang.String getPhonenumber() {
	return phonenumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:33:05)
 * @return java.lang.String
 */
public java.lang.String getPhonestatus() {
	return phonestatus;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2005 18:12:07)
 * @return java.lang.String
 */
public java.lang.String getSoc() {
	return soc;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2005 18:13:38)
 * @return java.lang.String
 */
public java.lang.String getSocdescription() {
	return socdescription;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2005 18:14:49)
 * @return java.sql.Date
 */
public java.sql.Date getSocstartdate() {
	return socstartdate;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:34:56)
 * @param newBen java.lang.Integer
 */
public void setBen(java.lang.Short newBen) {
	ben = newBen;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:33:56)
 * @param newImsi  java.lang.String
 */
public void setImsi( java.lang.String newImsi) {
	imsi = newImsi;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:31:55)
 * @param newLeasedocument java.lang.Integer
 */
public void setLeasedocument(java.lang.Integer newLeasedocument) {
	leasedocument = newLeasedocument;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:33:30)
 * @param newNetstandard java.lang.String
 */
public void setNetstandard(java.lang.String newNetstandard) {
	netstandard = newNetstandard;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:32:24)
 * @param newPhonenumber java.lang.String
 */
public void setPhonenumber(java.lang.String newPhonenumber) {
	phonenumber = newPhonenumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:33:05)
 * @param newPhonestatus java.lang.String
 */
public void setPhonestatus(java.lang.String newPhonestatus) {
	phonestatus = newPhonestatus;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2005 18:12:07)
 * @param newSoc java.lang.String
 */
public void setSoc(java.lang.String newSoc) {
	soc = newSoc;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2005 18:13:38)
 * @param newSocdescription java.lang.String
 */
public void setSocdescription(java.lang.String newSocdescription) {
	socdescription = newSocdescription;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2005 18:14:49)
 * @param newSocstartdate java.sql.Date
 */
public void setSocstartdate(java.sql.Date newSocstartdate) {
	socstartdate = newSocstartdate;
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
