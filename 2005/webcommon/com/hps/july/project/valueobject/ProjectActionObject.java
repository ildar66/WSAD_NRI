package com.hps.july.project.valueobject;

import com.hps.july.persistence.*;
import java.util.*;

/**
 * Объект-wrapper для события проекта.
 * Creation date: (29.05.2003 12:04:46)
 * @author: Dmitry Dneprov
 */
public class ProjectActionObject {
	private int divcode;
	private java.lang.String comment;
	private java.lang.String objtype;
	private java.lang.String usercolval;
	private int projectaction;
	private java.lang.Boolean completed;
	private java.lang.Boolean agreement;
	private boolean hasproblems;
	private java.sql.Date factdate;
	private java.sql.Date plandate;
	private java.sql.Date suggplandate;
	private java.lang.Boolean isNewplandate;
	private java.lang.String headername;
	private int divcol;
	private int projectactiontype;
	private java.lang.String notes;
	private int projectcode;
/**
 * ProjectActionObject constructor comment.
 */
public ProjectActionObject(int argProjectaction, int argDivCode) {
	super();
	//System.out.println("SETTING projectaction=" + argProjectaction);
	setProjectaction(argProjectaction);
	setObjtype("P");
	setDivcode(argDivCode);

}
/**
 * ProjectActionObject constructor comment.
 */
public ProjectActionObject(int argDivCol, int argDivCode, int argProject) {
	super();
	setDivcol(argDivCol);
	setDivcode(argDivCode);
	setObjtype("K");
	setProjectcode(argProject);

	/*
	// Determine user column value
	try {
		ProjectDivColValAccessBean colvalab = new ProjectDivColValAccessBean();
		colvalab.setInitKey_project_project(new Integer(argProject));
		colvalab.setInitKey_projectDivColumn_divcolid(new Integer(argDivCol));
		colvalab.refreshCopyHelper();
		setUsercolval(colvalab.getColvalue());
	} catch (Exception e) {
		setUsercolval("");
	}
	*/
}
/**
 * Confirm / Reject new plan date for projectaction.
 * Creation date: (13.10.2003 15:34:40)
 * @return boolean
 * @param argPrjAction int
 * @param isConfirm boolean
 */
public static void changeAllPlanDates(boolean isConfirm, Integer argProject) throws Exception {

	java.util.Enumeration en = new ProjectActionAccessBean().findByProjectOrderByOrderAsc(argProject);
	while (en.hasMoreElements()) {
    	ProjectActionAccessBean pab = (ProjectActionAccessBean)en.nextElement();
	    if (isConfirm)
	    	pab.setPlandate(pab.getSuggplandate());
	    else
	    	pab.setSuggplandate(pab.getPlandate());
	    	
	    pab.setIsNewplandate(Boolean.FALSE);
	    pab.commitCopyHelper();
	}
}
/**
 * Confirm / Reject new plan date for projectaction.
 * Creation date: (13.10.2003 15:34:40)
 * @return boolean
 * @param argPrjAction int
 * @param isConfirm boolean
 */
public static void changePlanDate(int argPrjAction, boolean isConfirm) throws Exception {
    ProjectActionAccessBean pab = new ProjectActionAccessBean();
    pab.setInitKey_projectaction(argPrjAction);
    pab.refreshCopyHelper();
    if (isConfirm)
    	pab.setPlandate(pab.getSuggplandate());
    else
    	pab.setSuggplandate(pab.getPlandate());
    	
    pab.setIsNewplandate(Boolean.FALSE);
    pab.commitCopyHelper();
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:52:03)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getAgreement() {
	return agreement;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2003 12:09:40)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:51:42)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCompleted() {
	return completed;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2003 12:07:29)
 * @return int
 */
public int getDivcode() {
	return divcode;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2003 14:52:35)
 * @return int
 */
public int getDivcol() {
	return divcol;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:53:01)
 * @return java.sql.Date
 */
public java.sql.Date getFactdate() {
	return factdate;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 12:02:39)
 * @return java.lang.String
 */
public java.lang.String getHeadername() {
	return headername;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 11:10:36)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsNewplandate() {
	return isNewplandate;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2004 12:29:15)
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2003 12:06:06)
 * @return java.lang.String
 */
public java.lang.String getObjtype() {
	return objtype;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:53:15)
 * @return java.sql.Date
 */
public java.sql.Date getPlandate() {
	return plandate;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:51:00)
 * @return int
 */
public int getProjectaction() {
	return projectaction;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2003 16:35:32)
 * @return int
 */
public int getProjectactiontype() {
	return projectactiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2004 16:01:29)
 * @return int
 */
public int getProjectcode() {
	return projectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 11:09:40)
 * @return java.sql.Date
 */
public java.sql.Date getSuggplandate() {
	return suggplandate;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2003 14:02:53)
 * @return java.lang.String
 */
public java.lang.String getUsercolval() {
	return usercolval;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:52:34)
 * @return boolean
 */
public boolean isHasproblems() {
	return hasproblems;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:52:03)
 * @param newAgreement java.lang.Boolean
 */
public void setAgreement(java.lang.Boolean newAgreement) {
	agreement = newAgreement;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2003 12:09:40)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:51:42)
 * @param newCompleted java.lang.Boolean
 */
public void setCompleted(java.lang.Boolean newCompleted) {
	completed = newCompleted;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2003 12:07:29)
 * @param newDivcode int
 */
public void setDivcode(int newDivcode) {
	divcode = newDivcode;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2003 14:52:35)
 * @param newDivcol int
 */
public void setDivcol(int newDivcol) {
	divcol = newDivcol;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:53:01)
 * @param newFactdate java.sql.Date
 */
public void setFactdate(java.sql.Date newFactdate) {
	factdate = newFactdate;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:52:34)
 * @param newHasproblems boolean
 */
public void setHasproblems(boolean newHasproblems) {
	hasproblems = newHasproblems;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 12:02:39)
 * @param newHeadername java.lang.String
 */
public void setHeadername(java.lang.String newHeadername) {
	headername = newHeadername;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 11:10:36)
 * @param newIsNewplandate java.lang.Boolean
 */
public void setIsNewplandate(java.lang.Boolean newIsNewplandate) {
	isNewplandate = newIsNewplandate;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2004 12:29:15)
 * @param newNotes java.lang.String
 */
public void setNotes(java.lang.String newNotes) {
	notes = newNotes;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2003 12:06:06)
 * @param newObjtype java.lang.String
 */
public void setObjtype(java.lang.String newObjtype) {
	objtype = newObjtype;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:53:15)
 * @param newPlandate java.sql.Date
 */
public void setPlandate(java.sql.Date newPlandate) {
	plandate = newPlandate;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 18:51:00)
 * @param newProjectaction int
 */
public void setProjectaction(int newProjectaction) {
	projectaction = newProjectaction;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2003 16:35:32)
 * @param newProjectactiontype int
 */
public void setProjectactiontype(int newProjectactiontype) {
	projectactiontype = newProjectactiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2004 16:01:29)
 * @param newProjectcode int
 */
public void setProjectcode(int newProjectcode) {
	projectcode = newProjectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 11:09:40)
 * @param newSuggplandate java.sql.Date
 */
public void setSuggplandate(java.sql.Date newSuggplandate) {
	suggplandate = newSuggplandate;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2003 14:02:53)
 * @param newUsercolval java.lang.String
 */
public void setUsercolval(java.lang.String newUsercolval) {
	usercolval = newUsercolval;
}
}
