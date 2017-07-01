/*
 * Created on 26.07.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.inventory.valueobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AntennVO extends BSEquipCommonVO {
	private Integer typeId;
	private String typeName;
	private Boolean resetAllSectors;
	private String sectors900;
	private String sectors1800;
	private BigDecimal azimut;
	private BigDecimal height;
	private BigDecimal maxPitch;
	private String tr900;
	private String tr1800;
	private String implementation;
	// фидеры
	private Integer fider900Id;
	private String  fiderType900Id;
	private String fiderType900Name;
	private List fiderType900List;
	private BigDecimal fider900Length;
	//
	private Integer fider1800Id;
	private String  fiderType1800Id;
	private String fiderType1800Name;
	private List fiderType1800List;
	private BigDecimal fider1800Length;
	//
	private Boolean commonFider;
	private BigDecimal fiderKSVN900;
	private BigDecimal fiderKSVN1800;
	
	public AntennVO() {
		super();
		typeId = new Integer(0);
		typeName = "";
		resetAllSectors = new Boolean(false);
		sectors900 = "";
		sectors1800 = "";
		azimut = new BigDecimal(0);
		height = new BigDecimal(0);
		maxPitch = new BigDecimal(0);
		tr900 = "";
		tr1800 = "";
		implementation = "";
		fiderType900Id = "0"; 
		fiderType900List = new ArrayList();
		fider900Length = new BigDecimal(0);
		fiderType1800Id = "0";
		fiderType1800List = new ArrayList();
		fider1800Length = new BigDecimal(0);
		commonFider = new Boolean(false);
		fiderKSVN900 = new BigDecimal(0);
		fiderKSVN1800 = new BigDecimal(0);
		//
		fider900Id = new Integer(0);
		fiderType900Name = "";
		fider1800Id = new Integer(0);
		fiderType1800Name = "";
	}
	/**
	 * @return
	 */
	public BigDecimal getAzimut() {
		return azimut;
	}

	public String getAzimutStr() {
		return getStringFromBigDecimal(azimut);
	}

	/**
	 * @return
	 */
	public Boolean getCommonFider() {
		return commonFider;
	}

	private String getStringFromBigDecimal(BigDecimal inBigDecimal) {
		return (inBigDecimal != null?inBigDecimal.toString():"");
	}

	/**
	 * @return
	 */
	public BigDecimal getFiderKSVN1800() {
		return fiderKSVN1800;
	}

	public String getFiderKSVN1800Str() {
		return getStringFromBigDecimal(fiderKSVN1800);
	}

	/**
	 * @return
	 */
	public BigDecimal getFiderKSVN900() {
		return fiderKSVN900;
	}

	public String getFiderKSVN900Str() {
		return getStringFromBigDecimal(fiderKSVN900);
	}

	/**
	 * @return
	 */
	public String getFiderType1800Id() {
		return fiderType1800Id;
	}

	/**
	 * @return
	 */
	public BigDecimal getFider1800Length() {
		return fider1800Length;
	}

	public String getFider1800LengthStr() {
		return getStringFromBigDecimal(fider1800Length);
	}


	/**
	 * @return
	 */
	public List getFiderType1800List() {
		return fiderType1800List;
	}

	/**
	 * @return
	 */
	public String getFiderType900Id() {
		return fiderType900Id;
	}

	/**
	 * @return
	 */
	public BigDecimal getFider900Length() {
		return fider900Length;
	}

	public String getFider900LengthStr() {
		return getStringFromBigDecimal(fider900Length);
	}

	/**
	 * @return
	 */
	public List getFiderType900List() {
		return fiderType900List;
	}

	/**
	 * @return
	 */
	public BigDecimal getHeight() {
		return height;
	}

	public String getHeightStr() {
		return getStringFromBigDecimal(height);
	}

	/**
	 * @return
	 */
	public String getImplementation() {
		return implementation;
	}

	/**
	 * @return
	 */
	public BigDecimal getMaxPitch() {
		return maxPitch;
	}

	public String getMaxPitchStr() {
		return getStringFromBigDecimal(maxPitch);
	}

	/**
	 * @return
	 */
	public Boolean getResetAllSectors() {
		return resetAllSectors;
	}

	/**
	 * @return
	 */
	public String getSectors1800() {
		return sectors1800;
	}

	/**
	 * @return
	 */
	public String getSectors900() {
		return sectors900;
	}

	/**
	 * @return
	 */
	public String getTr1800() {
		return tr1800;
	}

	/**
	 * @return
	 */
	public String getTr900() {
		return tr900;
	}

	/**
	 * @return
	 */
	public Integer getTypeId() {
		return typeId;
	}

	private BigDecimal getBigDecimalFromString(String inStr) {
		BigDecimal outBigDecimal;
		try {
			outBigDecimal = new BigDecimal(inStr);
		} catch (Exception ex) {
			outBigDecimal = new BigDecimal(0);
		}
		return outBigDecimal;
	}

	/**
	 * @param integer
	 */
	public void setAzimut(BigDecimal inDec) {
		azimut = inDec;
	}

	public void setAzimutStr(String inDecStr) {
		azimut = getBigDecimalFromString(inDecStr);
	}

	/**
	 * @param boolean1
	 */
	public void setCommonFider(Boolean boolean1) {
		commonFider = boolean1;
	}

	/**
	 * @param double1
	 */
	public void setFiderKSVN1800(BigDecimal inDec) {
		fiderKSVN1800 = inDec;
	}

	public void setFiderKSVN1800Str(String inDecStr) {
		fiderKSVN1800 = getBigDecimalFromString(inDecStr);
	}

	/**
	 * @param double1
	 */
	public void setFiderKSVN900(BigDecimal inDec) {
		fiderKSVN900 = inDec;
	}

	public void setFiderKSVN900Str(String inDecStr) {
		fiderKSVN900 = getBigDecimalFromString(inDecStr);
	}

	/**
	 * @param integer
	 */
	public void setFiderType1800Id(String typeId) {
		fiderType1800Id = typeId;
	}

	/**
	 * @param double1
	 */
	public void setFider1800Length(BigDecimal bigDecimal) {
		fider1800Length = bigDecimal;
	}

	public void setFider1800LengthStr(String bigDecimalStr) {
		fider1800Length = getBigDecimalFromString(bigDecimalStr);
	}

	/**
	 * @param list
	 */
	public void setFiderType1800List(List list) {
		fiderType1800List = list;
	}

	/**
	 * @param integer
	 */
	public void setFiderType900Id(String typeId) {
		fiderType900Id = typeId;
	}

	/**
	 * @param double1
	 */
	public void setFider900Length(BigDecimal bigDecimal) {
		fider900Length = bigDecimal;
	}

	public void setFider900LengthStr(String bigDecimalStr) {
		fider900Length = getBigDecimalFromString(bigDecimalStr);
	}

	/**
	 * @param list
	 */
	public void setFiderType900List(List list) {
		fiderType900List = list;
	}

	/**
	 * @param integer
	 */
	public void setHeight(BigDecimal inDec) {
		height = inDec;
	}

	public void setHeightStr(String inDecStr) {
		height = getBigDecimalFromString(inDecStr);
	}

	/**
	 * @param string
	 */
	public void setImplementation(String string) {
		implementation = string;
	}

	/**
	 * @param integer
	 */
	public void setMaxPitch(BigDecimal inDec) {
		maxPitch = inDec;
	}

	public void setMaxPitchStr(String inDecStr) {
		maxPitch = getBigDecimalFromString(inDecStr);
	}

	/**
	 * @param boolean1
	 */
	public void setResetAllSectors(Boolean boolean1) {
		resetAllSectors = boolean1;
	}

	/**
	 * @param string
	 */
	public void setSectors1800(String string) {
		sectors1800 = string;
	}

	/**
	 * @param string
	 */
	public void setSectors900(String string) {
		sectors900 = string;
	}

	/**
	 * @param string
	 */
	public void setTr1800(String string) {
		tr1800 = string;
	}

	/**
	 * @param string
	 */
	public void setTr900(String string) {
		tr900 = string;
	}

	/**
	 * @param integer
	 */
	public void setTypeId(Integer integer) {
		typeId = integer;
	}

	/**
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param string
	 */
	public void setTypeName(String string) {
		typeName = string;
	}

	/**
	 * @return
	 */
	public Integer getFider1800Id() {
		return fider1800Id;
	}

	/**
	 * @return
	 */
	public Integer getFider900Id() {
		return fider900Id;
	}

	/**
	 * @return
	 */
	public String getFiderType1800Name() {
		return fiderType1800Name;
	}

	/**
	 * @return
	 */
	public String getFiderType900Name() {
		return fiderType900Name;
	}

	/**
	 * @param integer
	 */
	public void setFider1800Id(Integer integer) {
		fider1800Id = integer;
	}

	/**
	 * @param integer
	 */
	public void setFider900Id(Integer integer) {
		fider900Id = integer;
	}

	/**
	 * @param string
	 */
	public void setFiderType1800Name(String string) {
		fiderType1800Name = string;
	}

	/**
	 * @param string
	 */
	public void setFiderType900Name(String string) {
		fiderType900Name = string;
	}

}
