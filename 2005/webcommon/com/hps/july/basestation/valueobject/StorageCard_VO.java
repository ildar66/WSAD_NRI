package com.hps.july.basestation.valueobject;

import  java.sql.Date;
/**
 * Карточки хранения учетных единиц VO.
 * Creation date: (25.07.2005 15:11:34)
 * @author: Shafigullin Ildar
 */
public class StorageCard_VO {
    /**
    	Таблица содержит перечень карточек хранения. Карточка хранения соответствует: 
    - для ресурсов, учитываемых серийно - отдельной учетной единице;
    - для ресурсов, учитываемых по партиям -  отдельной партии, находящейся в месте хранения;
    - для ресурсов, учитываемых количественно - всему количеству ресурса, находящемуся в месте хранения.
    */
	private java.lang.Integer storagecard;//Идентификатор карточки хранения
	private java.lang.Integer resource;//Ссылка на ресурс
	private java.sql.Date dateopened;//Дата открытия карточки хранения
	private java.lang.Integer owner;//Ссылка на владельца
	private java.lang.String policy;//Политика учета(S-Серийный, P-По партиям, B-Обычный/Количественный)
	private java.lang.String closed;//Признак карточка закрыта(Y-да,N-нет)
	public java.math.BigDecimal qty;//Количество ресурса
	private java.math.BigDecimal price;//Цена
	private java.lang.String boxed;//Упакована (для серийного учета)(Y-да,N-нет)
	private java.lang.Integer document;//Ссылка на последний документ по которому перемещалась карточка
	private java.lang.String broken;//Сломано (для серийного учета)(Y-да,N-нет).
	private java.lang.Integer storageplace;//Ссылка на место хранения
	private java.lang.Integer contract;//По какому контракту поступило
	private java.sql.Date dateclosed;//Дата закрытия карточки хранения
	private java.sql.Date i13ndate;//Дата последней инвентаризации
	private java.lang.String serialnumber;//Серийный номер
	private java.lang.String party;//Номер партии
	private java.math.BigDecimal qty_broken;//Количество сломано (для несерийного учета))
	private java.lang.String notes;//Примечания
	private java.lang.String configuration;//Технологическая конфигурация
	private java.lang.String place;//Посадочное место
	private java.lang.String manufserial;//Сер_ номер производителя
	private java.lang.String comment;//Комментарий
	private java.lang.String isfictserial;//Признак фиктивного серийного номера(Y-да,N-нет).
/**
 * StorageCard_VO constructor comment.
 */
public StorageCard_VO(Integer aStoragecard) {
	super();
	storagecard = aStoragecard;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:22:16)
 * @return java.lang.String
 */
public java.lang.String getBoxed() {
	return boxed;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:23:34)
 * @return java.lang.String
 */
public java.lang.String getBroken() {
	return broken;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:20:02)
 * @return java.lang.String
 */
public java.lang.String getClosed() {
	return closed;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:30:10)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:28:57)
 * @return java.lang.String
 */
public java.lang.String getConfiguration() {
	return configuration;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:25:02)
 * @return java.lang.Integer
 */
public java.lang.Integer getContract() {
	return contract;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:26:01)
 * @return java.sql.Date
 */
public java.sql.Date getDateclosed() {
	return dateclosed;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:17:36)
 * @return java.sql.Date
 */
public java.sql.Date getDateopened() {
	return dateopened;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:23:03)
 * @return java.lang.Integer
 */
public java.lang.Integer getDocument() {
	return document;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:26:30)
 * @return java.sql.Date
 */
public java.sql.Date getI13ndate() {
	return i13ndate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:30:38)
 * @return java.lang.String
 */
public java.lang.String getIsfictserial() {
	return isfictserial;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:29:47)
 * @return java.lang.String
 */
public java.lang.String getManufserial() {
	return manufserial;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:28:24)
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:18:15)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwner() {
	return owner;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:27:28)
 * @return java.lang.String
 */
public java.lang.String getParty() {
	return party;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:29:26)
 * @return java.lang.String
 */
