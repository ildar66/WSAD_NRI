/*
 * Created on 20.11.2006
 * Категории оборудования
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * @author dima
 *
 */
public class EquipCategoryVO implements Serializable {

	private int code;
	private String name;
	private Integer parentCode;
	private String sectlink;
	
	public static String SECTLINK_NOLINK = "N";
	public static String SECTLINK_ONELINK = "O";
	public static String SECTLINK_900ONLY = "9";
	public static String SECTLINK_TWOLINK = "T";
	
	public EquipCategoryVO() {
		super();
	}
	
	/*
	public EquipCategoryVO(int acode, String aname) {
		super();
		code = acode;
		name = aname;
		sectlink = SECTLINK_NOLINK;
	}
	*/
	
	public EquipCategoryVO(int acode, String aname, String asectlink) {
		super();
		code = acode;
		name = aname;
		sectlink = asectlink;
	}

	/*	
	public EquipCategoryVO(int acode, String aname, Integer aparentCode) {
		super();
		code = acode;
		name = aname;
		parentCode = aparentCode;
		sectlink = SECTLINK_NOLINK;
	}
	*/
	
	public EquipCategoryVO(int acode, String aname, Integer aparentCode, String asectlink) {
		super();
		code = acode;
		name = aname;
		parentCode = aparentCode;
		sectlink = asectlink;
	}
	
	public String toString() {
		return getName();
	}

	/**
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param i
	 */
	public void setCode(int i) {
		code = i;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @return
	 */
	public Integer getParentCode() {
		return parentCode;
	}

	/**
	 * @param integer
	 */
	public void setParentCode(Integer integer) {
		parentCode = integer;
	}

	/**
	 * @return
	 */
	public String getSectlink() {
		return sectlink;
	}

	/**
	 * @param string
	 */
	public void setSectlink(String string) {
		sectlink = string;
	}

}
