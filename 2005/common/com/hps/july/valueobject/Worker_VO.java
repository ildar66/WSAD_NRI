/*
 * Created on 25.04.2006
 *
 * ���������� ���������� VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * ���������� ���������� ����������� VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Worker_VO {
	private Integer worker = null; //������������� ���������
	private Integer company = null; //������ �� �����������
	private Integer man = null; //�������
	private Integer workPosition = null; //������ �� ���������
	private Integer division = null; //������ �� �������������
	private String lotusAddress = null; //����� lotus
	private String email = null; //����� ����������� �����
	private String phone1 = null; //�������1
	private String phone2 = null; //�������2
	private String localPhone = null; //������� �������
	private String fax = null; //����
	private String mobilePhone = null; //��������� �������
	private String isActive = null; //������� ���������� ���������
	private String isOur = null; //������� ����_�����
	private Integer organization = null; //������ �� �����������
	private String isServiceStuff = null; //������� ��������_�� ��������

	/**
	 * 
	 */
	public Worker_VO(Integer workerID) {
		super();
		worker = workerID;
	}

	/**
	 * @return
	 */
	public Integer getCompany() {
		return company;
	}

	/**
	 * @return
	 */
	public Integer getDivision() {
		return division;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @return
	 */
	public String getIsActive() {
		return isActive;
	}

	/**
	 * @return
	 */
	public String getIsOur() {
		return isOur;
	}

	/**
	 * @return
	 */
	public String getIsServiceStuff() {
		return isServiceStuff;
	}

	/**
	 * @return
	 */
	public String getLocalPhone() {
		return localPhone;
	}

	/**
	 * @return
	 */
	public String getLotusAddress() {
		return lotusAddress;
	}

	/**
	 * @return
	 */
	public Integer getMan() {
		return man;
	}

	/**
	 * @return
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @return
	 */
	public Integer getOrganization() {
		return organization;
	}

	/**
	 * @return
	 */
	public String getPhone1() {
		return phone1;
	}

	/**
	 * @return
	 */
	public String getPhone2() {
		return phone2;
	}

	/**
	 * @return
	 */
	public Integer getWorker() {
		return worker;
	}

	/**
	 * @return
	 */
	public Integer getWorkPosition() {
		return workPosition;
	}

	/**
	 * @param integer
	 */
	public void setCompany(Integer integer) {
		company = integer;
	}

	/**
	 * @param integer
	 */
	public void setDivision(Integer integer) {
		division = integer;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string
	 */
	public void setFax(String string) {
		fax = string;
	}

	/**
	 * @param string
	 */
	public void setIsActive(String string) {
		isActive = string;
	}

	/**
	 * @param string
	 */
	public void setIsOur(String string) {
		isOur = string;
	}

	/**
	 * @param string
	 */
	public void setIsServiceStuff(String string) {
		isServiceStuff = string;
	}

	/**
	 * @param string
	 */
	public void setLocalPhone(String string) {
		localPhone = string;
	}

	/**
	 * @param string
	 */
	public void setLotusAddress(String string) {
		lotusAddress = string;
	}

	/**
	 * @param integer
	 */
	public void setMan(Integer integer) {
		man = integer;
	}

	/**
	 * @param string
	 */
	public void setMobilePhone(String string) {
		mobilePhone = string;
	}

	/**
	 * @param integer
	 */
	public void setOrganization(Integer integer) {
		organization = integer;
	}

	/**
	 * @param string
	 */
	public void setPhone1(String string) {
		phone1 = string;
	}

	/**
	 * @param string
	 */
	public void setPhone2(String string) {
		phone2 = string;
	}

	/**
	 * @param integer
	 */
	public void setWorker(Integer integer) {
		worker = integer;
	}

	/**
	 * @param integer
	 */
	public void setWorkPosition(Integer integer) {
		workPosition = integer;
	}

}