public java.lang.String getPlace() {
	return place;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:18:49)
 * @return java.lang.String
 */
public java.lang.String getPolicy() {
	return policy;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:21:47)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPrice() {
	return price;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:21:25)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getQty() {
	return qty;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:28:01)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getQty_broken() {
	return qty_broken;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:16:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:26:57)
 * @return java.lang.String
 */
public java.lang.String getSerialnumber() {
	return serialnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:16:33)
 * @return java.lang.Integer
 */
public java.lang.Integer getStoragecard() {
	return storagecard;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:24:31)
 * @return java.lang.Integer
 */
public java.lang.Integer getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:22:16)
 * @param newBoxed java.lang.String
 */
public void setBoxed(java.lang.String newBoxed) {
	boxed = newBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:23:34)
 * @param newBroken java.lang.String
 */
public void setBroken(java.lang.String newBroken) {
	broken = newBroken;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:20:02)
 * @param newClosed java.lang.String
 */
public void setClosed(java.lang.String newClosed) {
	closed = newClosed;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:30:10)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:28:57)
 * @param newConfiguration java.lang.String
 */
public void setConfiguration(java.lang.String newConfiguration) {
	configuration = newConfiguration;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:25:02)
 * @param newContract java.lang.Integer
 */
public void setContract(java.lang.Integer newContract) {
	contract = newContract;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:26:01)
 * @param newDateclosed java.sql.Date
 */
public void setDateclosed(java.sql.Date newDateclosed) {
	dateclosed = newDateclosed;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:17:36)
 * @param newDateopened java.sql.Date
 */
public void setDateopened(java.sql.Date newDateopened) {
	dateopened = newDateopened;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:23:03)
 * @param newDocument java.lang.Integer
 */
public void setDocument(java.lang.Integer newDocument) {
	document = newDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:26:30)
 * @param newI13ndate java.sql.Date
 */
public void setI13ndate(java.sql.Date newI13ndate) {
	i13ndate = newI13ndate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:30:38)
 * @param newIsfictserial java.lang.String
 */
public void setIsfictserial(java.lang.String newIsfictserial) {
	isfictserial = newIsfictserial;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:29:47)
 * @param newManufserial java.lang.String
 */
public void setManufserial(java.lang.String newManufserial) {
	manufserial = newManufserial;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:28:24)
 * @param newNotes java.lang.String
 */
public void setNotes(java.lang.String newNotes) {
	notes = newNotes;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:18:15)
 * @param newOwner java.lang.Integer
 */
public void setOwner(java.lang.Integer newOwner) {
	owner = newOwner;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:27:28)
 * @param newParty java.lang.String
 */
public void setParty(java.lang.String newParty) {
	party = newParty;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:29:26)
 * @param newPlace java.lang.String
 */
public void setPlace(java.lang.String newPlace) {
	place = newPlace;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:18:49)
 * @param newPolicy java.lang.String
 */
public void setPolicy(java.lang.String newPolicy) {
	policy = newPolicy;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:21:47)
 * @param newPrice java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newPrice) {
	price = newPrice;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:21:25)
 * @param newQty java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newQty) {
	qty = newQty;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:28:01)
 * @param newQty_broken java.math.BigDecimal
 */
public void setQty_broken(java.math.BigDecimal newQty_broken) {
	qty_broken = newQty_broken;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:16:59)
 * @param newResource java.lang.Integer
 */
public void setResource(java.lang.Integer newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:26:57)
 * @param newSerialnumber java.lang.String
 */
public void setSerialnumber(java.lang.String newSerialnumber) {
    if (newSerialnumber.startsWith("fiction_"))
        serialnumber = "с/н неизвестен";
    else
        serialnumber = newSerialnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:16:33)
 * @param newStoragecard java.lang.Integer
 */
public void setStoragecard(java.lang.Integer newStoragecard) {
	storagecard = newStoragecard;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 15:24:31)
 * @param newStorageplace java.lang.Integer
 */
public void setStorageplace(java.lang.Integer newStorageplace) {
	storageplace = newStorageplace;
}
}
