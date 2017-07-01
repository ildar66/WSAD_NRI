package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
/**
 * Bean-Wrapper "ƒополнительные соглашени€ по аренде позиций"
 * Creation date: (23.08.2002 12:02:35)
 * @author: Sergey Gourov
 */
public class LeaseArendaAgreementNewValueObject {
	private com.hps.july.persistence.LeaseArendaAgreementNewAccessBean o;
	private java.lang.String mainDocumentNumber;
	private java.sql.Date mainStartDate;
	private java.sql.Date mainDocumentDate;
	private int leaseDocument;
	private java.lang.String namePosition;
	private java.lang.String allPositions;
/**
 * LeaseArendaAgreementNewValueObject constructor comment.
 */
public LeaseArendaAgreementNewValueObject(LeaseArendaAgreementNewAccessBean bean) {
	super();
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (24.02.2004 16:26:52)
 * @return java.lang.String
 */
public java.lang.String getAllPositions() {
	return allPositions;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2002 15:37:40)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2002 14:57:04)
 * @return java.sql.Date
 */
public java.sql.Date getMainDocumentDate() {
	return mainDocumentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:20:38)
 * @return java.lang.String
 */
public java.lang.String getMainDocumentNumber() {
	return mainDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:19:46)
 * @return java.sql.Date
 */
public java.sql.Date getMainStartDate() {
	return mainStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (06.02.2004 18:55:28)
 * @return java.lang.String
 */
public java.lang.String getNamePosition() {
	return namePosition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:03:50)
 * @return com.hps.july.persistence.LeaseArendaAgreementNewAccessBean
 */
public com.hps.july.persistence.LeaseArendaAgreementNewAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (24.02.2004 16:26:52)
 * @param newAllPositions java.lang.String
 */
public void setAllPositions(java.lang.String newAllPositions) {
	allPositions = newAllPositions;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2002 15:37:40)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2002 14:57:04)
 * @param newMainDocumentDate java.sql.Date
 */
public void setMainDocumentDate(java.sql.Date newMainDocumentDate) {
	mainDocumentDate = newMainDocumentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:20:38)
 * @param newMainDocumentNumber java.lang.String
 */
public void setMainDocumentNumber(java.lang.String newMainDocumentNumber) {
	mainDocumentNumber = newMainDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:19:46)
 * @param newMainStartDate java.sql.Date
 */
public void setMainStartDate(java.sql.Date newMainStartDate) {
	mainStartDate = newMainStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (06.02.2004 18:55:28)
 * @param newNamePosition java.lang.String
 */
public void setNamePosition(java.lang.String newNamePosition) {
	namePosition = newNamePosition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:03:50)
 * @param newO com.hps.july.persistence.LeaseArendaAgreementNewAccessBean
 */
public void setO(com.hps.july.persistence.LeaseArendaAgreementNewAccessBean newO) {
	o = newO;
}
}
