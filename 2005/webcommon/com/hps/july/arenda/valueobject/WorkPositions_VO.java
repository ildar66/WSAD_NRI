package com.hps.july.arenda.valueobject;

/**
 * контейнер "Позиций для рабочих".
 * Creation date: (18.03.2005 16:12:51)
 * @author: Shafigullin Ildar
 */
public class WorkPositions_VO {
	private java.lang.Integer workposition;
	private java.lang.String name;
	private java.lang.String isactive;
/**
 * Workpositions_VO constructor comment.
 */
public WorkPositions_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:24:34)
 * @param position java.lang.Integer
 */
public WorkPositions_VO(Integer position) {
    workposition = position;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:14:31)
 * @return java.lang.String
 */
public java.lang.String getIsactive() {
	return isactive;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:13:53)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:13:26)
 * @return java.lang.Integer
 */
public java.lang.Integer getWorkposition() {
	return workposition;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:14:31)
 * @param newIsactive java.lang.String
 */
public void setIsactive(java.lang.String newIsactive) {
	isactive = newIsactive;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:13:53)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:13:26)
 * @param newWorkposition java.lang.Integer
 */
public void setWorkposition(java.lang.Integer newWorkposition) {
	workposition = newWorkposition;
}
}
