/*
 * Created on 24.07.2006
 *
 * Общие свойства для объектов конфигурации оборудования БС
 */
package com.hps.july.inventory.valueobject;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BSEquipCommonVO {
	
	public static final String KEEP_STATE = "K";
	public static final String UPDATE_STATE = "U";
	public static final String ADD_STATE = "A";
	public static final String DELETE_STATE = "D";
	
	private Integer configId;
	private Integer baseStationId;
	private Integer partId;
	private String curState;
	private Boolean inStore;
	
	public BSEquipCommonVO() {
		configId = new Integer(0);
		baseStationId = new Integer(0);
		partId = new Integer(0);
		inStore = new Boolean(false); 
		curState = "";
	}
		
	/**
	 * @return
	 */
	public Boolean getIsKeep() {
		return new Boolean(KEEP_STATE.equals(curState));
	}

	/**
	 * @return
	 */
	public Boolean getIsDeleted() {
		return new Boolean(DELETE_STATE.equals(curState));
	}

	/**
	 * @return
	 */
	public Boolean getIsUpdeted() {
		return new Boolean(UPDATE_STATE.equals(curState));
	}

	/**
	 * @return
	 */
	public Boolean getIsAdded() {
		return new Boolean(ADD_STATE.equals(curState));
	}

	/**
	 * @return
	 */
	public Integer getPartId() {
		return partId;
	}

	/**
	 * @param string
	 */
	public void setPartId(Integer integer) {
		partId = integer;
	}

	/**
	 * @return
	 */
	public String getCurState() {
		return curState;
	}

	/**
	 * @param string
	 */
	public void setCurState(String string) {
		curState = string;
	}

	/**
	 * @return
	 */
	public Boolean getInStore() {
		return inStore;
	}

	/**
	 * @param boolean1
	 */
	public void setInStore(Boolean boolean1) {
		inStore = boolean1;
	}

	/**
	 * @return
	 */
	public Integer getConfigId() {
		return configId;
	}

	/**
	 * @param integer
	 */
	public void setConfigId(Integer integer) {
		configId = integer;
	}

	/**
	 * @return
	 */
	public Integer getBaseStationId() {
		return baseStationId;
	}

	/**
	 * @param integer
	 */
	public void setBaseStationId(Integer integer) {
		baseStationId = integer;
	}

}
