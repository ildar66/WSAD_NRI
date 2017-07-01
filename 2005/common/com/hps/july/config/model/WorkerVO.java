/*
 * Created on 10.08.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * Value object to hold workers
 * @author dima
 *
 */
public class WorkerVO implements Serializable, Comparable {

	private int code;
	private String name;
	
	public WorkerVO() {
		super();
	}
	
	public WorkerVO(int acode, String aname) {
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
		
		WorkerVO other = (WorkerVO)otherObject;
		
		return (code == other.code);
	}
	
	public int hashCode() {
		return new Integer(code).hashCode();
	}
	
	public int compareTo(Object other) {
		return name.compareTo(((WorkerVO)other).name);
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
		System.out.println("name = " + name);
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
		System.out.println("setName!!!!!!!!!!!!!!!");
		name = string;
	}

}
