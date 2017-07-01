package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*; /**
*  онтейнер "начислений и платежей акта сверки"
* Creation date: (23.12.2003 12:15:56)
* @author: Shofigullin Ildar
*/
public class SverkaChrgAndPayValueObject {
	private java.lang.Integer codeResource;
	private java.lang.Integer codeContract;
	private java.lang.Integer codeAkt;
	private java.lang.String customer;
	private java.lang.String executor;
	private java.lang.String mainCurr;
	private java.lang.String dopCurr;
	private java.lang.String resName;
	private java.lang.Integer periodContract;
	private java.lang.Integer periodResource;
	private Date periodStart;
	private java.sql.Date periodEnd;
	private java.lang.String billNumber;
	private java.sql.Date BillDate;
	private BigDecimal sumCharge;
	private java.math.BigDecimal ndsCharge;
	private java.math.BigDecimal mainSumCharge;
	private java.math.BigDecimal mainNdsCharge;
	private java.lang.String payNumber;
	private java.sql.Date payDate;
	private java.math.BigDecimal sumRubPay;
	private java.math.BigDecimal ndsRubPay;
	private java.math.BigDecimal rateContractPay;
	private java.math.BigDecimal sumContractPay;
	private java.math.BigDecimal ndsContractPay;
	private java.math.BigDecimal rateMainPay;
	private java.math.BigDecimal sumMainPay;
	private java.math.BigDecimal ndsMainPay;
	private java.math.BigDecimal startSaldoMain;
	private java.math.BigDecimal startNdsSaldoMain;
	private java.math.BigDecimal endSaldoMain;
	private java.math.BigDecimal endNdsSaldoMain;
	private java.math.BigDecimal endSaldoDop;
	private java.math.BigDecimal endNdsSaldoDop;
	private java.math.BigDecimal sumRubDifference;
	private java.sql.Date dateStartAkt;
	private java.sql.Date dateEndAkt;
	private java.lang.String currCharge;
	private java.math.BigDecimal rateCharge;
/**
 * SverkaChrgAndPayValueObject constructor comment.
 */
public SverkaChrgAndPayValueObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:22:51)
 * @return java.sql.Date
 */
public java.sql.Date getBillDate() {
	return BillDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:22:21)
 * @return java.lang.String
 */
public java.lang.String getBillNumber() {
	return billNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:18:05)
 * @return java.lang.Integer
 */
