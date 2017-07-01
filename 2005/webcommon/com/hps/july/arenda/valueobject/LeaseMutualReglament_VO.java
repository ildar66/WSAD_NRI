package com.hps.july.arenda.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (16.06.2005 10:37:29)
 * @author: Shafigullin Ildar
 */
public class LeaseMutualReglament_VO extends LeaseDocumentVO {
	private java.lang.String actType;
	private java.lang.String calcRateType;
	private java.lang.String mutualPeriod;
	private java.lang.Integer additionalCurrency_currency;
	private java.lang.Boolean commonRate;
	private java.lang.String dutyraterule;
	private java.sql.Date enddate;
	private java.lang.Integer maincurrency_currency;
	private java.lang.String mutState;
	private java.sql.Date startdate;
/**
 * LeaseMutualReglament_VO constructor comment.
 */
public LeaseMutualReglament_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 12:26:17)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LeaseMutualReglament_VO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
    super(ro);
    setActType(ro.getColumn("acttype").asString());
    setAdditionalCurrency_currency((Integer) ro.getColumn("additionalcurrency").asObject());
    setCalcRateType(ro.getColumn("calcratetype").asString());
    initCommonRate(ro.getColumn("commonrate").asString());
    setDutyraterule(ro.getColumn("dutyraterule").asString());
    setEnddate((java.sql.Date) ro.getColumn("enddate").asObject());
    setMaincurrency_currency((Integer) ro.getColumn("maincurrency").asObject());
    setMutState(ro.getColumn("mutstate").asString());
    setMutualPeriod(ro.getColumn("mutualperiod").asString());
    setStartdate((java.sql.Date) ro.getColumn("startdate").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:38:28)
 * @return java.lang.String
 */
public java.lang.String getActType() {
	return actType;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:39:56)
 * @return java.lang.Integer
 */
public java.lang.Integer getAdditionalCurrency_currency() {
	return additionalCurrency_currency;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:38:57)
 * @return java.lang.String
 */
public java.lang.String getCalcRateType() {
	return calcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:40:42)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCommonRate() {
	return commonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:41:16)
 * @return java.lang.String
 */
public java.lang.String getDutyraterule() {
	return dutyraterule;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:41:46)
 * @return java.sql.Date
 */
public java.sql.Date getEnddate() {
	return enddate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:42:08)
 * @return java.lang.Integer
 */
public java.lang.Integer getMaincurrency_currency() {
	return maincurrency_currency;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:42:35)
 * @return java.lang.String
 */
public java.lang.String getMutState() {
	return mutState;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:39:19)
 * @return java.lang.String
 */
public java.lang.String getMutualPeriod() {
	return mutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:43:26)
 * @return java.sql.Date
 */
public java.sql.Date getStartdate() {
	return startdate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:40:42)
 * @param newCommonRate java.lang.Boolean
 */
private void initCommonRate(String newCommonRateStr) {
    if ("Y".equals(newCommonRateStr))
        commonRate = Boolean.TRUE;
    else
        commonRate = Boolean.FALSE;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:38:28)
 * @param newActType java.lang.String
 */
public void setActType(java.lang.String newActType) {
	actType = newActType;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:39:56)
 * @param newAdditionalCurrency_currency java.lang.Integer
 */
public void setAdditionalCurrency_currency(java.lang.Integer newAdditionalCurrency_currency) {
	additionalCurrency_currency = newAdditionalCurrency_currency;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:38:57)
 * @param newCalcRateType java.lang.String
 */
public void setCalcRateType(java.lang.String newCalcRateType) {
	calcRateType = newCalcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:41:16)
 * @param newDutyraterule java.lang.String
 */
public void setDutyraterule(java.lang.String newDutyraterule) {
	dutyraterule = newDutyraterule;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:41:46)
 * @param newEnddate java.sql.Date
 */
public void setEnddate(java.sql.Date newEnddate) {
	enddate = newEnddate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:42:08)
 * @param newMaincurrency_currency java.lang.Integer
 */
public void setMaincurrency_currency(java.lang.Integer newMaincurrency_currency) {
	maincurrency_currency = newMaincurrency_currency;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:42:35)
 * @param newMutstate java.lang.String
 */
public void setMutState(java.lang.String newMutstate) {
	mutState = newMutstate;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:39:19)
 * @param newMutualPeriod java.lang.String
 */
public void setMutualPeriod(java.lang.String newMutualPeriod) {
	mutualPeriod = newMutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:43:26)
 * @param newStartdate java.sql.Date
 */
public void setStartdate(java.sql.Date newStartdate) {
	startdate = newStartdate;
}
}
