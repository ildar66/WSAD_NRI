/*
 * Created on 29.01.2007
 */
package com.hps.july.dictionary.valueobject;

/**
 * @author irogachev
 */
public class Cable_VO extends Resource_VO {

	private String diamid;
	
	private String diamname; 


	public Cable_VO() {
		super();
	}

	/**
	 * @return
	 */
	public String getDiamid() {
		return diamid;
	}

	/**
	 * @return
	 */
	public String getDiamname() {
		return diamname;
	}

	/**
	 * @param string
	 */
	public void setDiamid(String string) {
		diamid = string;
	}

	/**
	 * @param string
	 */
	public void setDiamname(String string) {
		diamname = string;
	}

}
