package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import java.math.BigDecimal;

public class PosVO {
	private Integer type;
	private StringAndIntegerProperty count = new StringAndIntegerProperty();
	private String sector;
	private String ksb;
	private java.lang.Integer id;
	private java.lang.Integer complect;
	private java.lang.String complectname;
	private java.lang.Integer categ;
	private java.lang.String gsm;
	private java.lang.String sn;
	private java.lang.String note;
	private java.lang.String roomnumber;
	private int position;
	private java.util.ArrayList calcerrors = new java.util.ArrayList();
	private java.lang.String unknownTypeError;
	private java.lang.String categname;
	private java.lang.String typename;
	private int resourcecateg;
	private java.lang.Boolean fictionSerial;
	private java.lang.Integer storagecard;
	private java.lang.String place;
	private java.lang.String manucode;
	private java.lang.Boolean loaded;
	private Double qty;
	private java.lang.String comment;
	private java.lang.String policy;
/**
 * Insert the method's description here.
 * Creation date: (02.09.2005 15:24:47)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getCalcerrors() {
	return calcerrors;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 11:55:44)
 * @return java.lang.Integer
 */
public java.lang.Integer getCateg() {
	return categ;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2005 15:51:31)
 * @return java.lang.String
 */
public java.lang.String getCategname() {
	return categname;
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2005 18:53:28)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 16:44:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplect() {
	return complect;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 17:39:41)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getCount() {
	return count;
}
/**
 * Insert the method's description here.
 * Creation date: (14.09.2005 14:48:20)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getFictionSerial() {
	return fictionSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 16:24:36)
 * @return java.lang.String
 */
public java.lang.String getGsm() {
	return gsm;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 13:36:00)
 * @return java.lang.Integer
 */
public java.lang.Integer getId() {
	return id;
}
/**
 * 
 * @return java.lang.String
 */
public String getKsb() {
	return ksb;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 14:26:21)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getLoaded() {
	return loaded;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 14:00:32)
 * @return java.lang.String
 */
public java.lang.String getManucode() {
	return manucode;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2005 18:30:23)
 * @return java.lang.String
 */
public java.lang.String getNote() {
	return note;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 13:50:49)
 * @return java.lang.String
 */
public java.lang.String getPlace() {
	return place;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2005 15:44:30)
 * @return java.lang.String
 */
public java.lang.String getPolicy() {
	return policy;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2005 15:21:18)
 * @return int
 */
public int getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 18:15:49)
 * @return java.lang.Integer
 */
public Double getQty() {
	return qty;
}
/**
 * Insert the method's description here.
 * Creation date: (07.09.2005 14:38:45)
 * @return int
 */
public int getResourcecateg() {
	return resourcecateg;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2005 18:30:54)
 * @return java.lang.String
 */
public java.lang.String getRoomnumber() {
	return roomnumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSector() {
	return sector;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2005 18:30:03)
 * @return java.lang.String
 */
public java.lang.String getSn() {
	return sn;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 13:47:01)
 * @return java.lang.Integer
 */
public java.lang.Integer getStoragecard() {
	return storagecard;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2005 15:51:51)
 * @return java.lang.String
 */
public java.lang.String getTypename() {
	return typename;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2005 14:07:25)
 * @return java.lang.String
 */
public java.lang.String getUnknownTypeError() {
	return unknownTypeError;
}
/**
 * Insert the method's description here.
 * Creation date: (15.09.2005 17:05:12)
 * @return boolean
 */
public boolean isSnError(String sn) {
	if(sn!=null && (sn.indexOf(",")!=-1 || sn.indexOf(";")!=-1)){
		return true;
	}else return false;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 11:55:44)
 * @param newCateg java.lang.Integer
 */
public void setCateg(java.lang.Integer newCateg) {
	categ = newCateg;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2005 15:51:31)
 * @param newCategname java.lang.String
 */
public void setCategname(java.lang.String newCategname) {
	categname = newCategname;
}
/**
 * Insert the method's description here.
 * Creation date: (28.09.2005 18:53:28)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 16:44:55)
 * @param newComplect java.lang.Integer
 */
public void setComplect(java.lang.Integer newComplect) {
	complect = newComplect;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 17:39:41)
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.08.2005 11:56:23)
 */
public void setCount(String newcount) {
	count.setString(newcount);
			
}
/**
 * Insert the method's description here.
 * Creation date: (14.09.2005 14:48:20)
 * @param newFictionSerial java.lang.Boolean
 */
public void setFictionSerial(java.lang.Boolean newFictionSerial) {
	fictionSerial = newFictionSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 16:24:36)
 * @param newGsm java.lang.String
 */
public void setGsm(java.lang.String newGsm) {
	gsm = newGsm;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 13:36:00)
 * @param newId java.lang.Integer
 */
public void setId(java.lang.Integer newId) {
	id = newId;
}
/**
 * 
 * @param newNote java.lang.String
 */
public void setKsb(String newKsb) {
	ksb = newKsb;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 14:26:21)
 * @param newLoaded java.lang.Boolean
 */
public void setLoaded(java.lang.Boolean newLoaded) {
	loaded = newLoaded;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 14:00:32)
 * @param newManucode java.lang.String
 */
public void setManucode(java.lang.String newManucode) {
	manucode = newManucode;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2005 18:30:23)
 * @param newNote java.lang.String
 */
public void setNote(java.lang.String newNote) {
	note = newNote;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 13:50:49)
 * @param newPlace java.lang.String
 */
public void setPlace(java.lang.String newPlace) {
	place = newPlace;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2005 15:44:30)
 * @param newPolicy java.lang.String
 */
public void setPolicy(java.lang.String newPolicy) {
	policy = newPolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2005 15:21:18)
 * @param newPosition int
 */
public void setPosition(int newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 18:15:49)
 * @param newQty java.lang.Integer
 */
public void setQty(Double newQty) {
	qty = newQty;
}
/**
 * Insert the method's description here.
 * Creation date: (07.09.2005 14:38:45)
 * @param newResourcecateg int
 */
public void setResourcecateg(int newResourcecateg) {
	resourcecateg = newResourcecateg;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2005 18:30:54)
 * @param newRoomnumber java.lang.String
 */
public void setRoomnumber(java.lang.String newRoomnumber) {
	roomnumber = newRoomnumber;
}
/**
 * 
 * @param newSn java.lang.String
 */
public void setSector(String newSector) {
	sector = newSector;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2005 18:30:03)
 * @param newSn java.lang.String
 */
public void setSn(java.lang.String newSn) {
	sn = newSn;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 13:47:01)
 * @param newStoragecard java.lang.Integer
 */
public void setStoragecard(java.lang.Integer newStoragecard) {
	storagecard = newStoragecard;
}
/**
 * 
 * @param newType java.lang.Integer
 */
public void setType(java.lang.Integer newType) {
	type = newType;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2005 15:51:51)
 * @param newTypename java.lang.String
 */
public void setTypename(java.lang.String newTypename) {
	typename = newTypename;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2005 14:07:25)
 * @param newUnknownTypeError java.lang.String
 */
public void setUnknownTypeError(java.lang.String newUnknownTypeError) {
	unknownTypeError = newUnknownTypeError;
}
}
