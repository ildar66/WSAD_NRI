package com.hps.july.project.formbean;

import com.hps.july.persistence.*;

/**
 * Форма lookup по выбору типового события.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class ActionsProjectLookupForm extends com.hps.july.web.util.BrowseForm {
private int projectaction;
		private int projecttype;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ActionsProjectLookupForm() {
	this.setFinderMethodName( "findStepsBeforeOrderByOrderAsc" );
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {new Integer(projecttype),new Integer(projectaction) };
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 17:10:16)
 * @return int
 */
public int getProjectaction() {
	return projectaction;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 20:34:33)
 * @return int
 */
public int getProjecttype() {
	return projecttype;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 17:10:16)
 * @param newProjectaction int
 */
public void setProjectaction(int newProjectaction) {
	projectaction = newProjectaction;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 20:34:33)
 * @param newProjecttype int
 */
public void setProjecttype(int newProjecttype) {
	projecttype = newProjecttype;
}
}
