package com.hps.july.persistence2;

/**
 * Объект-значение для хранения решений ГКРЧ.
 * Creation date: (21.06.2004 11:27:18)
 * @author: Dmitry Dneprov
 */
public class RRLDocValueObject implements java.io.Serializable {
	private int sitedoc;
	private java.lang.String blanknumber;
	private java.sql.Date blankdate;
	private java.sql.Date expiredate;
	private int organization;
/**
 * GKRCHDocValueObject constructor comment.
 */
public RRLDocValueObject() {
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
 * Creation date: (21.06.2004 11:29:22)
 * @return java.sql.Date
 */
public java.sql.Date getExpiredate() {
	return expiredate;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 17:45:03)
 * @return int
 */
public int getOrganization() {
	return organization;
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
 * Creation date: (21.06.2004 11:29:22)
 * @param newExpiredate java.sql.Date
 */
public void setExpiredate(java.sql.Date newExpiredate) {
	expiredate = newExpiredate;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2004 17:45:03)
 * @param newOrganization int
 */
public void setOrganization(int newOrganization) {
	organization = newOrganization;
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
