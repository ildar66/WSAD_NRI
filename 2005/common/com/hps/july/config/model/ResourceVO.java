/*
 * Created on 10.08.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * @author dima
 *
 */
public class ResourceVO implements Serializable, Comparable {

	private int code;
	private String name;
	private String fullname;
	private String manucode;
	private String nfscode;
	private String manufname;
	private String policy;
	
	public ResourceVO() {
		super();
	}
	
	public ResourceVO(int acode, String aname) {
		super();
		code = acode;
		name = aname;
	}
	
	public String toString() {
		return getName();
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		ResourceVO other = (ResourceVO)otherObject;
		
		return (code == other.code);
	}
	
	public int hashCode() {
		return new Integer(code).hashCode();
	}
	
	public int compareTo(Object other) {
		if (name == null) {
			if (((ResourceVO)other).name == null)
				return 0;
			else 
				return -1;
		} else if (((ResourceVO)other).name == null) {
			return 1;
		} else {
			return name.compareTo(((ResourceVO)other).name);
		}
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
	public String getFullname() {
		return fullname;
	}

	/**
	 * @return
	 */
	public String getManucode() {
		return manucode;
	}

	/**
	 * @return
	 */
	public String getManufname() {
		return manufname;
	}

	/**
	 * @return
	 */
	public String getNfscode() {
		return nfscode;
	}

	/**
	 * @param string
	 */
	public void setFullname(String string) {
		fullname = string;
	}

	/**
	 * @param string
	 */
	public void setManucode(String string) {
		manucode = string;
	}

	/**
	 * @param string
	 */
	public void setManufname(String string) {
		manufname = string;
	}

	/**
	 * @param string
	 */
	public void setNfscode(String string) {
		nfscode = string;
	}

	/**
	 * @return
	 */
	public String getPolicy() {
		return policy;
	}

	/**
	 * @param string
	 */
	public void setPolicy(String string) {
		policy = string;
	}

}
