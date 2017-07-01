package com.hps.july.arenda.valueobject;

import java.sql.*;
import com.hps.july.cdbc.lib.*;
/**
* контейнер Документа аренды.
* Creation date: (24.03.2004 18:57:56)
* @author: Shafigullin Ildar
*/
public class LeaseDocumentVO extends com.hps.july.valueobject.DomainObject{
	private Integer leaseDocument; //Уникальный код документа
	private Date docdate; //Учетная дата документа
	private String docnumber; //Номер документа
	private String doctype; //Тип документа(A-Договор аренды, N-Начисления, P-Оплаты, M-Акт взаимозачета, Q-Доп. соглашение об учете взаимных требований, F-Счет-фактуры, K-Договор (кроме аренды), B-Аб. договор, S-Ссудный договор)
	private java.lang.Integer operator;//Для работы с журналом
	private java.lang.String flagOldSystem;//Признак того что Документ получен из старой системы
	private java.lang.Integer regionid;//принадлежность к филиалу
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 17:38:33)
 */
public LeaseDocumentVO() {}
/**
 * LeaseDocument constructor.
 */
public LeaseDocumentVO(CDBCRowObject ro) {
	super();
	setLeaseDocument( (Integer)ro.getColumn("leasedocument").asObject() );
	setDocdate( (Date)ro.getColumn("docdate").asObject());
	setDocnumber(ro.getColumn("docnumber").asString());
	setDoctype(ro.getColumn("doctype").asString());
	setOperator((Integer)ro.getColumn("operator").asObject());
	setRegionid((Integer)ro.getColumn("regionid").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 18:58:39)
 * @return java.sql.Date
 */
public Date getDocdate() {
	return docdate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:02:07)
 * @return java.lang.String
 */
public java.lang.String getDocnumber() {
	return docnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:03:54)
 * @return java.lang.String
 */
public java.lang.String getDoctype() {
	return doctype;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 16:05:55)
 * @return java.lang.String
 */
public java.lang.String getFlagOldSystem() {
	return flagOldSystem;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:00:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:18:07)
 * @return java.lang.Integer
 */
public java.lang.Integer getOperator() {
	return operator;
}
/**
 * Insert the method's description here.
 * Creation date: (22.11.2005 18:18:31)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegionid() {
	return regionid;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 18:58:39)
 * @param newDocdate java.sql.Date
 */
public void setDocdate(Date newDocdate) {
	docdate = newDocdate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:02:07)
 * @param newDocnumber java.lang.String
 */
public void setDocnumber(java.lang.String newDocnumber) {
	docnumber = newDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:03:54)
 * @param newDoctype java.lang.String
 */
public void setDoctype(java.lang.String newDoctype) {
	doctype = newDoctype;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 16:05:55)
 * @param newFlagOldSystem java.lang.String
 */
public void setFlagOldSystem(java.lang.String newFlagOldSystem) {
	flagOldSystem = newFlagOldSystem;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:00:42)
 * @param newLeaseDocument java.lang.Integer
 */
public void setLeaseDocument(java.lang.Integer newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:18:07)
 * @param newOperator java.lang.Integer
 */
public void setOperator(java.lang.Integer newOperator) {
	operator = newOperator;
}
/**
 * Insert the method's description here.
 * Creation date: (22.11.2005 18:18:31)
 * @param newRegionid java.lang.Integer
 */
public void setRegionid(java.lang.Integer newRegionid) {
	regionid = newRegionid;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:24:18)
 * @return java.lang.String
 */
public String toString() {
	return "LeaseDocument: " + getLeaseDocument() + "; number: " + getDocnumber()+ "; regionID: " + getRegionid();
}
}
