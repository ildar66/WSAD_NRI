package com.hps.july.config.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ReportConfig2VO implements Serializable {

	private Integer numindex;
	private String category;
	private String equiptype;
	private String policy;
	private BigDecimal qty;
	private String serialnumber;
	private String inventserial;
	private String localserial;
	private List attributes;
	private String comment;
	
	public ReportConfig2VO() {
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
	public String getPolicy() {
		return policy;
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
	 * @param string
	 */
	public void setPolicy(String string) {
		policy = string;
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
	public List getAttributes() {
		return attributes;
	}

	/**
	 * @param list
	 */
	public void setAttributes(List list) {
		attributes = list;
	}

	/**
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param string
	 */
	public void setComment(String string) {
		comment = string;
	}

}
