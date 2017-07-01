/*
 * Created on 16.10.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * Repiter value object
 * @author dima
 *
 */
public class RepiterVO implements Serializable {

	private Integer repnum;  // Repiter number
	private String sectnum;  // Donor sector number
	private String conntype; // Connection type
	private String status;   // Repiter status

	public RepiterVO() {
		super();
	}
	
	public static String getStatusName(String status) {
		String s = "---";
		if ("P".equals(status)) s = "�����������"; 
		else if ("M".equals(status)) s = "���������������"; 
		else if ("W".equals(status)) s = "�������� � ������"; 
		else if ("D".equals(status)) s = "�������������"; 
		return s;
	}
	
	public static String getDonorType(String adonortype) {
		if ("A".equals(adonortype))
			return "���������";
		else if ("B".equals(adonortype))
			return "����������";
		else if ("C".equals(adonortype))
			return "���������� �����";
		else 
			return "---";
	}

	/**
	 * @return
	 */
	public String getConntype() {
		return conntype;
	}

	/**
	 * @return
	 */
	public Integer getRepnum() {
		return repnum;
	}

	/**
	 * @return
	 */
	public String getSectnum() {
		return sectnum;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param string
	 */
	public void setConntype(String string) {
		conntype = string;
	}

	/**
	 * @param integer
	 */
	public void setRepnum(Integer integer) {
		repnum = integer;
	}

	/**
	 * @param string
	 */
	public void setSectnum(String string) {
		sectnum = string;
	}

	/**
	 * @param string
	 */
	public void setStatus(String string) {
		status = string;
	}

}
