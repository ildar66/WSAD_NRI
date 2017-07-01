package com.hps.july.security.formbean;

import com.hps.july.persistence.PeopleKey;
/**
 * Форма списка работников.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class WorkerListForm extends com.hps.july.web.util.BrowseForm {
	private int man;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkerListForm() {
	this.setFinderMethodName( "findWorkersByMan" );
	man = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new PeopleKey(man) };
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 10:26:03)
 * @return int
 */
public int getMan() {
	return man;
}
/**
 * Insert the method's description here.
 * Creation date: (12.02.2002 10:26:03)
 * @param newMan int
 */
public void setMan(int newMan) {
	man = newMan;
}
}
