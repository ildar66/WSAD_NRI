package com.hps.july.config.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReportChangesVO implements Serializable {
	
	private Integer numindex;
	private String category;
	private String equiptype;
	private String policy;
	private BigDecimal qty;
	private String serialnumber;
	private String inventserial;
	private String localserial;
	private String standno;
	private String sectors900;
	private String sectors1800;
	private String attribute;
	private String oldvalue;
	private String newvalue;
	private String section;
	private Integer line;
	

	public ReportChangesVO() {
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
	public String getLocalserial() {
		return localserial;
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
	public String getSectors1800() {
		return sectors1800;
	}

	/**
	 * @return
	 */
	public String getSectors900() {
		return sectors900;
	}

	/**
	 * @return
	 */
	public String getSerialnumber() {
		return serialnumber;
	}

	/**
	 * @return
	 */
	public String getStandno() {
		return standno;
	}

	/**
	 * @param string
	 */
	public void setCategory(String string) {
		category = string;
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
	public void setLocalserial(String string) {
		localserial = string;
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
	public void setSectors1800(String string) {
		sectors1800 = string;
	}

	/**
	 * @param string
	 */
	public void setSectors900(String string) {
		sectors900 = string;
	}

	/**
	 * @param string
	 */
	public void setSerialnumber(String string) {
		serialnumber = string;
	}

	/**
	 * @param string
	 */
	public void setStandno(String string) {
		standno = string;
	}

	/**
	 * @return
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * @return
	 */
	public String getNewvalue() {
		return newvalue;
	}

	/**
	 * @return
	 */
	public String getOldvalue() {
		return oldvalue;
	}

	/**
	 * @param string
	 */
	public void setAttribute(String string) {
		attribute = string;
	}

	/**
	 * @param string
	 */
	public void setNewvalue(String string) {
		newvalue = string;
	}

	/**
	 * @param string
	 */
	public void setOldvalue(String string) {
		oldvalue = string;
	}

	/**
	 * @return
	 */
	public Integer getLine() {
		return line;
	}

	/**
	 * @return
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @param integer
	 */
	public void setLine(Integer integer) {
		line = integer;
	}

	/**
	 * @param string
	 */
	public void setSection(String string) {
		section = string;
	}

}
