package com.hps.july.config.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReportBTSMountActVO implements Serializable {
	
	private Integer numindex;
	private String nfscode;
	private String equiptype;
	private String policy;
	private BigDecimal qty;
	private String serialnumber;
	private String inventserial;
	private String comment;
	private String unitname;

	public ReportBTSMountActVO() {
		super();
	}

	/**
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @return
	 */
	public String getEquiptype() {
		return equiptype;
	}

	/**
	 * @return
	 */
	public String getInventserial() {
		return inventserial;
	}

	/**
	 * @return
	 */
	public String getNfscode() {
		return nfscode;
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
	public String getPolicy() {
		return policy;
	}

	/**
	 * @return
	 */
	public BigDecimal getQty() {
		return qty;
	}

	/**
	 * @return
	 */
	public String getSerialnumber() {
		return serialnumber;
	}

	/**
	 * @param string
	 */
	public void setComment(String string) {
		comment = string;
	}

	/**
	 * @param string
	 */
	public void setEquiptype(String string) {
		equiptype = string;
	}

	/**
	 * @param string
	 */
	public void setInventserial(String string) {
		inventserial = string;
	}

	/**
	 * @param string
	 */
	public void setNfscode(String string) {
		nfscode = string;
	}

	/**
	 * @param integer
	 */
	public void setNumindex(Integer integer) {
		numindex = integer;
	}

	/**
	 * @param string
	 */
	public void setPolicy(String string) {
		policy = string;
	}

	/**
	 * @param decimal
	 */
	public void setQty(BigDecimal decimal) {
		qty = decimal;
	}

	/**
	 * @param string
	 */
	public void setSerialnumber(String string) {
		serialnumber = string;
	}

	/**
	 * @return
	 */
	public String getUnitname() {
		return unitname;
	}

	/**
	 * @param string
	 */
	public void setUnitname(String string) {
		unitname = string;
	}

}
