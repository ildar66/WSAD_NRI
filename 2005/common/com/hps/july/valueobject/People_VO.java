package com.hps.july.valueobject;

import java.util.ArrayList;

/**
 * "Физическое лицо".
 * Creation date: (01.11.2005 12:54:24)
 * @author: Shafigullin Ildar
 */
public class People_VO {
	private java.lang.Integer man; //Уникальный код физического лица
	private java.lang.String firstname; //Имя физического лица
	private java.lang.String lastname; //Фамилия
	private java.lang.String middlename; //Отчество физического лица
	private java.lang.String passportser; //Серия и номер паспорта
	private java.sql.Date passportdate; //Дата выдачи паспорта(null)
	private java.lang.String passportwhom; //Кем выдан паспорт(null)
	private java.lang.String isactive; //Признак активности физ_ лица(Y/N)
	private java.lang.Integer tabnum; //Табельный номер(null)

	private ArrayList workers = null;
	/**
	 * People_VO constructor comment.
	 */
	public People_VO() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 14:17:09)
	 * @param id java.lang.Integer
	 */
	public People_VO(Integer id) {
		man = id;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 12:55:46)
	 * @return java.lang.String
	 */
	public java.lang.String getFirstname() {
		return firstname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:48:56)
	 * @return java.lang.String
	 */
	public java.lang.String getIsactive() {
		return isactive;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 12:55:59)
	 * @return java.lang.String
	 */
	public java.lang.String getLastname() {
		return lastname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 12:55:32)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getMan() {
		return man;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:47:46)
	 * @return java.lang.String
	 */
	public java.lang.String getMiddlename() {
		return middlename;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:48:24)
	 * @return java.sql.Date
	 */
	public java.sql.Date getPassportdate() {
		return passportdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:48:01)
	 * @return java.lang.String
	 */
	public java.lang.String getPassportser() {
		return passportser;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:48:41)
	 * @return java.lang.String
	 */
	public java.lang.String getPassportwhom() {
		return passportwhom;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:49:12)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getTabnum() {
		return tabnum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 12:55:46)
	 * @param newFirstname java.lang.String
	 */
	public void setFirstname(java.lang.String newFirstname) {
		firstname = newFirstname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:48:56)
	 * @param newIsactive java.lang.String
	 */
	public void setIsactive(java.lang.String newIsactive) {
		isactive = newIsactive;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 12:55:59)
	 * @param newLastname java.lang.String
	 */
	public void setLastname(java.lang.String newLastname) {
		lastname = newLastname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 12:55:32)
	 * @param newMan java.lang.Integer
	 */
	public void setMan(java.lang.Integer newMan) {
		man = newMan;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:47:46)
	 * @param newMiddlename java.lang.String
	 */
	public void setMiddlename(java.lang.String newMiddlename) {
		middlename = newMiddlename;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:48:24)
	 * @param newPassportdate java.sql.Date
	 */
	public void setPassportdate(java.sql.Date newPassportdate) {
		passportdate = newPassportdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:48:01)
	 * @param newPassportser java.lang.String
	 */
	public void setPassportser(java.lang.String newPassportser) {
		passportser = newPassportser;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:48:41)
	 * @param newPassportwhom java.lang.String
	 */
	public void setPassportwhom(java.lang.String newPassportwhom) {
		passportwhom = newPassportwhom;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 13:49:12)
	 * @param newTabnum java.lang.Integer
	 */
	public void setTabnum(java.lang.Integer newTabnum) {
		tabnum = newTabnum;
	}
	/**
	 * @return
	 */
	public ArrayList getWorkers() {
		return workers;
	}

	/**
	 * @param list
	 */
	public void setWorkers(ArrayList list) {
		workers = list;
	}
	/**
	 * @return
	 */
	public Worker_TO getFirstWorker() {
		if (getWorkers() != null && getWorkers().size() > 0)
			return (Worker_TO)workers.get(0);
		else
			return null;
	}
}
