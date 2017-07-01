/*
 * Created on 17.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

import java.math.BigDecimal;

/**
 * @author IShaffigulin
 * Строки документов VO
 * Базовые строки документов по движению оборудования
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DocPositions_VO {
	private Integer docPosition = null;//Идентификатор строки документа
	private Integer owner = null;//Ссылка на владельца
	private Integer order = null;//Прядок следования
	private Integer resource = null;//Ссылка на ресурс
	private Integer storageCardTo = null;//Ссылка на карточку хранения после операции переьещения _ куда
	private Integer storageCardFrom = null;//Ссылка на карточку хранения до операции перемещения _ откуда
	private Integer document = null;//Ссылка на документ
	private BigDecimal qty = null;//Коичество ресурса
	private BigDecimal price = null;//цена
	private String type = null;//Тип строки документа(I-inventarization; Q-just positions; W-inwaybillposition; C-contructpos; N-inlwbilpos; B-afsmountpos; P-IBPmountpos;)
	private String party = null;//Номер партии
	private String serialNumber = null;//Серийный номер
	private String sourceBoxed = null;//Исходное состояние(Y/N)
	private String resultBoxed = null;//Признак установки в карточке состояния упакованоРезультитующее состояние(Y/N)
	private String sourceBroken = null;//Исходно сломано(Y/N)
	private String resultBroken = null;//Признак установки в карточке состояния неисправна по результататам операции(Y/N)
	private String sourceClosed = null;//Исходно закрыта(Y/N)
	private String resultClosed = null;//Признак закрытия карточки по результатам операции(Y/N)
	private String configuration = null;//Технологическая конфигурация
	private Integer agregate = null;//Устройство
	private String agregateSerial = null;//Серийный код устройства
	private String oldAgregateSerial = null;//Старый код агрегата при разрыве
	private String notes = null;//Примечания
	private String oldPlace = null;//Старое посадочное место
	private String newPlace = null;//Новое посадочное место
	private String manufSerial = null;//Сер_ номер производителя
	private Integer agregateCardFrom = null;//Из карточки агрегата
	private Integer agregateCardTo = null;//В карточку агрегата
	private String comment = null;//Комментарий
	private String isFictSerial = null;//Признак фиктивного серийного номера(Y/N)
	private String realSerial = null;//Серийный номер на замену фиктивному
	private Integer agregateResource = null;//Ресурс агрегата куда монтируется
	private Integer oldAgregateResource = null;//Ресурс агрегата откуда демонтируется
	private Integer visualTagId = null;//Привязка к визуальному пункту

	/**
	 * 
	 */
	public DocPositions_VO() {
		super();
	}
	/**
	 * 
	 * @param aDocPosition
	 */
	public DocPositions_VO(Integer aDocPosition) {
		super();
		docPosition = aDocPosition;
	}

	/**
	 * @return
	 */
	public Integer getAgregate() {
		return agregate;
	}

	/**
	 * @return
	 */
	public Integer getAgregateCardFrom() {
		return agregateCardFrom;
	}

	/**
	 * @return
	 */
	public Integer getAgregateCardTo() {
		return agregateCardTo;
	}

	/**
	 * @return
	 */
	public Integer getAgregateResource() {
		return agregateResource;
	}

	/**
	 * @return
	 */
	public String getAgregateSerial() {
		return agregateSerial;
	}

	/**
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @return
	 */
	public String getConfiguration() {
		return configuration;
	}

	/**
	 * @return
	 */
	public Integer getDocPosition() {
		return docPosition;
	}

	/**
	 * @return
	 */
	public Integer getDocument() {
		return document;
	}

	/**
	 * @return
	 */
	public String getIsFictSerial() {
		return isFictSerial;
	}

	/**
	 * @return
	 */
	public String getManufSerial() {
		return manufSerial;
	}

	/**
	 * @return
	 */
	public String getNewPlace() {
		return newPlace;
	}

	/**
	 * @return
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @return
	 */
	public Integer getOldAgregateResource() {
		return oldAgregateResource;
	}

	/**
	 * @return
	 */
	public String getOldAgregateSerial() {
		return oldAgregateSerial;
	}

	/**
	 * @return
	 */
	public String getOldPlace() {
		return oldPlace;
	}

	/**
	 * @return
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @return
	 */
	public Integer getOwner() {
		return owner;
	}

	/**
	 * @return
	 */
	public String getParty() {
		return party;
	}

	/**
	 * @return
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @return
	 */
	public BigDecimal getQty() {
		return qty;
	}

	/**
	 * @return
	 */
	public String getRealSerial() {
		return realSerial;
	}

	/**
	 * @return
	 */
	public Integer getResource() {
		return resource;
	}

	/**
	 * @return
	 */
	public String getResultBoxed() {
		return resultBoxed;
	}

	/**
	 * @return
	 */
	public String getResultBroken() {
		return resultBroken;
	}

	/**
	 * @return
	 */
	public String getResultClosed() {
		return resultClosed;
	}

	/**
	 * @return
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @return
	 */
	public String getSourceBoxed() {
		return sourceBoxed;
	}

	/**
	 * @return
	 */
	public String getSourceBroken() {
		return sourceBroken;
	}

	/**
	 * @return
	 */
	public String getSourceClosed() {
		return sourceClosed;
	}

	/**
	 * @return
	 */
	public Integer getStorageCardFrom() {
		return storageCardFrom;
	}

	/**
	 * @return
	 */
	public Integer getStorageCardTo() {
		return storageCardTo;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return
	 */
	public Integer getVisualTagId() {
		return visualTagId;
	}

	/**
	 * @param integer
	 */
	public void setAgregate(Integer integer) {
		agregate = integer;
	}

	/**
	 * @param integer
	 */
	public void setAgregateCardFrom(Integer integer) {
		agregateCardFrom = integer;
	}

	/**
	 * @param integer
	 */
	public void setAgregateCardTo(Integer integer) {
		agregateCardTo = integer;
	}

	/**
	 * @param integer
	 */
	public void setAgregateResource(Integer integer) {
		agregateResource = integer;
	}

	/**
	 * @param string
	 */
	public void setAgregateSerial(String string) {
		agregateSerial = string;
	}

	/**
	 * @param string
	 */
	public void setComment(String string) {
		comment = string;
	}

	/**
	 * @param string
	 */
	public void setConfiguration(String string) {
		configuration = string;
	}

	/**
	 * @param integer
	 */
	public void setDocPosition(Integer integer) {
		docPosition = integer;
	}

	/**
	 * @param integer
	 */
	public void setDocument(Integer integer) {
		document = integer;
	}

	/**
	 * @param string
	 */
	public void setIsFictSerial(String string) {
		isFictSerial = string;
	}

	/**
	 * @param string
	 */
	public void setManufSerial(String string) {
		manufSerial = string;
	}

	/**
	 * @param string
	 */
	public void setNewPlace(String string) {
		newPlace = string;
	}

	/**
	 * @param string
	 */
	public void setNotes(String string) {
		notes = string;
	}

	/**
	 * @param integer
	 */
	public void setOldAgregateResource(Integer integer) {
		oldAgregateResource = integer;
	}

	/**
	 * @param string
	 */
	public void setOldAgregateSerial(String string) {
		oldAgregateSerial = string;
	}

	/**
	 * @param string
	 */
	public void setOldPlace(String string) {
		oldPlace = string;
	}

	/**
	 * @param integer
	 */
	public void setOrder(Integer integer) {
		order = integer;
	}

	/**
	 * @param integer
	 */
	public void setOwner(Integer integer) {
		owner = integer;
	}

	/**
	 * @param string
	 */
	public void setParty(String string) {
		party = string;
	}

	/**
	 * @param decimal
	 */
	public void setPrice(BigDecimal decimal) {
		price = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setQty(BigDecimal decimal) {
		qty = decimal;
	}

	/**
	 * @param string
	 */
	public void setRealSerial(String string) {
		realSerial = string;
	}

	/**
	 * @param integer
	 */
	public void setResource(Integer integer) {
		resource = integer;
	}

	/**
	 * @param string
	 */
	public void setResultBoxed(String string) {
		resultBoxed = string;
	}

	/**
	 * @param string
	 */
	public void setResultBroken(String string) {
		resultBroken = string;
	}

	/**
	 * @param string
	 */
	public void setResultClosed(String string) {
		resultClosed = string;
	}

	/**
	 * @param string
	 */
	public void setSerialNumber(String string) {
		serialNumber = string;
	}

	/**
	 * @param string
	 */
	public void setSourceBoxed(String string) {
		sourceBoxed = string;
	}

	/**
	 * @param string
	 */
	public void setSourceBroken(String string) {
		sourceBroken = string;
	}

	/**
	 * @param string
	 */
	public void setSourceClosed(String string) {
		sourceClosed = string;
	}

	/**
	 * @param integer
	 */
	public void setStorageCardFrom(Integer integer) {
		storageCardFrom = integer;
	}

	/**
	 * @param integer
	 */
	public void setStorageCardTo(Integer integer) {
		storageCardTo = integer;
	}

	/**
	 * @param string
	 */
	public void setType(String string) {
		type = string;
	}

	/**
	 * @param integer
	 */
	public void setVisualTagId(Integer integer) {
		visualTagId = integer;
	}

}
