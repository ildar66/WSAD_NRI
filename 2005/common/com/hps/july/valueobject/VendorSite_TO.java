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
 * Справочник отделений Поставщиков TO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class VendorSite_TO extends Base_TO{
	private VendorSite_VO vo;
	private String ownerName;
	private Vendor_VO vendor_VO;
	private String createdBy;
	private String modifiedBy;

	/**
	 * 
	 */
	public VendorSite_TO(VendorSite_VO argVo) {
		vo = argVo;
	}

	/**
	 * @return
	 */
	public VendorSite_VO getVo() {
		return vo;
	}

	/**
	 * @param site_VO
	 */
	public void setVo(VendorSite_VO site_VO) {
		vo = site_VO;
	}

	/**
	 * @return
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param string
	 */
	public void setOwnerName(String string) {
		ownerName = string;
	}

	/**
	 * @return
	 */
	public Vendor_VO getVendor_VO() {
		return vendor_VO;
	}

	/**
	 * @param vendor_VO
	 */
	public void setVendor_VO(Vendor_VO vendor_VO) {
		this.vendor_VO = vendor_VO;
	}

	/**
	 * @return
	 */
	public String getInfo() {
		return "(" + vo.getVendorSiteCode() + ") " + vo.getName();
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
}
