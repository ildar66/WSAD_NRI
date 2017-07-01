package com.hps.july.persistence2;

/**
 * Объект-значение для хранения этапов прохождения заявки на частотное разрешение.
 * Creation date: (21.06.2004 11:27:18)
 * @author: Dmitry Dneprov
 */
public class EtapDocValueObject implements java.io.Serializable {
	private int sitedoc;
	private java.lang.String blanknumber;
	private java.sql.Date blankdate;
	private java.sql.Date expiredate;
	private java.lang.String comment;
	private int etaptypeid;
	private int freqpermid;
	private String equiplink;
	private Boolean havepay;
/**
 * GKRCHDocValueObject constructor comment.
 */
public EtapDocValueObject() {
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
 * Creation date: (28.06.2004 17:12:16)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEquiplink() {
	return equiplink;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2004 17:12:46)
 * @return int
 */
public int getEtaptypeid() {
	return etaptypeid;
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
 * Creation date: (28.06.2004 17:13:03)
 * @return int
 */
public int getFreqpermid() {
	return freqpermid;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getHavepay() {
	return havepay;
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
 * Creation date: (28.06.2004 17:12:16)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * 
 * @param newEquiplink java.lang.String
 */
public void setEquiplink(java.lang.String newEquiplink) {
	equiplink = newEquiplink;
}
/**
 * Insert the method's description here.
 * Creation date: (28.06.2004 17:12:46)
 * @param newEtaptypeid int
 */
public void setEtaptypeid(int newEtaptypeid) {
	etaptypeid = newEtaptypeid;
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
 * Creation date: (28.06.2004 17:13:03)
 * @param newFreqpermid int
 */
public void setFreqpermid(int newFreqpermid) {
	freqpermid = newFreqpermid;
}
/**
 * 
 * @param newHavepay java.lang.Boolean
 */
public void setHavepay(java.lang.Boolean newHavepay) {
	havepay = newHavepay;
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
