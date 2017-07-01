package com.hps.july.valueobject;

/**
 * "Должность".
 * Creation date: (02.11.2005 11:09:11)
 * @author: Shafigullin Ildar
 */
public class WorkPosition_VO {
	private java.lang.Integer workposition;//Уникальный код должности
	private java.lang.String name;//Наименование должности
	private java.lang.String isactive;//Признак активности должности(Y/N)
/**
 * WorkPosition_VO constructor comment.
 */
public WorkPosition_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:15:38)
 * @param id java.lang.Integer
 */
public WorkPosition_VO(Integer id) {
    workposition = id;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:12:50)
 * @return java.lang.String
 */
public java.lang.String getIsactive() {
	return isactive;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:12:13)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:11:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getWorkposition() {
	return workposition;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:12:50)
 * @param newIsactive java.lang.String
 */
public void setIsactive(java.lang.String newIsactive) {
	isactive = newIsactive;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:12:13)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2005 11:11:37)
 * @param newWorkposition java.lang.Integer
 */
public void setWorkposition(java.lang.Integer newWorkposition) {
	workposition = newWorkposition;
}
}
