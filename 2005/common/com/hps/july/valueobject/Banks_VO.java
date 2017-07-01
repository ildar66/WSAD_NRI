/*
 * Created on 21.03.2006
 *
 * ���������� ������ VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * ���������� ������ VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Banks_VO extends DomainObject {
	private Integer idBank = null; //pk
	private String name = null; //������������
	private String bik = null; //���
	private String korAccount = null; //���� ����
	private String legalAddress = null; //����������� �����
	private String swift = null; //��� SWIFT
	private Integer source = null; //�������� ������(1-�� ������� ���; 2-� ������ ������)
	private String recordStatus = null; //������� ���������� ������(A-�������; D-������)

	/**
	 * 
	 */
	public Banks_VO(Integer idBank) {
		super();
		this.idBank = idBank;
	}

	/**
	 * @return
	 */
	public String getBik() {
		return bik;
	}

	/**
	 * @return
	 */
	public Integer getIdBank() {
		return idBank;
	}

	/**
	 * @return
	 */
	public String getKorAccount() {
		return korAccount;
	}

	/**
	 * @return
	 */
	public String getLegalAddress() {
		return legalAddress;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @return
	 */
	public Integer getSource() {
		return source;
	}

	/**
	 * @return
	 */
	public String getSwift() {
		return swift;
	}

	/**
	 * @param string
	 */
	public void setBik(String string) {
		bik = string;
	}

	/**
	 * @param integer
	 */
	public void setIdBank(Integer integer) {
		idBank = integer;
	}

	/**
	 * @param string
	 */
	public void setKorAccount(String string) {
		korAccount = string;
	}

	/**
	 * @param string
	 */
	public void setLegalAddress(String string) {
		legalAddress = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param string
	 */
	public void setRecordStatus(String string) {
		recordStatus = string;
	}

	/**
	 * @param integer
	 */
	public void setSource(Integer integer) {
		source = integer;
	}

	/**
	 * @param string
	 */
	public void setSwift(String string) {
		swift = string;
	}

}
