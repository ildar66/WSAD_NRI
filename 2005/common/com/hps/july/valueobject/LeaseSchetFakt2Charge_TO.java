/*
 * Created on 09.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

import java.math.BigDecimal;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeaseSchetFakt2Charge_TO {
	private LeaseCharge_VO chargeVO;
	private Integer idSchetfakt;
	private BigDecimal linkSumCharge;
	private String curName;
	private String resName;

	/**
	 * 
	 */
	public LeaseSchetFakt2Charge_TO() {
		super();
	}

	/**
	 * @return
	 */
	public Integer getIdSchetfakt() {
		return idSchetfakt;
	}

	/**
	 * @return
	 */
	public BigDecimal getLinkSumCharge() {
		return linkSumCharge;
	}

	/**
	 * @return
	 */
	public LeaseCharge_VO getChargeVO() {
		return chargeVO;
	}

	/**
	 * @param integer
	 */
	public void setIdSchetfakt(Integer integer) {
		idSchetfakt = integer;
	}

	/**
	 * @param decimal
	 */
	public void setLinkSumCharge(BigDecimal decimal) {
		linkSumCharge = decimal;
	}

	/**
	 * @param charge_VO
	 */
	public void setChargeVO(LeaseCharge_VO charge_VO) {
		chargeVO = charge_VO;
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

}