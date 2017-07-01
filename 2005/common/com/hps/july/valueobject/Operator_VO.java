/*
 * Created on 22.06.2007
 *
 * Оператор NRI(VO)
 */
package com.hps.july.valueobject;

import java.sql.Timestamp;

/**
 * @author IShaffigulin
 *
 * Оператор NRI(VO)
 */
public class Operator_VO {
	private Integer operator = null;
	private Integer man = null;
	private String loiginID = null;
	private String isEnabled = null;
	private Integer msuCode = null;
	private Timestamp lastLoginTime = null;
	private Integer lastRegionID = null;

	/**
	 * 
	 */
	public Operator_VO(Integer aOperator) {
		setOperator(aOperator);
	}

	/**
	 * @return
	 */
	public String getIsEnabled() {
		return isEnabled;
	}

	/**
	 * @return
	 */
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @return
	 */
	public Integer getLastRegionID() {
		return lastRegionID;
	}

	/**
	 * @return
	 */
	public String getLoiginID() {
		return loiginID;
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
	public Integer getMsuCode() {
		return msuCode;
	}

	/**
	 * @return
	 */
	public Integer getOperator() {
		return operator;
	}

	/**
	 * @param string
	 */
	public void setIsEnabled(String string) {
		isEnabled = string;
	}

	/**
	 * @param timestamp
	 */
	public void setLastLoginTime(Timestamp timestamp) {
		lastLoginTime = timestamp;
	}

	/**
	 * @param integer
	 */
	public void setLastRegionID(Integer integer) {
		lastRegionID = integer;
	}

	/**
	 * @param string
	 */
	public void setLoiginID(String string) {
		loiginID = string;
	}

	/**
	 * @param integer
	 */
	public void setMan(Integer integer) {
		man = integer;
	}

	/**
	 * @param integer
	 */
	public void setMsuCode(Integer integer) {
		msuCode = integer;
	}

	/**
	 * @param integer
	 */
	private void setOperator(Integer integer) {
		operator = integer;
	}

}
