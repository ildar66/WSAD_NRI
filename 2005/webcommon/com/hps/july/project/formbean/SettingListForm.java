package com.hps.july.project.formbean;

import com.hps.july.persistence.*;
import com.hps.july.project.*;
import com.hps.july.web.util.*;
import java.util.*;

/**
 * Форма списка параметров настроек задачи.
 * Creation date: (25.09.2002 19:26:04)
 * 
 */
public class SettingListForm extends com.hps.july.web.util.BrowseForm implements Securities{
    private ProjectTypeAccessBean projectType;
	private int projecttype;
	private int divcode;
	private java.lang.String divname;
/**
 * TypeProjectListForm constructor comment.
 */
public SettingListForm() {

	setFinderMethodName("findByProjecttypeOrderByOrderAsc");

}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2003 15:11:54)
 * @return int
 */
public int getDivcode() {
	return divcode;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2003 15:12:26)
 * @return java.lang.String
 */
public java.lang.String getDivname() {
	return divname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.09.2002 19:26:04)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    try {
	    if (projectType != null)
        	return new Object[] { new Integer(projectType.getProjecttype())};
        else
        	return new Object[] { new Integer(0)};
    } catch (Exception e) {
        Util_Alex.pr(e, "getFilterParameter", this);
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 16:06:30)
 * @return javax.servlet.http.HttpServletRequest
 */
public int getProjecttype() {
	return projecttype;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2002 17:54:48)
 * @return com.hps.july.persistence.ProjectTypeAccessBean
 */
public com.hps.july.persistence.ProjectTypeAccessBean getProjectType() {
	return projectType;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2003 16:46:16)
 * @return java.lang.String
 * @param nameBase java.lang.String
 */
public String makeName(String nameBase) {
	return nameBase + "_" + getProjecttype() + "_" + getDivcode();
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2003 15:11:54)
 * @param newDivcode int
 */
public void setDivcode(int newDivcode) {
	divcode = newDivcode;

	// Determine division name
	try {
		DivisionAccessBean dbean = new DivisionAccessBean();
		dbean.setInitKey_division(newDivcode);
		dbean.refreshCopyHelper();
		setDivname(dbean.getName());
	} catch (Exception e) {
		setDivname("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2003 15:12:26)
 * @param newDivname java.lang.String
 */
public void setDivname(java.lang.String newDivname) {
	divname = newDivname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.12.2002 13:23:08)
 * @param newProjectParameter java.lang.String
 */
public void setProjecttype(int value) throws Exception {
    projecttype = value;
    try {
	    projectType = new ProjectTypeAccessBean();
	    projectType.setInitKey_projecttype(value);
	    projectType.refreshCopyHelper();
    } catch (javax.ejb.ObjectNotFoundException e) {
	    projectType = null;
    }

}
}
