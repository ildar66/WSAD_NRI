/*
 * Created on 30.03.2007
 *
 * История изменения описей TO.
 */
package com.hps.july.arenda.valueobject;

/**
 * @author IShaffigulin
 *
 * История изменения описей TO.
 */
public class LeaseRegistryBuchDocsHistory_TO {
	private LeaseRegistryBuchDocsHistory_VO vo = null;
	private String peopleName = null;

	/**
	 * 
	 * @param aVo
	 */
	public LeaseRegistryBuchDocsHistory_TO(LeaseRegistryBuchDocsHistory_VO aVo) {
		setVo(aVo);
	}

	/**
	 * @return
	 */
	public String getPeopleName() {
		return peopleName;
	}

	/**
	 * @return
	 */
	public LeaseRegistryBuchDocsHistory_VO getVo() {
		return vo;
	}

	/**
	 * @param string
	 */
	public void setPeopleName(String string) {
		peopleName = string;
	}

	/**
	 * @param history_VO
	 */
	private void setVo(LeaseRegistryBuchDocsHistory_VO history_VO) {
		vo = history_VO;
	}

}
