/*
 * Created on 21.11.2006
 */
package com.hps.july.dictionary.valueobject;

/**
 * @author irogachev
 */
public class CurComplect_VO {

	private String complectCode;
	private String nfsId;
	private String nfsCode;
	private String nfsName;
	private String complectName;
	private String power;

	public CurComplect_VO() {
		super();
	}

	/**
	 * @return
	 */
	public String getComplectCode() {
		return complectCode;
	}

	/**
	 * @return
	 */
	public String getComplectName() {
		return complectName;
	}

	/**
	 * @return
	 */
	public String getNfsCode() {
		return nfsCode;
	}

	/**
	 * @return
	 */
	public String getPower() {
		return power;
	}

	/**
	 * @param string
	 */
	public void setComplectCode(String string) {
		complectCode = string;
	}

	/**
	 * @param string
	 */
	public void setComplectName(String string) {
		complectName = string;
	}

	/**
	 * @param string
	 */
	public void setNfsCode(String string) {
		nfsCode = string;
	}

	/**
	 * @param string
	 */
	public void setPower(String string) {
		power = string;
	}
	
	public String toString() {
		String delimiterStr = " # ";
		String outStr = complectCode + delimiterStr + nfsCode + delimiterStr + complectName + delimiterStr + power;
		return outStr;    
	}

	/**
	 * @param string
	 */
	public void setNfsName(String string) {
		nfsName = string;
	}

	/**
	 * @return
	 */
	public String getNfsName() {
		return nfsName;
	}

	/**
	 * @return
	 */
	public String getNfsId() {
		return nfsId;
	}

	/**
	 * @param string
	 */
	public void setNfsId(String string) {
		nfsId = string;
	}

}
