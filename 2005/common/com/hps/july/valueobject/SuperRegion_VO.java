/*
 * Created on 23.01.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SuperRegion_VO {
	private Integer supRegID;//Идентификатор суперрегионов
	private String supRegName;//Наименование суперрегиона
	private Integer supRegCode;//Код суперрегиона
	/**
	 * 
	 */
	public SuperRegion_VO(Integer supRegID) {
		this.supRegID = supRegID;
	}

	/**
	 * @return
	 */
	public Integer getSupRegCode() {
		return supRegCode;
	}

	/**
	 * @return
	 */
	public Integer getSupRegID() {
		return supRegID;
	}

	/**
	 * @return
	 */
	public String getSupRegName() {
		return supRegName;
	}

	/**
	 * @param integer
	 */
	public void setSupRegCode(Integer integer) {
		supRegCode = integer;
	}

	/**
	 * @param integer
	 */
	public void setSupRegID(Integer integer) {
		supRegID = integer;
	}

	/**
	 * @param string
	 */
	public void setSupRegName(String string) {
		supRegName = string;
	}

}
