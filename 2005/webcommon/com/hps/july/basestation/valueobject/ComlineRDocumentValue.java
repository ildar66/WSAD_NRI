package com.hps.july.basestation.valueobject;

import com.hps.july.web.util.*;

/**
 * Служебный класс-контейнер с информацией о документе связанном с линией связи
 */
public class ComlineRDocumentValue {
	private int docid;
	private java.sql.Date regdate;
	private String number;
	private String doctype;
	private java.sql.Date expdate;
	private String comments;
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComments() {
	return comments;
}
/**
 * 
 * @return int
 */
public int getDocid() {
	return docid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDoctype() {
	return doctype;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getExpdate() {
	return expdate;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getRegdate() {
	return regdate;
}
/**
 * 
 * @param newComments java.lang.String
 */
public void setComments(java.lang.String newComments) {
	comments = newComments;
}
/**
 * 
 * @param newDocid int
 */
public void setDocid(int newDocid) {
	docid = newDocid;
}
/**
 * 
 * @param newDoctype java.lang.String
 */
public void setDoctype(java.lang.String newDoctype) {
	doctype = newDoctype;
}
/**
 * 
 * @param newExpdate java.sql.Date
 */
public void setExpdate(java.sql.Date newExpdate) {
	expdate = newExpdate;
}
/**
 * 
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * 
 * @param newRegdate java.sql.Date
 */
public void setRegdate(java.sql.Date newRegdate) {
	regdate = newRegdate;
}
}
