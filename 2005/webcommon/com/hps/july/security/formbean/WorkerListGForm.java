package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма списка работников группы.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class WorkerListGForm extends com.hps.july.web.util.BrowseForm {
	private int group;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkerListGForm() {
	this.setFinderMethodName( "findWorkersByDivision" );
	group = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new DivisionKey(group) };
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 14:31:58)
 * @return int
 */
public int getGroup() {
	return group;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 14:31:58)
 * @param newGroup int
 */
public void setGroup(int newGroup) {
	group = newGroup;
}
}
