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
public class OrganizationVO implements Serializable, Comparable {

	private int code;
	private String name;
	private String representfio;
	
	public OrganizationVO() {
		super();
	}
	
	public OrganizationVO(int acode, String aname, String afio) {
		super();
		code = acode;
		name = aname;
		representfio = afio;
	}
	
	public String toString() {
		return getName();
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		OrganizationVO other = (OrganizationVO)otherObject;
		
		return (code == other.code);
	}
	
	public int hashCode() {
		return new Integer(code).hashCode();
	}
	
	public int compareTo(Object other) {
		return name.compareTo(((OrganizationVO)other).name);
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
	public String getRepresentfio() {
		return representfio;
	}

	/**
	 * @param string
	 */
	public void setRepresentfio(String string) {
		representfio = string;
	}

}
