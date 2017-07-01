package com.hps.july.arenda.valueobject;

import com.hps.july.cdbc.lib.*;
/**
* Контейнер "Контракт из NFS".
* Creation date: (17.06.2004 14:39:15)
* @author: Shafigullin Ildar
*/
public class NFS_Contract_VO {
	private java.lang.Integer idContractNfs; //уникальный код контракта NFS
	private java.lang.String numContract; //номер договора
	private java.lang.String numContractNfs; //эектронный номер договора в системе NFS
	private java.lang.String dateContract;
/**
 * NFS_Contract_VO constructor comment.
 */
public NFS_Contract_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 14:51:02)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public NFS_Contract_VO(CDBCRowObject ro) {
	idContractNfs = (Integer) ro.getColumn("idcontractnfs").asObject();
	setNumContract(ro.getColumn("numcontract").asString());
	setNumContractNfs(ro.getColumn("numcontractnfs").asString());
	setDateContract(ro.getColumn("datecontract").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 15:05:49)
 * @return java.lang.String
 */
public java.lang.String getDateContract() {
	return dateContract;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 14:40:13)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdContractNfs() {
	return idContractNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 14:42:41)
 * @return java.lang.String
 */
public java.lang.String getNumContract() {
	return numContract;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 14:43:11)
 * @return java.lang.String
 */
public java.lang.String getNumContractNfs() {
	return numContractNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 15:05:49)
 * @param newDateContract java.lang.String
 */
public void setDateContract(java.lang.String newDateContract) {
	dateContract = newDateContract;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 14:42:41)
 * @param newNumContract java.lang.String
 */
public void setNumContract(java.lang.String newNumContract) {
	numContract = newNumContract;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 14:43:11)
 * @param newNumContractNfs java.lang.String
 */
public void setNumContractNfs(java.lang.String newNumContractNfs) {
	numContractNfs = newNumContractNfs;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "Contract: id=" + idContractNfs + "; Num= " + getNumContract()+ "; NumNFS= " + getNumContractNfs();
}
}
