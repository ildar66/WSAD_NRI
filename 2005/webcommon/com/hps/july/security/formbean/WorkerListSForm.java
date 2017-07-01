package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма списка работника службы.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class WorkerListSForm extends com.hps.july.web.util.BrowseForm {
	private int service;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkerListSForm() {
	this.setFinderMethodName( "findWorkersByDivision" );
	service = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new DivisionKey(service) };
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 14:28:13)
 * @return int
 */
public int getService() {
	return service;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 14:28:13)
 * @param newService int
 */
public void setService(int newService) {
	service = newService;
}
}
