package com.hps.july.arenda.valueobject;

import java.sql.*;
/**
 * Заголовок счет-фактуры.
 * Creation date: (27.04.2004 11:36:33)
 * @author: Shafigullin Ildar
 */
public class SchetFactHeaderValueObject {
	private java.lang.String numberSchetFakt;
	private Date dateSchetFakt;
	private java.lang.String baseDocNumber;
	private java.sql.Date baseDocDate;
	private java.lang.String nameAddrSender;
	private java.lang.String nameAddrRecipient;
	private java.lang.String nameSeller;
	private java.lang.String nameBuyer;
	private java.lang.String addressSeller;
	private java.lang.String addressBuyer;
	private java.lang.String innSeller;
	private java.lang.String innBuyer;
	private java.lang.String nameManager;
	private java.lang.String nameBugalter;
	private java.lang.String namePosition;
	private String currencyName;
	/**
	 * SchetFactHeaderValueObject constructor comment.
	 */
	public SchetFactHeaderValueObject() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:47:01)
	 * @return java.lang.String
	 */
	public java.lang.String getAddressBuyer() {
		return addressBuyer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:46:38)
	 * @return java.lang.String
	 */
	public java.lang.String getAddressSeller() {
		return addressSeller;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:43:29)
	 * @return java.sql.Date
	 */
	public java.sql.Date getBaseDocDate() {
		return baseDocDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:43:06)
	 * @return java.lang.String
	 */
	public java.lang.String getBaseDocNumber() {
		return baseDocNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:41:43)
	 * @return java.sql.Date
	 */
	public Date getDateSchetFakt() {
		return dateSchetFakt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:47:57)
	 * @return java.lang.String
	 */
	public java.lang.String getInnBuyer() {
		return innBuyer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:47:29)
	 * @return java.lang.String
	 */
	public java.lang.String getInnSeller() {
		return innSeller;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:44:13)
	 * @return java.lang.String
	 */
	public java.lang.String getNameAddrRecipient() {
		return nameAddrRecipient;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:43:55)
	 * @return java.lang.String
	 */
	public java.lang.String getNameAddrSender() {
		return nameAddrSender;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:48:41)
	 * @return java.lang.String
	 */
	public java.lang.String getNameBugalter() {
		return nameBugalter;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:45:08)
	 * @return java.lang.String
	 */
	public java.lang.String getNameBuyer() {
		return nameBuyer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:48:19)
	 * @return java.lang.String
	 */
	public java.lang.String getNameManager() {
		return nameManager;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:49:08)
	 * @return java.lang.String
	 */
	public java.lang.String getNamePosition() {
		return namePosition;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:44:39)
	 * @return java.lang.String
	 */
	public java.lang.String getNameSeller() {
		return nameSeller;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:40:36)
	 * @return java.lang.String
	 */
	public java.lang.String getNumberSchetFakt() {
		return numberSchetFakt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:47:01)
	 * @param newAddressBuyer java.lang.String
	 */
	public void setAddressBuyer(java.lang.String newAddressBuyer) {
		addressBuyer = newAddressBuyer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:46:38)
	 * @param newAddressSeller java.lang.String
	 */
	public void setAddressSeller(java.lang.String newAddressSeller) {
		addressSeller = newAddressSeller;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:43:29)
	 * @param newBaseDocDate java.sql.Date
	 */
	public void setBaseDocDate(java.sql.Date newBaseDocDate) {
		baseDocDate = newBaseDocDate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:43:06)
	 * @param newBaseDocNumber java.lang.String
	 */
	public void setBaseDocNumber(java.lang.String newBaseDocNumber) {
		baseDocNumber = newBaseDocNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:41:43)
	 * @param newDateSchetFakt java.sql.Date
	 */
	public void setDateSchetFakt(Date newDateSchetFakt) {
		dateSchetFakt = newDateSchetFakt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:47:57)
	 * @param newInnBuyer java.lang.String
	 */
	public void setInnBuyer(java.lang.String newInnBuyer) {
		innBuyer = newInnBuyer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:47:29)
	 * @param newInnSeller java.lang.String
	 */
	public void setInnSeller(java.lang.String newInnSeller) {
		innSeller = newInnSeller;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:44:13)
	 * @param newNameAddrRecipient java.lang.String
	 */
	public void setNameAddrRecipient(java.lang.String newNameAddrRecipient) {
		nameAddrRecipient = newNameAddrRecipient;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:43:55)
	 * @param newNameAddrSender java.lang.String
	 */
	public void setNameAddrSender(java.lang.String newNameAddrSender) {
		nameAddrSender = newNameAddrSender;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:48:41)
	 * @param newNameBugalter java.lang.String
	 */
	public void setNameBugalter(java.lang.String newNameBugalter) {
		nameBugalter = newNameBugalter;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:45:08)
	 * @param newNameBuyer java.lang.String
	 */
	public void setNameBuyer(java.lang.String newNameBuyer) {
		nameBuyer = newNameBuyer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:48:19)
	 * @param newNameManager java.lang.String
	 */
	public void setNameManager(java.lang.String newNameManager) {
		nameManager = newNameManager;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:49:08)
	 * @param newNamePosition java.lang.String
	 */
	public void setNamePosition(java.lang.String newNamePosition) {
		namePosition = newNamePosition;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:44:39)
	 * @param newNameSeller java.lang.String
	 */
	public void setNameSeller(java.lang.String newNameSeller) {
		nameSeller = newNameSeller;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.04.2004 11:40:36)
	 * @param newNumberSchetFakt java.lang.String
	 */
	public void setNumberSchetFakt(java.lang.String newNumberSchetFakt) {
		numberSchetFakt = newNumberSchetFakt;
	}
	/**
	 * Returns a String that represents the value of this object.
	 * @return a string representation of the receiver
	 */
	public String toString() {
		// Insert code to print the receiver here.
		// This implementation forwards the message to super. You may replace or supplement this.
		return super.toString();
	}
	/**
	 * @return
	 */
	public String getCurrencyName() {
		return currencyName;
	}

	/**
	 * @param string
	 */
	public void setCurrencyName(String string) {
		currencyName = string;
	}

}
