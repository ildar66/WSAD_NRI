package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
import com.hps.july.cdbc.lib.*;
/**
 * Bean-Wraper: Абонентские договора.
 * Creation date: (27.05.2004 15:48:21)
 * @author: Shafigullin Ildar
 */
public class LeaseAbonentBAN_VO extends LeaseContractVO {
	private java.lang.String accounttype;
	private java.lang.String bil_acctypename;
	private java.lang.String bil_billaddress;
	private java.lang.String bil_contrstatus;
	private java.lang.String bil_contrstname;
	private java.lang.String bil_inn;
	private java.lang.String bil_name;
	private Date bil_startservdate;
	private java.sql.Date bil_suspdate;
	private java.sql.Date bil_contrstdate;
	private int ban;
	private boolean flagworkpie;
	private boolean useallben;
	private BigDecimal balans;
	private java.lang.String proctype;
	private boolean useinacts;
	private boolean techcontract;
	private Integer mainposition;
	private StoragePlaceVO mainpositionVO;
	private int cntPhone;
	private java.math.BigDecimal balansNRI;
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 16:42:22)
 */
public LeaseAbonentBAN_VO() {}
/**
 * LeaseAbonentBAN_VO constructor comment.
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LeaseAbonentBAN_VO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super(ro);
	initFlagworkpie(ro);
	initBan(ro);
	initUseallben(ro);
	setBalans((java.math.BigDecimal) ro.getColumn("balans").asObject());
	initMainPosition(ro);
	setProctype(ro.getColumn("proctype").asString());
	initUseinacts(ro);
	initTechcontract(ro);
	setBil_name(ro.getColumn("bil_name").asString());
}
/**
 * Compares two objects for equality. Returns a boolean that indicates
 * whether this object is equivalent to the specified object. This method
 * is used when an object is stored in a hashtable.
 * @param obj the Object to compare with
 * @return true if these Objects are equal; false otherwise.
 * @see java.util.Hashtable
 */
public boolean equals(Object obj) {
	// Insert code to compare the receiver and obj here.
	// This implementation forwards the message to super.  You may replace or supplement this.
	// NOTE: obj might be an instance of any class
	return super.equals(obj);
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:53:41)
 * @return java.lang.String
 */
public java.lang.String getAccounttype() {
	return accounttype;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:59:01)
 * @return java.math.BigDecimal
 */
public BigDecimal getBalans() {
	return balans;
}
/**
 * Insert the method's description here.
 * Creation date: (07.09.2005 17:51:27)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getBalansNRI() {
	return balansNRI;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:57:53)
 * @return int
 */
public int getBan() {
	return ban;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:54:03)
 * @return java.lang.String
 */
public java.lang.String getBil_acctypename() {
	return bil_acctypename;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:54:24)
 * @return java.lang.String
 */
public java.lang.String getBil_billaddress() {
	return bil_billaddress;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:54:47)
 * @return java.lang.String
 */
public java.lang.String getBil_contrstatus() {
	return bil_contrstatus;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:57:37)
 * @return java.sql.Date
 */
public java.sql.Date getBil_contrstdate() {
	return bil_contrstdate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:55:02)
 * @return java.lang.String
 */
public java.lang.String getBil_contrstname() {
	return bil_contrstname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:55:19)
 * @return java.lang.String
 */
public java.lang.String getBil_inn() {
	return bil_inn;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:55:45)
 * @return java.lang.String
 */
public java.lang.String getBil_name() {
	return bil_name;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:56:48)
 * @return java.sql.Date
 */
public Date getBil_startservdate() {
	return bil_startservdate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:57:19)
 * @return java.sql.Date
 */
public java.sql.Date getBil_suspdate() {
	return bil_suspdate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2004 18:50:05)
 * @return int
 */
public int getCntPhone() {
	return cntPhone;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:58:11)
 * @return boolean
 */
public boolean getFlagworkpie() {
	return flagworkpie;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 16:02:20)
 * @return Integer
 */
public Integer getMainposition() {
	return mainposition;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 15:06:03)
 * @return com.hps.july.arenda.valueobject.StoragePlaceVO
 */
public StoragePlaceVO getMainpositionVO() {
	return mainpositionVO;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 16:01:06)
 * @return java.lang.String
 */
public java.lang.String getProctype() {
	return proctype;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 16:01:39)
 * @return boolean
 */
public boolean getTechcontract() {
	return techcontract;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:58:32)
 * @return boolean
 */
public boolean getUseallben() {
	return useallben;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 16:01:22)
 * @return boolean
 */
public boolean getUseinacts() {
	return useinacts;
}
/**
 * Generates a hash code for the receiver.
 * This method is supported primarily for
 * hash tables, such as those provided in java.util.
 * @return an integer hash code for the receiver
 * @see java.util.Hashtable
 */
