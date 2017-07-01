package com.hps.july.project.formbean;

import com.hps.july.persistence.*;
import com.hps.july.project.*;
import com.hps.july.project.valueobject.*;
import com.hps.july.web.util.*;
import java.util.*;

/**
 * Форма списка событий проекта.
 * Creation date: (25.09.2002 19:26:04)
 * 
 */
public class ProjectActionListForm extends com.hps.july.web.util.BrowseForm implements Securities{
	private java.lang.String showacttype;
	private int divcode;
	private int acceptcode;
	private int rejectcode;
	private int projectParameter;
	private java.lang.String projectname;
	private int projecttype;
	private boolean isFull;
	private int storageplace;
	private java.lang.String projecttypename;
	private java.lang.String fullPosition;
	private java.lang.String contructerName;
	private java.lang.String notes;
	private java.lang.String state;
/**
 * TypeProjectListForm constructor comment.
 */
public ProjectActionListForm() {

	setShowacttype("A");
	setFinderMethodName("findByProjectOrderByOrderAsc");

}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2003 17:52:35)
 * @return java.util.Enumeration
 * @param argProject java.lang.Integer
 */
public Collection findByProjectOrderByOrderAsc(Integer argProject, Integer argDivCode) 
		throws javax.naming.NamingException, javax.ejb.FinderException, java.rmi.RemoteException,
		javax.ejb.CreateException {
			
	Vector result = new Vector();

	// Determine projecttype
	int prjtype = 0;
	try {
		ProjectAccessBean prab = new ProjectAccessBean();
		prab.setInitKey_project(argProject.intValue());
		prab.refreshCopyHelper();
		prjtype = prab.getProjecttype().getProjecttype();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	
    // Init user columns vector before first column
    Enumeration enb = new ProjectDivColumnsAccessBean().findByColDivisionActtypeOrderByAfterColAsc(new Integer(0), argDivCode, new Integer(prjtype));
    while (enb.hasMoreElements()) {
	    ProjectDivColumnsAccessBean pab = (ProjectDivColumnsAccessBean)enb.nextElement();
	    UserColumnObject co = new UserColumnObject(pab, argProject.intValue());
	    result.add(co);
    }

    Enumeration en = new ProtoActionAccessBean().findByProjecttypeOrderByOrderAsc(new Integer(prjtype));
   	while (en.hasMoreElements()) {
		ProtoActionAccessBean pbn = (ProtoActionAccessBean)en.nextElement();

		Enumeration en1 = new ProjectActionAccessBean().findByProjectAndProjectActionType(argProject, new Integer(pbn.getProjectActionType().getProjectactiontype()));
		if (en1.hasMoreElements()) {
			ProjectActionAccessBean bn = (ProjectActionAccessBean)en1.nextElement();
			result.add(bn);
		}
		
	    // Add user columns after current column
	    Enumeration ena = new ProjectDivColumnsAccessBean().findByColDivisionActtypeOrderByAfterColAsc(new Integer(pbn.getProjectaction()), 
		    argDivCode, new Integer(prjtype));
	    while (ena.hasMoreElements()) {
		    ProjectDivColumnsAccessBean pab = (ProjectDivColumnsAccessBean)ena.nextElement();
		    UserColumnObject co = new UserColumnObject(pab, argProject.intValue());
		    result.add(co);
	    }
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 16:57:34)
 * @return int
 */
public int getAcceptcode() {
	return acceptcode;
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 12:15:50)
 * @return java.lang.String
 */
public String getCanAdd(javax.servlet.http.HttpServletRequest request) throws Exception{
    if (Util_Alex.isUserInSecurity(SECURITY_ADMIN, request) && !isIsFull()) {

        return "true";
    } else
        return "false";
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getConfirmRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("planAdmin");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 14:06:16)
 * @return java.lang.String
 */
public java.lang.String getContructerName() {
	return contructerName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 18:19:23)
 * @return int
 */
public int getDivcode() {
	return divcode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("planAdmin");
	roles.add("planResponsible");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (25.09.2002 19:26:04)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    try {
        return new Object[] { new Integer(getProjectParameter()), new Integer(getDivcode())};
    } catch (Exception e) {
        Util_Alex.pr(e, "getFilterParameter", this);
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 14:05:24)
 * @return java.lang.String
 */
public java.lang.String getFullPosition() {
	return fullPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 14:06:54)
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:42:42)
 * @return java.lang.String
 */
public java.lang.String getProjectname() {
	return projectname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:44:12)
 * @return int
 */
public int getProjectParameter() {
	return projectParameter;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:44:12)
 * @return int
 */
public int getProjecttype() {
	return projecttype;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 13:23:57)
 * @return java.lang.String
 */
public java.lang.String getProjecttypename() {
	return projecttypename;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 16:57:46)
 * @return int
 */
public int getRejectcode() {
	return rejectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 15:41:03)
 * @return java.lang.String
 */
public java.lang.String getShowacttype() {
	return showacttype;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 14:07:36)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:50:54)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:46:59)
 * @return boolean
 */
public boolean isIsFull() {
	return isFull;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2003 16:46:16)
 * @return java.lang.String
 * @param nameBase java.lang.String
 */
public String makeName(String nameBase) {
	try {
		return nameBase + "_" + getProjecttype() + "_" + getDivcode();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 16:57:34)
 * @param newAcceptcode int
 */
public void setAcceptcode(int newAcceptcode) {
	acceptcode = newAcceptcode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 14:06:16)
 * @param newContructerName java.lang.String
 */
public void setContructerName(java.lang.String newContructerName) {
	contructerName = newContructerName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 18:19:23)
 * @param newDivcode int
 */
public void setDivcode(int newDivcode) {
	divcode = newDivcode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 14:05:24)
 * @param newFullPosition java.lang.String
 */
public void setFullPosition(java.lang.String newFullPosition) {
	fullPosition = newFullPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:46:59)
 * @param newIsFull boolean
 */
public void setIsFull(boolean newIsFull) {
	isFull = newIsFull;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 14:06:54)
 * @param newNotes java.lang.String
 */
public void setNotes(java.lang.String newNotes) {
	notes = newNotes;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:42:42)
 * @param newProjectname java.lang.String
 */
public void setProjectname(java.lang.String newProjectname) {
	projectname = newProjectname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 13:23:08)
 * @param newProjectParameter java.lang.String
 */
public void setProjectParameter(int newProjectParameter) throws Exception{
	projectParameter = newProjectParameter;
    ProjectAdv project = new ProjectAdv();
    project.setInitKey_project(newProjectParameter);
    project.refreshCopyHelper();
	setProjectname(project.getName());
	setProjecttype(project.getProjecttype().getProjecttype());
	setProjecttypename(project.getProjecttype().getName());
	setIsFull(project.isFull());
	setStorageplace(project.getPosition().getStorageplace());
	setFullPosition(project.getFullPosition());
	setContructerName(project.getContructerName());
	setNotes(project.getNotes());
	setState(project.getState());
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:44:12)
 * @param newProjecttype int
 */
public void setProjecttype(int newProjecttype) {
	projecttype = newProjecttype;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 13:23:57)
 * @param newProjecttypename java.lang.String
 */
public void setProjecttypename(java.lang.String newProjecttypename) {
	projecttypename = newProjecttypename;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2003 16:57:46)
 * @param newRejectcode int
 */
public void setRejectcode(int newRejectcode) {
	rejectcode = newRejectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 15:41:03)
 * @param newShowacttype java.lang.String
 */
public void setShowacttype(java.lang.String newShowacttype) {
	showacttype = newShowacttype;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 14:07:36)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 12:50:54)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
}
