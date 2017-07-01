package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
/**
*  онтейнер "заголовка акта сверки".
* Creation date: (23.12.2003 11:42:18)
* @author: Shofigullin Ildar
*/
public class SverkaHeaderValueObject {
	private java.lang.Integer codeAkt;
	private java.lang.String numberAkt;
	private Date dateAkt;
	private java.lang.String position;
	private java.lang.String header1;
	private java.lang.String header2;
	private java.sql.Date dateStartAkt;
	private java.sql.Date dateEndAkt;
	private java.lang.String isCommonRate;
	private BigDecimal commonRate;
	private java.sql.Date commonRateDate;
	private java.lang.String userHeader;
	private java.lang.String userFooter;
	private java.lang.String otvUser;
	private java.lang.String mainCurr;
	private java.lang.String dopCurr;
	private java.lang.String contractNumber;
	private java.sql.Date contractDate;
	private java.lang.String customer;
	private java.lang.String executor;
	private java.lang.String jobCustomer;
	private java.lang.String jobExecutor;
	private java.lang.String fioCustomer;
	private java.lang.String fioExecutor;
	private java.lang.String otvEconomist;
	private java.lang.String highColontitul;
	private int typeView;//вид таблицы
	private java.lang.String town;
/**
 * SverkaHeaderValueObject constructor comment.
 */
public SverkaHeaderValueObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:44:04)
 * @return java.lang.Integer
 */
public java.lang.Integer getCodeAkt() {
	return codeAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:48:19)
 * @return java.math.BigDecimal
 */
public BigDecimal getCommonRate() {
	return commonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:48:50)
 * @return java.sql.Date
 */
public java.sql.Date getCommonRateDate() {
	return commonRateDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:53:04)
 * @return java.sql.Date
 */
public java.sql.Date getContractDate() {
	return contractDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:52:46)
 * @return java.lang.String
 */
public java.lang.String getContractNumber() {
	return contractNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:53:29)
 * @return java.lang.String
 */
public java.lang.String getCustomer() {
	return customer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:44:50)
 * @return java.sql.Date
 */
public Date getDateAkt() {
	return dateAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:47:19)
 * @return java.sql.Date
 */
public java.sql.Date getDateEndAkt() {
	return dateEndAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:46:13)
 * @return java.sql.Date
 */
public java.sql.Date getDateStartAkt() {
	return dateStartAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:52:29)
 * @return java.lang.String
 */
public java.lang.String getDopCurr() {
	return dopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:53:45)
 * @return java.lang.String
 */
public java.lang.String getExecutor() {
	return executor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:55:21)
 * @return java.lang.String
 */
public java.lang.String getFioCustomer() {
	return fioCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:55:38)
 * @return java.lang.String
 */
public java.lang.String getFioExecutor() {
	return fioExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:45:21)
 * @return java.lang.String
 */
public java.lang.String getHeader1() {
	return header1;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:45:40)
 * @return java.lang.String
 */
public java.lang.String getHeader2() {
	return header2;
}
/**
 * Insert the method's description here.
 * Creation date: (03.02.2004 16:37:42)
 * @return java.lang.String
 */
public java.lang.String getHighColontitul() {
	return highColontitul;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:47:50)
 * @return java.lang.String
 */
public java.lang.String getIsCommonRate() {
	return isCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:54:17)
 * @return java.lang.String
 */
public java.lang.String getJobCustomer() {
	return jobCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:55:03)
 * @return java.lang.String
 */
public java.lang.String getJobExecutor() {
	return jobExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:51:09)
 * @return String
 */
public String getMainCurr() {
	return mainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:44:26)
 * @return java.lang.String
 */
public java.lang.String getNumberAkt() {
	return numberAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:55:58)
 * @return String
 */
public String getOtvEconomist() {
	return otvEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:50:54)
 * @return java.lang.String
 */
public java.lang.String getOtvUser() {
	return otvUser;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:45:06)
 * @return java.lang.String
 */
public java.lang.String getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2005 12:17:55)
 * @return java.lang.String
 */
public java.lang.String getTown() {
	return town;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2005 17:05:24)
 * @return int
 */
public int getTypeView() {
	return typeView;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:50:32)
 * @return java.lang.String
 */
public java.lang.String getUserFooter() {
	return userFooter;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:49:10)
 * @return java.lang.String
 */
public java.lang.String getUserHeader() {
	return userHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:44:04)
 * @param newCodeAkt java.lang.Integer
 */
