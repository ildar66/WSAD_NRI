/*
 * Created on 29.08.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RegistryBuchCompositionMutAct_TO {
	private Integer idRegistryDoc = null;
	private String actState = null;
	private Integer leaseDocument = null;
	private String docNumber = null;
	private Date docDate = null;
	private Date actStartDate = null;
	private Date actEndDate = null;
	private String namePosition = null;
	private String numberPosition = null;
	private String nameOrg = null;
	/**
	 * 
	 */
	public RegistryBuchCompositionMutAct_TO(Integer id) {
		super();
		setLeaseDocument(id);
	}

	/**
	 * @return
	 */
	public Date getActEndDate() {
		return actEndDate;
	}

	/**
	 * @return
	 */
	public Date getActStartDate() {
		return actStartDate;
	}

	/**
	 * @return
	 */
	public String getActState() {
		return actState;
	}

	/**
	 * @return
	 */
	public Date getDocDate() {
		return docDate;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		return docNumber;
	}

	/**
	 * @return
	 */
	public Integer getIdRegistryDoc() {
		return idRegistryDoc;
	}

	/**
	 * @return
	 */
	public Integer getLeaseDocument() {
		return leaseDocument;
	}

	/**
	 * @param date
	 */
	public void setActEndDate(Date date) {
		actEndDate = date;
	}

	/**
	 * @param date
	 */
	public void setActStartDate(Date date) {
		actStartDate = date;
	}

	/**
	 * @param string
	 */
	public void setActState(String string) {
		actState = string;
	}

	/**
	 * @param date
	 */
	public void setDocDate(Date date) {
		docDate = date;
	}

	/**
	 * @param string
	 */
	public void setDocNumber(String string) {
		docNumber = string;
	}

	/**
	 * @param integer
	 */
	public void setIdRegistryDoc(Integer integer) {
		idRegistryDoc = integer;
	}

	/**
	 * @param integer
	 */
	private void setLeaseDocument(Integer integer) {
		leaseDocument = integer;
	}

	/**
	 * @return
	 */
	public String getActStateStr() {
		return getActStateInfo(getActState());
	}	
	
	/**
	 * @return
	 */
	public static String getActStateInfo(String docState) {
		String docStateStr = docState;
		if ("O".equals(docStateStr)) {
			docStateStr = "оформляется";
		} else if("R".equals(docStateStr)){
			docStateStr = "расчитан";
		} else if("C".equals(docStateStr)){
			docStateStr = "закрыт";			
		} else if("1".equals(docStateStr)){
			docStateStr = "Получена бумажная копия с печатями";
		} else if("2".equals(docStateStr)){
			docStateStr = "Передан в бухгалтерию";
		} else if("3".equals(docStateStr)){
			docStateStr = "Принят бухгалтерией";
		} else if("4".equals(docStateStr)){
			docStateStr = "Передан закупщику";
		} else if("5".equals(docStateStr)){
			docStateStr = "Принят закупщиком";
		} else if("V".equals(docStateStr)){
			docStateStr = "Возвращен";
		}
		return docStateStr;
	}	
	/**
	 * @return
	 */
	public String getNamePosition() {
		return namePosition;
	}

	/**
	 * @return
	 */
	public String getNumberPosition() {
		return numberPosition;
	}

	/**
	 * @param string
	 */
	public void setNamePosition(String string) {
		namePosition = string;
	}

	/**
	 * @param string
	 */
	public void setNumberPosition(String string) {
		numberPosition = string;
	}

	/**
	 * @return
	 */
	public String getNameOrg() {
		return nameOrg;
	}

	/**
	 * @param string
	 */
	public void setNameOrg(String string) {
		nameOrg = string;
	}

}
