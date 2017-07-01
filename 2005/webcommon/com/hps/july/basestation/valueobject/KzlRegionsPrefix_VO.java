package com.hps.july.basestation.valueobject;

/**
 * Справочная таблица для префиксов регионов VO.
 * Creation date: (18.08.2005 11:27:38)
 * @author: Shafigullin Ildar
 */
public class KzlRegionsPrefix_VO {
	private java.lang.Integer regionid;//key
	private java.lang.Integer cellid_prefix;//key
	private java.lang.Integer cellname_prefix;//
	private java.lang.Integer group_prefix;//
	private java.lang.Integer super_prefix;//
/**
 * KzlRegionsPrefix_VO constructor comment.
 */
public KzlRegionsPrefix_VO(Integer regionID) {
	super();
	regionid=regionID;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:28:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getCellid_prefix() {
	return cellid_prefix;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:28:58)
 * @return java.lang.Integer
 */
public java.lang.Integer getCellname_prefix() {
	return cellname_prefix;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:31:46)
 * @return java.lang.Integer
 */
public java.lang.Integer getGroup_prefix() {
	return group_prefix;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:28:05)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegionid() {
	return regionid;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:32:49)
 * @return java.lang.Integer
 */
public java.lang.Integer getSuper_prefix() {
	return super_prefix;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:28:36)
 * @param newCellid_prefix java.lang.Integer
 */
public void setCellid_prefix(java.lang.Integer newCellid_prefix) {
	cellid_prefix = newCellid_prefix;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:28:58)
 * @param newCellname_prefix java.lang.Integer
 */
public void setCellname_prefix(java.lang.Integer newCellname_prefix) {
	cellname_prefix = newCellname_prefix;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:31:46)
 * @param newGroup_prefix java.lang.Integer
 */
public void setGroup_prefix(java.lang.Integer newGroup_prefix) {
	group_prefix = newGroup_prefix;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:28:05)
 * @param newRegionid java.lang.Integer
 */
public void setRegionid(java.lang.Integer newRegionid) {
	regionid = newRegionid;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:32:49)
 * @param newSuper_prefix java.lang.Integer
 */
public void setSuper_prefix(java.lang.Integer newSuper_prefix) {
	super_prefix = newSuper_prefix;
}
}
