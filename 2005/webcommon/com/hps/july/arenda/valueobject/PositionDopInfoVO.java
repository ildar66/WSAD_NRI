package com.hps.july.arenda.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (27.12.2004 16:01:41)
 * @author: Shafigullin Ildar
 */
public class PositionDopInfoVO {
	private java.lang.String applaceTypeName;//тип помещения
	private java.lang.String apparatTypeName;//тип аппаратной
	private String apparatPlaceName;//местонахождение аппаратной
	private java.lang.String oporaPlaceName;//место размещения опоры
	private java.lang.String antennPlaceName;//место размещения антен
	private java.lang.String isvc;//если Y то отображаем опору, иначе не отображаем поля (место размещения опоры и чужая опора)
	private java.lang.String oporaour;//чужая опора (Y -да, N - нет)
/**
 * PositionDopInfoVO constructor comment.
 */
public PositionDopInfoVO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:07:29)
 * @return java.lang.String
 */
public java.lang.String getAntennPlaceName() {
	return antennPlaceName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:05:24)
 * @return String
 */
public String getApparatPlaceName() {
	return apparatPlaceName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:02:32)
 * @return java.lang.String
 */
public java.lang.String getApparatTypeName() {
	return apparatTypeName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:02:13)
 * @return java.lang.String
 */
public java.lang.String getApplaceTypeName() {
	return applaceTypeName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:07:51)
 * @return java.lang.String
 */
public java.lang.String getIsvc() {
	return isvc;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:08:52)
 * @return java.lang.String
 */
public java.lang.String getOporaour() {
	return oporaour;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:06:50)
 * @return java.lang.String
 */
public java.lang.String getOporaPlaceName() {
	return oporaPlaceName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:07:29)
 * @param newAntennPlaceName java.lang.String
 */
public void setAntennPlaceName(java.lang.String newAntennPlaceName) {
	antennPlaceName = newAntennPlaceName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:05:24)
 * @param newApparatPlaceName String
 */
public void setApparatPlaceName(String newApparatPlaceName) {
	apparatPlaceName = newApparatPlaceName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:02:32)
 * @param newApparattypename java.lang.String
 */
public void setApparatTypename(java.lang.String newApparatTypeName) {
	apparatTypeName = newApparatTypeName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:02:13)
 * @param newApplacetypeName java.lang.String
 */
public void setApplacetypeName(java.lang.String newApplaceTypeName) {
	applaceTypeName = newApplaceTypeName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:07:51)
 * @param newIsvc java.lang.String
 */
public void setIsvc(java.lang.String newIsvc) {
	isvc = newIsvc;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:08:52)
 * @param newOporaour java.lang.String
 */
public void setOporaour(java.lang.String newOporaour) {
	oporaour = newOporaour;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:06:50)
 * @param newOporaPlaceName java.lang.String
 */
public void setOporaPlaceName(java.lang.String newOporaPlaceName) {
	oporaPlaceName = newOporaPlaceName;
}
}
