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
public class RegistryBuchCompositionSF_TO extends RegistryBuchComposition_TO{
	private Integer idSchetFakt;
	private String numberSf;
	private Date dateSf;
	private BigDecimal sumSf;
	private BigDecimal ndsSf;

	/**
	 * 
	 */
	public RegistryBuchCompositionSF_TO() {
		super();
	}

	/**
	 * @return
	 */
	public Date getDateSf() {
		return dateSf;
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
	public BigDecimal getNdsSf() {
		return ndsSf;
	}

	/**
	 * @return
	 */
	public String getNumberSf() {
		return numberSf;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumSf() {
		return sumSf;
	}

	/**
	 * @param date
	 */
	public void setDateSf(Date date) {
		dateSf = date;
	}

	/**
	 * @param integer
	 */
	public void setIdSchetFakt(Integer integer) {
		idSchetFakt = integer;
	}

	/**
	 * @param decimal
	 */
	public void setNdsSf(BigDecimal decimal) {
		ndsSf = decimal;
	}

	/**
	 * @param string
	 */
	public void setNumberSf(String string) {
		numberSf = string;
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
	public String getDocStateStr() {
		return getDocStateInfo(getDocState());
	}	
	
	/**
	 * @return
	 */
	public static String getDocStateInfo(String docState) {
		String docStateStr = docState;
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
			docStateStr = "Передана закупщику";
		} else if("5".equals(docStateStr)){
			docStateStr = "Принята закупщиком";
		} else if("V".equals(docStateStr)){
			docStateStr = "Возвращена";
		}
		return docStateStr;
	}	

}
