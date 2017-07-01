package com.hps.july.basestation.valueobject;

public class ReportFreqHistoryValue {
	private String docname;
	private String blanknumber;
	private java.sql.Date docdate;
	private java.sql.Date expiredate;
	private String comment;
/**
 * HavePlanReportValue constructor comment.
 */
public ReportFreqHistoryValue() {
	super();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getDocdate() {
	return docdate;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDocname() {
	return docname;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getExpiredate() {
	return expiredate;
}
/**
 * 
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
/**
 * 
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * 
 * @param newDocdate java.sql.Date
 */
public void setDocdate(java.sql.Date newDocdate) {
	docdate = newDocdate;
}
/**
 * 
 * @param newDocname java.lang.String
 */
public void setDocname(java.lang.String newDocname) {
	docname = newDocname;
}
/**
 * 
 * @param newExpiredate java.sql.Date
 */
public void setExpiredate(java.sql.Date newExpiredate) {
	expiredate = newExpiredate;
}
}
