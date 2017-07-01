/*
 * Created on 10.08.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * Value object to hold store characteristics
 * @author dima
 *
 */
public class StoreVO implements Serializable, Comparable, Cloneable {

	private int code;
	private String name;
	
	public StoreVO() {
		super();
	}
	
	public StoreVO(int acode, String aname) {
		super();
		code = acode;
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
		
		StoreVO other = (StoreVO)otherObject;
		
		return (code == other.code);
	}
	
	public int hashCode() {
		return new Integer(code).hashCode();
	}
	
	// To sort by name
	public int compareTo(Object other) {
		return name.compareTo(((StoreVO)other).name);
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

}
