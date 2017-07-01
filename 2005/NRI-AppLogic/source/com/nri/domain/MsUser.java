/*
 * Created on 02.08.2007
 *
 * NriObject Пользователи MicroStrategy.
 */
package com.nri.domain;

/**
 * @author IShaffigulin
 *
 * NriObject Пользователи MicroStrategy.
 */
public class MsUser extends NriObject {
	private Integer msuCode = null; //Код
	private String msUser = null; //Имя пользователя
	private String msPassword = null; //Пароль 
	/**
	 * 
	 */
	public MsUser() {
		super();
	}

	/**
	 * 
	 */
	public MsUser(Integer aCode) {
		super();
		setMsuCode(aCode);
	}

	/**
	 * @return
	 */
	public String getMsPassword() {
		return msPassword;
	}

	/**
	 * @return
	 */
	public Integer getMsuCode() {
		return msuCode;
	}

	/**
	 * @return
	 */
	public String getMsUser() {
		return msUser;
	}

	/**
	 * @param string
	 */
	public void setMsPassword(String string) {
		msPassword = string;
	}

	/**
	 * @param integer
	 */
	public void setMsuCode(Integer integer) {
		msuCode = integer;
	}

	/**
	 * @param string
	 */
	public void setMsUser(String string) {
		msUser = string;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object anObject) {
		if (anObject == null) {
			return false;
		}
		if (!(anObject instanceof MsUser)) {
			return false;
		}
		MsUser aMsUser = (MsUser) anObject;
		return aMsUser.getMsuCode().intValue() == getMsuCode().intValue();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("MsUser: ");
		sb.append(getMsuCode() + "(" + getMsUser() + ")");
		//sb.append('\n');
		//sb.append(" IsActive: ");
		//sb.append(getIsActive());

		return sb.toString();
	}

}
