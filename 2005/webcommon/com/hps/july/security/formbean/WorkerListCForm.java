package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
/**
 * Форма списка работников компании.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class WorkerListCForm extends com.hps.july.web.util.BrowseForm {
	private int company;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkerListCForm() {
	this.setFinderMethodName( "findWorkersByCompany" );
	company = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 14:22:15)
 * @return int
 */
public int getCompany() {
	return company;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new CompanyKey(company) };
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 14:22:15)
 * @param newCompany int
 */
public void setCompany(int newCompany) {
	company = newCompany;
}
}
