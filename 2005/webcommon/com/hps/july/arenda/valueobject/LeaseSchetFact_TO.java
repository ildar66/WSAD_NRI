/*
 * Created on 16.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeaseSchetFact_TO {
	private LeaseSchetFact_VO vo = null;
	private String curName = null;
	private BigDecimal sumSf = null;
	private BigDecimal ndsSf = null;
	private String nameOrg = null;
	private Date docDate = null;
	private String docNumber = null;
	private String numRegistryDoc = null;//Опись № 
	private Date dateRegistryDoc = null;//Опись от 
	private String typeSF = null;//тип СФ для печати
	/**
	 * 
	 */
	public LeaseSchetFact_TO(LeaseSchetFact_VO aVO) {
		this.vo = aVO;
	}

	/**
	 * @return
	 */
	public String getCurName() {
		return curName;
	}

	/**
	 * @return
	 */
	public LeaseSchetFact_VO getVo() {
		return vo;
	}

	/**
	 * @param string
	 */
	public void setCurName(String string) {
		curName = string;
	}

	/**
	 * @param fact_VO
	 */
	public void setVo(LeaseSchetFact_VO fact_VO) {
		vo = fact_VO;
	}

	/**
	 * @return
	 */
	public BigDecimal getNdsSf() {
		return ndsSf;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumSf() {
		return sumSf;
	}

	/**
	 * @param decimal
	 */
	public void setNdsSf(BigDecimal decimal) {
		ndsSf = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setSumSf(BigDecimal decimal) {
		sumSf = decimal;
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
	public String getNameOrg() {
		return nameOrg;
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
	 * @param string
	 */
	public void setNameOrg(String string) {
		nameOrg = string;
	}

	/**
	 * @return
	 */
	public Date getDateRegistryDoc() {
		return dateRegistryDoc;
	}

	/**
	 * @return
	 */
	public String getNumRegistryDoc() {
		return numRegistryDoc;
	}

	/**
	 * @param date
	 */
	public void setDateRegistryDoc(Date date) {
		dateRegistryDoc = date;
	}

	/**
	 * @param string
	 */
	public void setNumRegistryDoc(String string) {
		numRegistryDoc = string;
	}

	/**
	 * @return
	 */
	public String getTypeSF() {
		return typeSF;
	}

	/**
	 * @param string
	 */
	public void setTypeSF(String string) {
		typeSF = string;
	}

}
