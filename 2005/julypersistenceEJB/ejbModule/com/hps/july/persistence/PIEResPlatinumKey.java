package com.hps.july.persistence;

public class PIEResPlatinumKey implements java.io.Serializable {
	public java.lang.String idresplatinum;
	private final static long serialVersionUID = 3206093459760846163L;
	public int owner;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEResPlatinumKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdresplatinum java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEResPlatinumKey(java.lang.String argIdresplatinum) {
	idresplatinum = argIdresplatinum;
}
/**
 * Initialize a key from the passed values
 * @param argIdresplatinum java.lang.String
 * @param argOwner int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEResPlatinumKey(java.lang.String argIdresplatinum, int argOwner) {
	idresplatinum = argIdresplatinum;
	owner = argOwner;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof PIEResPlatinumKey) {
		PIEResPlatinumKey otherKey = (PIEResPlatinumKey) o;
		return ((this.idresplatinum.equals(otherKey.idresplatinum)
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
	return (idresplatinum.hashCode()
		 + (new java.lang.Integer(owner).hashCode()));
}
}
