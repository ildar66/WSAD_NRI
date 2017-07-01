package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
/**
 * Form-Bean
 * поиск счетов
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class AccountLookupListForm extends com.hps.july.web.util.BrowseForm {
	private int organization;
	private java.lang.String orgname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public AccountLookupListForm() {
	this.setFinderMethodName( "findAccountByOrganization" );
	organization = 0;
	orgname = "";
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new OrganizationKey(organization) };
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 11:24:30)
 * @return int
 */
public int getOrganization() {
	return organization;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 11:24:46)
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 11:24:30)
 * @param newOrganization int
 */
public void setOrganization(int newOrganization) {
	organization = newOrganization;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 11:24:46)
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
}
