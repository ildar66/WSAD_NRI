package com.hps.july.persistence2;

/**
 * Служебный класс по скоростям потока ррл антенн и параметрам,
 * зависящим от скорости потока. Используется при работе с ejb бинами.
 */
public class RRLResourceParamsValue implements java.io.Serializable{
	private int rrlantid;
	private int resource;
	private java.math.BigDecimal antdiam;
	private java.math.BigDecimal amplifkoeff;
	private java.math.BigDecimal dnangleh;
	private java.math.BigDecimal dnanglew;
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:15:58)
 */
public RRLResourceParamsValue() {}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAmplifkoeff() {
	return amplifkoeff;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAntdiam() {
	return antdiam;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDnangleh() {
	return dnangleh;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @return java.lang.String
 */
public java.math.BigDecimal getDnanglew() {
	return dnanglew;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @return java.lang.String
 */
public int getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @return java.lang.String
 */
public int getRrlantid() {
	return rrlantid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @param newAmplifkoeff java.math.BigDecimal
 */
public void setAmplifkoeff(java.math.BigDecimal newAmplifkoeff) {
	amplifkoeff = newAmplifkoeff;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @param newAntdiam java.math.BigDecimal
 */
public void setAntdiam(java.math.BigDecimal newAntdiam) {
	antdiam = newAntdiam;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @param newDnangleh java.math.BigDecimal
 */
public void setDnangleh(java.math.BigDecimal newDnangleh) {
	dnangleh = newDnangleh;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @param newDnanglew java.lang.String
 */
public void setDnanglew(java.math.BigDecimal newDnanglew) {
	dnanglew = newDnanglew;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @param newResource java.lang.String
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @param newRrlantid java.lang.String
 */
public void setRrlantid(int newRrlantid) {
	rrlantid = newRrlantid;
}
}
