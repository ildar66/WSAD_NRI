/*
 * Created on 17.07.2007
 *
 * NriObject ���������� ����.
 */
package com.nri.domain;

import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * NriObject ���������� ����.
 */
public class People extends NriObject {
	private Integer man = null; //�������
	private String firstName = null; //��� ����������� ����
	private String lastName = null; //�������
	private String middleName = null; //�������� ����������� ����
	private String passportSer = null; //�������
	private Date passportDate = null; //���� ������ ��������
	private String passportWhom = null; //��� ����� �������
	private Boolean isActive = null; //������� ���������� ���_ ����
	private Integer tabNum = null; //��������� �����

	/**
	 * 
	 */
	public People() {
		super();
	}

	/**
	 * 
	 */
	public People(Integer aMan) {
		super();
		man = aMan;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return 
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return
	 */
	public Date getPassportDate() {
		return passportDate;
	}

	/**
	 * @return
	 */
	public String getPassportSer() {
		return passportSer;
	}

	/**
	 * @return
	 */
	public String getPassportWhom() {
		return passportWhom;
	}

	/**
	 * @return
	 */
	public Integer getTabNum() {
		return tabNum;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param boolean1
	 */
	public void setIsActive(Boolean boolean1) {
		isActive = boolean1;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param string
	 */
	public void setMiddleName(String string) {
		middleName = string;
	}

	/**
	 * @param date
	 */
	public void setPassportDate(Date date) {
		passportDate = date;
	}

	/**
	 * @param string
	 */
	public void setPassportSer(String string) {
		passportSer = string;
	}

	/**
	 * @param string
	 */
	public void setPassportWhom(String string) {
		passportWhom = string;
	}

	/**
	 * @param integer
	 */
	public void setTabNum(Integer integer) {
		tabNum = integer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object anObject) {
		if (anObject == null) {
			return false;
		}
		if (!(anObject instanceof People)) {
			return false;
		}
		People anPeople = (People) anObject;
		return anPeople.getMan().equals(getMan());
	}

	/**
	 * @return
	 */
	public Integer getMan() {
		return man;
	}

	/**
	 * @param integer
	 */
	public void setMan(Integer integer) {
		man = integer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("People: ");
		sb.append(getLastName() + " " + getFirstName());
		//sb.append('\n');
		sb.append(" IsActive: ");
		sb.append(getIsActive());

		return sb.toString();
	}

}
