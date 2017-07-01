package com.hps.july.project.formbean;

import com.hps.july.persistence.*;
/**
 * Форма списка ответственных.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class WorkresponsibilityListForm extends com.hps.july.web.util.BrowseForm {
	private int storageplace;
	private java.lang.String posname;
	private java.lang.String posid;
	private int project;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkresponsibilityListForm() {
	this.setFinderMethodName( "findPositionResponsibleWorkersByPosition" );
	storageplace = 0;
	posname = "";
	}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2003 17:25:34)
 * @return java.lang.String
 */
public String getBackPage() {
	return "projectList.do#p" + getProject();
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	//return super.getEditRoles();
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("planAdmin");
	roles.add("planResponsible");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new com.hps.july.persistence.StoragePlaceKey(storageplace) };
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:07:32)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2003 17:23:42)
 * @return int
 */
public int getProject() {
	return project;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:14)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:07:32)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2003 17:23:42)
 * @param newProject int
 */
public void setProject(int newProject) {
	project = newProject;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:14)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
}
