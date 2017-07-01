package com.hps.july.arenda.valueobject;

import java.util.*;
/**
* Дополнительные соглашения по аренде позиций(контейнер)
*(Первое дополнительное соглашение трактуется как сам договор) 
* Creation date: (25.03.2004 12:44:27)
* @author: Shafigullin Ildar
*/
public class LeaseArendaAgrmntVO extends LeaseContractVO {
	private Integer mainLeaseDocument; //Ссылка на базовый договор
	private String isactive; //Признак активности(Y-Активен, N-нет)
	private String howgivephones; //Как выданы телефоны
	private Integer numberofphones; //Кол-во выданных телефонов
	private String calcelectrotype; //Тип расчета за электроэнергию(1-По отдельному договору, 2-Входит в арендную плату, 3-По счетам)
	private String isdogelectro; //Признак наличия договора по электричеству(Y-да, N-нет)
	private String dogelectonum; //Номер договора электричества
	private Date dogelectrodate;//Дата договора электричества
	private java.lang.String officialdoc;//Регистрация договора в государственных органах(Y-да, N-нет)
	private java.lang.String needofficialdoc;//необходима Регистрация договора в гос. органах(Y-да, N-нет)
	private java.lang.String mainPosition;//главная позиция
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 17:33:52)
 */
public LeaseArendaAgrmntVO() {}
/**
 * LeaseArendaAgrmnt constructor .
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LeaseArendaAgrmntVO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super(ro);
	setMainLeaseDocument((Integer)ro.getColumn("mainleasedocument").asObject());
	setIsactive(ro.getColumn("isactive").asString());
	//setHowgivephones(ro.getColumn("howgivephones").asString());
	setNumberofphones((Integer)ro.getColumn("numberofphones").asObject());
	setCalcelectrotype(ro.getColumn("calcelectrotype").asString());
	setIsdogelectro(ro.getColumn("isdogelectro").asString());
	setDogelectonum(ro.getColumn("dogelectonum").asString());
	setDogelectrodate((Date)ro.getColumn("dogelectrodate").asObject());
	setOfficialdoc(ro.getColumn("officialdoc").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:53:26)
 * @return java.lang.String
 */
public java.lang.String getCalcelectrotype() {
	return calcelectrotype;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:55:32)
 * @return java.lang.String
 */
public java.lang.String getDogelectonum() {
	return dogelectonum;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:56:51)
 * @return java.util.Date
 */
public Date getDogelectrodate() {
	return dogelectrodate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:52:23)
 * @return java.lang.String
 */
public java.lang.String getHowgivephones() {
	return howgivephones;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:51:29)
 * @return java.lang.String
 */
public java.lang.String getIsactive() {
	return isactive;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:54:55)
 * @return java.lang.String
 */
public java.lang.String getIsdogelectro() {
	return isdogelectro;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:50:50)
 * @return java.lang.Integer
 */
public java.lang.Integer getMainLeaseDocument() {
	return mainLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2005 15:06:07)
 * @return java.lang.String
 */
public java.lang.String getNeedofficialdoc() {
	return needofficialdoc;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:52:56)
 * @return java.lang.Integer
 */
public java.lang.Integer getNumberofphones() {
	return numberofphones;
}
/**
 * Insert the method's description here.
 * Creation date: (16.03.2005 15:05:15)
 * @return java.lang.String
 */
public java.lang.String getOfficialdoc() {
	return officialdoc;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:53:26)
 * @param newCalcelectrotype java.lang.String
 */
public void setCalcelectrotype(java.lang.String newCalcelectrotype) {
	calcelectrotype = newCalcelectrotype;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:55:32)
 * @param newDogelectonum java.lang.String
 */
public void setDogelectonum(java.lang.String newDogelectonum) {
	dogelectonum = newDogelectonum;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:56:51)
 * @param newDogelectrodate java.util.Date
 */
public void setDogelectrodate(Date newDogelectrodate) {
	dogelectrodate = newDogelectrodate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:52:23)
 * @param newHowgivephones java.lang.String
 */
public void setHowgivephones(java.lang.String newHowgivephones) {
	howgivephones = newHowgivephones;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:51:29)
 * @param newIsactive java.lang.String
 */
public void setIsactive(java.lang.String newIsactive) {
	isactive = newIsactive;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:54:55)
 * @param newIsdogelectro java.lang.String
 */
public void setIsdogelectro(java.lang.String newIsdogelectro) {
	isdogelectro = newIsdogelectro;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:50:50)
 * @param newMainLeaseDocument java.lang.Integer
 */
public void setMainLeaseDocument(java.lang.Integer newMainLeaseDocument) {
	mainLeaseDocument = newMainLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (16.05.2005 15:06:07)
 * @param newNeedofficialdoc java.lang.String
 */
public void setNeedofficialdoc(java.lang.String newNeedofficialdoc) {
	needofficialdoc = newNeedofficialdoc;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 12:52:56)
 * @param newNumberofphones java.lang.Integer
 */
public void setNumberofphones(java.lang.Integer newNumberofphones) {
	numberofphones = newNumberofphones;
}
/**
 * Insert the method's description here.
 * Creation date: (16.03.2005 15:05:15)
 * @param newOfficialdoc java.lang.String
 */
public void setOfficialdoc(java.lang.String newOfficialdoc) {
	officialdoc = newOfficialdoc;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	// Insert code to print the receiver here.
	String str = "LeaseArendaAgrmntVO mainDoc=" + getMainLeaseDocument() + "; ";
	// This implementation forwards the message to super. You may replace or supplement this.
	return str + super.toString();
}
	/**
	 * @return
	 */
	public java.lang.String getMainPosition() {
		return mainPosition;
	}

	/**
	 * @param string
	 */
	public void setMainPosition(java.lang.String string) {
		mainPosition = string;
	}

}
