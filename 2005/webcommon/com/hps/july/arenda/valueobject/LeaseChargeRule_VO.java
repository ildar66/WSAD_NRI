package com.hps.july.arenda.valueobject;

/**
 * Bean-Wraper "Правила начислений".
 * Creation date: (19.04.2005 16:46:16)
 * @author: Shafigullin Ildar
 */
public class LeaseChargeRule_VO {
	private java.lang.Integer leaserule;//Уникальный код правила
	private ResourceVO resource;//Код услуги
	private CurrencyVO currency;//Валюта
	private java.math.BigDecimal summ;//Сумма услуги	
	private java.lang.String chargePeriod;//Периодичность начислений(M-Месяц, Q-Квартал, Y-Год)
	private java.lang.String chargeDateRule;//Правило определения даты начислений(S-На начало периода, E-На конец периода)
/**
 * LeaseChargeRule_VO constructor comment.
 */
public LeaseChargeRule_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 17:09:15)
 * @param aLeaserule java.lang.Integer
 */
public LeaseChargeRule_VO(Integer aLeaserule) {
    this.leaserule = aLeaserule;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:51:05)
 * @return java.lang.String
 */
public java.lang.String getChargeDateRule() {
	return chargeDateRule;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:50:50)
 * @return java.lang.String
 */
public java.lang.String getChargePeriod() {
	return chargePeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:50:18)
 * @return com.hps.july.arenda.valueobject.CurrencyVO
 */
public CurrencyVO getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:48:07)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaserule() {
	return leaserule;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:49:48)
 * @return com.hps.july.arenda.valueobject.ResourceVO
 */
public ResourceVO getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:49:13)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumm() {
	return summ;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:51:05)
 * @param newChargedaterule java.lang.String
 */
public void setChargeDateRule(java.lang.String newChargedaterule) {
	chargeDateRule = newChargedaterule;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:50:50)
 * @param newChargeperiod java.lang.String
 */
public void setChargePeriod(java.lang.String newChargeperiod) {
	chargePeriod = newChargeperiod;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:50:18)
 * @param newCurrency com.hps.july.arenda.valueobject.CurrencyVO
 */
public void setCurrency(CurrencyVO newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:48:07)
 * @param newLeaserule java.lang.Integer
 */
public void setLeaserule(java.lang.Integer newLeaserule) {
	leaserule = newLeaserule;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:49:48)
 * @param newResource com.hps.july.arenda.valueobject.ResourceVO
 */
public void setResource(ResourceVO newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2005 16:49:13)
 * @param newSumm java.math.BigDecimal
 */
public void setSumm(java.math.BigDecimal newSumm) {
	summ = newSumm;
}
}
