package com.hps.july.basestation.valueobject;

import java.math.BigDecimal;

public class ReportComlinesValue {
	private String filenumber;
	private String numberinfile;
	private Integer posaid;
	private String posaname;
	private Integer posbid;
	private String posbname;
	private String resmodel;
	private BigDecimal height_a;
	private BigDecimal height_b;
	private BigDecimal palat;
	private BigDecimal palong;
	private BigDecimal pblat;
	private BigDecimal pblong;
	private BigDecimal power;
	private String speed;
	private BigDecimal diam_a;
	private BigDecimal diam_b;
	private BigDecimal frequency_a;
	private BigDecimal frequency_b;
/**
 * HavePlanReportValue constructor comment.
 */
public ReportComlinesValue() {
	super();
}
public BigDecimal getAzimuthAB() {
	return com.hps.july.basestation.formbean.ComlineRForm.calcAzimut(palong,palat,pblong,pblat);
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getDiam_a() {
	return diam_a;
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getDiam_b() {
	return diam_b;
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
 * @return BigDecimal
 */
public BigDecimal getFrequency_a() {
	return frequency_a;
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getFrequency_b() {
	return frequency_b;
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getHeight_a() {
	return height_a;
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getHeight_b() {
	return height_b;
}
public BigDecimal getLengthAB() {
	return com.hps.july.basestation.formbean.ComlineRForm.calcLength(palong,palat,pblong,pblat);
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNumberinfile() {
	return numberinfile;
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getPalat() {
	return palat;
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getPalong() {
	return palong;
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getPblat() {
	return pblat;
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getPblong() {
	return pblong;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getPosaid() {
	return posaid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosaname() {
	return posaname;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getPosbid() {
	return posbid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosbname() {
	return posbname;
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getPower() {
	return power;
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
public java.lang.String getSpeed() {
	return speed;
}
/**
 * 
 * @param newDiam_a BigDecimal
 */
public void setDiam_a(BigDecimal newDiam_a) {
	diam_a = newDiam_a;
}
/**
 * 
 * @param newDiam_b BigDecimal
 */
public void setDiam_b(BigDecimal newDiam_b) {
	diam_b = newDiam_b;
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
 * @param newFrequency_a BigDecimal
 */
public void setFrequency_a(BigDecimal newFrequency_a) {
	frequency_a = newFrequency_a;
}
/**
 * 
 * @param newFrequency_b BigDecimal
 */
public void setFrequency_b(BigDecimal newFrequency_b) {
	frequency_b = newFrequency_b;
}
/**
 * 
 * @param newHeight_a BigDecimal
 */
public void setHeight_a(BigDecimal newHeight_a) {
	height_a = newHeight_a;
}
/**
 * 
 * @param newHeight_b BigDecimal
 */
public void setHeight_b(BigDecimal newHeight_b) {
	height_b = newHeight_b;
}
/**
 * 
 * @param newNumberinfile java.lang.String
 */
public void setNumberinfile(java.lang.String newNumberinfile) {
	numberinfile = newNumberinfile;
}
/**
 * 
 * @param newPalat BigDecimal
 */
public void setPalat(BigDecimal newPalat) {
	palat = newPalat;
}
/**
 * 
 * @param newPalong BigDecimal
 */
public void setPalong(BigDecimal newPalong) {
	palong = newPalong;
}
/**
 * 
 * @param newPblat BigDecimal
 */
public void setPblat(BigDecimal newPblat) {
	pblat = newPblat;
}
/**
 * 
 * @param newPblong BigDecimal
 */
public void setPblong(BigDecimal newPblong) {
	pblong = newPblong;
}
/**
 * 
 * @param newPosaid java.lang.Integer
 */
public void setPosaid(java.lang.Integer newPosaid) {
	posaid = newPosaid;
}
/**
 * 
 * @param newPosaname java.lang.String
 */
public void setPosaname(java.lang.String newPosaname) {
	posaname = newPosaname;
}
/**
 * 
 * @param newPosbid java.lang.Integer
 */
public void setPosbid(java.lang.Integer newPosbid) {
	posbid = newPosbid;
}
/**
 * 
 * @param newPosbname java.lang.String
 */
public void setPosbname(java.lang.String newPosbname) {
	posbname = newPosbname;
}
/**
 * 
 * @param newPower BigDecimal
 */
public void setPower(BigDecimal newPower) {
	power = newPower;
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
 * @param newSpeed java.lang.String
 */
public void setSpeed(java.lang.String newSpeed) {
	speed = newSpeed;
}
}
