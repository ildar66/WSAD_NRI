/*
 * Created on 05.04.2006
 *
 * "Заказчик" VO
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * "Заказчик" VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class OwnerContract2FilialNri_VO {
	private Integer idOwnerContract = null;
	private String name = null;

	/**
	 * 
	 */
	public OwnerContract2FilialNri_VO(Integer id, String aName) {
		idOwnerContract = id;
		name = aName;
	}

	/**
	 * @return
	 */
	public Integer getIdOwnerContract() {
		return idOwnerContract;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param integer
	 */
	private void setIdOwnerContract(Integer integer) {
		idOwnerContract = integer;
	}

	/**
	 * @param string
	 */
	private void setName(String string) {
		name = string;
	}

}
