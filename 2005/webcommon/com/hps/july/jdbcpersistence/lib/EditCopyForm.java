package com.hps.july.jdbcpersistence.lib;

/**
 * Форма редактирования с поддержкой копирования записи.
 * Creation date: (30.03.2003 15:55:45)
 * @author: Alexander Shrago
 */
public abstract class EditCopyForm extends com.hps.july.web.util.EditForm {
private String path;
private int state;
	
/**
 * Insert the method's description here.
 * Creation date: (21.04.2003 21:21:38)
 * @return java.lang.String
 */
public java.lang.String getPath() {
	return path;
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2003 19:18:42)
 * @return int
 */
public int getState() {
	return state;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 15:58:16)
 */
public abstract void prepareCopy(javax.servlet.http.HttpServletRequest request);
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 15:58:16)
 */
public  void prepareEdit(javax.servlet.http.HttpServletRequest request){}
/**
 * Insert the method's description here.
 * Creation date: (21.04.2003 21:21:38)
 * @param newPath java.lang.String
 */
public void setPath(java.lang.String newPath) {
	path = newPath;
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2003 19:18:42)
 * @param newState int
 */
public void setState(int newState) {
	state = newState;
}
}
