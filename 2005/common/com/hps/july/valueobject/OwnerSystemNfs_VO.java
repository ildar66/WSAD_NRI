/*
 * Created on 05.04.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * "владельцы" VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class OwnerSystemNfs_VO {
	private Integer idOwnerNFS = null;
	private String nameOwnerNFS = null;

	/**
	 * 
	 */
	public OwnerSystemNfs_VO(Integer id, String name) {
		idOwnerNFS = id;
		nameOwnerNFS = name;
	}

	/**
	 * @return
	 */
	public Integer getIdOwnerNFS() {
		return idOwnerNFS;
	}

	/**
	 * @return
	 */
	public String getNameOwnerNFS() {
		return nameOwnerNFS;
	}

	/**
	 * @param integer
	 */
	public void setIdOwnerNFS(Integer integer) {
		idOwnerNFS = integer;
	}

	/**
	 * @param string
	 */
	public void setNameOwnerNFS(String string) {
		nameOwnerNFS = string;
	}

}
