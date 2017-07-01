/*
 * Created on 21.09.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Sector value object
 * @author dima
 *
 */
public class SectorVO implements Serializable, Comparable {
	
	public static final short DIAP900 = 900;
	public static final short DIAP1800 = 1800;
	
	private int idsect;
	private String namesect;
	private short band;
	private String numsect;
	private Integer cellname;
	private Integer lac;
	private BigDecimal azimut;
	private String recordStatus;
	private String previousRecordStatus;

	public SectorVO() {
		super();
		recordStatus = "A";
		previousRecordStatus = "U";
	}

	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		SectorVO other = (SectorVO)otherObject;
		
		if (namesect != null)
			return namesect.equals(other.namesect) && (band == other.band);
		else
			return (namesect == other.namesect) && (band == other.band);
	}
	
	public int hashCode() {
		if (namesect != null)
			return new Integer(band).hashCode() + 11 * namesect.hashCode();
		return new Integer(band).hashCode();
	}
	
	public int compareTo(Object other) {
		if (other != null) {
			if (band == ((SectorVO)other).band) {
				if ( (namesect == null) && (((SectorVO)other).namesect == null) )
					return 0;
				else if (namesect == null)
					return -1;
				else if (((SectorVO)other).namesect == null)
					return 1;
				else
					return namesect.compareTo(((SectorVO)other).namesect);
			} else {
				if ( (namesect == null) && (((SectorVO)other).namesect == null) )
					return (new Short(((SectorVO)other).band).compareTo(new Short(band)));
				else if (namesect == null)
					return -1;
				else if (((SectorVO)other).namesect == null)
					return 1;
				else
					return (new Short(((SectorVO)other).band).compareTo(new Short(band)));
			}
		}
		return 1;
	}
	
	
	public static SectorVO constructSectorKey(int sectnumber) {
		SectorVO sect = new SectorVO();
		switch (sectnumber) {
			case 0: break;
			case 1:  
				sect.setBand(SectorVO.DIAP900);
				sect.setNamesect("O");
				break;
			case 2: 
				sect.setBand(SectorVO.DIAP900);
				sect.setNamesect("E");
				break;
			case 3: 
				sect.setBand(SectorVO.DIAP900);
				sect.setNamesect("F");
				break;
			case 4: 
				sect.setBand(SectorVO.DIAP900);
				sect.setNamesect("G");
				break;
			case 5: 
				sect.setBand(SectorVO.DIAP900);
				sect.setNamesect("H");
				break;
			case 6: 
				sect.setBand(SectorVO.DIAP1800);
				sect.setNamesect("O");
				break;
			case 7: 
				sect.setBand(SectorVO.DIAP1800);
				sect.setNamesect("A");
				break;
			case 8: 
				sect.setBand(SectorVO.DIAP1800);
				sect.setNamesect("B");
				break;
			case 9: 
				sect.setBand(SectorVO.DIAP1800);
				sect.setNamesect("C");
				break;
			case 10: 
				sect.setBand(SectorVO.DIAP1800);
				sect.setNamesect("D");
				break;
		}
		
		return sect;
	}
	
	/**
	 * @return
	 */
	public short getBand() {
		return band;
	}

	/**
	 * @return
	 */
	public int getIdsect() {
		return idsect;
	}

	/**
	 * @return
	 */
	public String getNamesect() {
		return namesect;
	}

	/**
	 * @return
	 */
	public String getNumsect() {
		return numsect;
	}

	/**
	 * @param s
	 */
	public void setBand(short s) {
		band = s;
	}

	/**
	 * @param i
	 */
	public void setIdsect(int i) {
		idsect = i;
	}

	/**
	 * @param string
	 */
	public void setNamesect(String string) {
		namesect = string;
	}

	/**
	 * @param string
	 */
	public void setNumsect(String string) {
		numsect = string;
	}

	public static String getSectorLetter(int sectnum, short adiap) {
		if (adiap == DIAP900) {
			switch (sectnum) {
				case 0: return "O";
				case 1: return "E";
				case 2: return "F";
				case 3: return "G";
				case 4: return "H";
			}
		} else if (adiap == DIAP1800) {
			switch (sectnum) {
				case 0: return "O";
				case 1: return "A";
				case 2: return "B";
				case 3: return "C";
				case 4: return "D";
			}
		} 
		return "";
	}
	/**
	 * @return
	 */
	public BigDecimal getAzimut() {
		return azimut;
	}

	/**
	 * @return
	 */
	public Integer getCellname() {
		return cellname;
	}

	/**
	 * @return
	 */
	public Integer getLac() {
		return lac;
	}

	/**
	 * @param decimal
	 */
	public void setAzimut(BigDecimal decimal) {
		azimut = decimal;
	}

	/**
	 * @param integer
	 */
	public void setCellname(Integer integer) {
		cellname = integer;
	}

	/**
	 * @param integer
	 */
	public void setLac(Integer integer) {
		lac = integer;
	}

	/**
	 * @return
	 */
	public String getPreviousRecordStatus() {
		return previousRecordStatus;
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
	public void setPreviousRecordStatus(String string) {
		previousRecordStatus = string;
	}

	/**
	 * @param string
	 */
	public void setRecordStatus(String string) {
		recordStatus = string;
	}

}
