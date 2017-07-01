package com.hps.july.dictionary.formbean;

/**
 * Форма списка юр. лиц (организаций) для добавления в группу
 */
public class OrganizationMultiListForm
	extends com.hps.july.web.util.BrowseForm
{
	private String orgname;
	private Boolean selissupplier;
	private Boolean selisrenter;
	private Boolean selisprovider;
	private Boolean isorgname;
	private Boolean isinn;
	private String orginn;
	private Boolean isgroup;
	private Integer group;
	private String groupname;
	private Integer groupping;
	private String grouppingname;
	private int[] selectedOrg;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public OrganizationMultiListForm() {
	this.setFinderMethodName( "findOrganizationsByQBEAndGroup" );
	isorgname = java.lang.Boolean.FALSE;
	orgname = "";
	selisprovider = java.lang.Boolean.FALSE;
	selisrenter = java.lang.Boolean.FALSE;
	selissupplier = new java.lang.Boolean(false);
	isinn = java.lang.Boolean.TRUE;
	orginn = "";
	isgroup = Boolean.TRUE;
	group = new Integer(0);
	groupname = "";
	groupping = new Integer(0);
	grouppingname = "";
	selectedOrg = new int [0];	
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
	if (getGroup() == null)
		setGroup(new Integer(0));
	if (getGroupping() == null)
		setGroupping(new Integer(0));
	return new Object[] { isorgname.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, orgname, 
		selissupplier, selisprovider, selisrenter,
		isinn.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, orginn,
		new java.lang.Integer(1),
		isgroup.booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, getGroup(), getGroupping() };
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 10:02:08)
 * @return java.lang.Integer
 */
public java.lang.Integer getGroup() {
	return group;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 10:02:24)
 * @return java.lang.String
 */
public java.lang.String getGroupname() {
	return groupname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 10:02:47)
 * @return java.lang.Integer
 */
public java.lang.Integer getGroupping() {
	return groupping;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 10:03:02)
 * @return java.lang.String
 */
public java.lang.String getGrouppingname() {
	return grouppingname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 10:01:07)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsgroup() {
	return isgroup;
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
 * Creation date: (11.07.2002 10:22:48)
 * @return int[]
 */
public int[] getSelectedOrg() {
	return selectedOrg;
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
 * Creation date: (11.06.2002 10:02:08)
 * @param newGroup java.lang.Integer
 */
public void setGroup(java.lang.Integer newGroup) {
	group = newGroup;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 10:02:24)
 * @param newGroupname java.lang.String
 */
public void setGroupname(java.lang.String newGroupname) {
	groupname = newGroupname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 10:02:47)
 * @param newGroupping java.lang.Integer
 */
public void setGroupping(java.lang.Integer newGroupping) {
	groupping = newGroupping;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 10:03:02)
 * @param newGrouppingname java.lang.String
 */
public void setGrouppingname(java.lang.String newGrouppingname) {
	grouppingname = newGrouppingname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2002 10:01:07)
 * @param newIsgroup java.lang.Boolean
 */
public void setIsgroup(java.lang.Boolean newIsgroup) {
	isgroup = newIsgroup;
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
 * Creation date: (11.07.2002 10:22:48)
 * @param newSelectedOrg int[]
 */
public void setSelectedOrg(int[] newSelectedOrg) {
	selectedOrg = newSelectedOrg;
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
