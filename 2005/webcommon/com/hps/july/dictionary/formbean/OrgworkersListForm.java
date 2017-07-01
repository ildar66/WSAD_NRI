package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * Форма списка служащих организации (юр. лица)
 */
public class OrgworkersListForm extends com.hps.july.web.util.BrowseForm {
	private int organization;
	private String organizationname;
	private String lastnamemask;
public OrgworkersListForm() {
	this.setFinderMethodName( "findAlienWorkers" );
//	this.setFinderMethodName( "findWorkersByOrganization" );
	organization = 0;
	organizationname = null;
	lastnamemask = "*";
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictPartAdmin");
	roles.add("dictPartOperator");
	/*
	roles.add("ArendaMainEconomist");
	roles.add("ArendaEconomist");
	roles.add("ArendaManager");
	roles.add("ArendaMainManager");
	*/
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] { 
		new Integer(organization),
		(lastnamemask == null)?"":lastnamemask
	};
//	return new Object[] {
//		new OrganizationKey(organization)
//	};
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLastnamemask() {
	return lastnamemask;
}
public int getOrganization() {
	return organization;
}
public java.lang.String getOrganizationname() {
	return organizationname;
}
public void setLastnamemask(java.lang.String newLastnamemask) {
	lastnamemask = newLastnamemask;
}
public void setOrganization(int newOrganization) {
	organization = newOrganization;
}
public void setOrganizationname(java.lang.String newOrganizationname) {
	organizationname = newOrganizationname;
}
}
