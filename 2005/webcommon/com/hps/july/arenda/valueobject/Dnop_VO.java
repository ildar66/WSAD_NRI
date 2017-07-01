/*
 * Created on 18.12.2006
 *
 * "��� �������� ����������" VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;

/**
 * @author IShaffigulin
 *
 * "��� �������� ����������" VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Dnop_VO {
	private Integer leaseCharge = null; //��� ����������
	private Integer leasePayment = null; //��� �������
	private BigDecimal chargeSum = null; //����� ����� � ������ ����������
	private BigDecimal chargeRurRate = null; //���� ������ ���������� � �����
	private BigDecimal chargeRurSum = null; //����� ����� � ������ �� ����� ����������
	private BigDecimal payRurSum = null; //����� ����� � ������ �� ����� �������
	
	private String source = null; //�������� ���������:
	public final static String BILLING = "B";//Billing
	public final static String HAND = "H";//Hand
	public final static String AUTO = "A";//Auto

	private Integer act = null; //��� �� �������� ������������ ������
	private Integer usedInAct = null; //��� � ������� ������������
	private String byHandChrgRateRur = null; //������� ����������� ����� �������(Y/N)
	/**
	 * 
	 */
	public Dnop_VO(Integer aLeaseCharge, Integer aLeasePayment) {
		super();
		leaseCharge = aLeaseCharge; //��� ����������
		leasePayment = aLeasePayment; //��� �������
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
			sourceStr = "�� ��������";
		} else if(HAND.equals(source)){
			sourceStr = "� ������";
		} else if(AUTO.equals(source)){
			sourceStr = "�������������";			
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
