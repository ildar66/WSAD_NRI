/*
 * Created on 21.11.2006
 */
package com.hps.july.dictionary.valueobject;

/**
 * @author irogachev
 */
public class CmplStruct_VO {

	private String nriCode;
	private String resourceName;
	private String model;
	private String quantity;
	private String unit_name;
	private String nfsid;
	private String count_nfs;
	private boolean enablednfs;

	/**
	 * 
	 */
	public CmplStruct_VO() {
		super();
	}

	public boolean getEnablednfs(){
		return enablednfs;
	}
	
	public void setEnablednfs(boolean newEnablednfs){
		enablednfs = newEnablednfs;
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
	public String getNriCode() {
		return nriCode;
	}

	/**
	 * @return
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @return
	 */
	public String getResourceName() {
		return resourceName;
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
	public void setNriCode(String string) {
		nriCode = string;
	}

	/**
	 * @param string
	 */
	public void setQuantity(String string) {
		quantity = string;
	}

	/**
	 * @param string
	 */
	public void setResourceName(String string) {
		resourceName = string;
	}

	/**
	 * @return
	 */
	public String getNfsid() {
		return nfsid;
	}

	/**
	 * @return
	 */
	public String getUnit_name() {
		return unit_name;
	}

	/**
	 * @param string
	 */
	public void setNfsid(String string) {
		nfsid = string;
	}

	/**
	 * @param string
	 */
	public void setUnit_name(String string) {
		unit_name = string;
	}

	/**
	 * @return
	 */
	public String getCount_nfs() {
		return count_nfs;
	}

	/**
	 * @param string
	 */
	public void setCount_nfs(String string) {
		count_nfs = string;
	}

}
