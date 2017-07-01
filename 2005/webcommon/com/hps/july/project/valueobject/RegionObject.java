package com.hps.july.project.valueobject;

/**
 * Объект для хранения региона.
 * Creation date: (26.09.2003 18:19:50)
 * @author: Dmitry Dneprov
 */
public class RegionObject {
	private int regionid;
	private java.lang.String regname;
	private int supregid;
/**
 * RegionObject constructor comment.
 */
public RegionObject(int aregionId, int asupregId, String aregname) {
	super();
	regionid = aregionId;
	supregid = asupregId;
	regname = aregname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:21:17)
 * @return int
 */
public int getRegionid() {
	return regionid;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:21:39)
 * @return java.lang.String
 */
public java.lang.String getRegname() {
	return regname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:22:22)
 * @return int
 */
public int getSupregid() {
	return supregid;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:21:17)
 * @param newRegionid int
 */
public void setRegionid(int newRegionid) {
	regionid = newRegionid;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:21:39)
 * @param newRegname java.lang.String
 */
public void setRegname(java.lang.String newRegname) {
	regname = newRegname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:22:22)
 * @param newSupregid int
 */
public void setSupregid(int newSupregid) {
	supregid = newSupregid;
}
}
