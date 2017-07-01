package com.hps.july.security.formbean;

/**
 * Форма списка автомашин дирекции.
 * Creation date: (21.07.2003 18:29:27)
 * @author: Sergey Gourov
 */
public class DirectionCarsList extends com.hps.july.web.util.BrowseForm {
	private int division;
/**
 * DirectionCarsList constructor comment.
 */
public DirectionCarsList() {
	setFinderMethodName("findByQBE");
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2003 19:08:59)
 * @return int
 */
public int getDivision() {
	return division;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2003 18:29:27)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Boolean(false), new Integer(0), new Boolean(true), new Integer(getDivision()), new Integer(1) };
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2003 19:08:59)
 * @param newDivision int
 */
public void setDivision(int newDivision) {
	division = newDivision;
}
}
