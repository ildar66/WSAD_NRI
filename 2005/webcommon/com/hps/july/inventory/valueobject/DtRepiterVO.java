/*
 * Created on 30.06.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.inventory.valueobject;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DtRepiterVO {
	private Integer num;
	private String 	donorSector;
	private String 	connType;
	private String 	state;
	
	/**
	 * @return
	 */
	public String getConnType() {
		return connType;
	}

	/**
	 * @return
	 */
	public String getDonorSector() {
		return donorSector;
	}

	/**
	 * @return
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param string
	 */
	public void setConnType(String string) {
		connType = string;
	}

	/**
	 * @param string
	 */
	public void setDonorSector(String string) {
		donorSector = string;
	}

	/**
	 * @param integer
	 */
	public void setNum(Integer integer) {
		num = integer;
	}

	/**
	 * @param string
	 */
	public void setState(String string) {
		state = string;
	}

}
