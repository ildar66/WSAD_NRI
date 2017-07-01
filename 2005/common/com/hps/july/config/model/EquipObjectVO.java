/*
 * Created on 16.11.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * TRX value object
 * @author dima
 * 
 */
public class EquipObjectVO implements Serializable {
	
	private int idequipobject;
	private int idequipcategory;
	private ResourceVO resource;
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
	private Integer parentObject;
	private boolean emptySerials;
	private SectorVO [] sectors900;
	private SectorVO [] sectors1800;

	public EquipObjectVO() {
		super();
		resource = new ResourceVO();
		recordStatus = "A";
		previousRecordStatus = "U";
		haveSerial = true;
		haveInventSerial = true;
		emptySerials = true;
		sectors900 = new SectorVO [5];
		sectors1800 = new SectorVO [5];
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
	
	// One sector in each band can be selected at a time
	public void setSectorInDiapAllowTwo(short diap, int numSect, SectorVO sect) {
		if (sect != null) {
			if (diap == SectorVO.DIAP900) {
				for (int i=0; i<sectors900.length; ++i) {
					sectors900 [i] = null;
				}
			}
			if (diap == SectorVO.DIAP1800) {
				for (int i=0; i<sectors1800.length; ++i) {
					sectors1800 [i] = null;
				}
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
	public int getIdequipobject() {
		return idequipobject;
	}

	/**
	 * @param i
	 */
	public void setIdequipobject(int i) {
		idequipobject = i;
	}

	/**
	 * @return
	 */
	public int getIdequipcategory() {
		return idequipcategory;
	}

	/**
	 * @param i
	 */
	public void setIdequipcategory(int i) {
		idequipcategory = i;
	}

	/**
	 * @return
	 */
	public Integer getParentObject() {
		return parentObject;
	}

	/**
	 * @param integer
	 */
	public void setParentObject(Integer integer) {
		parentObject = integer;
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
	public String getCountPolicy() {
		return countPolicy;
	}

	/**
	 * @param string
	 */
	public void setCountPolicy(String string) {
		countPolicy = string;
	}

	public String getPreviousRecordStatus() {
		return previousRecordStatus;
	}

	public void setPreviousRecordStatus(String string) {
		previousRecordStatus = string;
	}

	/**
	 * @return
	 */
	public SectorVO[] getSectors1800() {
		return sectors1800;
	}

	/**
	 * @return
	 */
	public SectorVO[] getSectors900() {
		return sectors900;
	}

	/**
	 * @param sectorVOs
	 */
	public void setSectors1800(SectorVO[] sectorVOs) {
		sectors1800 = sectorVOs;
	}

	/**
	 * @param sectorVOs
	 */
	public void setSectors900(SectorVO[] sectorVOs) {
		sectors900 = sectorVOs;
	}

}
