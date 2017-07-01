/*
 * Created on 18.05.2006
 *
 * Служебные записки на изменение ЗП в системе НФС VO
 */
package com.hps.july.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * "Служебные записки на изменение ЗП в системе НФС" VO
 */
public class LeaseZPOfficeMemo_VO extends DomainObject {
	private Integer idOfficeMemo = null; //pk
	private Integer leaseContract = null; //ссылка на базовый договор
	private Integer leaseDopContract = null; //ссылка на доп соглашение
	private String flagAddVendor = null; //Признак создания нового поставщика('I'-Создать нового поставщика; 'N'-ничего делать)
	private String flagAddVendorSite = null; //Признак создания нового отделения(N/Y)
	private String flagAddContract = null; //Признак создания контракта(N/Y)
	private String typeActionZP = null; //Тип действия над ЗП('I'-Создать; 'U'-Изменить)
	private Integer idZP = null; //ссылка на ЗП
	private BigDecimal oldSumZP = null; //текущая сумма ЗП
	private Integer idVendorSite = null; //Отделение поставщика
	private Integer idResource = null; //Предмет договора
	private BigDecimal sumCharge = null; //Сумма к начислению в месяц
	private BigDecimal sumZP = null; //сумма ЗП
	private BigDecimal sumNdsZP = null; //сумма НДС ЗП
	private Integer idCurrCharge = null; //Валюта договора
	private Date dateStartZP = null; //Дата начала периода ЗП
	private Date dateEndZp = null; //Дата окончания периода ЗП
	private String reason = null; //Основание для изменений
	private BigDecimal rateNds = null; //Ставка НДС
	/**
	 * правило определения курса:
	 * A - на дату выставления счета
	 * B - на дату платежа
	 * C - за день до платежа
	 * D - последняя дата оплачиваемого периода
	 * E - начальная дата оплачиваемого периода
	 * F - на Х число месяца предшествующего оплачиваемому периоду
	 * G - на Х число последнего месяца предшествующего кварталу оплачиваемого периода
	 * H - на последнюю дату предшествующего периода
	 * I - на первое число следующего периода
	 * K - фиксированный курс
	 * 
	 */
	private String rateCalcRule = null; //правило определения курса для платежей и начислений
	private BigDecimal rateDelta = null; //наценка в процентах для расчета курса
	private Integer rateCalcRuleDay = null; //Число месяца для некоторых вариантов расчета курса
	private BigDecimal rateFix = null; //Значение фиксированного курса(rateCalcRule = 'K') 
	/**
	 * 
	 * @param aIdOfficeMemo
	 */

	public LeaseZPOfficeMemo_VO(Integer aIdOfficeMemo) {
		super();
		this.idOfficeMemo = aIdOfficeMemo;
	}

	/**
	 * @return
	 */
	public Date getDateEndZp() {
		return dateEndZp;
	}

	/**
	 * @return
	 */
	public Date getDateStartZP() {
		return dateStartZP;
	}

	/**
	 * @return
	 */
	public String getFlagAddContract() {
		return flagAddContract;
	}

	/**
	 * @return
	 */
	public String getFlagAddVendor() {
		return flagAddVendor;
	}

	/**
	 * @return
	 */
	public String getFlagAddVendorSite() {
		return flagAddVendorSite;
	}

	/**
	 * @return
	 */
	public Integer getIdCurrCharge() {
		return idCurrCharge;
	}

	/**
	 * @return
	 */
	public Integer getIdOfficeMemo() {
		return idOfficeMemo;
	}

	/**
	 * @return
	 */
	public Integer getIdResource() {
		return idResource;
	}

	/**
	 * @return
	 */
	public Integer getIdVendorSite() {
		return idVendorSite;
	}

	/**
	 * @return
	 */
	public Integer getIdZP() {
		return idZP;
	}

	/**
	 * @return
	 */
	public Integer getLeaseContract() {
		return leaseContract;
	}

	/**
	 * @return
	 */
	public Integer getLeaseDopContract() {
		return leaseDopContract;
	}

	/**
	 * @return
	 */
	public BigDecimal getOldSumZP() {
		return oldSumZP;
	}

	/**
	 * @return
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumCharge() {
		return sumCharge;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumNdsZP() {
		return sumNdsZP;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumZP() {
		return sumZP;
	}

	/**
	 * @return
	 */
	public String getTypeActionZP() {
		return typeActionZP;
	}

	/**
	 * @param date
	 */
	public void setDateEndZp(Date date) {
		dateEndZp = date;
	}

	/**
	 * @param date
	 */
	public void setDateStartZP(Date date) {
		dateStartZP = date;
	}

	/**
	 * @param string
	 */
	public void setFlagAddContract(String string) {
		flagAddContract = string;
	}

	/**
	 * @param string
	 */
	public void setFlagAddVendor(String string) {
		flagAddVendor = string;
	}

	/**
	 * @param string
	 */
	public void setFlagAddVendorSite(String string) {
		flagAddVendorSite = string;
	}

	/**
	 * @param integer
	 */
	public void setIdCurrCharge(Integer integer) {
		idCurrCharge = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdOfficeMemo(Integer integer) {
		idOfficeMemo = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdResource(Integer integer) {
		idResource = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdVendorSite(Integer integer) {
		idVendorSite = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdZP(Integer integer) {
		idZP = integer;
	}

	/**
	 * @param integer
	 */
	public void setLeaseContract(Integer integer) {
		leaseContract = integer;
	}

	/**
	 * @param integer
	 */
	public void setLeaseDopContract(Integer integer) {
		leaseDopContract = integer;
	}

	/**
	 * @param decimal
	 */
	public void setOldSumZP(BigDecimal decimal) {
		oldSumZP = decimal;
	}

	/**
	 * @param string
	 */
	public void setReason(String string) {
		reason = string;
	}

	/**
	 * @param decimal
	 */
	public void setSumCharge(BigDecimal decimal) {
		sumCharge = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setSumNdsZP(BigDecimal decimal) {
		sumNdsZP = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setSumZP(BigDecimal decimal) {
		sumZP = decimal;
	}

	/**
	 * @param string
	 */
	public void setTypeActionZP(String string) {
		typeActionZP = string;
	}

	/**
	 * @return
	 */
	public String getRateCalcRule() {
		return rateCalcRule;
	}

	/**
	 * @return
	 */
	public Integer getRateCalcRuleDay() {
		return rateCalcRuleDay;
	}

	/**
	 * @return
	 */
	public BigDecimal getRateDelta() {
		return rateDelta;
	}

	/**
	 * @return
	 */
	public BigDecimal getRateFix() {
		return rateFix;
	}

	/**
	 * @return
	 */
	public BigDecimal getRateNds() {
		return rateNds;
	}

	/**
	 * @param string
	 */
	public void setRateCalcRule(String string) {
		if ("".equals(string)) {
			rateCalcRule = null;
		} else {
			rateCalcRule = string;
		}

	}

	/**
	 * @param integer
	 */
	public void setRateCalcRuleDay(Integer integer) {
		rateCalcRuleDay = integer;
	}

	/**
	 * @param decimal
	 */
	public void setRateDelta(BigDecimal decimal) {
		rateDelta = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setRateFix(BigDecimal decimal) {
		rateFix = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setRateNds(BigDecimal decimal) {
		rateNds = decimal;
	}

}
