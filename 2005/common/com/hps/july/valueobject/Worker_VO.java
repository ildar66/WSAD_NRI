/*
 * Created on 25.04.2006
 *
 * Справочник работников VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * Справочник работников предприятия VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Worker_VO {
	private Integer worker = null; //Идентификатор работника
	private Integer company = null; //Ссылка на предприятие
	private Integer man = null; //Физлицо
	private Integer workPosition = null; //Ссылка на должность
	private Integer division = null; //Ссылка на подразделение
	private String lotusAddress = null; //Адрес lotus
	private String email = null; //Адрес электронной почты
	private String phone1 = null; //Телефон1
	private String phone2 = null; //Телефон2
	private String localPhone = null; //Местный телефон
	private String fax = null; //Факс
	private String mobilePhone = null; //Мобильный телефон
	private String isActive = null; //Признак активности работника
	private String isOur = null; //Признак свой_чужой
	private Integer organization = null; //Ссылка на организацию
	private String isServiceStuff = null; //Признак выездной_не выездной

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
