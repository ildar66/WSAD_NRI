/*
 * Created on 10.08.2006
 *
 * An object to hold basestation info
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * @author dima
 *
 */
public class BaseStationVO implements Serializable, Comparable {

	private int code;
	private int gsmid;
	private String name;
	private String address;
	private int poscode;
	
	public BaseStationVO() {
		super();
	}
	
	public BaseStationVO(int acode, int agsmid, String aname, String aaddress, int aposcode) {
		super();
		code = acode;
		name = aname;
		gsmid = agsmid;
		address = aaddress;
		poscode = aposcode;
	}
	
	public String toString() {
		return getName();
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		BaseStationVO other = (BaseStationVO)otherObject;
		
		return (code == other.code);
	}
	
	public int hashCode() {
		return new Integer(code).hashCode();
	}
	
	public int compareTo(Object other) {
		return name.compareTo(((BaseStationVO)other).name);
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
	public String getAddress() {
		return address;
	}

	/**
	 * @return
	 */
	public int getGsmid() {
		return gsmid;
	}

	/**
	 * @param string
	 */
	public void setAddress(String string) {
		address = string;
	}

	/**
	 * @param i
	 */
	public void setGsmid(int i) {
		gsmid = i;
	}

	/**
	 * @return
	 */
	public int getPoscode() {
		return poscode;
	}

	/**
	 * @param i
	 */
	public void setPoscode(int i) {
		poscode = i;
	}

}
