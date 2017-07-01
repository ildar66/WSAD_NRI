/*
 * Created on 29.01.2007
 */
package com.hps.july.dictionary.valueobject;

/**
 * @author irogachev
 */
public class Resource_VO {

	private String id;
	private String manuf;
	private String model;
	private String unit;
	private String active;
//	private String nfsitemid;
//	private String datatype;
	private String nfsid;
	private String countnfs;

	public Resource_VO() {
		super();
	}

	/**
	 * @return
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @return
	 */
	public String getCountnfs() {
		return countnfs;
	}

	/**
	 * @return
	public String getDatatype() {
		return datatype;
	}
	 */

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getManuf() {
		return manuf;
	}

	/**
	 * @return
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return
	 */
	public String getNfsid() {
		return nfsid;
	}

	/**
	 * @return
	public String getNfsitemid() {
		return nfsitemid;
	}
	 */

	/**
	 * @return
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param string
	 */
	public void setActive(String string) {
		active = string;
	}

	/**
	 * @param string
	 */
	public void setCountnfs(String string) {
		countnfs = string;
	}

	/**
	 * @param string
	public void setDatatype(String string) {
		datatype = string;
	}
	 */

	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
	}

	/**
	 * @param string
	 */
	public void setManuf(String string) {
		manuf = string;
	}

	/**
	 * @param string
	 */
	public void setModel(String string) {
		model = string;
	}

	/**
	 * @param string
	 */
	public void setNfsid(String string) {
		nfsid = string;
	}

	/**
	 * @param string
	public void setNfsitemid(String string) {
		nfsitemid = string;
	}
	 */

	/**
	 * @param string
	 */
	public void setUnit(String string) {
		unit = string;
	}

}
