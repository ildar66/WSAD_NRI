package com.hps.july.persistence2;

/**
 * Служебный класс для ррл антенны. Используется при работе с
 * ejb бинами.
 * @author: Dmitry Dneprov
 */
public class RRLAntenaValue implements java.io.Serializable{
	private int resource;
	private String mkkrrecomm;
	private java.lang.String protocolnum;
	private java.sql.Date protocoldate;
	private java.math.BigDecimal freqdevlowk;
	private int freqdevlowlog10;
	private java.lang.String name;
	private java.lang.String model;
	private java.lang.String notes;
	private java.lang.Boolean complect;
	private java.lang.String countpolicy;
	private java.lang.Boolean boxable;
	private java.lang.Boolean priceable;
	private java.lang.Boolean complectpart;
	private java.lang.Boolean active;
	private int subType;
	private java.math.BigDecimal freqdevhighk;
	private int freqdevhighlog10;
/**
 * RRLAntenaValue constructor comment.
 */
public RRLAntenaValue() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:08:23)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getActive() {
	return active;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:04:21)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getBoxable() {
	return boxable;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:03:12)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getComplect() {
	return complect;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:07:08)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getComplectpart() {
	return complectpart;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:03:38)
 * @return java.lang.String
 */
public java.lang.String getCountpolicy() {
	return countpolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:09:39)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getFreqdevhighk() {
	return freqdevhighk;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:10:16)
 * @return java.math.BigDecimal
 */
public int getFreqdevhighlog10() {
	return freqdevhighlog10;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:34:09)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getFreqdevlowk() {
	return freqdevlowk;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:34:39)
 * @return int
 */
public int getFreqdevlowlog10() {
	return freqdevlowlog10;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:30:02)
 * @return int
 */
public String getMkkrrecomm() {
	return mkkrrecomm;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:00:51)
 * @return java.lang.String
 */
public java.lang.String getModel() {
	return model;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:59:48)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:02:23)
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:05:27)
 * @return java.lang.String
 */
public java.lang.Boolean getPriceable() {
	return priceable;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:31:21)
 * @return int
 */
public java.sql.Date getProtocoldate() {
	return protocoldate;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:30:58)
 * @return java.lang.String
 */
public java.lang.String getProtocolnum() {
	return protocolnum;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:28:59)
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:08:41)
 * @return int
 */
public int getSubType() {
	return subType;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:08:23)
 * @param newActive java.lang.Boolean
 */
public void setActive(java.lang.Boolean newActive) {
	active = newActive;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:04:21)
 * @param newBoxable java.lang.Boolean
 */
public void setBoxable(java.lang.Boolean newBoxable) {
	boxable = newBoxable;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:03:12)
 * @param newComplect java.lang.Boolean
 */
public void setComplect(java.lang.Boolean newComplect) {
	complect = newComplect;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:07:08)
 * @param newArgComplectpart java.lang.Boolean
 */
public void setComplectpart(java.lang.Boolean newComplectpart) {
	complectpart = newComplectpart;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:03:38)
 * @param newCountpolicy java.lang.String
 */
public void setCountpolicy(java.lang.String newCountpolicy) {
	countpolicy = newCountpolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:09:39)
 * @param newFreqdevhighk java.math.BigDecimal
 */
public void setFreqdevhighk(java.math.BigDecimal newFreqdevhighk) {
	freqdevhighk = newFreqdevhighk;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:10:16)
 * @param newFreqdevhighlog10 java.math.BigDecimal
 */
public void setFreqdevhighlog10(int newFreqdevhighlog10) {
	freqdevhighlog10 = newFreqdevhighlog10;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:34:09)
 * @param newFreqdevlowk java.math.BigDecimal
 */
public void setFreqdevlowk(java.math.BigDecimal newFreqdevlowk) {
	freqdevlowk = newFreqdevlowk;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:34:39)
 * @param newFreqdevlowlog10 int
 */
public void setFreqdevlowlog10(int newFreqdevlowlog10) {
	freqdevlowlog10 = newFreqdevlowlog10;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:30:02)
 * @param newMkkrrecomm int
 */
public void setMkkrrecomm(String newMkkrrecomm) {
	mkkrrecomm = newMkkrrecomm;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:00:51)
 * @param newModel java.lang.String
 */
public void setModel(java.lang.String newModel) {
	model = newModel;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:59:48)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:02:23)
 * @param newNotes java.lang.String
 */
public void setNotes(java.lang.String newNotes) {
	notes = newNotes;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:05:27)
 * @param newPriceable java.lang.String
 */
public void setPriceable(java.lang.Boolean newPriceable) {
	priceable = newPriceable;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:31:21)
 * @param newProtocoldate int
 */
public void setProtocoldate(java.sql.Date newProtocoldate) {
	protocoldate = newProtocoldate;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:30:58)
 * @param newProtocolnum java.lang.String
 */
public void setProtocolnum(java.lang.String newProtocolnum) {
	protocolnum = newProtocolnum;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 12:28:59)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2004 13:08:41)
 * @param newSubType int
 */
public void setSubType(int newSubType) {
	subType = newSubType;
}
}
