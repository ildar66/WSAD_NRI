package com.hps.july.persistence2;

/**
 * Служебный класс по диаметрам ррл антенн и параметрам, зависящим от диаметра.
 * Используется при работе с ejb бинами.
 */
public class RRLResourceSpeedParamsValue implements java.io.Serializable{
	private int rrlspeedid;
	private int resource;
	private java.lang.String streamspeed;
	private java.lang.String radiationclass;
	private java.math.BigDecimal recvsensitivity;
/**
 * RRLResourceSpeedParamsValue constructor comment.
 */
public RRLResourceSpeedParamsValue() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:32:58)
 * @return java.lang.String
 */
public java.lang.String getRadiationclass() {
	return radiationclass;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:33:21)
 * @return java.lang.String
 */
public java.math.BigDecimal getRecvsensitivity() {
	return recvsensitivity;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:31:55)
 * @return java.lang.String
 */
public int getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:31:33)
 * @return java.lang.String
 */
public int getRrlspeedid() {
	return rrlspeedid;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:32:38)
 * @return java.lang.String
 */
public java.lang.String getStreamspeed() {
	return streamspeed;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:32:58)
 * @param newRadiationclass java.lang.String
 */
public void setRadiationclass(java.lang.String newRadiationclass) {
	radiationclass = newRadiationclass;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:33:21)
 * @param newRecvsensitivity java.lang.String
 */
public void setRecvsensitivity(java.math.BigDecimal newRecvsensitivity) {
	recvsensitivity = newRecvsensitivity;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:31:55)
 * @param newResource java.lang.String
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:31:33)
 * @param newRrlspeedid java.lang.String
 */
public void setRrlspeedid(int newRrlspeedid) {
	rrlspeedid = newRrlspeedid;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:32:38)
 * @param newStreamspeed java.lang.String
 */
public void setStreamspeed(java.lang.String newStreamspeed) {
	streamspeed = newStreamspeed;
}
}
