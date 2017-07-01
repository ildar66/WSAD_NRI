package com.hps.july.project.formbean;

import com.hps.july.persistence.*;

/**
 * Форма lookup по выбору типового события проекта.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class ProjectActionTypeLookupForm extends com.hps.july.web.util.BrowseForm {
private int projecttype;
private int projectactiontype;
	
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ProjectActionTypeLookupForm() {
	this.setFinderMethodName( "findByProjecttypeOrderByCodeAsc" );
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    Object[] ob = new Object[2];
    ob[0] = new Integer(projecttype);
    ob[1] = new Integer(projectactiontype);

    return ob;
}
/**
 * Insert the method's description here.
 * Creation date: (30.12.2002 10:41:30)
 * @param newProjectactiontype int
 */
public void setProjectactiontype(int newProjectactiontype) {
	projectactiontype = newProjectactiontype;
}
/**
 * Insert the method's description here.
 * Creation date: (30.12.2002 10:41:30)
 * @param newProjecttype int
 */
public void setProjecttype(int newProjecttype) {
	projecttype = newProjecttype;
}
}
