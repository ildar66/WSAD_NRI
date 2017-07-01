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
 * ������ ���������� VO
 * ������� ������ ���������� �� �������� ������������
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DocPositions_VO {
	private Integer docPosition = null;//������������� ������ ���������
	private Integer owner = null;//������ �� ���������
	private Integer order = null;//������ ����������
	private Integer resource = null;//������ �� ������
	private Integer storageCardTo = null;//������ �� �������� �������� ����� �������� ����������� _ ����
	private Integer storageCardFrom = null;//������ �� �������� �������� �� �������� ����������� _ ������
	private Integer document = null;//������ �� ��������
	private BigDecimal qty = null;//��������� �������
	private BigDecimal price = null;//����
	private String type = null;//��� ������ ���������(I-inventarization; Q-just positions; W-inwaybillposition; C-contructpos; N-inlwbilpos; B-afsmountpos; P-IBPmountpos;)
	private String party = null;//����� ������
	private String serialNumber = null;//�������� �����
	private String sourceBoxed = null;//�������� ���������(Y/N)
	private String resultBoxed = null;//������� ��������� � �������� ��������� ����������������������� ���������(Y/N)
	private String sourceBroken = null;//������� �������(Y/N)
	private String resultBroken = null;//������� ��������� � �������� ��������� ���������� �� ������������� ��������(Y/N)
	private String sourceClosed = null;//������� �������(Y/N)
	private String resultClosed = null;//������� �������� �������� �� ����������� ��������(Y/N)
	private String configuration = null;//��������������� ������������
	private Integer agregate = null;//����������
	private String agregateSerial = null;//�������� ��� ����������
	private String oldAgregateSerial = null;//������ ��� �������� ��� �������
	private String notes = null;//����������
	private String oldPlace = null;//������ ���������� �����
	private String newPlace = null;//����� ���������� �����
	private String manufSerial = null;//���_ ����� �������������
	private Integer agregateCardFrom = null;//�� �������� ��������
	private Integer agregateCardTo = null;//� �������� ��������
	private String comment = null;//�����������
	private String isFictSerial = null;//������� ���������� ��������� ������(Y/N)
	private String realSerial = null;//�������� ����� �� ������ ����������
	private Integer agregateResource = null;//������ �������� ���� �����������
	private Integer oldAgregateResource = null;//������ �������� ������ �������������
	private Integer visualTagId = null;//�������� � ����������� ������

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
