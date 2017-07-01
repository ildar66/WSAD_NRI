package com.hps.july.dictionary.formbean;

/**
 * Форма выбора сервиса
 */
public class ServiceLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.Integer direction;
	private java.lang.String directionname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ServiceLookupListForm() {
	this.setFinderMethodName( "findByParentOrderByNameAsc" );
	direction = new Integer(0);
	}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 13:49:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getDirection() {
	return direction;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2002 18:17:37)
 * @return java.lang.String
 */
public java.lang.String getDirectionname() {
	return directionname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { direction };
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 13:49:37)
 * @param newDirection java.lang.Integer
 */
public void setDirection(java.lang.Integer newDirection) {
	direction = newDirection;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2002 18:17:37)
 * @param newDirectionname java.lang.String
 */
public void setDirectionname(java.lang.String newDirectionname) {
	directionname = newDirectionname;
}
}