public int hashCode() {
	// Insert code to generate a hash code for the receiver here.
	// This implementation forwards the message to super.  You may replace or supplement this.
	// NOTE: if two objects are equal (equals(Object) returns true) they must have the same hash code
	return super.hashCode();
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:01:54)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initBan(CDBCRowObject ro) {
	if (ro.getColumn("ban").asObject() != null) {
		int ban = ((Integer)ro.getColumn("ban").asObject()).intValue();
		setBan(ban);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:09:13)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initFlagworkpie(CDBCRowObject ro) {
	String flagworkpieStr = ro.getColumn("flagworkpie").asString();
	if (flagworkpieStr.equalsIgnoreCase("Y")) {
		setFlagworkpie(true);
	} else
		setFlagworkpie(false);
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:51:22)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initMainPosition(CDBCRowObject ro) {
	Integer mainPos = (Integer) ro.getColumn("mainposition").asObject();
	if (mainPos != null) {
		setMainposition(mainPos);
		StoragePlaceVO vo = new StoragePlaceVO(mainPos.intValue());
		vo.setName(ro.getColumn("mainpositionname").asString());
		setMainpositionVO(vo);
	} else {
		setMainpositionVO(null);
	}

}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:26:08)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initTechcontract(CDBCRowObject ro) {
	String techcontractStr = ro.getColumn("techcontract").asString();
	if (techcontractStr.equalsIgnoreCase("Y")) {
		setTechcontract(true);
	} else {
		setTechcontract(false);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:14:56)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initUseallben(CDBCRowObject ro) {
	String useallbenStr = ro.getColumn("useallben").asString();
	if (useallbenStr.equalsIgnoreCase("Y")) {
		setUseallben(true);
	} else {
		setUseallben(false);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:23:09)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initUseinacts(CDBCRowObject ro) {
	String useinactsStr = ro.getColumn("useinacts").asString();
	if (useinactsStr.equalsIgnoreCase("Y")) {
		setUseinacts(true);
	} else {
		setUseinacts(false);
	}

}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:53:41)
 * @param newAccounttype java.lang.String
 */
public void setAccounttype(java.lang.String newAccounttype) {
	accounttype = newAccounttype;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:59:01)
 * @param newBalans java.math.BigDecimal
 */
public void setBalans(BigDecimal newBalans) {
	balans = newBalans;
}
/**
 * Insert the method's description here.
 * Creation date: (07.09.2005 17:51:27)
 * @param newBalansNRI java.math.BigDecimal
 */
public void setBalansNRI(java.math.BigDecimal newBalansNRI) {
	balansNRI = newBalansNRI;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:57:53)
 * @param newBan int
 */
public void setBan(int newBan) {
	ban = newBan;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:54:03)
 * @param newBil_acctypename java.lang.String
 */
public void setBil_acctypename(java.lang.String newBil_acctypename) {
	bil_acctypename = newBil_acctypename;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:54:24)
 * @param newBil_billaddress java.lang.String
 */
public void setBil_billaddress(java.lang.String newBil_billaddress) {
	bil_billaddress = newBil_billaddress;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:54:47)
 * @param newBil_contrstatus java.lang.String
 */
public void setBil_contrstatus(java.lang.String newBil_contrstatus) {
	bil_contrstatus = newBil_contrstatus;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:57:37)
 * @param newBil_contrstdate java.sql.Date
 */
public void setBil_contrstdate(java.sql.Date newBil_contrstdate) {
	bil_contrstdate = newBil_contrstdate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:55:02)
 * @param newBil_contrstname java.lang.String
 */
public void setBil_contrstname(java.lang.String newBil_contrstname) {
	bil_contrstname = newBil_contrstname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:55:19)
 * @param newBil_inn java.lang.String
 */
public void setBil_inn(java.lang.String newBil_inn) {
	bil_inn = newBil_inn;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:55:45)
 * @param newBil_name java.lang.String
 */
public void setBil_name(java.lang.String newBil_name) {
	bil_name = newBil_name;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:56:48)
 * @param newBil_startservdate java.sql.Date
 */
public void setBil_startservdate(Date newBil_startservdate) {
	bil_startservdate = newBil_startservdate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:57:19)
 * @param newBil_suspdate java.sql.Date
 */
public void setBil_suspdate(java.sql.Date newBil_suspdate) {
	bil_suspdate = newBil_suspdate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2004 18:50:05)
 * @param newCntPhone int
 */
public void setCntPhone(int newCntPhone) {
	cntPhone = newCntPhone;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:58:11)
 * @param newFlagworkpie boolean
 */
public void setFlagworkpie(boolean newFlagworkpie) {
	flagworkpie = newFlagworkpie;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 16:02:20)
 * @param newMainPosition Integer
 */
public void setMainposition(Integer newMainPosition) {
	mainposition = newMainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 15:06:03)
 * @param newMainpositionVO com.hps.july.arenda.valueobject.StoragePlaceVO
 */
public void setMainpositionVO(StoragePlaceVO newMainpositionVO) {
	mainpositionVO = newMainpositionVO;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 16:01:06)
 * @param newProctype java.lang.String
 */
public void setProctype(java.lang.String newProctype) {
	proctype = newProctype;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 16:01:39)
 * @param newTechcontract boolean
 */
public void setTechcontract(boolean newTechcontract) {
	techcontract = newTechcontract;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 15:58:32)
 * @param newUseallben boolean
 */
public void setUseallben(boolean newUseallben) {
	useallben = newUseallben;
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2004 16:01:22)
 * @param newUseinacts boolean
 */
public void setUseinacts(boolean newUseinacts) {
	useinacts = newUseinacts;
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
