package com.hps.july.basestation.valueobject;

/**
 * Регионы VO.
 * Creation date: (18.08.2005 11:43:08)
 * @author: Shafigullin Ildar
 */
public class KzlRegion_VO {
	private java.lang.Integer regionid;//KEY
	private java.lang.String regionname;
	private java.lang.String regioncomment;
	private java.lang.Integer regiontype;
	private java.lang.Integer regionpopulation;
	private java.lang.Integer ruralpopulation;
	private java.math.BigDecimal regionarea;
	private java.lang.Integer regionnri;
/**
 * KzlRegions_VO constructor comment.
 */
public KzlRegion_VO(Integer regionID) {
    super();
    regionid = regionID;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:59)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRegionarea() {
	return regionarea;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:34)
 * @return java.lang.String
 */
public java.lang.String getRegioncomment() {
	return regioncomment;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:01)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegionid() {
	return regionid;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:18)
 * @return java.lang.String
 */
public java.lang.String getRegionname() {
	return regionname;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:46:47)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegionnri() {
	return regionnri;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:11)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegionpopulation() {
	return regionpopulation;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:54)
 * @return java.lang.Integer
 */
public java.lang.Integer getRegiontype() {
	return regiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getRuralpopulation() {
	return ruralpopulation;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:59)
 * @param newRegionarea java.math.BigDecimal
 */
public void setRegionarea(java.math.BigDecimal newRegionarea) {
	regionarea = newRegionarea;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:34)
 * @param newRegioncomment java.lang.String
 */
public void setRegioncomment(java.lang.String newRegioncomment) {
	regioncomment = newRegioncomment;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:01)
 * @param newRegionid java.lang.Integer
 */
public void setRegionid(java.lang.Integer newRegionid) {
	regionid = newRegionid;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:18)
 * @param newRegionname java.lang.String
 */
public void setRegionname(java.lang.String newRegionname) {
	regionname = newRegionname;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:46:47)
 * @param newRegionnri java.lang.Integer
 */
public void setRegionnri(java.lang.Integer newRegionnri) {
	regionnri = newRegionnri;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:11)
 * @param newRegionpopulation java.lang.Integer
 */
public void setRegionpopulation(java.lang.Integer newRegionpopulation) {
	regionpopulation = newRegionpopulation;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:44:54)
 * @param newRegiontype java.lang.Integer
 */
public void setRegiontype(java.lang.Integer newRegiontype) {
	regiontype = newRegiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2005 11:45:36)
 * @param newRuralpopulation java.lang.Integer
 */
public void setRuralpopulation(java.lang.Integer newRuralpopulation) {
	ruralpopulation = newRuralpopulation;
}
}
