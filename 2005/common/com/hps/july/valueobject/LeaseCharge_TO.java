/*
 * Created on 11.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeaseCharge_TO {
	private LeaseCharge_VO vo;
	private String curName;//валюта
	private String resName;//ресурс
	private java.math.BigDecimal rate;//ставка НДС

	/**
	 * 
	 */
	public LeaseCharge_TO(LeaseCharge_VO vo) {
		this.vo = vo;
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
	public String getResName() {
		return resName;
	}

	/**
	 * @return
	 */
	public LeaseCharge_VO getVo() {
		return vo;
	}

	/**
	 * @param string
	 */
	public void setCurName(String string) {
		curName = string;
	}

	/**
	 * @param string
	 */
	public void setResName(String string) {
		resName = string;
	}

	/**
	 * @param charge_VO
	 */
	public void setVo(LeaseCharge_VO charge_VO) {
		vo = charge_VO;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getRate() {
		return rate;
	}

	/**
	 * @param decimal
	 */
	public void setRate(java.math.BigDecimal decimal) {
		rate = decimal;
	}

}
