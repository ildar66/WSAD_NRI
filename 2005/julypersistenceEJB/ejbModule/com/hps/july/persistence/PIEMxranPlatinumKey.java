package com.hps.july.persistence;

public class PIEMxranPlatinumKey implements java.io.Serializable {
	public java.lang.String mxranplatinum;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer owner_organization;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEMxranPlatinumKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argMxranplatinum java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEMxranPlatinumKey(java.lang.String argMxranplatinum) {
	mxranplatinum = argMxranplatinum;
}
/**
 * Initialize a key from the passed values
 * @param argMxranplatinum java.lang.String
 * @param argOwner com.hps.july.persistence.OrganizationKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEMxranPlatinumKey(java.lang.String argMxranplatinum, OrganizationKey argOwner) {
	mxranplatinum = argMxranplatinum;
	privateSetOwnerKey(argOwner);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof PIEMxranPlatinumKey) {
		PIEMxranPlatinumKey otherKey = (PIEMxranPlatinumKey) o;
		return ((this.mxranplatinum.equals(otherKey.mxranplatinum)
		 && this.owner_organization.equals(otherKey.owner_organization)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.OrganizationKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OrganizationKey getOwnerKey() {
	com.hps.july.persistence.OrganizationKey temp = null;
	temp = new com.hps.july.persistence.OrganizationKey();
	boolean owner_NULLTEST = true;
	owner_NULLTEST &= (owner_organization == null);
	temp.organization = ((owner_organization == null) ? 0 : owner_organization.intValue());
	if (owner_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (mxranplatinum.hashCode()
		 + owner_organization.hashCode());
}
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.OrganizationKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOwnerKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean owner_NULLTEST = (inKey == null);
	if (owner_NULLTEST) owner_organization = null; else owner_organization = (new Integer(inKey.organization));
}
}
