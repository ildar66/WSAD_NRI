package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;

/**
 * Форма выбора антены сектора базовой станции
 */
public class AntennaLookupList
	extends com.hps.july.web.util.BrowseForm
{
	private int sectorcode;
/**
 * AntennaLookupList constructor comment.
 */
public AntennaLookupList() {
	setFinderMethodName("findAntena2sectorsBySector");
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2003 19:07:37)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new SectorKey(getSectorcode()) };
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2003 19:17:56)
 * @return int
 */
public int getSectorcode() {
	return sectorcode;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2003 19:17:56)
 * @param newSectorcode int
 */
public void setSectorcode(int newSectorcode) {
	sectorcode = newSectorcode;
}
}
