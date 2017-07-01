/*
 * Created on 17.04.2006
 *
 * Служебные записки на оплату TO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * Служебные записки на оплату TO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeasePayOfficeMemo_TO extends Base_TO {
	private LeasePayOfficeMemo_VO vo;
	private String curName;
	private String account;
	private String bankName;
	private String bankBik;
	private String vendorSiteName;
	/**
	 * 
	 */
	public LeasePayOfficeMemo_TO(LeasePayOfficeMemo_VO aVO) {
		vo = aVO;
	}

	/**
	 * @return
	 */
	public LeasePayOfficeMemo_VO getVo() {
		return vo;
	}

	/**
	 * @param memo_VO
	 */
	public void setVo(LeasePayOfficeMemo_VO memo_VO) {
		vo = memo_VO;
	}
	/**
	 * @return
	 */
	public String getBeginDateStr() {
		return getStringFromDate(getVo().getBeginDate());
	}
	/**
	 * @return
	 */
	public String getEndDateStr() {
		return getStringFromDate(getVo().getEndDate());
	}
	/**
	 */
	public void setBeginDateStr(String dateStr) {
		getVo().setBeginDate(getDateFromString(dateStr));
	}
	/**
	 */
	public void setEndDateStr(String dateStr) {
		getVo().setEndDate(getDateFromString(dateStr));
	}
	/**
	 */
	public String getSumStr() {
		return getStringFromBigDecimal(getVo().getSum());
	}
	/**
	 */
	public void setSumStr(String sumStr) {
		getVo().setSum(getBigDecimalFromString(sumStr));
	}
	/**
	 */
	public String getNdsStr() {
		return getStringFromBigDecimal(getVo().getNds());
	}
	/**
	 */
	public void setNdsStr(String ndsStr) {
		getVo().setNds(getBigDecimalFromString(ndsStr));
	}
	/**
	 * @return Boolean
	 */
	public Boolean getFlagAvans() {
		return getBooleanFromString(getVo().getFlagAvans());
	}
	/**
	 * @return Boolean
	 */
	public Boolean getFlag3face() {
		return getBooleanFromString(getVo().getFlag3face());
	}
	/**
	 * @param Boolean
	 */
	public void setFlag3face(Boolean b) {
		getVo().setFlag3face(getStringFromBoolean(b));
	}

	/**
	 * @param Boolean
	 */
	public void setFlagAvans(Boolean b) {
		getVo().setFlagAvans(getStringFromBoolean(b));
	}
	/**
	 * @return
	 */
	public String getCurName() {
		return curName;
	}

	/**
	 * @param string
	 */
	public void setCurName(String string) {
		curName = string;
	}

	/**
	 * @return
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @return
	 */
	public String getBankBik() {
		return bankBik;
	}

	/**
	 * @return
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param string
	 */
	public void setAccount(String string) {
		account = string;
	}

	/**
	 * @param string
	 */
	public void setBankBik(String string) {
		bankBik = string;
	}

	/**
	 * @param string
	 */
	public void setBankName(String string) {
		bankName = string;
	}

	/**
	 * @return
	 */
	public String getVendorSiteName() {
		return vendorSiteName;
	}

	/**
	 * @param string
	 */
	public void setVendorSiteName(String string) {
		vendorSiteName = string;
	}
	/**
	 * @return
	 */
	public String getBillDateStr() {
		return getStringFromDate(getVo().getBillDate());
	}
	/**
	 */
	public void setBillDateStr(String dateStr) {
		getVo().setBillDate(getDateFromString(dateStr));
	}
	/**
	 */
	public String getRateNdsStr() {
		return getStringFromBigDecimal(getVo().getRateNds());
	}
	/**
	 */
	public void setRateNdsStr(String rateNdsStr) {
		getVo().setRateNds(getBigDecimalFromString(rateNdsStr));
	}
	/**
	 */
	public String getRateValueStr() {
		return getStringFromBigDecimal(getVo().getRateValue());
	}
	/**
	 */
	public void setRateValueStr(String rateValueStr) {
		getVo().setRateValue(getBigDecimalFromString(rateValueStr));
	}
	/**
	 * @return
	 */
	public String getRateDateStr() {
		return getStringFromDate(getVo().getRateDate());
	}
	/**
	 */
	public void setRateDateStr(String dateStr) {
		getVo().setRateDate(getDateFromString(dateStr));
	}
	/**
	 */
	public String getSumRubStr() {
		return getStringFromBigDecimal(getVo().getSumRub());
	}
	/**
	 */
	public void setSumRubStr(String sumRubStr) {
		getVo().setSumRub(getBigDecimalFromString(sumRubStr));
	}
	/**
	 */
	public String getNdsRubStr() {
		return getStringFromBigDecimal(getVo().getNdsRub());
	}
	/**
	 */
	public void setNdsRubStr(String ndsRubStr) {
		getVo().setNdsRub(getBigDecimalFromString(ndsRubStr));
	}		
}
