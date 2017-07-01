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
public class ManufacturerVO implements Serializable {

	private int code;
	private String name;
	
	public ManufacturerVO() {
		super();
	}
	
	public ManufacturerVO(int acode, String aname) {
		super();
		code = acode;
		name = aname;
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

}
