package com.hps.july.dictionary.valueobject;

/**
 * Служебный класс по скоростям потока ррл антенн и параметрам,
 * зависящим от скорости потока. Используется для отображения.
 */
public class RRLResourceParamsValueFrm implements java.io.Serializable{
	private String rrlantid;
	private String resource;
	private String antdiam;
	private String amplifkoeff;
	private String dnangleh;
	private String dnanglew;
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:15:58)
 */
public RRLResourceParamsValueFrm() {}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @return java.math.BigDecimal
 */
public String getAmplifkoeff() {
	return amplifkoeff;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @return java.math.BigDecimal
 */
public String getAntdiam() {
	return antdiam;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @return java.math.BigDecimal
 */
public String getDnangleh() {
	return dnangleh;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @return java.lang.String
 */
public String getDnanglew() {
	return dnanglew;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @return java.lang.String
 */
public String getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @return java.lang.String
 */
public String getRrlantid() {
	return rrlantid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @param newAmplifkoeff java.math.BigDecimal
 */
public void setAmplifkoeff(String newAmplifkoeff) {
	amplifkoeff = newAmplifkoeff;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @param newAntdiam java.math.BigDecimal
 */
public void setAntdiam(String newAntdiam) {
	antdiam = newAntdiam;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:16:41)
 * @param newDnangleh java.math.BigDecimal
 */
public void setDnangleh(String newDnangleh) {
	dnangleh = newDnangleh;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @param newDnanglew java.lang.String
 */
public void setDnanglew(String newDnanglew) {
	dnanglew = newDnanglew;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @param newResource java.lang.String
 */
public void setResource(String newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 13:42:09)
 * @param newRrlantid java.lang.String
 */
public void setRrlantid(String newRrlantid) {
	rrlantid = newRrlantid;
}
}
