/*
 * Created on 09.08.2006
 *
 * Данные шкафа
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * @author dima
 *
 */
public class BSStandVO implements Serializable, Comparable {

	private int code;
	private ResourceVO resource;
	private String standno;
	private String comment;
	private Integer storagecard;
	private String countPolicy;
	private String serialnumber;
	private String inventserial;
	private String localserial;
	private boolean haveSerial;
	private boolean haveInventSerial;
	private boolean haveLocalSerial;
	private boolean broken;
	private int trx_num;
	
	private String recordStatus;
	private String previousRecordStatus;
	
	private boolean emptySerials;
	public static int codeserial = -1;

	public BSStandVO() {
		super();
		setCode(codeserial);
		codeserial--;
		setRecordStatus("A");
		previousRecordStatus = "U";
		resource = new ResourceVO();
		haveSerial = true;
		haveInventSerial = true;
		emptySerials = true;
	}
	
	public String toString() {
		return standno;
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		BSStandVO other = (BSStandVO)otherObject;
		
		return (code == other.code);
	}
	
	public int hashCode() {
		return new Integer(code).hashCode();
	}

	public int compareTo(Object other) {
		
		if (other != null) {
			if (code < ((BSStandVO)other).code)
				return -1;
			else if (code == ((BSStandVO)other).code)
				return 0;
			else
				return 1;
		} else {
			return 1;
		}
	}
	
	/**
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @return
	 */
	public String getCountPolicy() {
		return countPolicy;
	}

	/**
	 * @return
	 */
	public boolean isHaveInventSerial() {
		return haveInventSerial;
	}

	/**
	 * @return
	 */
	public boolean isHaveLocalSerial() {
		return haveLocalSerial;
	}

	/**
	 * @return
	 */
	public boolean isHaveSerial() {
		return haveSerial;
	}

	/**
	 * @return
	 */
	public String getInventserial() {
		return inventserial;
	}

	/**
	 * @return
	 */
	public String getLocalserial() {
		return localserial;
	}

	/**
	 * @return
	 */
	public String getSerialnumber() {
		return serialnumber;
	}

	/**
	 * @param string
	 */
	public void setComment(String string) {
		comment = string;
	}

	/**
	 * @param string
	 */
	public void setCountPolicy(String string) {
		countPolicy = string;
	}

	/**
	 * @param b
	 */
	public void setHaveInventSerial(boolean b) {
		haveInventSerial = b;
	}

	/**
	 * @param b
	 */
	public void setHaveLocalSerial(boolean b) {
		haveLocalSerial = b;
	}

	/**
	 * @param b
	 */
	public void setHaveSerial(boolean b) {
		haveSerial = b;
	}

	/**
	 * @param string
	 */
	public void setInventserial(String string) {
		inventserial = string;
	}

	/**
	 * @param string
	 */
	public void setLocalserial(String string) {
		localserial = string;
	}

	/**
	 * @param string
	 */
	public void setSerialnumber(String string) {
		serialnumber = string;
	}

	/**
	 * @return
	 */
	public boolean isBroken() {
		return broken;
	}

	/**
	 * @param b
	 */
	public void setBroken(boolean b) {
		broken = b;
	}

	/**
	 * @return
	 */
	public ResourceVO getResource() {
		return resource;
	}

	/**
	 * @param manufacturerVO
	 */
	public void setResource(ResourceVO resourceVO) {
		resource = resourceVO;
	}

	/**
	 * @return
	 */
	public int getTrx_num() {
		return trx_num;
	}

	/**
	 * @param i
	 */
	public void setTrx_num(int i) {
		trx_num = i;
	}

	/**
	 * @return
	 */
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @param string
	 */
	public void setRecordStatus(String string) {
		recordStatus = string;
	}

	/**
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param i
	 */
	public void setCode(int i) {
		code = i;
	}

	/**
	 * @return
	 */
	public String getStandno() {
		return standno;
	}

	/**
	 * @param string
	 */
	public void setStandno(String string) {
		standno = string;
	}

	/**
	 * @return
	 */
	public boolean isEmptySerials() {
		return emptySerials;
	}

	/**
	 * @param b
	 */
	public void setEmptySerials(boolean b) {
		emptySerials = b;
	}

	/**
	 * @return
	 */
	public Integer getStoragecard() {
		return storagecard;
	}

	/**
	 * @param integer
	 */
	public void setStoragecard(Integer integer) {
		storagecard = integer;
	}


	public String getPreviousRecordStatus() {
		return previousRecordStatus;
	}

	public void setPreviousRecordStatus(String string) {
		previousRecordStatus = string;
	}

}
