package com.hps.july.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (22.11.2005 12:12:42)
 * @author: Shafigullin Ildar
 */
public class RegionsAccess_TO {
	private RegionsAccess_VO vo = null;
	private java.lang.String regionName = null;
	private String supRegName = null;
	private Currency_VO nationalCurrVO = null;
	/**
	 * RegionsAccess_TO constructor comment.
	 */
	public RegionsAccess_TO(RegionsAccess_VO vo) {
		super();
		this.vo = vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 17:30:33)
	 * @return boolean
	 */
	public boolean getEditarenda() {
		return "Y".equals(vo.getEditarenda());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 17:30:33)
	 * @return boolean
	 */
	public boolean getEditfact() {
		return "Y".equals(vo.getEditfact());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 17:30:33)
	 * @return boolean
	 */
	public boolean getEditplan() {
		return "Y".equals(vo.getEditplan());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.11.2005 12:14:19)
	 * @return java.lang.String
	 */
	public java.lang.String getRegionName() {
		return regionName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 17:30:33)
	 * @return boolean
	 */
	public boolean getViewarenda() {
		return "Y".equals(vo.getViewarenda());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 17:30:33)
	 * @return boolean
	 */
	public boolean getViewfact() {
		return "Y".equals(vo.getViewfact());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 17:30:33)
	 * @return boolean
	 */
	public boolean getViewplan() {
		return "Y".equals(vo.getViewplan());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.11.2005 12:13:19)
	 * @return com.hps.july.valueobject.RegionsAccess_VO
	 */
	public RegionsAccess_VO getVo() {
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.11.2005 12:14:19)
	 * @param newRegionName java.lang.String
	 */
	public void setRegionName(java.lang.String newRegionName) {
		regionName = newRegionName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.11.2005 12:13:19)
	 * @param newVo com.hps.july.valueobject.RegionsAccess_VO
	 */
	private void setVo(RegionsAccess_VO newVo) {
		vo = newVo;
	}
	/**
	 * @return
	 */
	public String getSupRegName() {
		return supRegName;
	}

	/**
	 * @param string
	 */
	public void setSupRegName(String string) {
		supRegName = string;
	}

	/**
	 * @return
	 */
	public Currency_VO getNationalCurrVO() {
		return nationalCurrVO;
	}

	/**
	 * @param currency_VO
	 */
	public void setNationalCurrVO(Currency_VO currency_VO) {
		nationalCurrVO = currency_VO;
	}

}
