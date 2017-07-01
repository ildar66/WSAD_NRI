/*
 * Created on 13.04.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * ���������� ��������� ������ ����������� VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Accounts_VO extends DomainObject {
	private Integer accountId = null; //���� pk
	private Integer bank = null; //����(������)
	private Integer idVendorSite = null; //��������� ����������(������)
	private String account = null; //����� �����
	private Boolean active = null; //������� ����������
	/**
	 * 
	 */
	public Accounts_VO(Integer argAccountId) {
		super();
		accountId = argAccountId;
	}

	/**
	 * @return
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @return
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * @return
	 */
	public Boolean isActive() {
		return active;
	}

	/**
	 * @return
	 */
	public Integer getBank() {
		return bank;
	}

	/**
	 * @return
	 */
	public Integer getIdVendorSite() {
		return idVendorSite;
	}

	/**
	 * @param string
	 */
	public void setAccount(String string) {
		account = string;
	}

	/**
	 * @param integer
	 */
	public void setAccountId(Integer integer) {
		accountId = integer;
	}

	/**
	 * @param b
	 */
	public void setActive(Boolean b) {
		active = b;
	}

	/**
	 * @param integer
	 */
	public void setBank(Integer integer) {
		bank = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdVendorSite(Integer integer) {
		idVendorSite = integer;
	}

	/**
	 * @return
	 */
	public Boolean getActive() {
		return active;
	}

}
