/*
 * Created on 05.08.2006
 *
 * "тип объекта" VO из таблицы AdminRegionTypes
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * "тип объекта" VO из таблицы AdminRegionTypes
 */
public class AdminRegionType_VO {
	private Integer regionType = null;
	private String nameType = null;
	/**
	 * 
	 */
	public AdminRegionType_VO(Integer aRegionType, String aNameType) {
		super();
		setRegionType(aRegionType);
		setNameType(aNameType);
	}

	/**
	 * @return
	 */
	public String getNameType() {
		return nameType;
	}

	/**
	 * @return
	 */
	public Integer getRegionType() {
		return regionType;
	}

	/**
	 * @param string
	 */
	private void setNameType(String string) {
		nameType = string;
	}

	/**
	 * @param integer
	 */
	private void setRegionType(Integer integer) {
		regionType = integer;
	}

}
