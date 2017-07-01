/*
 * Created on 21.01.2006
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
public class AdminRegion_TO {
	private AdminRegion_VO vo;
	private int countChild;
	private String nameRegionNRI;
	private String regionTypeName;

	/**
	 * 
	 */
	public AdminRegion_TO(AdminRegion_VO vo) {
		this.vo = vo;
	}

	/**
	 * @return
	 */
	public int getCountChild() {
		return countChild;
	}

	/**
	 * @return
	 */
	public AdminRegion_VO getVo() {
		return vo;
	}

	/**
	 * @param i
	 */
	public void setCountChild(int i) {
		countChild = i;
	}

	/**
	 * @param region_VO
	 */
	public void setVo(AdminRegion_VO region_VO) {
		vo = region_VO;
	}

	/**
	 * @return
	 */
	public String getNameRegionNRI() {
		return nameRegionNRI;
	}

	/**
	 * @param string
	 */
	public void setNameRegionNRI(String string) {
		nameRegionNRI = string;
	}

	/**
	 * @return
	 */
	public String getRegionTypeName() {
		return regionTypeName;
	}

	/**
	 * @param string
	 */
	public void setRegionTypeName(String string) {
		regionTypeName = string;
	}

}
