/*
 * Created on 15.12.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * Value object to hold controller characteristics
 * @author dima
 *
 */
public class ControllerVO implements Serializable, Comparable, Cloneable {

	private int code;
	private int number;
	private String name;
	
	public ControllerVO() {
		super();
	}
	
	public ControllerVO(int acode, int anumber, String aname) {
		super();
		code = acode;
		number = anumber;
		name = aname;
	}
	
	public String toString() {
		return getName();
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();	
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		ControllerVO other = (ControllerVO)otherObject;
		
		return (code == other.code);
	}
	
	public int hashCode() {
		return new Integer(code).hashCode();
	}
	
	// To sort by name
	public int compareTo(Object other) {
		return name.compareTo(((ControllerVO)other).name);
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
	public int getNumber() {
		return number;
	}

	/**
	 * @param i
	 */
	public void setNumber(int i) {
		number = i;
	}

}
