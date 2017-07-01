package com.hps.july.persistence;

public class PIEBankPlatinumKey implements java.io.Serializable {
	public java.lang.String idbankplatinum;
	public int owner;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEBankPlatinumKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdbankplatinum java.lang.String
 * @param argOwner int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEBankPlatinumKey(java.lang.String argIdbankplatinum, int argOwner) {
	idbankplatinum = argIdbankplatinum;
	owner = argOwner;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEBankPlatinumKey) {
		PIEBankPlatinumKey otherKey = (PIEBankPlatinumKey) o;
		return ((this.idbankplatinum.equals(otherKey.idbankplatinum)
		 && (this.owner == otherKey.owner)));
	}
	else
		return false;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (idbankplatinum.hashCode()
		 + (new java.lang.Integer(owner).hashCode()));
}
}
