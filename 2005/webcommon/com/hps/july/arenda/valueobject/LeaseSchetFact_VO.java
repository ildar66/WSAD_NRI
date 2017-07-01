/*
 * Created on 13.01.2006
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.sql.Date;

import com.hps.july.valueobject.DomainObject;

/**
 * @author IShaffigulin
 * ����� ������� �� ������ VO
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeaseSchetFact_VO extends DomainObject {
	private Integer idSchetFakt; //��� ����� �������
	private Integer idContract; //��� ��������
	private Integer idAkt; //��� ����
	private Integer idCurrency; //��� ������
	private String numberSchetFakt; //����� ���� �������
	private Date dateSchetFakt; //���� ���� �������
	private String baseDocNumber; //� ��������� _ �����
	private Date baseDocDate; //� ��������� _ ����
	//private BYTE doctext;//����� ��������� � word
	//private String docfilename;//��� ����� ���������
	private Date dateStartSf; //���� ������ �������
	private Date dateEndSf; //���� ��������� �������
	private String state;//���������:
	private String createdByName = null;
	private String modifiedByName = null;	
	/**
	 * 
	 */
	public LeaseSchetFact_VO(Integer iIdSchetFakt) {
		super();
		setIdSchetFakt(iIdSchetFakt);
	}

	/**
	 * @return
	 */
	public Date getBaseDocDate() {
		return baseDocDate;
	}

	/**
	 * @return
	 */
	public String getBaseDocNumber() {
		return baseDocNumber;
	}

	/**
	 * @return
	 */
	public Date getDateEndSf() {
		return dateEndSf;
	}

	/**
	 * @return
	 */
	public Date getDateSchetFakt() {
		return dateSchetFakt;
	}

	/**
	 * @return
	 */
	public Date getDateStartSf() {
		return dateStartSf;
	}

	/**
	 * @return
	 */
	public Integer getIdAkt() {
		return idAkt;
	}

	/**
	 * @return
	 */
	public Integer getIdContract() {
		return idContract;
	}

	/**
	 * @return
	 */
	public Integer getIdCurrency() {
		return idCurrency;
	}

	/**
	 * @return
	 */
	public Integer getIdSchetFakt() {
		return idSchetFakt;
	}

	/**
	 * @return
	 */
	public String getNumberSchetFakt() {
		return numberSchetFakt;
	}

	/**
	 * @param date
	 */
	public void setBaseDocDate(Date date) {
		baseDocDate = date;
	}

	/**
	 * @param string
	 */
	public void setBaseDocNumber(String string) {
		baseDocNumber = string;
	}

	/**
	 * @param date
	 */
	public void setDateEndSf(Date date) {
		dateEndSf = date;
	}

	/**
	 * @param date
	 */
	public void setDateSchetFakt(Date date) {
		dateSchetFakt = date;
	}

	/**
	 * @param date
	 */
	public void setDateStartSf(Date date) {
		dateStartSf = date;
	}

	/**
	 * @param integer
	 */
	public void setIdAkt(Integer integer) {
		idAkt = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdContract(Integer integer) {
		idContract = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdCurrency(Integer integer) {
		idCurrency = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdSchetFakt(Integer integer) {
		idSchetFakt = integer;
	}

	/**
	 * @param string
	 */
	public void setNumberSchetFakt(String string) {
		numberSchetFakt = string;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param string
	 */
	public void setState(String string) {
		state = string;
	}
	
	/**
	 * @return
	 */
	public String getStateStr() {
		String docStateStr = getState();
		if ("O".equals(docStateStr)) {
			docStateStr = "�����������";
		} else if("R".equals(docStateStr)){
			docStateStr = "���������";
		} else if("1".equals(docStateStr)){
			docStateStr = "�������� �������� ����� � ��������";
		} else if("2".equals(docStateStr)){
			docStateStr = "�������� � �����������";
		} else if("3".equals(docStateStr)){
			docStateStr = "������� ������������";
		} else if("4".equals(docStateStr)){
			docStateStr = "�������� ���������";
		} else if("5".equals(docStateStr)){
			docStateStr = "������� ����������";
		} else if("V".equals(docStateStr)){
			docStateStr = "����������";
		}
		return docStateStr;
	}	
	

	/**
	 * @return
	 */
	public String getCreatedByName() {
		return createdByName;
	}

	/**
	 * @return
	 */
	public String getModifiedByName() {
		return modifiedByName;
	}

	/**
	 * @param string
	 */
	public void setCreatedByName(String string) {
		createdByName = string;
	}

	/**
	 * @param string
	 */
	public void setModifiedByName(String string) {
		modifiedByName = string;
	}

}
