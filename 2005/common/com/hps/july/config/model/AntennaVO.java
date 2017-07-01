/*
 * Created on 15.09.2006
 *
 * Данные антенны
 */
package com.hps.july.config.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author dima
 *
 */
public class AntennaVO implements Serializable {

	private int code;
	private ResourceVO resource;
	private String comment;
	private String countPolicy;
	private Integer storagecard;
	private String serialnumber;
	private String inventserial;
	private String localserial;
	private boolean haveSerial;
	private boolean haveInventSerial;
	private boolean haveLocalSerial;
	private boolean broken;
	
	private String recordStatus;
	private String previousRecordStatus;
	
	private java.math.BigDecimal azimuth;
	private java.math.BigDecimal hset;
	private java.math.BigDecimal nakl;
	private StringSelectorVO kindant900;
	private StringSelectorVO kindant1800;
	private StringSelectorVO locationtype;
	private ResourceVO cable1;
	private java.math.BigDecimal cablen1;
	private ResourceVO cable2;
	private java.math.BigDecimal cablen2;
	private boolean commoncable;
	private java.math.BigDecimal ksvn900;
	private java.math.BigDecimal ksvn1800;
	private SectorVO sector900;
	private SectorVO sector1800;
	private boolean emptySerials;

	public AntennaVO() {
		super();
		resource = new ResourceVO();
		kindant900 = new StringSelectorVO(null, getKindAntName(null));
		kindant1800 = new StringSelectorVO(null, getKindAntName(null));
		locationtype = new StringSelectorVO("O", getLocationName("O"));
		cable1 = new ResourceVO();
		cable2 = new ResourceVO();
		recordStatus = "A";
		previousRecordStatus = "U";
		haveSerial = true;
		haveInventSerial = true;
		emptySerials = true;
	}

	public static String getKindAntName(String akindant) {
		if ("T".equals(akindant))
			return "T";
		else if ("R".equals(akindant))
			return "R";
		else if ("D".equals(akindant))
			return "T/R";
		else 
			return "---";
	}
	
	public static String getLocationName(String alocation) {
		if ("I".equals(alocation))
			return "Indoor";
		else if ("O".equals(alocation))
			return "Outdoor";
		else 
			return "---";
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getAzimuth() {
		return azimuth;
	}

	/**
	 * @return
	 */
	public boolean isBroken() {
		return broken;
	}

	/**
	 * @return
	 */
	public int getCode() {
		return code;
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
	public java.math.BigDecimal getHset() {
		return hset;
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
	public StringSelectorVO getKindant1800() {
		return kindant1800;
	}

	/**
	 * @return
	 */
	public StringSelectorVO getKindant900() {
		return kindant900;
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
	public StringSelectorVO getLocationtype() {
		return locationtype;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getNakl() {
		return nakl;
	}

	/**
	 * @return
	 */
	public String getRecordStatus() {
		return recordStatus;
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
	public String getSerialnumber() {
		return serialnumber;
	}

	/**
	 * @param decimal
	 */
	public void setAzimuth(java.math.BigDecimal decimal) {
		azimuth = decimal;
	}

	/**
	 * @param b
	 */
	public void setBroken(boolean b) {
		broken = b;
	}

	/**
	 * @param i
	 */
	public void setCode(int i) {
		code = i;
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
	 * @param decimal
	 */
	public void setHset(java.math.BigDecimal decimal) {
		hset = decimal;
	}

	/**
	 * @param string
	 */
	public void setInventserial(String string) {
		inventserial = string;
	}

	/**
	 * @param selectorVO
	 */
	public void setKindant1800(StringSelectorVO selectorVO) {
		kindant1800 = selectorVO;
	}

	/**
	 * @param selectorVO
	 */
	public void setKindant900(StringSelectorVO selectorVO) {
		kindant900 = selectorVO;
	}

	/**
	 * @param string
	 */
	public void setLocalserial(String string) {
		localserial = string;
	}

	/**
	 * @param selectorVO
	 */
	public void setLocationtype(StringSelectorVO selectorVO) {
		locationtype = selectorVO;
	}

	/**
	 * @param decimal
	 */
	public void setNakl(java.math.BigDecimal decimal) {
		nakl = decimal;
	}

	/**
	 * @param string
	 */
	public void setRecordStatus(String string) {
		recordStatus = string;
	}

	/**
	 * @param resourceVO
	 */
	public void setResource(ResourceVO resourceVO) {
		resource = resourceVO;
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
	public ResourceVO getCable1() {
		return cable1;
	}

	/**
	 * @return
	 */
	public ResourceVO getCable2() {
		return cable2;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getCablen1() {
		return cablen1;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getCablen2() {
		return cablen2;
	}

	/**
	 * @return
	 */
	public boolean isCommoncable() {
		return commoncable;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getKsvn1800() {
		return ksvn1800;
	}

	/**
	 * @return
	 */
	public java.math.BigDecimal getKsvn900() {
		return ksvn900;
	}

	/**
	 * @param resourceVO
	 */
	public void setCable1(ResourceVO resourceVO) {
		cable1 = resourceVO;
	}

	/**
	 * @param resourceVO
	 */
	public void setCable2(ResourceVO resourceVO) {
		cable2 = resourceVO;
	}

	/**
	 * @param decimal
	 */
	public void setCablen1(java.math.BigDecimal decimal) {
		cablen1 = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setCablen2(java.math.BigDecimal decimal) {
		cablen2 = decimal;
	}

	/**
	 * @param b
	 */
	public void setCommoncable(boolean b) {
		commoncable = b;
	}

	/**
	 * @param decimal
	 */
	public void setKsvn1800(java.math.BigDecimal decimal) {
		ksvn1800 = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setKsvn900(java.math.BigDecimal decimal) {
		ksvn900 = decimal;
	}
	
	/**
	 * @return
	 */
	public SectorVO getSector1800() {
		return sector1800;
	}

	/**
	 * @return
	 */
	public SectorVO getSector900() {
		return sector900;
	}

	/**
	 * @param sectorVO
	 */
	public void setSector1800(SectorVO sectorVO) {
		sector1800 = sectorVO;
	}

	/**
	 * @param sectorVO
	 */
	public void setSector900(SectorVO sectorVO) {
		sector900 = sectorVO;
	}

	public SectorVO getSectorInDiap(short diap) {
		SectorVO svo = null;
		if (diap == SectorVO.DIAP900)  
			svo = getSector900();
		else if (diap == SectorVO.DIAP1800)  
			svo = getSector1800();
		return svo;
	}
	
	public void setSectorInDiap(short diap, SectorVO svo) {
		if (diap == SectorVO.DIAP900)  
			setSector900(svo);
		else if (diap == SectorVO.DIAP1800)  
			setSector1800(svo);
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
