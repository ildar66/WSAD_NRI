/*
 * Created on 01.06.2007
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * @author dima
 *
 */
public class ApartmentVO implements Serializable {

	private Integer code;
	private String name;
	
	public ApartmentVO() {
		super();
	}
	
	public ApartmentVO(Integer acode, String aname) {
		super();
		code = acode;
		name = aname;
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		ApartmentVO other = (ApartmentVO)otherObject;
		
		if (code == null) {
			if (other.code == null)
				return true;
			else 
				return false;
		} else {
			if (other.code == null)
				return false;
		}
		
		return code.equals(other.code);
	}
	
	public String toString() {
		return getName();
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
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
	public Integer getCode() {
		return code;
	}

	/**
	 * @param integer
	 */
	public void setCode(Integer integer) {
		code = integer;
	}

}
