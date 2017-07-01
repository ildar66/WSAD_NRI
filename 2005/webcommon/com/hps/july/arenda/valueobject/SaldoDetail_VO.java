/*
 * Created on 20.02.2007
 *
 * "������ ��� ��������� ������" VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * "������ ��� ��������� ������" VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SaldoDetail_VO {
	private Integer idSldDetail = null; //pk
	private Integer leaseContract = null; //��� ��������
	private Date salDate = null; //���� ������
	private Integer resource = null; //������
	private Integer mainCurrency = null; //�������� ������
	private Integer additionalCurrency = null; //��� ������
	private Integer act = null; //���
	private BigDecimal mainSum = null; //����� (� ���) � �������� ������
	private BigDecimal mainNdsSum = null; //����� ��� � �������� ������
	private BigDecimal additionalSum = null; //����� (� ���) � ��� ������
	private BigDecimal additionalNdsSum = null; //����� ��� � �������� ������1
	private BigDecimal rateNds = null; //������ ���
	private Integer groupRec = null; //��� �� ���� ������������
	private String saldoByHand = null; //������� ������ ��������� ������
	private String notes = null; //������� ��������� ������
	private BigDecimal mSumCalc = null; //������ ����� ������ � ������ 1 (�� �������)
	private BigDecimal mNdsCalc = null; //��� ������ � ������ 1 (�� �������)
	private BigDecimal aSumCalc = null; //������ ����� ������ � ������ 2 (�� �������)
	private BigDecimal aNdsCalc = null; //��� ������ � ������ 2 (�� �������)
	private Integer operator = null; //��� ����� ������ �������

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
