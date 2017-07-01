package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * Форма списка счетов юр. лица
 */
public class AccountListForm extends com.hps.july.web.util.BrowseForm {
	private int organization;
	private java.lang.String orgname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public AccountListForm() {
	this.setFinderMethodName( "findAccountByOrganization" );
	organization = 0;
	orgname = "";
	}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictPartAdmin");
	roles.add("MainEconomist");
	roles.add("Economist");
	roles.add("ArendaEconomist");
	roles.add("ArendaMainEconomist");
	return roles;
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