public void setCodeAkt(java.lang.Integer newCodeAkt) {
	codeAkt = newCodeAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:48:19)
 * @param newCommonRate java.math.BigDecimal
 */
public void setCommonRate(BigDecimal newCommonRate) {
	commonRate = newCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:48:50)
 * @param newCommonRateDate java.sql.Date
 */
public void setCommonRateDate(java.sql.Date newCommonRateDate) {
	commonRateDate = newCommonRateDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:53:04)
 * @param newContractDate java.sql.Date
 */
public void setContractDate(java.sql.Date newContractDate) {
	contractDate = newContractDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:52:46)
 * @param newContractNumber java.lang.String
 */
public void setContractNumber(java.lang.String newContractNumber) {
	contractNumber = newContractNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:53:29)
 * @param newCustomer java.lang.String
 */
public void setCustomer(java.lang.String newCustomer) {
	customer = newCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:44:50)
 * @param newDateAkt java.sql.Date
 */
public void setDateAkt(Date newDateAkt) {
	dateAkt = newDateAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:47:19)
 * @param newDateEndAkt java.sql.Date
 */
public void setDateEndAkt(java.sql.Date newDateEndAkt) {
	dateEndAkt = newDateEndAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:46:13)
 * @param newDateStartAkt java.sql.Date
 */
public void setDateStartAkt(java.sql.Date newDateStartAkt) {
	dateStartAkt = newDateStartAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:52:29)
 * @param newDopCurr java.lang.String
 */
public void setDopCurr(java.lang.String newDopCurr) {
	dopCurr = newDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:53:45)
 * @param newExecutor java.lang.String
 */
public void setExecutor(java.lang.String newExecutor) {
	executor = newExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:55:21)
 * @param newFioCustomer java.lang.String
 */
public void setFioCustomer(java.lang.String newFioCustomer) {
	fioCustomer = newFioCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:55:38)
 * @param newFioExecutor java.lang.String
 */
public void setFioExecutor(java.lang.String newFioExecutor) {
	fioExecutor = newFioExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:45:21)
 * @param newHeader1 java.lang.String
 */
public void setHeader1(java.lang.String newHeader1) {
	header1 = newHeader1;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:45:40)
 * @param newHeader2 java.lang.String
 */
public void setHeader2(java.lang.String newHeader2) {
	header2 = newHeader2;
}
/**
 * Insert the method's description here.
 * Creation date: (03.02.2004 16:37:42)
 * @param newHighColontitul java.lang.String
 */
public void setHighColontitul(java.lang.String newHighColontitul) {
	highColontitul = newHighColontitul;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:47:50)
 * @param newIsCommonRate java.lang.String
 */
public void setIsCommonRate(java.lang.String newIsCommonRate) {
	isCommonRate = newIsCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:54:17)
 * @param newJobCustomer java.lang.String
 */
public void setJobCustomer(java.lang.String newJobCustomer) {
	jobCustomer = newJobCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:55:03)
 * @param newJobExecutor java.lang.String
 */
public void setJobExecutor(java.lang.String newJobExecutor) {
	jobExecutor = newJobExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:51:09)
 * @param newMainCurr String
 */
public void setMainCurr(String newMainCurr) {
	mainCurr = newMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:44:26)
 * @param newNumberAkt java.lang.String
 */
public void setNumberAkt(java.lang.String newNumberAkt) {
	numberAkt = newNumberAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:55:58)
 * @param newOtvEconomist String
 */
public void setOtvEconomist(String newOtvEconomist) {
	otvEconomist = newOtvEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:50:54)
 * @param newOtvUser java.lang.String
 */
public void setOtvUser(java.lang.String newOtvUser) {
	otvUser = newOtvUser;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:45:06)
 * @param newPosition java.lang.String
 */
public void setPosition(java.lang.String newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (09.12.2005 12:17:55)
 * @param newTown java.lang.String
 */
public void setTown(java.lang.String newTown) {
	town = newTown;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2005 17:05:24)
 * @param newTypeView int
 */
public void setTypeView(int newTypeView) {
	typeView = newTypeView;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:50:32)
 * @param newUserFooter java.lang.String
 */
public void setUserFooter(java.lang.String newUserFooter) {
	userFooter = newUserFooter;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 11:49:10)
 * @param newUserHeader java.lang.String
 */
public void setUserHeader(java.lang.String newUserHeader) {
	userHeader = newUserHeader;
}
}
