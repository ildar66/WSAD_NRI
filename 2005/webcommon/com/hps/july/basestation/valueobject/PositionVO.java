package com.hps.july.basestation.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (21.12.2004 14:57:41)
 * @author: Shafigullin Ildar
 */
public class PositionVO extends StoragePlaceVO {
	private Integer gsmid;
	private Integer dampsid;
	private PositionDopInfoVO dopInfoVO;
	private java.math.BigDecimal latitude;//Координаты широта
	private java.math.BigDecimal longitude;//Координаты долгота
/**
 * PositionVO constructor comment.
 */
public PositionVO() {
	super();
}
/**
 * PositionVO constructor comment.
 * @param key int
 */
public PositionVO(int key) {
	super(key);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2005 13:06:54)
 * @param param com.hps.july.cdbc.lib.CDBCRowObject
 */
public PositionVO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super(ro);
    setDampsid((Integer) ro.getColumn("dampsid").asObject());
    setGsmid((Integer) ro.getColumn("gsmid").asObject());
    setLatitude((java.math.BigDecimal) ro.getColumn("latitude").asObject());
    setLongitude((java.math.BigDecimal) ro.getColumn("longitude").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2004 15:00:26)
 * @return int
 */
public Integer getDampsid() {
	return dampsid;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:10:10)
 * @return com.hps.july.arenda.valueobject.PositionDopInfoVO
 */
public PositionDopInfoVO getDopInfoVO() {
	return dopInfoVO;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2004 15:00:26)
 * @return int
 */
public Integer getGsmid() {
	return gsmid;
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2005 12:28:11)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getLatitude() {
	return latitude;
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2005 12:53:58)
 */
public String getLatitudeStr() {
    if (latitude != null)
        return latitude.toString();
    else
        return "";
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2005 12:28:35)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getLongitude() {
	return longitude;
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2005 12:28:35)
 * @return java.math.BigDecimal
 */
public String getLongitudeStr() {
    if (longitude != null)
        return longitude.toString();
    else
        return "";
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2004 15:00:26)
 * @param newDampsid int
 */
public void setDampsid(Integer newDampsid) {
	dampsid = newDampsid;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:10:10)
 * @param newDopInfoVO com.hps.july.arenda.valueobject.PositionDopInfoVO
 */
public void setDopInfoVO(PositionDopInfoVO newDopInfoVO) {
	dopInfoVO = newDopInfoVO;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2004 15:00:26)
 * @param newGsmid int
 */
public void setGsmid(Integer newGsmid) {
	gsmid = newGsmid;
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2005 12:28:11)
 * @param newLatitude java.math.BigDecimal
 */
public void setLatitude(java.math.BigDecimal newLatitude) {
	latitude = newLatitude;
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2005 12:28:35)
 * @param newLongitude java.math.BigDecimal
 */
public void setLongitude(java.math.BigDecimal newLongitude) {
	longitude = newLongitude;
}
}
