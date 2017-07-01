/*
 * Created on 18.12.2006
 *
 * "Чем оплачено начисление" VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;

/**
 * @author IShaffigulin
 *
 * "Чем оплачено начисление" VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Dnop_VO {
	private Integer leaseCharge = null; //код начисления
	private Integer leasePayment = null; //код платежа
	private BigDecimal chargeSum = null; //Сумма связи в валюте начисления
	private BigDecimal chargeRurRate = null; //Курс валюты начисления к рублю
	private BigDecimal chargeRurSum = null; //Сумма связи в рублях по курсу начисления
	private BigDecimal payRurSum = null; //Сумма связи в рублях по курсу платежа
	
	private String source = null; //Источник получения:
	public final static String BILLING = "B";//Billing
	public final static String HAND = "H";//Hand
	public final static String AUTO = "A";//Auto

	private Integer act = null; //Акт по которому сформирована запись
	private Integer usedInAct = null; //Акт в котором используется
	private String byHandChrgRateRur = null; //Признак исправления курса вручную(Y/N)
	/**
	 * 
	 */
	public Dnop_VO(Integer aLeaseCharge, Integer aLeasePayment) {
		super();
		leaseCharge = aLeaseCharge; //код начисления
		leasePayment = aLeasePayment; //код платежа
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
	public String getByHandChrgRateRur() {
		return byHandChrgRateRur;
	}

	/**
	 * @return
	 */
	public BigDecimal getChargeRurRate() {
		return chargeRurRate;
	}

	/**
	 * @return
	 */
	public BigDecimal getChargeRurSum() {
		return chargeRurSum;
	}

	/**
	 * @return
	 */
	public BigDecimal getChargeSum() {
		return chargeSum;
	}

	/**
	 * @return
	 */
	public Integer getLeaseCharge() {
		return leaseCharge;
	}

	/**
	 * @return
	 */
	public Integer getLeasePayment() {
		return leasePayment;
	}

	/**
	 * @return
	 */
	public BigDecimal getPayRurSum() {
		return payRurSum;
	}

	/**
	 * @return
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * @return
	 */
	public String getSourceStr() {
		String sourceStr = source;
		if (BILLING.equals(source)) {
			sourceStr = "из биллинга";
		} else if(HAND.equals(source)){
			sourceStr = "в ручную";
		} else if(AUTO.equals(source)){
			sourceStr = "автоматически";			
		}
		return sourceStr;
	}	

	/**
	 * @return
	 */
	public Integer getUsedInAct() {
		return usedInAct;
	}

	/**
	 * @param integer
	 */
	public void setAct(Integer integer) {
		act = integer;
	}

	/**
	 * @param string
	 */
	public void setByHandChrgRateRur(String string) {
		byHandChrgRateRur = string;
	}

	/**
	 * @param BigDecimal
	 */
	public void setChargeRurRate(BigDecimal decimal) {
		chargeRurRate = decimal;
	}

	/**
	 * @param BigDecimal
	 */
	public void setChargeRurSum(BigDecimal decimal) {
		chargeRurSum = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setChargeSum(BigDecimal decimal) {
		chargeSum = decimal;
	}

	/**
	 * @param integer
	 */
	public void setLeaseCharge(Integer integer) {
		leaseCharge = integer;
	}

	/**
	 * @param integer
	 */
	public void setLeasePayment(Integer integer) {
		leasePayment = integer;
	}

	/**
	 * @param BigDecimal
	 */
	public void setPayRurSum(BigDecimal decimal) {
		payRurSum = decimal;
	}

	/**
	 * @param string
	 */
	public void setSource(String string) {
		source = string;
	}

	/**
	 * @param integer
	 */
	public void setUsedInAct(Integer integer) {
		usedInAct = integer;
	}

}
