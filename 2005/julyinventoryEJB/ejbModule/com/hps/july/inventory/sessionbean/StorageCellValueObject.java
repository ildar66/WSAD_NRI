package com.hps.july.inventory.sessionbean;

/**
 * Insert the type's description here.
 * Creation date: (15.06.2002 13:52:14)
 * @author: Oleg Gashnikov
 */
public class StorageCellValueObject {
	private int resource;
	private java.lang.String policy;
	private java.lang.String serial;
	private java.lang.String party;
	private boolean broken;
	private boolean boxed;
	private java.math.BigDecimal qty;
	private java.math.BigDecimal price;
	private int storageCard;
	private int owner;
	private java.lang.String configuration;
	private java.lang.String place;
	private java.lang.Integer realposition;
	private java.lang.Integer virtposition;
	private java.lang.String manufserial;
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 14:56:10)
 */
public StorageCellValueObject() {}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 14:52:22)
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception java.lang.Exception The exception description.
 */
public StorageCellValueObject(com.hps.july.persistence.DocumentPositionAccessBean position) throws java.lang.Exception {
	resource		= position.getResourceKey().resource;
	policy			= position.getResource().getCountpolicy();
	serial			= position.getSerialnumber();
	party			= position.getParty();	
	broken			= position.getResultBroken().booleanValue();
	boxed			= position.getResultBoxed().booleanValue();
	qty				= position.getQty();
	price			= position.getPrice();
	owner			= position.getOwnerKey().organization;
	configuration	= position.getConfiguration();
	place			= position.getNewplace();
	realposition	= new Integer(position.getDocposition());
	manufserial		= position.getManufserial();
	}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 14:42:17)
 * @param sCard com.hps.july.persistence.StorageCardAccessBean
 */
public StorageCellValueObject(com.hps.july.persistence.StorageCardAccessBean sCard) throws Exception {
	resource		= sCard.getResourceKey().resource;
	policy			= sCard.getPolicy();
	serial			= sCard.getSerialnumber();
	party			= sCard.getParty();	
	broken			= sCard.getBroken().booleanValue();
	boxed			= sCard.getBoxed().booleanValue();
	qty				= sCard.getQty();
	price			= sCard.getPrice();
	storageCard		= sCard.getStoragecard();
	owner			= sCard.getOwnerKey().organization;
	configuration	= sCard.getConfiguration();
	place			= sCard.getPlace();
	manufserial		= sCard.getManufserial();
	}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 14:50:34)
 * @param sCard com.hps.july.persistence.StorageCardAccessBean
 * @param price java.math.BigDecimal
 * @exception java.lang.Exception The exception description.
 */
public StorageCellValueObject(com.hps.july.persistence.StorageCardAccessBean sCard, java.math.BigDecimal price) throws java.lang.Exception {
	this( sCard );
	this.qty = price;
	}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2002 12:10:15)
 * @return java.lang.String
 */
public java.lang.String getConfiguration() {
	return configuration;
}
/**
 * Insert the method's description here.
 * Creation date: (20.03.2003 11:06:33)
 * @return java.lang.String
 */
public java.lang.String getManufserial() {
	return manufserial;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 14:21:46)
 * @return int
 */
public int getOwner() {
	return owner;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:55:26)
 * @return java.lang.String
 */
public java.lang.String getParty() {
	return party;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2002 16:31:21)
 * @return java.lang.String
 */
public java.lang.String getPlace() {
	return place;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:54:18)
 * @return java.lang.String
 */
public java.lang.String getPolicy() {
	return policy;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:58:28)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPrice() {
	return price;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:57:23)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getQty() {
	return qty;
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 16:03:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getRealposition() {
	return realposition;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:53:32)
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:55:07)
 * @return java.lang.String
 */
public java.lang.String getSerial() {
	return serial;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:59:31)
 * @return int
 */
public int getStorageCard() {
	return storageCard;
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 16:04:11)
 * @return java.lang.Integer
 */
public java.lang.Integer getVirtposition() {
	return virtposition;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:56:43)
 * @return boolean
 */
public boolean isBoxed() {
	return boxed;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:56:20)
 * @return boolean
 */
public boolean isBroken() {
	return broken;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:56:43)
 * @param newBoxed boolean
 */
public void setBoxed(boolean newBoxed) {
	boxed = newBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:56:20)
 * @param newBroken boolean
 */
public void setBroken(boolean newBroken) {
	broken = newBroken;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2002 12:10:15)
 * @param newConfiguration java.lang.String
 */
public void setConfiguration(java.lang.String newConfiguration) {
	configuration = newConfiguration;
}
/**
 * Insert the method's description here.
 * Creation date: (20.03.2003 11:06:33)
 * @param newManufserial java.lang.String
 */
public void setManufserial(java.lang.String newManufserial) {
	manufserial = newManufserial;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 14:21:46)
 * @param newOwner int
 */
public void setOwner(int newOwner) {
	owner = newOwner;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:55:26)
 * @param newParty java.lang.String
 */
public void setParty(java.lang.String newParty) {
	party = newParty;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2002 16:31:21)
 * @param newPlace java.lang.String
 */
public void setPlace(java.lang.String newPlace) {
	place = newPlace;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:54:18)
 * @param newPolicy java.lang.String
 */
public void setPolicy(java.lang.String newPolicy) {
	policy = newPolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:58:28)
 * @param newPrice java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newPrice) {
	price = newPrice;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:57:23)
 * @param newQty java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newQty) {
	qty = newQty;
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 16:03:38)
 * @param newRealposition java.lang.Integer
 */
public void setRealposition(java.lang.Integer newRealposition) {
	realposition = newRealposition;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:53:32)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:55:07)
 * @param newSerial java.lang.String
 */
public void setSerial(java.lang.String newSerial) {
	serial = newSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:59:31)
 * @param newStorageCard int
 */
public void setStorageCard(int newStorageCard) {
	storageCard = newStorageCard;
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 16:04:12)
 * @param newVirtposition java.lang.Integer
 */
public void setVirtposition(java.lang.Integer newVirtposition) {
	virtposition = newVirtposition;
}
}
