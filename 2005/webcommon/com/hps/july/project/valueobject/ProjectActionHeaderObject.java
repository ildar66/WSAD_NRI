package com.hps.july.project.valueobject;

/**
 * Объект для хранения колонки события проекта.
 * Creation date: (29.09.2003 10:38:46)
 * @author: Dmitry Dneprov
 */
public class ProjectActionHeaderObject {
	private int objtype;
	public final static int OBJPRJACTION = 1;
	public final static int OBJUSRCOL = 2;
	private int divcolid;
	private int division;
	private java.lang.String colname;
	private java.lang.String result;
	private int typeresponsibility;
	private int projectactiontype;
/**
 * ProjectActionHeaderObject constructor for usercolumn object.
 */
public ProjectActionHeaderObject(int adivcolid, int adivision, String acolname) {
	super();
	objtype = OBJUSRCOL;
	divcolid = adivcolid;
	division = adivision;
	colname = acolname;
}
/**
 * ProjectActionHeaderObject constructor for projectactiontype object.
 */
public ProjectActionHeaderObject(int aprojectactiontype, int adivision, String acolname, String aresult, int atyperesponsibility) {
	super();
	objtype = OBJPRJACTION;
	projectactiontype = aprojectactiontype;
	division = adivision;
	colname = acolname;
	result = aresult;
	typeresponsibility = atyperesponsibility;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:44:01)
 * @return java.lang.String
 */
public java.lang.String getColname() {
	return colname;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:42:08)
 * @return int
 */
public int getDivcolid() {
	return divcolid;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:42:31)
 * @return int
 */
public int getDivision() {
	return division;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:39:10)
 * @return int
 */
public int getObjtype() {
	return objtype;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:51:42)
 * @return int
 */
public int getProjectactiontype() {
	return projectactiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:50:49)
 * @return java.lang.String
 */
public java.lang.String getResult() {
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:51:20)
 * @return int
 */
public int getTyperesponsibility() {
	return typeresponsibility;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:44:01)
 * @param newColname java.lang.String
 */
public void setColname(java.lang.String newColname) {
	colname = newColname;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:42:08)
 * @param newDivcolid int
 */
public void setDivcolid(int newDivcolid) {
	divcolid = newDivcolid;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:42:31)
 * @param newDivision int
 */
public void setDivision(int newDivision) {
	division = newDivision;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:39:10)
 * @param newObjtype int
 */
public void setObjtype(int newObjtype) {
	objtype = newObjtype;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:51:42)
 * @param newProjectactiontype int
 */
public void setProjectactiontype(int newProjectactiontype) {
	projectactiontype = newProjectactiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:50:49)
 * @param newResult java.lang.String
 */
public void setResult(java.lang.String newResult) {
	result = newResult;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 10:51:20)
 * @param newTyperesponsibility int
 */
public void setTyperesponsibility(int newTyperesponsibility) {
	typeresponsibility = newTyperesponsibility;
}
}
