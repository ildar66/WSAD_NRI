package com.hps.july.persistence2;

/**
 * Объект-значение для хранения решений ГКРЧ.
 * Creation date: (21.06.2004 11:27:18)
 * @author: Dmitry Dneprov
 */
public class GKRCHDocValueObject implements java.io.Serializable {
	private int sitedoc;
	private java.lang.String blanknumber;
	private java.sql.Date blankdate;
	private java.sql.Date expiredate;
	private java.lang.String comment;
//	private java.lang.String freqrange;
	private java.lang.String restrictions;
/**
 * GKRCHDocValueObject constructor comment.
 */
public GKRCHDocValueObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:29:01)
 * @return java.sql.Date
 */
public java.sql.Date getBlankdate() {
	return blankdate;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:28:37)
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:31:31)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:29:22)
 * @return java.sql.Date
 */
public java.sql.Date getExpiredate() {
	return expiredate;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:32:29)
 * @return java.lang.String
 */
public java.lang.String getRestrictions() {
	return restrictions;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:28:12)
 * @return int
 */
public int getSitedoc() {
	return sitedoc;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:29:01)
 * @param newBlankdate java.sql.Date
 */
public void setBlankdate(java.sql.Date newBlankdate) {
	blankdate = newBlankdate;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:28:37)
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:31:31)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:29:22)
 * @param newExpiredate java.sql.Date
 */
public void setExpiredate(java.sql.Date newExpiredate) {
	expiredate = newExpiredate;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:32:29)
 * @param newRestrictions java.lang.String
 */
public void setRestrictions(java.lang.String newRestrictions) {
	restrictions = newRestrictions;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 11:28:12)
 * @param newSitedoc int
 */
public void setSitedoc(int newSitedoc) {
	sitedoc = newSitedoc;
}
}
