package com.hps.july.arenda.valueobject;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.math.BigDecimal;

/**
 * Контейнер для данных строки в списке "Платежей по ответственному"
 */
public class RespPaysValueObject
{
/*
	private int				operator; // Integer operator
	private String			operatorname; // Varchar Фамилия оператора
*/
	private Integer			bs; // Integer
	private String			bsname; // Varchar(255)
	private Integer			countbs; // Integer (Признак наличия нескольких БС по договору
	private Integer			arendodatel; // Integer (Арендодатель)
	private String			arendodatelname; // Varchar(255) (Краткое наименование арендодателя)
	private Integer			beeline; // Integer (Организация Beeline)
	private String			beelinename; // Varchar(255) (Наименование организации)
	private String			arendodatelinn; // Varchar(40) (ИНН Арендодателя)
	private int				basecontract; // Код базового договора
	private String			vendor; // Varchar(40) Vendor-код договора
	private String			number; // Varchar(40) Код договора
	private java.sql.Date	date; // Date Дата договора
	private Integer			service; // Integer Код услуги
	private String			servicename; // varchar(255) Наименование услуги
	private String			pptype; // Char(1) Тип оплаты ('A' - Аванс, 'B' - По счёту, 'C' - По окончании периода)
	private BigDecimal		sum; // Decimal(15,2)
	private Integer			currency; // Integer код валюты
	private String			currencyname; // Varchar(40) Наименование валюты
	private String			periodpay; // Char(1) Период оплаты ('M' - Месяц, 'Q' - квартал, 'Y' - год)
	private String			paydate; // Varchar(255) Срок опл.
	private String			raterule; // Varchar(255) Курс (Правило определения оплаты)
	private String			condition; // Varchar(255) Доп. условия оплаты
	private PayValueObject	lastpay; // Integer Код последнего платёжного поручения
	private boolean			payreq; // Char(1) Требование оплаты ('Y' - Да , 'N' - Нет)
public RespPaysValueObject() {
	super();
}
public RespPaysValueObject(ResultSet rs) {
	super();
	// fill data from resultset
	try {
		arendodatel = getInteger(rs,"arendodatel");
		arendodatelname = rs.getString("arendodatelname");
		arendodatelinn = rs.getString("arendodatelinn");
		basecontract = rs.getInt("basecontract");
		beeline = getInteger(rs,"beeline");
		beelinename = rs.getString("beelinename");
		bs = getInteger(rs,"bs");
		bsname = rs.getString("bsname");
		condition = rs.getString("termspay");
		countbs = getInteger(rs,"countbs");
		currency = getInteger(rs,"currency");
		currencyname = rs.getString("currencyname");
		date = rs.getDate("date");
//		lastpay = getInteger(rs,"idlastpay");
		lastpay = new PayValueObject(rs);
		number = rs.getString("number");
		paydate = rs.getString("ruledatepay");
		payreq = getBoolean(rs,"flagneedpay");
		periodpay = rs.getString("periodpay");
		pptype = rs.getString("pptype");
		raterule = rs.getString("ruleratepay");
		service = getInteger(rs,"service");
		servicename = rs.getString("servicename");
		sum = rs.getBigDecimal("sumpay");
		vendor = rs.getString("vendor");
	} catch(SQLException e) {
System.out.println("RESPPAYS FILL EXCEPTION");
		e.printStackTrace(System.out);
	}
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getArendodatel() {
	return arendodatel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getArendodatelinn() {
	return arendodatelinn;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getArendodatelname() {
	return arendodatelname;
}
/**
 * 
 * @return int
 */
public int getBasecontract() {
	return basecontract;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getBeeline() {
	return beeline;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBeelinename() {
	return beelinename;
}
protected boolean getBoolean(ResultSet rs, String fieldName) {
	if(fieldName == null) {
		return false;
	}
	try {
		String r = rs.getString(fieldName);
		if(r != null && "Y".equals(r.trim())) {
			return true;
		} else {
			return false;
		}
	} catch(SQLException se) {
		System.out.println("GETBOOL SQL EXCEPTION on field '"+fieldName+"'");
		return false;
	}
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getBs() {
	return bs;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBsname() {
	return bsname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCondition() {
	return condition;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getCountbs() {
	return countbs;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getCurrency() {
	return currency;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCurrencyname() {
	return currencyname;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date;
}
protected Integer getInteger(ResultSet rs, String fieldName) {
	if(fieldName == null) {
		return null;
	}
	try {
		int r = rs.getInt(fieldName);
		if(rs.wasNull()) {
			return null;
		} else {
			return new Integer(r);
		}
	} catch(SQLException se) {
		System.out.println("GETINT SQL EXCEPTION on field '"+fieldName+"'");
		return null;
	}
}
public PayValueObject getLastpay() {
	return lastpay;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPaydate() {
	return paydate;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPeriodpay() {
	return periodpay;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPptype() {
	return pptype;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRaterule() {
	return raterule;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getService() {
	return service;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getServicename() {
	return servicename;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSum() {
	return sum;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getVendor() {
	return vendor;
}
/**
 * 
 * @return boolean
 */
public boolean isPayreq() {
	return payreq;
}
/**
 * 
 * @param newArendodatel java.lang.Integer
 */
public void setArendodatel(java.lang.Integer newArendodatel) {
	arendodatel = newArendodatel;
}
/**
 * 
 * @param newArendodatelinn java.lang.String
 */
public void setArendodatelinn(java.lang.String newArendodatelinn) {
	arendodatelinn = newArendodatelinn;
}
/**
 * 
 * @param newArendodatelname java.lang.String
 */
public void setArendodatelname(java.lang.String newArendodatelname) {
	arendodatelname = newArendodatelname;
}
/**
 * 
 * @param newBasecontract int
 */
public void setBasecontract(int newBasecontract) {
	basecontract = newBasecontract;
}
/**
 * 
 * @param newBeeline java.lang.Integer
 */
public void setBeeline(java.lang.Integer newBeeline) {
	beeline = newBeeline;
}
/**
 * 
 * @param newBeelinename java.lang.String
 */
public void setBeelinename(java.lang.String newBeelinename) {
	beelinename = newBeelinename;
}
/**
 * 
 * @param newBs java.lang.Integer
 */
public void setBs(java.lang.Integer newBs) {
	bs = newBs;
}
/**
 * 
 * @param newBsname java.lang.String
 */
public void setBsname(java.lang.String newBsname) {
	bsname = newBsname;
}
/**
 * 
 * @param newCondition java.lang.String
 */
public void setCondition(java.lang.String newCondition) {
	condition = newCondition;
}
/**
 * 
 * @param newCountbs java.lang.Integer
 */
public void setCountbs(java.lang.Integer newCountbs) {
	countbs = newCountbs;
}
/**
 * 
 * @param newCurrency java.lang.Integer
 */
public void setCurrency(java.lang.Integer newCurrency) {
	currency = newCurrency;
}
/**
 * 
 * @param newCurrencyname java.lang.String
 */
public void setCurrencyname(java.lang.String newCurrencyname) {
	currencyname = newCurrencyname;
}
/**
 * 
 * @param newDate java.sql.Date
 */
public void setDate(java.sql.Date newDate) {
	date = newDate;
}
public void setLastpay(PayValueObject newLastpay) {
	lastpay = newLastpay;
}
/**
 * 
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * 
 * @param newPaydate java.lang.String
 */
public void setPaydate(java.lang.String newPaydate) {
	paydate = newPaydate;
}
/**
 * 
 * @param newPayreq boolean
 */
public void setPayreq(boolean newPayreq) {
	payreq = newPayreq;
}
/**
 * 
 * @param newPeriodpay java.lang.String
 */
public void setPeriodpay(java.lang.String newPeriodpay) {
	periodpay = newPeriodpay;
}
/**
 * 
 * @param newPptype java.lang.String
 */
public void setPptype(java.lang.String newPptype) {
	pptype = newPptype;
}
/**
 * 
 * @param newRaterule java.lang.String
 */
public void setRaterule(java.lang.String newRaterule) {
	raterule = newRaterule;
}
/**
 * 
 * @param newService java.lang.Integer
 */
public void setService(java.lang.Integer newService) {
	service = newService;
}
/**
 * 
 * @param newServicename java.lang.String
 */
public void setServicename(java.lang.String newServicename) {
	servicename = newServicename;
}
/**
 * 
 * @param newSum java.math.BigDecimal
 */
public void setSum(java.math.BigDecimal newSum) {
	sum = newSum;
}
/**
 * 
 * @param newVendor java.lang.String
 */
public void setVendor(java.lang.String newVendor) {
	vendor = newVendor;
}
}
