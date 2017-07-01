package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * Форма списка юр. лиц компании
 */
public class OrganizationListCForm extends com.hps.july.web.util.BrowseForm {
	private int company;
	private java.lang.Integer group;
	private java.lang.String groupname;
	private java.lang.Integer groupping;
	private java.lang.String grouppingname;
	private java.lang.Boolean isgroup;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public OrganizationListCForm() {
	this.setFinderMethodName( "findOrganizationsButBanksByCompanyAndGroup" );
	company = 0;
	isgroup = Boolean.TRUE;
	group = new Integer(0);
	groupping = new Integer(0);
	}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 16:10:14)
 * @return int
 */
public int getCompany() {
	return company;
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
	return new Object[] {
		new Integer(company),
		isgroup.booleanValue()?Boolean.FALSE:Boolean.TRUE,
		group,
		groupping
	};
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 16:41:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getGroup() {
	return group;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 16:41:38)
 * @return java.lang.String
 */
public java.lang.String getGroupname() {
	return groupname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 16:41:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getGroupping() {
	return groupping;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 16:42:09)
 * @return java.lang.String
 */
public java.lang.String getGrouppingname() {
	return grouppingname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 16:42:35)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsgroup() {
	return isgroup;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 16:10:14)
 * @param newCompany int
 */
public void setCompany(int newCompany) {
	company = newCompany;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 16:41:06)
 * @param newGroup java.lang.Integer
 */
public void setGroup(java.lang.Integer newGroup) {
	group = newGroup;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 16:41:38)
 * @param newGroupname java.lang.String
 */
public void setGroupname(java.lang.String newGroupname) {
	groupname = newGroupname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 16:41:55)
 * @param newGroupping java.lang.Integer
 */
public void setGroupping(java.lang.Integer newGroupping) {
	groupping = newGroupping;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 16:42:09)
 * @param newGrouppingname java.lang.String
 */
public void setGrouppingname(java.lang.String newGrouppingname) {
	grouppingname = newGrouppingname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 16:42:35)
 * @param newIsgroup java.lang.Boolean
 */
public void setIsgroup(java.lang.Boolean newIsgroup) {
	isgroup = newIsgroup;
}
}
