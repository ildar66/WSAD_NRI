/*
 * Created on 07.07.2006
 *
 * "Основные данные позиций (сайтов)" TO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Position_TO {
	private PositionVO vo = null;
	private String nameOtvPos = null;
	private Integer leaseDocument = null;
	private Integer mainPosition = null;
	private String docNumber = null;
	private String gsmIDs = null;
	private String dampsIDs = null;
	/**
	 * 
	 */
	public Position_TO(PositionVO aVo) {
		super();
		vo = aVo;
	}

	/**
	 * @return
	 */
	public PositionVO getVo() {
		return vo;
	}

	/**
	 * @param positionVO
	 */
	public void setVo(PositionVO positionVO) {
		vo = positionVO;
	}

	/**
	 * @return
	 */
	public String getNameOtvPos() {
		return nameOtvPos;
	}

	/**
	 * @param string
	 */
	public void setNameOtvPos(String string) {
		nameOtvPos = string;
	}

	/**
	 * @return
	 */
	public Integer getLeaseDocument() {
		return leaseDocument;
	}

	/**
	 * @param integer
	 */
	public void setLeaseDocument(Integer integer) {
		leaseDocument = integer;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		return docNumber;
	}

	/**
	 * @return
	 */
	public Integer getMainPosition() {
		return mainPosition;
	}

	/**
	 * @param string
	 */
	public void setDocNumber(String string) {
		docNumber = string;
	}

	/**
	 * @param integer
	 */
	public void setMainPosition(Integer integer) {
		mainPosition = integer;
	}

	/**
	 * @return
	 */
	public String getDampsIDs() {
		return dampsIDs;
	}

	/**
	 * @return
	 */
	public String getGsmIDs() {
		return gsmIDs;
	}

	/**
	 * @param string
	 */
	public void setDampsIDs(String string) {
		dampsIDs = string;
	}

	/**
	 * @param string
	 */
	public void setGsmIDs(String string) {
		gsmIDs = string;
	}

}
