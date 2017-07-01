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
 * Счета фактуры по аренде VO
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeaseSchetFact_VO extends DomainObject {
	private Integer idSchetFakt; //Код счета фактуры
	private Integer idContract; //Код договора
	private Integer idAkt; //Код акта
	private Integer idCurrency; //Код валюты
	private String numberSchetFakt; //Номер счет фактуры
	private Date dateSchetFakt; //Дата счет фактуры
	private String baseDocNumber; //к документу _ номер
	private Date baseDocDate; //к документу _ дата
	//private BYTE doctext;//Текст документа в word
	//private String docfilename;//Имя файла документа
	private Date dateStartSf; //Дата начала периода
	private Date dateEndSf; //Дата окончания периода
	private String state;//состояние:
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
			docStateStr = "оформляется";
		} else if("R".equals(docStateStr)){
			docStateStr = "расчитана";
		} else if("1".equals(docStateStr)){
			docStateStr = "Получена бумажная копия с печатями";
		} else if("2".equals(docStateStr)){
			docStateStr = "Передана в бухгалтерию";
		} else if("3".equals(docStateStr)){
			docStateStr = "Принята бухгалтерией";
		} else if("4".equals(docStateStr)){
			docStateStr = "Передано закупщику";
		} else if("5".equals(docStateStr)){
			docStateStr = "Принято закупщиком";
		} else if("V".equals(docStateStr)){
			docStateStr = "Возвращено";
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
