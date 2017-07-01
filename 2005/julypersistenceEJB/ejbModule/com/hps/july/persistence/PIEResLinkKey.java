package com.hps.july.persistence;

public class PIEResLinkKey implements java.io.Serializable {
	public int idresnri;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.String resplatinum_idresplatinum;
	public java.lang.Integer resplatinum_owner;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEResLinkKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdresnri int
 * @param argResplatinum com.hps.july.persistence.PIEResPlatinumKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEResLinkKey(int argIdresnri, PIEResPlatinumKey argResplatinum) {
	idresnri = argIdresnri;
	privateSetResplatinumKey(argResplatinum);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof PIEResLinkKey) {
		PIEResLinkKey otherKey = (PIEResLinkKey) o;
		return (((this.idresnri == otherKey.idresnri)
		 && this.resplatinum_idresplatinum.equals(otherKey.resplatinum_idresplatinum)
		 && this.resplatinum_owner.equals(otherKey.resplatinum_owner)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.PIEResPlatinumKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEResPlatinumKey getResplatinumKey() {
	com.hps.july.persistence.PIEResPlatinumKey temp = null;
	temp = new com.hps.july.persistence.PIEResPlatinumKey();
	boolean resplatinum_NULLTEST = true;
	resplatinum_NULLTEST &= (resplatinum_idresplatinum == null);
	temp.idresplatinum = resplatinum_idresplatinum;
	resplatinum_NULLTEST &= (resplatinum_owner == null);
	temp.owner = ((resplatinum_owner == null) ? 0 : resplatinum_owner.intValue());
	if (resplatinum_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return ((new java.lang.Integer(idresnri).hashCode())
		 + resplatinum_idresplatinum.hashCode()
		 + resplatinum_owner.hashCode());
}
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.PIEResPlatinumKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResplatinumKey(com.hps.july.persistence.PIEResPlatinumKey inKey) {
	boolean resplatinum_NULLTEST = (inKey == null);
	if (resplatinum_NULLTEST) resplatinum_idresplatinum = null; else resplatinum_idresplatinum = inKey.idresplatinum;
	if (resplatinum_NULLTEST) resplatinum_owner = null; else resplatinum_owner = (new Integer(inKey.owner));
}
}
