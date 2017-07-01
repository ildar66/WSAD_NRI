package com.hps.july.project.valueobject;

/**
 * Объект для хранения названий колонок.
 * Creation date: (09.06.2003 15:11:46)
 * @author: Dmitry Dneprov
 */
public class ColumnOrderObject {
	private int colcode;
	private java.lang.String colname;
/**
 * ColumnOrderObject constructor comment.
 */
public ColumnOrderObject(int argColCode, String argColName) {
	super();
	colcode = argColCode;
	colname = argColName;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 15:12:06)
 * @return int
 */
public int getColcode() {
	return colcode;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 15:12:21)
 * @return java.lang.String
 */
public java.lang.String getColname() {
	return colname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 15:12:06)
 * @param newColcode int
 */
public void setColcode(int newColcode) {
	colcode = newColcode;
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 15:12:21)
 * @param newColname java.lang.String
 */
public void setColname(java.lang.String newColname) {
	colname = newColname;
}
}
