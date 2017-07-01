package com.hps.july.config.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReportConfig1VO implements Serializable {

	private Integer numindex;
	private String category;
	private BigDecimal qty;
	
	public ReportConfig1VO() {
		super();
	}

	/**
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return
	 */
	public Integer getNumindex() {
		return numindex;
	}

	/**
	 * @return
	 */
	public BigDecimal getQty() {
		return qty;
	}

	/**
	 * @param string
	 */
	public void setCategory(String string) {
		category = string;
	}

	/**
	 * @param integer
	 */
	public void setNumindex(Integer integer) {
		numindex = integer;
	}

	/**
	 * @param decimal
	 */
	public void setQty(BigDecimal decimal) {
		qty = decimal;
	}

}
