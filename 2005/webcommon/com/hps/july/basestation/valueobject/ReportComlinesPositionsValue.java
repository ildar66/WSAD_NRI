package com.hps.july.basestation.valueobject;

import java.math.BigDecimal;

public class ReportComlinesPositionsValue {
	private String filenumber;
	private String numberinfile;
	private Integer paid;
	private String paname;
	private String paadress;
	private BigDecimal palat;
	private BigDecimal palong;
	private String paorderno;
	private String pahaveplan;
	
	private Integer pbid;
	private String pbname;
	private String pbadress;
	private BigDecimal pblat;
	private BigDecimal pblong;
	private String pborderno;
	private String pbhaveplan;
/**
 * HavePlanReportValue constructor comment.
 */
public ReportComlinesPositionsValue() {
	super();
}
public BigDecimal getAzimuthAB() {
	return com.hps.july.basestation.formbean.ComlineRForm.calcAzimut(palong,palat,pblong,pblat);
}
public static String getDegrees(BigDecimal src)
{
	String result = "";
	if(src != null) {
		int deg = (int)src.doubleValue();
		int min = (int)((src.doubleValue() - deg) * 60.0d);
		double sec = (src.doubleValue() - deg - (double)min / 60) * 3600.0d;
		result = String.valueOf(deg);
		result += "°";
		result += String.valueOf(min);
		result += "'";
		result += String.valueOf((new BigDecimal(sec)).setScale(1,BigDecimal.ROUND_HALF_UP));
		result += "\"";
	}
	return result;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFilenumber() {
	return filenumber;
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
 * @return java.lang.String
 */
public java.lang.String getPaadress() {
	return paadress;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPahaveplan() {
	return pahaveplan;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getPaid() {
	return paid;
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getPalat() {
	return palat;
}
public String getPalatFrm() {
	return getDegrees(palat);
}
/**
 * 
 * @return BigDecimal
 */
public BigDecimal getPalong() {
	return palong;
}
public String getPalongFrm() {
	return getDegrees(palong);
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPaname() {
	return paname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPaorderno() {
	return paorderno;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPbadress() {
	return pbadress;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPbhaveplan() {
	return pbhaveplan;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getPbid() {
	return pbid;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPblat() {
	return pblat;
}
public String getPblatFrm() {
	return getDegrees(pblat);
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPblong() {
	return pblong;
}
public String getPblongFrm() {
	return getDegrees(pblong);
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPbname() {
	return pbname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPborderno() {
	return pborderno;
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
 * @param newNumberinfile java.lang.String
 */
public void setNumberinfile(java.lang.String newNumberinfile) {
	numberinfile = newNumberinfile;
}
/**
 * 
 * @param newPaadress java.lang.String
 */
public void setPaadress(java.lang.String newPaadress) {
	paadress = newPaadress;
}
/**
 * 
 * @param newPahaveplan java.lang.String
 */
public void setPahaveplan(java.lang.String newPahaveplan) {
	pahaveplan = newPahaveplan;
}
/**
 * 
 * @param newPaid java.lang.Integer
 */
public void setPaid(java.lang.Integer newPaid) {
	paid = newPaid;
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
 * @param newPaname java.lang.String
 */
public void setPaname(java.lang.String newPaname) {
	paname = newPaname;
}
/**
 * 
 * @param newPaorderno java.lang.String
 */
public void setPaorderno(java.lang.String newPaorderno) {
	paorderno = newPaorderno;
}
/**
 * 
 * @param newPbadress java.lang.String
 */
public void setPbadress(java.lang.String newPbadress) {
	pbadress = newPbadress;
}
/**
 * 
 * @param newPbhaveplan java.lang.String
 */
public void setPbhaveplan(java.lang.String newPbhaveplan) {
	pbhaveplan = newPbhaveplan;
}
/**
 * 
 * @param newPbid java.lang.Integer
 */
public void setPbid(java.lang.Integer newPbid) {
	pbid = newPbid;
}
/**
 * 
 * @param newPblat java.math.BigDecimal
 */
public void setPblat(java.math.BigDecimal newPblat) {
	pblat = newPblat;
}
/**
 * 
 * @param newPblong java.math.BigDecimal
 */
public void setPblong(java.math.BigDecimal newPblong) {
	pblong = newPblong;
}
/**
 * 
 * @param newPbname java.lang.String
 */
public void setPbname(java.lang.String newPbname) {
	pbname = newPbname;
}
/**
 * 
 * @param newPborderno java.lang.String
 */
public void setPborderno(java.lang.String newPborderno) {
	pborderno = newPborderno;
}
}
