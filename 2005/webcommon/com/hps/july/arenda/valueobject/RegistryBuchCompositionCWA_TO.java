/*
 * Created on 21.02.2006
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
public class RegistryBuchCompositionCWA_TO extends RegistryBuchComposition_TO{
	private Integer idCWAcode;

	private String docNumberCWA;
	private Date docDateCWA;
	private String nameCurrency;
	private BigDecimal actSum;
	private BigDecimal actNds;
	private Date actStartDate;
	private Date actEndDate;


	/**
	 * 
	 */
	public RegistryBuchCompositionCWA_TO() {
		super();
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
	public BigDecimal getActNds() {
		return actNds;
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
	public BigDecimal getActSum() {
		return actSum;
	}

	/**
	 * @return
	 */
	public Date getDocDateCWA() {
		return docDateCWA;
	}

	/**
	 * @return
	 */
	public String getDocNumberCWA() {
		return docNumberCWA;
	}

	/**
	 * @return
	 */
	public Integer getIdCWAcode() {
		return idCWAcode;
	}

	/**
	 * @return
	 */
	public String getNameCurrency() {
		return nameCurrency;
	}

	/**
	 * @param date
	 */
	public void setActEndDate(Date date) {
		actEndDate = date;
	}

	/**
	 * @param decimal
	 */
	public void setActNds(BigDecimal decimal) {
		actNds = decimal;
	}

	/**
	 * @param date
	 */
	public void setActStartDate(Date date) {
		actStartDate = date;
	}

	/**
	 * @param decimal
	 */
	public void setActSum(BigDecimal decimal) {
		actSum = decimal;
	}

	/**
	 * @param date
	 */
	public void setDocDateCWA(Date date) {
		docDateCWA = date;
	}

	/**
	 * @param string
	 */
	public void setDocNumberCWA(String string) {
		docNumberCWA = string;
	}

	/**
	 * @param integer
	 */
	public void setIdCWAcode(Integer integer) {
		idCWAcode = integer;
	}

	/**
	 * @param string
	 */
	public void setNameCurrency(String string) {
		nameCurrency = string;
	}
	
	/**
	 * @return
	 */
	public String getDocStateStr() {
		return getDocStateInfo(getDocState());
	}
	
	/**
	 * 
	 * @param docState
	 * @return
	 */
	public static String getDocStateInfo(String docState){
		String docStateStr = docState;
		if ("O".equals(docStateStr)) {
			docStateStr = "оформляется";
		} else if("R".equals(docStateStr)){
			docStateStr = "расчитан";
		} else if("1".equals(docStateStr)){
			docStateStr = "Получен от арендодателя";
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
}
