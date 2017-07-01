package com.hps.july.persistence;

public class SearchesKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer group_searchgroup;
	public java.lang.Integer organization_organization;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SearchesKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argGroup com.hps.july.persistence.SearchGroupKey
 * @param argOrganization com.hps.july.persistence.OrganizationKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SearchesKey(SearchGroupKey argGroup, OrganizationKey argOrganization) {
	privateSetGroupKey(argGroup);
	privateSetOrganizationKey(argOrganization);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof SearchesKey) {
		SearchesKey otherKey = (SearchesKey) o;
		return ((this.group_searchgroup.equals(otherKey.group_searchgroup)
		 && this.organization_organization.equals(otherKey.organization_organization)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.SearchGroupKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SearchGroupKey getGroupKey() {
	com.hps.july.persistence.SearchGroupKey temp = null;
	temp = new com.hps.july.persistence.SearchGroupKey();
	boolean group_NULLTEST = true;
	group_NULLTEST &= (group_searchgroup == null);
	temp.searchgroup = ((group_searchgroup == null) ? 0 : group_searchgroup.intValue());
	if (group_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.OrganizationKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OrganizationKey getOrganizationKey() {
	com.hps.july.persistence.OrganizationKey temp = null;
	temp = new com.hps.july.persistence.OrganizationKey();
	boolean organization_NULLTEST = true;
	organization_NULLTEST &= (organization_organization == null);
	temp.organization = ((organization_organization == null) ? 0 : organization_organization.intValue());
	if (organization_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (group_searchgroup.hashCode()
		 + organization_organization.hashCode());
}
/**
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.SearchGroupKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetGroupKey(com.hps.july.persistence.SearchGroupKey inKey) {
	boolean group_NULLTEST = (inKey == null);
	if (group_NULLTEST) group_searchgroup = null; else group_searchgroup = (new Integer(inKey.searchgroup));
}
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.OrganizationKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOrganizationKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean organization_NULLTEST = (inKey == null);
	if (organization_NULLTEST) organization_organization = null; else organization_organization = (new Integer(inKey.organization));
}
}
