/*
 * Created on 14.02.2007
 *
 * �������� ������������� �� ��������� � �������, ����������� � ���� (������������ � �������� ����������)
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;

/**
 * @author IShaffigulin
 *
 * �������� ������������� �� ��������� � �������, ����������� � ���� (������������ � �������� ����������)
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MutualDebtNds_VO {
	//private Integer actCode;//��� ����
	private String customer;//������������ ���������.
	private String executor;//������������ �����������.
	private Integer headerId;//���������� ����� ��������������.
	private BigDecimal sumMain;//�������� ����� ������ � �������� ������.
	private String currMain;//�������� ������ ����.
	/**
	 * 
	 */
	public MutualDebtNds_VO() {
		super();
	}

	/**
	 * @return
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @return
	 */
	public String getExecutor() {
		return executor;
	}

	/**
	 * @param string
	 */
	public void setCustomer(String string) {
		customer = string;
	}

	/**
	 * @param string
	 */
	public void setExecutor(String string) {
		executor = string;
	}

	/**
	 * @return
	 */
	public String getCurrMain() {
		return currMain;
	}

	/**
	 * @return
	 */
	public Integer getHeaderId() {
		return headerId;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumMain() {
		return sumMain;
	}

	/**
	 * @param string
	 */
	public void setCurrMain(String string) {
		currMain = string;
	}

	/**
	 * @param integer
	 */
	public void setHeaderId(Integer integer) {
		headerId = integer;
	}

	/**
	 * @param decimal
	 */
	public void setSumMain(BigDecimal decimal) {
		sumMain = decimal;
	}

}
