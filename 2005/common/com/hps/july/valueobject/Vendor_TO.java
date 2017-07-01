/*
 * Created on 11.08.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * Поставщики TO Object.
 */
public class Vendor_TO extends Base_TO {
	private Vendor_VO vo;
	private String createdBy;
	private String modifiedBy;
	/**
	 * 
	 */
	public Vendor_TO(Vendor_VO aVO) {
		super();
		vo = aVO;
	}	

	/**
	 * @return
	 */
	public Vendor_VO getVo() {
		return vo;
	}

	/**
	 * @param vendor_VO
	 */
	public void setVo(Vendor_VO vendor_VO) {
		vo = vendor_VO;
	}
	/**
	 * @return
	 */
	public String getPassportDate() {
		return getStringFromDate(getVo().getPassportDate());
	}
	/**
	 */
	public void setPassportDate(String dateStr) {
		getVo().setPassportDate(getDateFromString(dateStr));
	}
	/**
	 * @return
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param string
	 */
	public void setCreatedBy(String string) {
		createdBy = string;
	}

	/**
	 * @param string
	 */
	public void setModifiedBy(String string) {
		modifiedBy = string;
	}

}
