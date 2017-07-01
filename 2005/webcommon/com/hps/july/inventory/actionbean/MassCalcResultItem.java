package com.hps.july.inventory.actionbean;

import org.apache.struts.action.*;

/**
 * Класс объектов с информацией о документе и ошибках при обсчёте
 * Используется в массовом обсчёте документов
 */
public class MassCalcResultItem {
	private int docId;
	private java.sql.Date docDate;
	private String docNumber;
	private String docType;
	private ActionErrors errors;
	private int state;
	private String storagename = "";
	private String enteror = "";
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getDocDate() {
	return docDate;
}
public int getDocId() {
	return docId;
}
public java.lang.String getDocNumber() {
	return docNumber;
}
public java.lang.String getDocType() {
	return docType;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEnteror() {
	return enteror;
}
public org.apache.struts.action.ActionErrors getErrors() {
	return errors;
}
public int getState() {
	return state;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
/**
 * 
 * @param newDocDate java.sql.Date
 */
public void setDocDate(java.sql.Date newDocDate) {
	docDate = newDocDate;
}
public void setDocId(int newDocId) {
	docId = newDocId;
}
public void setDocNumber(java.lang.String newDocNumber) {
	docNumber = newDocNumber;
}
public void setDocType(java.lang.String newDocType) {
	docType = newDocType;
}
/**
 * 
 * @param newEnteror java.lang.String
 */
public void setEnteror(java.lang.String newEnteror) {
	enteror = newEnteror;
}
public void setErrors(org.apache.struts.action.ActionErrors newErrors) {
	errors = newErrors;
}
public void setState(int newState) {
	state = newState;
}
/**
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
}