public java.lang.Integer getCodeAkt() {
	return codeAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:17:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getCodeContract() {
	return codeContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:16:31)
 * @return java.lang.Integer
 */
public java.lang.Integer getCodeResource() {
	return codeResource;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2003 11:22:40)
 * @return java.lang.String
 */
public java.lang.String getCurrCharge() {
	return currCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:18:25)
 * @return java.lang.String
 */
public java.lang.String getCustomer() {
	return customer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:32:48)
 * @return java.sql.Date
 */
public java.sql.Date getDateEndAkt() {
	return dateEndAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:32:27)
 * @return java.sql.Date
 */
public java.sql.Date getDateStartAkt() {
	return dateStartAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:19:34)
 * @return java.lang.String
 */
public java.lang.String getDopCurr() {
	return dopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:31:33)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getEndNdsSaldoDop() {
	return endNdsSaldoDop;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:30:57)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getEndNdsSaldoMain() {
	return endNdsSaldoMain;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:31:15)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getEndSaldoDop() {
	return endSaldoDop;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:30:36)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getEndSaldoMain() {
	return endSaldoMain;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:18:51)
 * @return java.lang.String
 */
public java.lang.String getExecutor() {
	return executor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:19:10)
 * @return java.lang.String
 */
public java.lang.String getMainCurr() {
	return mainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:24:16)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getMainNdsCharge() {
	return mainNdsCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:23:57)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getMainSumCharge() {
	return mainSumCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:23:38)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNdsCharge() {
	return ndsCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:27:27)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNdsContractPay() {
	return ndsContractPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:28:36)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNdsMainPay() {
	return ndsMainPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:26:07)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNdsRubPay() {
	return ndsRubPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:25:19)
 * @return java.sql.Date
 */
public java.sql.Date getPayDate() {
	return payDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:25:00)
 * @return java.lang.String
 */
public java.lang.String getPayNumber() {
	return payNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:20:10)
 * @return java.lang.Integer
 */
public java.lang.Integer getPeriodContract() {
	return periodContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:21:16)
 * @return java.sql.Date
 */
public java.sql.Date getPeriodEnd() {
	return periodEnd;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:20:30)
 * @return java.lang.Integer
 */
public java.lang.Integer getPeriodResource() {
	return periodResource;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:20:52)
 * @return java.sql.Date
 */
public Date getPeriodStart() {
	return periodStart;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2003 11:23:11)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRateCharge() {
	return rateCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:26:35)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRateContractPay() {
	return rateContractPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:27:47)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRateMainPay() {
	return rateMainPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:19:52)
 * @return java.lang.String
 */
public java.lang.String getResName() {
	return resName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:30:17)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getStartNdsSaldoMain() {
	return startNdsSaldoMain;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:29:45)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getStartSaldoMain() {
	return startSaldoMain;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:23:15)
 * @return java.math.BigDecimal
 */
public BigDecimal getSumCharge() {
	return sumCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:26:57)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumContractPay() {
	return sumContractPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:28:10)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumMainPay() {
	return sumMainPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:31:53)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumRubDifference() {
	return sumRubDifference;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:25:44)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumRubPay() {
	return sumRubPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:22:51)
 * @param newBillDate java.sql.Date
 */
public void setBillDate(java.sql.Date newBillDate) {
	BillDate = newBillDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:22:21)
 * @param newBillNumber java.lang.String
 */
public void setBillNumber(java.lang.String newBillNumber) {
	billNumber = newBillNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:18:05)
 * @param newCodeAkt java.lang.Integer
 */
public void setCodeAkt(java.lang.Integer newCodeAkt) {
	codeAkt = newCodeAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:17:06)
 * @param newCodeContract java.lang.Integer
 */
public void setCodeContract(java.lang.Integer newCodeContract) {
	codeContract = newCodeContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:16:31)
 * @param newCodeResource java.lang.Integer
 */
public void setCodeResource(java.lang.Integer newCodeResource) {
	codeResource = newCodeResource;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2003 11:22:40)
 * @param newCurrCharge java.lang.String
 */
public void setCurrCharge(java.lang.String newCurrCharge) {
	currCharge = newCurrCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:18:25)
 * @param newCustomer java.lang.String
 */
public void setCustomer(java.lang.String newCustomer) {
	customer = newCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:32:48)
 * @param newDateEndAkt java.sql.Date
 */
public void setDateEndAkt(java.sql.Date newDateEndAkt) {
	dateEndAkt = newDateEndAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:32:27)
 * @param newDateStartAkt java.sql.Date
 */
public void setDateStartAkt(java.sql.Date newDateStartAkt) {
	dateStartAkt = newDateStartAkt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:19:34)
 * @param newDopCurr java.lang.String
 */
public void setDopCurr(java.lang.String newDopCurr) {
	dopCurr = newDopCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:31:33)
 * @param newEndNdsSaldoDop java.math.BigDecimal
 */
public void setEndNdsSaldoDop(java.math.BigDecimal newEndNdsSaldoDop) {
	endNdsSaldoDop = newEndNdsSaldoDop;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:30:57)
 * @param newEndNdsSaldoMain java.math.BigDecimal
 */
public void setEndNdsSaldoMain(java.math.BigDecimal newEndNdsSaldoMain) {
	endNdsSaldoMain = newEndNdsSaldoMain;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:31:15)
 * @param newEndSaldoDop java.math.BigDecimal
 */
public void setEndSaldoDop(java.math.BigDecimal newEndSaldoDop) {
	endSaldoDop = newEndSaldoDop;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:30:36)
 * @param newEndSaldoMain java.math.BigDecimal
 */
public void setEndSaldoMain(java.math.BigDecimal newEndSaldoMain) {
	endSaldoMain = newEndSaldoMain;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:18:51)
 * @param newExecutor java.lang.String
 */
public void setExecutor(java.lang.String newExecutor) {
	executor = newExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:19:10)
 * @param newMainCurr java.lang.String
 */
public void setMainCurr(java.lang.String newMainCurr) {
	mainCurr = newMainCurr;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:24:16)
 * @param newMainNdsCharge java.math.BigDecimal
 */
public void setMainNdsCharge(java.math.BigDecimal newMainNdsCharge) {
	mainNdsCharge = newMainNdsCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:23:57)
 * @param newMainSumCharge java.math.BigDecimal
 */
public void setMainSumCharge(java.math.BigDecimal newMainSumCharge) {
	mainSumCharge = newMainSumCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:23:38)
 * @param newNdsCharge java.math.BigDecimal
 */
public void setNdsCharge(java.math.BigDecimal newNdsCharge) {
	ndsCharge = newNdsCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:27:27)
 * @param newNdsContractPay java.math.BigDecimal
 */
public void setNdsContractPay(java.math.BigDecimal newNdsContractPay) {
	ndsContractPay = newNdsContractPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:28:36)
 * @param newNdsMainPay java.math.BigDecimal
 */
public void setNdsMainPay(java.math.BigDecimal newNdsMainPay) {
	ndsMainPay = newNdsMainPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:26:07)
 * @param newNdsRubPay java.math.BigDecimal
 */
public void setNdsRubPay(java.math.BigDecimal newNdsRubPay) {
	ndsRubPay = newNdsRubPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:25:19)
 * @param newPayDate java.sql.Date
 */
public void setPayDate(java.sql.Date newPayDate) {
	payDate = newPayDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:25:00)
 * @param newPayNumber java.lang.String
 */
public void setPayNumber(java.lang.String newPayNumber) {
	payNumber = newPayNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:20:10)
 * @param newPeriodContract java.lang.Integer
 */
public void setPeriodContract(java.lang.Integer newPeriodContract) {
	periodContract = newPeriodContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:21:16)
 * @param newPeriodEnd java.sql.Date
 */
public void setPeriodEnd(java.sql.Date newPeriodEnd) {
	periodEnd = newPeriodEnd;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:20:30)
 * @param newPeriodResource java.lang.Integer
 */
public void setPeriodResource(java.lang.Integer newPeriodResource) {
	periodResource = newPeriodResource;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:20:52)
 * @param newPeriodStart java.sql.Date
 */
public void setPeriodStart(Date newPeriodStart) {
	periodStart = newPeriodStart;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2003 11:23:11)
 * @param newRateCharge java.math.BigDecimal
 */
public void setRateCharge(java.math.BigDecimal newRateCharge) {
	rateCharge = newRateCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:26:35)
 * @param newRateContractPay java.math.BigDecimal
 */
public void setRateContractPay(java.math.BigDecimal newRateContractPay) {
	rateContractPay = newRateContractPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:27:47)
 * @param newRateMainPay java.math.BigDecimal
 */
public void setRateMainPay(java.math.BigDecimal newRateMainPay) {
	rateMainPay = newRateMainPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:19:52)
 * @param newResName java.lang.String
 */
public void setResName(java.lang.String newResName) {
	resName = newResName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:30:17)
 * @param newStartNdsSaldoMain java.math.BigDecimal
 */
public void setStartNdsSaldoMain(java.math.BigDecimal newStartNdsSaldoMain) {
	startNdsSaldoMain = newStartNdsSaldoMain;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:29:45)
 * @param newStartSaldoMain java.math.BigDecimal
 */
public void setStartSaldoMain(java.math.BigDecimal newStartSaldoMain) {
	startSaldoMain = newStartSaldoMain;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:23:15)
 * @param newSumCharge java.math.BigDecimal
 */
public void setSumCharge(BigDecimal newSumCharge) {
	sumCharge = newSumCharge;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:26:57)
 * @param newSumContractPay java.math.BigDecimal
 */
public void setSumContractPay(java.math.BigDecimal newSumContractPay) {
	sumContractPay = newSumContractPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:28:10)
 * @param newSumMainPay java.math.BigDecimal
 */
public void setSumMainPay(java.math.BigDecimal newSumMainPay) {
	sumMainPay = newSumMainPay;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:31:53)
 * @param newSumRubDifference java.math.BigDecimal
 */
public void setSumRubDifference(java.math.BigDecimal newSumRubDifference) {
	sumRubDifference = newSumRubDifference;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2003 12:25:44)
 * @param newSumRubPay java.math.BigDecimal
 */
public void setSumRubPay(java.math.BigDecimal newSumRubPay) {
	sumRubPay = newSumRubPay;
}
}
