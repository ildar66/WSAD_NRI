package com.hps.july.arenda.valueobject;

/**
 * Bean-Wrapper "Пользователь"
 * Creation date: (10.02.2003 18:34:00)
 * @author: Sergey Gourov
 */
public class CustomerValueObject {
	private java.lang.String name;
	private java.lang.Integer organization;
	/**
	 * CustomerValueObject constructor comment.
	 */
	public CustomerValueObject() {
		super();
	}
	/**
	 * CustomerValueObject constructor comment.
	 */
	public CustomerValueObject(Integer aOrganization, String aName) {
		super();
		setOrganization(aOrganization);
		setName(aName);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.02.2003 18:36:14)
	 * @return java.lang.String
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.02.2003 18:49:38)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getOrganization() {
		return organization;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.02.2003 18:36:14)
	 * @param newName java.lang.String
	 */
	public void setName(java.lang.String newName) {
		name = newName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.02.2003 18:49:38)
	 * @param newOrganization java.lang.Integer
	 */
	public void setOrganization(java.lang.Integer newOrganization) {
		organization = newOrganization;
	}
}
