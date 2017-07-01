/*
 * Created on 18.05.2006
 *
 * "Служебные записки на изменение ЗП в системе НФС" TO
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * "Служебные записки на изменение ЗП в системе НФС" TO
 */
public class LeaseZPOfficeMemo_TO extends Base_TO {
	private LeaseZPOfficeMemo_VO vo = null;
	private String curName = null;

	/**
	 * 
	 * @param aVO
	 */
	public LeaseZPOfficeMemo_TO(LeaseZPOfficeMemo_VO aVO) {
		vo = aVO;
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
	public LeaseZPOfficeMemo_VO getVo() {
		return vo;
	}

	/**
	 * @param string
	 */
	public void setCurName(String string) {
		curName = string;
	}

	/**
	 * @param memo_VO
	 */
	public void setVo(LeaseZPOfficeMemo_VO memo_VO) {
		vo = memo_VO;
	}
	/**
	 * @return Boolean
	 */
	public Boolean getFlagAddContract() {
		return getBooleanFromString(getVo().getFlagAddContract());
	}
	/**
	 * @param Boolean
	 */
	public void setFlagAddContract(Boolean b) {
		getVo().setFlagAddContract(getStringFromBoolean(b));
	}

	/**
	 * @return Boolean
	 */
	public Boolean getFlagAddVendorSite() {
		return getBooleanFromString(getVo().getFlagAddVendorSite());
	}
	/**
	 * @param Boolean
	 */
	public void setFlagAddVendorSite(Boolean b) {
		getVo().setFlagAddVendorSite(getStringFromBoolean(b));
	}

	/**
	 * @param Boolean
	 */
	public void setFlagAddVendor(Boolean b) {
		if (b.booleanValue()) {
			getVo().setFlagAddVendor("I");
		} else {
			getVo().setFlagAddVendor("N");
		}
	}
	/**
	 * @return Boolean
	 */
	public Boolean getFlagAddVendor() {
		return "I".equals(getVo().getFlagAddVendor()) ? Boolean.TRUE : Boolean.FALSE;
	}
	/**
	 */
	public String getSumCharge() {
		return getStringFromBigDecimal(getVo().getSumCharge());
	}
	/**
	 */
	public void setSumCharge(String sumStr) {
		getVo().setSumCharge(getBigDecimalFromString(sumStr));
	}
	/**
	 */
	public String getSumNdsZP() {
		return getStringFromBigDecimal(getVo().getSumNdsZP());
	}
	/**
	 */
	public void setSumNdsZP(String sumStr) {
		getVo().setSumNdsZP(getBigDecimalFromString(sumStr));
	}
	/**
	 */
	public String getSumZP() {
		return getStringFromBigDecimal(getVo().getSumZP());
	}
	/**
	 */
	public void setSumZP(String sumStr) {
		getVo().setSumZP(getBigDecimalFromString(sumStr));
	}
	/**
	 */
	public String getOldSumZP() {
		return getStringFromBigDecimal(getVo().getOldSumZP());
	}
	/**
	 */
	public void setOldSumZP(String sumStr) {
		getVo().setOldSumZP(getBigDecimalFromString(sumStr));
	}
	/**
	 * @return
	 */
	public String getDateEndZp() {
		return getStringFromDate(getVo().getDateEndZp());
	}
	/**
	 */
	public void setDateEndZp(String dateStr) {
		getVo().setDateEndZp(getDateFromString(dateStr));
	}
	/**
	 * @return
	 */
	public String getDateStartZP() {
		return getStringFromDate(getVo().getDateStartZP());
	}
	/**
	 */
	public void setDateStartZP(String dateStr) {
		getVo().setDateStartZP(getDateFromString(dateStr));
	}
	/**
	 */
	public String getRateDelta() {
		return getStringFromBigDecimal(getVo().getRateDelta());
	}
	/**
	 */
	public void setRateDelta(String sumStr) {
		getVo().setRateDelta(getBigDecimalFromString(sumStr));
	}
	/**
	 */
	public String getRateFix() {
		return getStringFromBigDecimal(getVo().getRateFix());
	}
	/**
	 */
	public void setRateFix(String sumStr) {
		getVo().setRateFix(getBigDecimalFromString(sumStr));
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
}
