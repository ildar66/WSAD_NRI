package com.hps.july.persistence;

public class PIEMxranLinkKey implements java.io.Serializable {
	public int mxrannri;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.String mxranplatinum_mxranplatinum;
	public java.lang.Integer mxranplatinum_owner_organization;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEMxranLinkKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argMxrannri int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEMxranLinkKey(int argMxrannri) {
	mxrannri = argMxrannri;
}
/**
 * Initialize a key from the passed values
 * @param argMxrannri int
 * @param argMxranplatinum com.hps.july.persistence.PIEMxranPlatinumKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEMxranLinkKey(int argMxrannri, PIEMxranPlatinumKey argMxranplatinum) {
	mxrannri = argMxrannri;
	privateSetMxranplatinumKey(argMxranplatinum);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof PIEMxranLinkKey) {
		PIEMxranLinkKey otherKey = (PIEMxranLinkKey) o;
		return (((this.mxrannri == otherKey.mxrannri)
		 && this.mxranplatinum_mxranplatinum.equals(otherKey.mxranplatinum_mxranplatinum)
		 && this.mxranplatinum_owner_organization.equals(otherKey.mxranplatinum_owner_organization)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named PIEMxranLink2mxran.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.PIEMxranPlatinumKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEMxranPlatinumKey getMxranplatinumKey() {
	com.hps.july.persistence.PIEMxranPlatinumKey temp = null;
	temp = new com.hps.july.persistence.PIEMxranPlatinumKey();
	boolean mxranplatinum_NULLTEST = true;
	mxranplatinum_NULLTEST &= (mxranplatinum_mxranplatinum == null);
	temp.mxranplatinum = mxranplatinum_mxranplatinum;
	mxranplatinum_NULLTEST &= (mxranplatinum_owner_organization == null);
	temp.owner_organization = mxranplatinum_owner_organization;
	if (mxranplatinum_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return ((new java.lang.Integer(mxrannri).hashCode())
		 + mxranplatinum_mxranplatinum.hashCode()
		 + mxranplatinum_owner_organization.hashCode());
}
/**
 * This method was generated for supporting the association named PIEMxranLink2mxran.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.PIEMxranPlatinumKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetMxranplatinumKey(com.hps.july.persistence.PIEMxranPlatinumKey inKey) {
	boolean mxranplatinum_NULLTEST = (inKey == null);
	if (mxranplatinum_NULLTEST) mxranplatinum_mxranplatinum = null; else mxranplatinum_mxranplatinum = inKey.mxranplatinum;
	if (mxranplatinum_NULLTEST) mxranplatinum_owner_organization = null; else mxranplatinum_owner_organization = inKey.owner_organization;
}
}
