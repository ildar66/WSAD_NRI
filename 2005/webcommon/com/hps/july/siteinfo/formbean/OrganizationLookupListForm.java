package com.hps.july.siteinfo.formbean;

/**
 * Форма выбора организации
 */
public class OrganizationLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String orgname;
	private java.lang.Boolean selissupplier;
	private java.lang.Boolean selisrenter;
	private java.lang.Boolean selisprovider;
	private java.lang.Boolean isorgname;
	private java.lang.Boolean isinn;
	private java.lang.String orginn;
public OrganizationLookupListForm() {
	this.setFinderMethodName( "findOrganizationsByQBE" );
	isorgname = Boolean.FALSE;
	isinn = Boolean.TRUE;
	selisprovider = Boolean.FALSE;
	selisrenter = Boolean.TRUE;
	selissupplier = Boolean.FALSE;
	orginn = "";
	orgname = "*";
	}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		isorgname.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, orgname, 
		selissupplier, selisprovider, selisrenter,
		isinn.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, orginn,
		new java.lang.Integer(1)
	};
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:38:03)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsinn() {
	return isinn;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:37:31)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsorgname() {
	return isorgname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:38:20)
 * @return java.lang.String
 */
public java.lang.String getOrginn() {
	return orginn;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 16:35:20)
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:10:33)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSelisprovider() {
	return selisprovider;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:09:24)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSelisrenter() {
	return selisrenter;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:08:52)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSelissupplier() {
	return selissupplier;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:38:03)
 * @param newIsinn java.lang.Boolean
 */
public void setIsinn(java.lang.Boolean newIsinn) {
	isinn = newIsinn;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:37:31)
 * @param newIsorgname java.lang.Boolean
 */
public void setIsorgname(java.lang.Boolean newIsorgname) {
	isorgname = newIsorgname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 18:38:20)
 * @param newOrginn java.lang.String
 */
public void setOrginn(java.lang.String newOrginn) {
	orginn = newOrginn;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 16:35:20)
 * @param newName java.lang.String
 */
public void setOrgname(java.lang.String newName) {
	orgname = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:10:33)
 * @param newIsprovider java.lang.Boolean
 */
public void setSelisprovider(java.lang.Boolean newIsprovider) {
	selisprovider = newIsprovider;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:09:24)
 * @param newIsrenter java.lang.Boolean
 */
public void setSelisrenter(java.lang.Boolean newIsrenter) {
	selisrenter = newIsrenter;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 11:08:52)
 * @param newIssupplier java.lang.Boolean
 */
public void setSelissupplier(java.lang.Boolean newIssupplier) {
	selissupplier = newIssupplier;
}
}
