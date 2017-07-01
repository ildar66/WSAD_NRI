package com.hps.july.siteinfo.formbean;

/**
 * Форма выбора подрядчика
 */
public class RenterLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String orgname;
	private java.lang.Boolean isorgname;
	private java.lang.Boolean isinn;
	private java.lang.String orginn;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public RenterLookupListForm() {
	this.setFinderMethodName( "findOrganizationsByQBE" );
	isorgname = java.lang.Boolean.FALSE;
	orgname = "";
	isinn = java.lang.Boolean.TRUE;
	orginn = "";
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { isorgname.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, orgname, 
		java.lang.Boolean.FALSE, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE,
		isinn.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, orginn,
		new java.lang.Integer(1) };
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
}
