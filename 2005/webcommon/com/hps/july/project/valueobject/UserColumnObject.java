package com.hps.july.project.valueobject;

import com.hps.july.persistence.*;
import java.util.*;

/**
 * Объект для хранения пользовательской колонки.
 * Creation date: (09.06.2003 15:11:46)
 * @author: Dmitry Dneprov
 */
public class UserColumnObject {
	private int colcode;
	private java.lang.String colname;
	private java.lang.String colvalue;
/**
 * ColumnOrderObject constructor comment.
 */
public UserColumnObject(ProjectDivColumnsAccessBean argPab, int argProject) 
		throws javax.ejb.CreateException, java.rmi.RemoteException, javax.ejb.FinderException,
		javax.naming.NamingException {
	super();
	setColcode(argPab.getDivcolid());
	setColname(argPab.getColname());
	// Determine user column value
	try {
		ProjectDivColValAccessBean colvalab = new ProjectDivColValAccessBean();
		colvalab.setInitKey_project_project(new Integer(argProject));
		colvalab.setInitKey_projectDivColumn_divcolid(new Integer(getColcode()));
		colvalab.refreshCopyHelper();
		setColvalue(colvalab.getColvalue());
	} catch (Exception e) {
		setColvalue("");
	}
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
 * Creation date: (18.06.2003 18:55:36)
 * @return java.lang.String
 */
public java.lang.String getColvalue() {
	return colvalue;
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
/**
 * Insert the method's description here.
 * Creation date: (18.06.2003 18:55:36)
 * @param newColvalue java.lang.String
 */
public void setColvalue(java.lang.String newColvalue) {
	colvalue = newColvalue;
}
}
