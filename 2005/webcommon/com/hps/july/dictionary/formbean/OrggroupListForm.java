package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * Форма списка групп в которую входит компания
 */
public class OrggroupListForm extends com.hps.july.web.util.BrowseForm {
	private int organization;
	private java.lang.String organizationname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public OrggroupListForm() {
	this.setFinderMethodName( "findSearchesByOrganization" );
	organization = 0;
	organizationname = null;
	}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictPartAdmin");
	roles.add("dictPartOperator");
	roles.add("ArendaMainEconomist");
	roles.add("ArendaEconomist");
	roles.add("ArendaManager");
	roles.add("ArendaMainManager");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new com.hps.july.persistence.OrganizationKey(organization) };
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:03:36)
 * @return int
 */
public int getOrganization() {
	return organization;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:03:36)
 * @return java.lang.String
 */
public java.lang.String getOrganizationname() {
	return organizationname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:03:36)
 * @param newOrganization int
 */
public void setOrganization(int newOrganization) {
	organization = newOrganization;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 18:03:36)
 * @param newOrganizationname java.lang.String
 */
public void setOrganizationname(java.lang.String newOrganizationname) {
	organizationname = newOrganizationname;
}
}
