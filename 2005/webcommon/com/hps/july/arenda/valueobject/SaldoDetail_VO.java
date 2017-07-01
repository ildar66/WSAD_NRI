/*
 * Created on 20.02.2007
 *
 * "Сальдо для договоров аренды" VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * "Сальдо для договоров аренды" VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SaldoDetail_VO {
	private Integer idSldDetail = null; //pk
	private Integer leaseContract = null; //код договора
	private Date salDate = null; //дата сальдо
	private Integer resource = null; //услуга
	private Integer mainCurrency = null; //Основная валюта
	private Integer additionalCurrency = null; //Доп валюта
	private Integer act = null; //акт
	private BigDecimal mainSum = null; //Сумма (с НДС) в основной валюте
	private BigDecimal mainNdsSum = null; //Сумма НДС в основной валюте
	private BigDecimal additionalSum = null; //Сумма (с НДС) в доп валюте
	private BigDecimal additionalNdsSum = null; //Сумма НДС в основной валюте1
	private BigDecimal rateNds = null; //ставка НДС
	private Integer groupRec = null; //НДС по акту взаимозачета
	private String saldoByHand = null; //Признак ручной установки сальдо
	private String notes = null; //Причина изменения сальдо
	private BigDecimal mSumCalc = null; //старая сумма сальдо в валюте 1 (по расчету)
	private BigDecimal mNdsCalc = null; //НДС сальдо в валюте 1 (по расчету)
	private BigDecimal aSumCalc = null; //старая сумма сальдо в валюте 2 (по расчету)
	private BigDecimal aNdsCalc = null; //НДС сальдо в валюте 2 (по расчету)
	private Integer operator = null; //Кто менял сальдо вручную

	/**
	 * 
	 */
	public SaldoDetail_VO(Integer aIdSldDetail) {
		super();
		setIdSldDetail(aIdSldDetail);
	}

	/**
	 * @return
	 */
	public BigDecimal getAdditionalNdsSum() {
		return additionalNdsSum;
	}

	/**
	 * @return
	 */
	public BigDecimal getAdditionalSum() {
		return additionalSum;
	}

	/**
	 * @return
	 */
	public BigDecimal getANdsCalc() {
		return aNdsCalc;
	}

	/**
	 * @return
	 */
	public BigDecimal getASumCalc() {
		return aSumCalc;
	}

	/**
	 * @return
	 */
	public Integer getGroupRec() {
		return groupRec;
	}

	/**
	 * @return
	 */
	public Integer getIdSldDetail() {
		return idSldDetail;
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
	public BigDecimal getMainNdsSum() {
		return mainNdsSum;
	}

	/**
	 * @return
	 */
	public BigDecimal getMainSum() {
		return mainSum;
	}

	/**
	 * @return
	 */
	public BigDecimal getMNdsCalc() {
		return mNdsCalc;
	}

	/**
	 * @return
	 */
	public BigDecimal getMSumCalc() {
		return mSumCalc;
	}

	/**
	 * @return
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @return
	 */
	public Integer getOperator() {
		return operator;
	}

	/**
	 * @return
	 */
	public BigDecimal getRateNds() {
		return rateNds;
	}

	/**
	 * @return
	 */
	public Integer getResource() {
		return resource;
	}

	/**
	 * @return
	 */
	public Date getSalDate() {
		return salDate;
	}

	/**
	 * @return
	 */
	public String getSaldoByHand() {
		return saldoByHand;
	}

	/**
	 * @param decimal
	 */
	public void setAdditionalNdsSum(BigDecimal decimal) {
		additionalNdsSum = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setAdditionalSum(BigDecimal decimal) {
		additionalSum = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setANdsCalc(BigDecimal decimal) {
		aNdsCalc = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setASumCalc(BigDecimal decimal) {
		aSumCalc = decimal;
	}

	/**
	 * @param integer
	 */
	public void setGroupRec(Integer integer) {
		groupRec = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdSldDetail(Integer integer) {
		idSldDetail = integer;
	}

	/**
	 * @param integer
	 */
	public void setLeaseContract(Integer integer) {
		leaseContract = integer;
	}

	/**
	 * @param decimal
	 */
	public void setMainNdsSum(BigDecimal decimal) {
		mainNdsSum = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setMainSum(BigDecimal decimal) {
		mainSum = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setMNdsCalc(BigDecimal decimal) {
		mNdsCalc = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setMSumCalc(BigDecimal decimal) {
		mSumCalc = decimal;
	}

	/**
	 * @param string
	 */
	public void setNotes(String string) {
		notes = string;
	}

	/**
	 * @param integer
	 */
	public void setOperator(Integer integer) {
		operator = integer;
	}

	/**
	 * @param decimal
	 */
	public void setRateNds(BigDecimal decimal) {
		rateNds = decimal;
	}

	/**
	 * @param integer
	 */
	public void setResource(Integer integer) {
		resource = integer;
	}

	/**
	 * @param date
	 */
	public void setSalDate(Date date) {
		salDate = date;
	}

	/**
	 * @param string
	 */
	public void setSaldoByHand(String string) {
		saldoByHand = string;
	}

	/**
	 * @return
	 */
	public Integer getMainCurrency() {
		return mainCurrency;
	}

	/**
	 * @param integer
	 */
	public void setMainCurrency(Integer integer) {
		mainCurrency = integer;
	}

	/**
	 * @return
	 */
	public Integer getAct() {
		return act;
	}

	/**
	 * @return
	 */
	public Integer getAdditionalCurrency() {
		return additionalCurrency;
	}

	/**
	 * @param integer
	 */
	public void setAct(Integer integer) {
		act = integer;
	}

	/**
	 * @param integer
	 */
	public void setAdditionalCurrency(Integer integer) {
		additionalCurrency = integer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "SaldoDetail_VO: LeaseContract="
			+ getLeaseContract()
			+ "; SalDate="
			+ getSalDate()
			+ "; Resource="
			+ getResource()
			+ "; IdSldDetail="
			+ getIdSldDetail()
			+ "\n; MainCurrency="
			+ getMainCurrency()
			+ "; MainSum="
			+ getMainSum()
			+ "; MainNdsSum="
			+ getMainNdsSum()
			+ "; AdditionalCurrency="
			+ getAdditionalCurrency()
			+ "\n; AdditionalSum="
			+ getAdditionalSum()
			+ "; AdditionalNdsSum="
			+ getAdditionalNdsSum()
			+ "; RateNds="
			+ getRateNds()
			+ "; GroupRec="
			+ getGroupRec()
			+ "\n; Operator="
			+ getOperator()
			+ "; Act="
			+ getAct()
			+ "; SaldoByHand="
			+ getSaldoByHand();
	}

}
