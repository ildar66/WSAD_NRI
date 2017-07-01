/*
 * Created on 20.02.2007
 *
 * "Сальдо для договоров аренды" TO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import com.hps.july.valueobject.Base_TO;

/**
 * @author IShaffigulin
 *
 * "Сальдо для договоров аренды" TO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SaldoDetail_TO extends Base_TO {
	private SaldoDetail_VO vo = null;
	private String resourceName = null;
	private String mainCurrencyName = null;
	private String additionalCurrencyName = null;
	/**
	 * 
	 */
	public SaldoDetail_TO(SaldoDetail_VO aVO) {
		super();
		setVo(aVO);
	}

	/**
	 * @return
	 */
	public SaldoDetail_VO getVo() {
		return vo;
	}

	/**
	 * @param detail_VO
	 */
	private void setVo(SaldoDetail_VO detail_VO) {
		vo = detail_VO;
	}

	/**
	 * @return
	 */
	public String getAdditionalCurrencyName() {
		return additionalCurrencyName;
	}

	/**
	 * @return
	 */
	public String getMainCurrencyName() {
		return mainCurrencyName;
	}

	/**
	 * @return
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param string
	 */
	public void setAdditionalCurrencyName(String string) {
		additionalCurrencyName = string;
	}

	/**
	 * @param string
	 */
	public void setMainCurrencyName(String string) {
		mainCurrencyName = string;
	}

	/**
	 * @param string
	 */
	public void setResourceName(String string) {
		resourceName = string;
	}

	/**
	 * @param date
	 */
	public void setSalDate(String dateStr) {
		getVo().setSalDate(getDateFromString(dateStr));
	}

	/**
	 * @return
	 */
	public String getSalDate() {
		return getStringFromDate(getVo().getSalDate());
	}
	
	/**
	 */
	public String getMainSum() {
		return getStringFromBigDecimal(getVo().getMainSum());
	}
	
	/**
	 */
	public void setMainSum(String sumStr) {
		getVo().setMainSum(getBigDecimalFromString(sumStr));
	}
	
	/**
	 */
	public String getMainNdsSum() {
		return getStringFromBigDecimal(getVo().getMainNdsSum());
	}
	
	/**
	 */
	public void setMainNdsSum(String sumStr) {
		getVo().setMainNdsSum(getBigDecimalFromString(sumStr));
	}
	
	/**
	 */
	public String getAdditionalSum() {
		return getStringFromBigDecimal(getVo().getAdditionalSum());
	}
	
	/**
	 */
	public void setAdditionalSum(String sumStr) {
		getVo().setAdditionalSum(getBigDecimalFromString(sumStr));
	}
	
	/**
	 */
	public String getAdditionalNdsSum() {
		return getStringFromBigDecimal(getVo().getAdditionalNdsSum());
	}
	
	/**
	 */
	public void setAdditionalNdsSum(String sumStr) {
		getVo().setAdditionalNdsSum(getBigDecimalFromString(sumStr));
	}
	
	/**
	 */
	public String getRateNds() {
		return getStringFromBigDecimal(getVo().getRateNds());
	}
	
	/**
	 */
	public void setRateNds(String sumStr) {
		getVo().setRateNds(getBigDecimalFromString(sumStr));
	}	
	/**
	 * @return
	 */
	public Boolean getGroupRec() {
		return getBooleanFromInt(getVo().getGroupRec());
	}

	/**
	 * @param boolean1
	 */
	public void setGroupRec(Boolean b) {
		getVo().setGroupRec(getIntFromBoolean(b)); 
	}

}
