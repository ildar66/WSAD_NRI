/*
 * Created on 06.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * Пользователь системы NFS (VO).
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Nfs_Users_VO {
	private Integer personID;//код НФС
	private Integer idUserNFS;
	private String login;//login НФС
	private String fullName;//ФИО пользователя НФС
	private String flagWorkNRI;
	private String recordStatus;

	/**
	 * 
	 */
	public Nfs_Users_VO(Integer aPersonID) {
		personID = aPersonID;
	}

	/**
	 * @return
	 */
	public String getFlagWorkNRI() {
		return flagWorkNRI;
	}

	/**
	 * @return
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @return
	 */
	public Integer getIdUserNFS() {
		return idUserNFS;
	}

	/**
	 * @return
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return
	 */
	public Integer getPersonID() {
		return personID;
	}

	/**
	 * @return
	 */
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @param string
	 */
	public void setFlagWorkNRI(String string) {
		flagWorkNRI = string;
	}

	/**
	 * @param string
	 */
	public void setFullName(String string) {
		fullName = string;
	}

	/**
	 * @param integer
	 */
	public void setIdUserNFS(Integer integer) {
		idUserNFS = integer;
	}

	/**
	 * @param string
	 */
	public void setLogin(String string) {
		login = string;
	}

	/**
	 * @param integer
	 */
	public void setPersonID(Integer integer) {
		personID = integer;
	}

	/**
	 * @param string
	 */
	public void setRecordStatus(String string) {
		recordStatus = string;
	}

}
