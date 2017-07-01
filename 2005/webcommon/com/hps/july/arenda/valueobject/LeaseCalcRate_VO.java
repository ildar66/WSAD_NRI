package com.hps.july.arenda.valueobject;

import com.hps.july.cdbc.lib.*;
/**
* Bean-Wrapper "Курсы зачета при расчете акта".
* Creation date: (20.06.2005 17:50:45)
* @author: Shafigullin Ildar
*/
public class LeaseCalcRate_VO {
    private java.lang.Integer leaseDocPosition; //код позиции документа
    private CurrencyVO currencyVO; //валюта
    private java.math.BigDecimal rate; //курс
    private java.lang.String byhand; //признак ручной установки
    private LeaseMutualActVO actVO; //код акта
    private java.lang.Integer source; //признак ???
    private java.math.BigDecimal rateold;
    private java.lang.Integer sourceold;
	private java.lang.String sumLeaseCalcRate;//получаем из процедуры: getSumLeaseCalcRate(leasedocposition, currency)
/**
 * LeaseCalcRate_VO constructor comment.
 */
public LeaseCalcRate_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:11:04)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LeaseCalcRate_VO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
    leaseDocPosition = (Integer)ro.getColumn("leasedocposition").asObject();
    initCurrencyVO(ro);
    setRate((java.math.BigDecimal)ro.getColumn("rate").asObject());
    setByhand(ro.getColumn("byhand").asString());
    initActVO(ro);
    setSource((Integer)ro.getColumn("source").asObject());
    setRateold((java.math.BigDecimal)ro.getColumn("rateold").asObject());
    setSourceold((Integer)ro.getColumn("sourceold").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:04:21)
 * @return com.hps.july.arenda.valueobject.LeaseMutualActVO
 */
public LeaseMutualActVO getActVO() {
	return actVO;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:03:11)
 * @return java.lang.String
 */
public java.lang.String getByhand() {
	return byhand;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:00:28)
 * @return com.hps.july.arenda.valueobject.CurrencyVO
 */
public CurrencyVO getCurrencyVO() {
	return currencyVO;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 17:54:23)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseDocPosition() {
	return leaseDocPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:02:49)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRate() {
	return rate;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:07:31)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRateold() {
	return rateold;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:05:58)
 * @return java.lang.Integer
 */
public java.lang.Integer getSource() {
	return source;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:08:10)
 * @return java.lang.Integer
 */
public java.lang.Integer getSourceold() {
	return sourceold;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2005 14:59:40)
 * @return java.lang.String
 */
public java.lang.String getSumLeaseCalcRate() {
	return sumLeaseCalcRate;
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2004 11:44:23)
 */
private void initActVO(CDBCRowObject ro) {
	if (ro.getColumn("act").asObject() != null) {
		LeaseMutualActVO actVO = new LeaseMutualActVO();
		actVO.setLeaseDocument((Integer)ro.getColumn("act").asObject());
		setActVO(actVO);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (28.10.2004 11:44:23)
 */
private void initCurrencyVO(CDBCRowObject ro) {
	if (ro.getColumn("currency").asObject() != null) {
		CurrencyVO currVO = new CurrencyVO((Integer) ro.getColumn("currency").asObject());
		currVO.setShortname(ro.getColumn("currname").asString());
		setCurrencyVO(currVO);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:04:21)
 * @param newAct com.hps.july.arenda.valueobject.LeaseMutualActVO
 */
public void setActVO(LeaseMutualActVO newAct) {
	actVO = newAct;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:03:11)
 * @param newByhand java.lang.String
 */
public void setByhand(java.lang.String newByhand) {
	byhand = newByhand;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:00:28)
 * @param newCurrencyVO com.hps.july.arenda.valueobject.CurrencyVO
 */
public void setCurrencyVO(CurrencyVO newCurrencyVO) {
	currencyVO = newCurrencyVO;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 17:54:23)
 * @param newLeaseDocPosition java.lang.Integer
 */
public void setLeaseDocPosition(java.lang.Integer newLeaseDocPosition) {
	leaseDocPosition = newLeaseDocPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:02:49)
 * @param newRate java.math.BigDecimal
 */
public void setRate(java.math.BigDecimal newRate) {
	rate = newRate;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:07:31)
 * @param newRateold java.math.BigDecimal
 */
public void setRateold(java.math.BigDecimal newRateold) {
	rateold = newRateold;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:05:58)
 * @param newSource java.lang.Integer
 */
public void setSource(java.lang.Integer newSource) {
	source = newSource;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:08:10)
 * @param newSourceold java.lang.Integer
 */
public void setSourceold(java.lang.Integer newSourceold) {
	sourceold = newSourceold;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2005 14:59:40)
 * @param newSumLeaseCalcRate java.lang.String
 */
public void setSumLeaseCalcRate(java.lang.String newSumLeaseCalcRate) {
	sumLeaseCalcRate = newSumLeaseCalcRate;
}
}
