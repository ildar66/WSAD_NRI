package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма списка работников подразделения.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class WorkerListDForm extends com.hps.july.web.util.BrowseForm {
	private int department;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkerListDForm() {
	this.setFinderMethodName( "findWorkersByDivision" );
	department = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 14:30:33)
 * @return int
 */
public int getDepartment() {
	return department;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new DivisionKey(department) };
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 14:30:33)
 * @param newDepartment int
 */
public void setDepartment(int newDepartment) {
	department = newDepartment;
}
}
