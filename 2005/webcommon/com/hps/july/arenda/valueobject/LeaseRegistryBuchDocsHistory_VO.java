/*
 * Created on 30.03.2007
 *
 * История изменения описей VO.
 */
package com.hps.july.arenda.valueobject;

import java.sql.Timestamp;

/**
 * @author IShaffigulin
 *
 * История изменения описей VO.
 */
public class LeaseRegistryBuchDocsHistory_VO {
	private Integer historyId = null; //ID записи(PK).
	private Integer idRegistryDoc = null; //ID описи.
	private Integer man = null; //код Оператора.
	private Timestamp actionTime = null; //Время записи.
	private RegistryBuchDocsState state = null; //Состояние. 

	/**
	 * 
	 * @param aHistoryId
	 * @param aIdRegistryDoc
	 * @param aOperator
	 * @param aActionTime
	 * @param aState
	 */
	public LeaseRegistryBuchDocsHistory_VO(Integer aHistoryId, Integer aIdRegistryDoc, Integer aOperator, Timestamp aActionTime, RegistryBuchDocsState aState) {
		historyId = aHistoryId;
		idRegistryDoc = aIdRegistryDoc;
		man = aOperator;
		actionTime = aActionTime;
		state = aState;
	}

	/**
	 * @return
	 */
	public Timestamp getActionTime() {
		return actionTime;
	}

	/**
	 * @return
	 */
	public Integer getHistoryId() {
		return historyId;
	}

	/**
	 * @return
	 */
	public Integer getIdRegistryDoc() {
		return idRegistryDoc;
	}

	/**
	 * @return
	 */
	public Integer getMan() {
		return man;
	}

	/**
	 * @return
	 */
	public RegistryBuchDocsState getState() {
		return state;
	}

}
