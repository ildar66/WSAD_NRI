package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
/**
* Контейнер "по ресурсам акта сверки".
* Creation date: (23.12.2003 12:00:44)
* @author: Shofigullin Ildar
*/
public class SverkaContrResValueObject {
	private java.lang.Integer codeContract;
	private java.lang.Integer codeResource;
	private java.lang.Integer codeAkt;
	private java.lang.String numberContract;
	private Date dateContract;
	private java.lang.String customer;
	private java.lang.String executor;
	private java.lang.String resName;
	private java.lang.String mainCurr;
	private BigDecimal startSumMainCurr;
	private java.math.BigDecimal startNdsMainCurr;
	private java.math.BigDecimal endSumMainCurr;
	private java.math.BigDecimal endNdsMainCurr;
	private java.lang.String dopCurr;
	private java.math.BigDecimal startSumDopCurr;
	private java.math.BigDecimal startNdsDopCurr;
	private java.math.BigDecimal endSumDopCurr;
	private java.math.BigDecimal endNdsDopCurr;
	private java.math.BigDecimal sumRubDifference;
	private java.sql.Date dateStartAkt;
	private java.sql.Date dateEndAkt;
/**
 * SverkaContrResValueObject constructor comment.
 */
public SverkaContrResValueObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:02:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getCodeAkt() {
	return codeAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:01:08)
 * @return java.lang.Integer
 */
public java.lang.Integer getCodeContract() {
	return codeContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:01:28)
 * @return java.lang.Integer
 */
public java.lang.Integer getCodeResource() {
	return codeResource;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:03:37)
 * @return java.lang.String
 */
public java.lang.String getCustomer() {
	return customer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:03:15)
 * @return java.sql.Date
 */
public Date getDateContract() {
	return dateContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:12:35)
 * @return java.sql.Date
 */
public java.sql.Date getDateEndAkt() {
	return dateEndAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:12:12)
 * @return java.sql.Date
 */
public java.sql.Date getDateStartAkt() {
	return dateStartAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:08:04)
 * @return java.lang.String
 */
public java.lang.String getDopCurr() {
	return dopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:11:01)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getEndNdsDopCurr() {
	return endNdsDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:07:40)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getEndNdsMainCurr() {
	return endNdsMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:10:29)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getEndSumDopCurr() {
	return endSumDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:07:02)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getEndSumMainCurr() {
	return endSumMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:04:05)
 * @return java.lang.String
 */
public java.lang.String getExecutor() {
	return executor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:05:05)
 * @return java.lang.String
 */
public java.lang.String getMainCurr() {
	return mainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:02:30)
 * @return java.lang.String
 */
public java.lang.String getNumberContract() {
	return numberContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:04:39)
 * @return java.lang.String
 */
public java.lang.String getResName() {
	return resName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:09:51)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getStartNdsDopCurr() {
	return startNdsDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:06:15)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getStartNdsMainCurr() {
	return startNdsMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:09:06)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getStartSumDopCurr() {
	return startSumDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:05:45)
 * @return java.math.BigDecimal
 */
public BigDecimal getStartSumMainCurr() {
	return startSumMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:11:35)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumRubDifference() {
	return sumRubDifference;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:02:06)
 * @param newCodeAkt java.lang.Integer
 */
public void setCodeAkt(java.lang.Integer newCodeAkt) {
	codeAkt = newCodeAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:01:08)
 * @param newCodeContract java.lang.Integer
 */
public void setCodeContract(java.lang.Integer newCodeContract) {
	codeContract = newCodeContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:01:28)
 * @param newCodeResource java.lang.Integer
 */
public void setCodeResource(java.lang.Integer newCodeResource) {
	codeResource = newCodeResource;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:03:37)
 * @param newCustomer java.lang.String
 */
public void setCustomer(java.lang.String newCustomer) {
	customer = newCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:03:15)
 * @param newDateContract java.sql.Date
 */
public void setDateContract(Date newDateContract) {
	dateContract = newDateContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:12:35)
 * @param newDateEndAkt java.sql.Date
 */
public void setDateEndAkt(java.sql.Date newDateEndAkt) {
	dateEndAkt = newDateEndAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:12:12)
 * @param newDateStartAkt java.sql.Date
 */
public void setDateStartAkt(java.sql.Date newDateStartAkt) {
	dateStartAkt = newDateStartAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:08:04)
 * @param newDopCurr java.lang.String
 */
public void setDopCurr(java.lang.String newDopCurr) {
	dopCurr = newDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:11:01)
 * @param newEndNdsDopCurr java.math.BigDecimal
 */
public void setEndNdsDopCurr(java.math.BigDecimal newEndNdsDopCurr) {
	endNdsDopCurr = newEndNdsDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:07:40)
 * @param newEndNdsMainCurr java.math.BigDecimal
 */
public void setEndNdsMainCurr(java.math.BigDecimal newEndNdsMainCurr) {
	endNdsMainCurr = newEndNdsMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:10:29)
 * @param newEndSumDopCurr java.math.BigDecimal
 */
public void setEndSumDopCurr(java.math.BigDecimal newEndSumDopCurr) {
	endSumDopCurr = newEndSumDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:07:02)
 * @param newEndSumMainCurr java.math.BigDecimal
 */
public void setEndSumMainCurr(java.math.BigDecimal newEndSumMainCurr) {
	endSumMainCurr = newEndSumMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:04:05)
 * @param newExecutor java.lang.String
 */
public void setExecutor(java.lang.String newExecutor) {
	executor = newExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:05:05)
 * @param newMainCurr java.lang.String
 */
public void setMainCurr(java.lang.String newMainCurr) {
	mainCurr = newMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:02:30)
 * @param newNumberContract java.lang.String
 */
public void setNumberContract(java.lang.String newNumberContract) {
	numberContract = newNumberContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:04:39)
 * @param newResName java.lang.String
 */
public void setResName(java.lang.String newResName) {
	resName = newResName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:09:51)
 * @param newStartNdsDopCurr java.math.BigDecimal
 */
public void setStartNdsDopCurr(java.math.BigDecimal newStartNdsDopCurr) {
	startNdsDopCurr = newStartNdsDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:06:15)
 * @param newStartNdsMainCurr java.math.BigDecimal
 */
public void setStartNdsMainCurr(java.math.BigDecimal newStartNdsMainCurr) {
	startNdsMainCurr = newStartNdsMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:09:06)
 * @param newStartSumDopCurr java.math.BigDecimal
 */
public void setStartSumDopCurr(java.math.BigDecimal newStartSumDopCurr) {
	startSumDopCurr = newStartSumDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:05:45)
 * @param newStartSumMainCurr java.math.BigDecimal
 */
public void setStartSumMainCurr(BigDecimal newStartSumMainCurr) {
	startSumMainCurr = newStartSumMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:11:35)
 * @param newSumRubDifference java.math.BigDecimal
 */
public void setSumRubDifference(java.math.BigDecimal newSumRubDifference) {
	sumRubDifference = newSumRubDifference;
}
}
