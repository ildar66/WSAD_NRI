package com.hps.july.dictionary.valueobject;

/**
 * Служебный класс с данными по Типам курсов.
 * Creation date: (04.04.2005 16:50:10)
 * @author: Shafigullin Ildar
 */
public class RateType_VO {
	private java.lang.Integer ratetype;//Тип курса
	private java.lang.String name;//Наименование типа курсов валют
	private java.lang.Integer basecurrency;//Базовая валюта
/**
 * RateType_VO constructor comment.
 */
public RateType_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 18:35:57)
 * @param type java.lang.Integer
 */
public RateType_VO(Integer type) {
    ratetype = type;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:52:26)
 * @return java.lang.Integer
 */
public java.lang.Integer getBasecurrency() {
	return basecurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:51:39)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:51:15)
 * @return java.lang.Integer
 */
public java.lang.Integer getRatetype() {
	return ratetype;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:52:26)
 * @param newBasecurrency java.lang.Integer
 */
public void setBasecurrency(java.lang.Integer newBasecurrency) {
	basecurrency = newBasecurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:51:39)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 16:51:15)
 * @param newRatetype java.lang.Integer
 */
public void setRatetype(java.lang.Integer newRatetype) {
	ratetype = newRatetype;
}
}
