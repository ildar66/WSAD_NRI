package com.hps.july.basestation.valueobject;

import java.math.BigDecimal;

public class ReportProtocolPosition {
	private String filenumber;
	private Integer gsmid;
	private String posname;
	private String vendorid;
	private String address;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private String goslongitude;
	private String goslatitude;
	private String resmodel;
	private String frequency;
	private Double height;
	private String emclass;
	private Double powerwt;
	private String fasnum;
	private java.sql.Date fasdate;
	private java.sql.Date fasexpire;
	private String grchaddress;
	private String comment;
	private String hopsstate;
public ReportProtocolPosition() {
	super();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
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
 * @return java.lang.String
 */
public java.lang.String getEmclass() {
	return emclass;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getFasdate() {
	return fasdate;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getFasexpire() {
	return fasexpire;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFasnum() {
	return fasnum;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFilenumber() {
	return filenumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFrequency() {
	return frequency;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getGoslatitude() {
	return goslatitude;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getGoslongitude() {
	return goslongitude;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getGrchaddress() {
	return grchaddress;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getGsmid() {
	return gsmid;
}
public Double getHeight() {
	return height;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHopsstate() {
	return hopsstate;
}
public String getLat() {
	if(latitude == null || latitude.doubleValue() == 0) {
		return "0°";
	} else {
		double d = latitude.doubleValue();
		int grad = (int)Math.floor(d);
		d = (d - grad) * 60.0;
		int min = (int)Math.floor(d);
		d = (d - min) * 600.0;
		double sec = Math.round(d)/10.0;
		return (String.valueOf(grad)+"°"+String.valueOf(min)+"'"+String.valueOf(sec)+"\"");
	}
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getLatitude() {
	return latitude;
}
public String getLong() {
	if(longitude == null || longitude.doubleValue() == 0) {
		return "0°";
	} else {
		double d = longitude.doubleValue();
		int grad = (int)Math.floor(d);
		d = (d - grad) * 60.0;
		int min = (int)Math.floor(d);
		d = (d - min) * 600.0;
		double sec = Math.round(d)/10.0;
		return (String.valueOf(grad)+"°"+String.valueOf(min)+"'"+String.valueOf(sec)+"''");
	}
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getLongitude() {
	return longitude;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
public java.math.BigDecimal getPower() {
	if(powerwt == null) {
		return null;
	} else {
		double d = powerwt.doubleValue();
		BigDecimal bd = new BigDecimal(Math.pow(10.0d,(d-30.0)/10.0));
		return bd.setScale(2,BigDecimal.ROUND_HALF_EVEN);
	}
}
public Double getPowerwt() {
	return powerwt;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResmodel() {
	return resmodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getVendorid() {
	return vendorid;
}
/**
 * 
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
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
 * @param newEmclass java.lang.String
 */
public void setEmclass(java.lang.String newEmclass) {
	emclass = newEmclass;
}
/**
 * 
 * @param newFasdate java.sql.Date
 */
public void setFasdate(java.sql.Date newFasdate) {
	fasdate = newFasdate;
}
/**
 * 
 * @param newFasexpire java.sql.Date
 */
public void setFasexpire(java.sql.Date newFasexpire) {
	fasexpire = newFasexpire;
}
/**
 * 
 * @param newFasnum java.lang.String
 */
public void setFasnum(java.lang.String newFasnum) {
	fasnum = newFasnum;
}
/**
 * 
 * @param newFilenumber java.lang.String
 */
public void setFilenumber(java.lang.String newFilenumber) {
	filenumber = newFilenumber;
}
/**
 * 
 * @param newFrequency java.lang.String
 */
public void setFrequency(java.lang.String newFrequency) {
	frequency = newFrequency;
}
/**
 * 
 * @param newGoslatitude java.lang.String
 */
public void setGoslatitude(java.lang.String newGoslatitude) {
	goslatitude = newGoslatitude;
}
/**
 * 
 * @param newGoslongitude java.lang.String
 */
public void setGoslongitude(java.lang.String newGoslongitude) {
	goslongitude = newGoslongitude;
}
/**
 * 
 * @param newGrchaddress java.lang.String
 */
public void setGrchaddress(java.lang.String newGrchaddress) {
	grchaddress = newGrchaddress;
}
/**
 * 
 * @param newGsmid java.lang.Integer
 */
public void setGsmid(java.lang.Integer newGsmid) {
	gsmid = newGsmid;
}
public void setHeight(Double newHeight) {
	height = newHeight;
}
/**
 * 
 * @param newHopsstate java.lang.String
 */
public void setHopsstate(java.lang.String newHopsstate) {
	hopsstate = newHopsstate;
}
/**
 * 
 * @param newLatitude java.math.BigDecimal
 */
public void setLatitude(java.math.BigDecimal newLatitude) {
	latitude = newLatitude;
}
/**
 * 
 * @param newLongitude java.math.BigDecimal
 */
public void setLongitude(java.math.BigDecimal newLongitude) {
	longitude = newLongitude;
}
/**
 * 
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
public void setPower(Double newPowerwt) {
	powerwt = newPowerwt;
}
/**
 * 
 * @param newResmodel java.lang.String
 */
public void setResmodel(java.lang.String newResmodel) {
	resmodel = newResmodel;
}
/**
 * 
 * @param newVendorid java.lang.String
 */
public void setVendorid(java.lang.String newVendorid) {
	vendorid = newVendorid;
}
}
