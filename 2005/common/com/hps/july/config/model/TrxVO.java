/*
 * Created on 21.09.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * TRX value object
 * @author dima
 *
 */
public class TrxVO implements Serializable {
	
	private int idtrx;
	private ResourceVO resource;
	private BSStandVO bsstand;
	private Integer storagecard;
	private java.math.BigDecimal qty;
	
	private String recordStatus;
	private String previousRecordStatus;
	
	private boolean broken;
	private String comment;
	private String countPolicy;
	private String serialnumber;
	private String inventserial;
	private String localserial;
	private boolean haveSerial;
	private boolean haveInventSerial;
	private boolean haveLocalSerial;
	private SectorVO [] sectors900;
	private SectorVO [] sectors1800;
	private boolean emptySerials;

	public TrxVO() {
		super();
		resource = new ResourceVO();
		bsstand = new BSStandVO();
		sectors900 = new SectorVO [5];
		sectors1800 = new SectorVO [5];
		recordStatus = "A";
		haveSerial = true;
		haveInventSerial = true;
		emptySerials = true;
		previousRecordStatus = "U";
	}
	
	public SectorVO getSectorInDiap(short diap, int numSect) {
		SectorVO res = null;
		if (diap == SectorVO.DIAP900) {
			res = sectors900 [numSect];
		} else if (diap == SectorVO.DIAP1800) {
			res = sectors1800 [numSect];
		} 
		return res;
	}

	// Only one sector can be selected at a time in all bands
	public void setSectorInDiap(short diap, int numSect, SectorVO sect) {
		if (sect != null) {
			for (int i=0; i<sectors900.length; ++i) {
				sectors900 [i] = null;
			}
			for (int i=0; i<sectors1800.length; ++i) {
				sectors1800 [i] = null;
			}
		}
		if (diap == SectorVO.DIAP900) {
			sectors900 [numSect] = sect;
		} else if (diap == SectorVO.DIAP1800) {
			sectors1800 [numSect] = sect;
		} 
	}

	/*
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		TrxVO other = (TrxVO)otherObject;
		
		return (namesect.equals(other.namesect) && (band == other.band));
	}
	
	public int hashCode() {
		return new Integer(band).hashCode() + 11 * namesect.hashCode();
	}
	
	public int compareTo(Object other) {
		return namesect.compareTo(((TrxVO)other).namesect);
	}
	*/
	
	/**
	 * @return
	 */
	public int getIdtrx() {
		return idtrx;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getQty() {
		return qty;
	}

	/**
	 * @return
	 */
	public ResourceVO getResource() {
		return resource;
	}

	/**
	 * @return
	 */
	public Integer getStoragecard() {
		return storagecard;
	}

	/**
	 * @param i
	 */
	public void setIdtrx(int i) {
		idtrx = i;
	}

	/**
	 * @param decimal
	 */
	public void setQty(java.math.BigDecimal decimal) {
		qty = decimal;
	}

	/**
	 * @param resourceVO
	 */
	public void setResource(ResourceVO resourceVO) {
		resource = resourceVO;
	}

	/**
	 * @param integer
	 */
	public void setStoragecard(Integer integer) {
		storagecard = integer;
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
	public BSStandVO getBsstand() {
		return bsstand;
	}

	/**
	 * @param standVO
	 */
	public void setBsstand(BSStandVO standVO) {
		bsstand = standVO;
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
	public boolean isEmptySerials() {
		return emptySerials;
	}

	/**
	 * @param b
	 */
	public void setEmptySerials(boolean b) {
		emptySerials = b;
	}

	public String getPreviousRecordStatus() {
		return previousRecordStatus;
	}

	public void setPreviousRecordStatus(String string) {
		previousRecordStatus = string;
	}

	public SectorVO[] getSectors1800() {
		return sectors1800;
	}

	public SectorVO[] getSectors900() {
		return sectors900;
	}

}
