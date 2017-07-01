/*
 * Created on 26.07.2006
 *
 * Получатель MAIL
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * Получатель MAIL
 */
public class MailRecipient_VO {
	private Integer man;
	private String name;
	private String mail;

	/**
	 * 
	 */
	public MailRecipient_VO(Integer aMan, String aName, String aMail) {
		super();
		setMan(aMan);
		setName(aName);
		setMail(aMail);
	}

	/**
	 * @return
	 */
	public String getMail() {
		return mail;
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
	public String getName() {
		return name;
	}

	/**
	 * @param string
	 */
	public void setMail(String string) {
		mail = string;
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
	public void setName(String string) {
		name = string;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "recipient[man=" + getMan() + " name=" + getName() + " mail=" + getMail() + "]";
	}

}
