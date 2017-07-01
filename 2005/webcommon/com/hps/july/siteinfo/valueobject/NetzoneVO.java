package com.hps.july.siteinfo.valueobject;

/**
 * Класс-контейнер с параметрами зоны сети (код и имя)
 */
public class NetzoneVO
	implements java.io.Serializable
{
	private int netzone;
	private java.lang.String name;
	private int regionid;
/**
 * Insert the method's description here.
 * Creation date: (11.07.2005 16:12:21)
 */
public NetzoneVO(int azoneId,int region, String azonename) {
	super();
	netzone = azoneId;
	name = azonename;
	regionid = region;
}
/**
 * NetzoneObject constructor comment.
 */
public NetzoneVO(int azoneId, String azonename) {
	super();
	netzone = azoneId;
	name = azonename;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:59:10)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:58:58)
 * @return int
 */
public int getNetzone() {
	return netzone;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2005 16:13:35)
 * @return int
 */
public int getRegionid() {
	return regionid;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:59:10)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 18:58:58)
 * @param newNetzone int
 */
public void setNetzone(int newNetzone) {
	netzone = newNetzone;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2005 16:13:35)
 * @param newRegionid int
 */
public void setRegionid(int newRegionid) {
	regionid = newRegionid;
}
}
