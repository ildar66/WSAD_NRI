package com.hps.july.persistence;

public class PIEPayPlatinumKey implements java.io.Serializable {
	public java.lang.String idpayplatinum; 
	private final static long serialVersionUID = 3206093459760846163L;
	public int owner;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEPayPlatinumKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdpayplatinum java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEPayPlatinumKey(java.lang.String argIdpayplatinum) {
	idpayplatinum = argIdpayplatinum;
}
/**
 * Initialize a key from the passed values
 * @param argIdpayplatinum java.lang.String
 * @param argOwner int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEPayPlatinumKey(java.lang.String argIdpayplatinum, int argOwner) {
	idpayplatinum = argIdpayplatinum;
	owner = argOwner;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof PIEPayPlatinumKey) {
		PIEPayPlatinumKey otherKey = (PIEPayPlatinumKey) o;
		return ((this.idpayplatinum.equals(otherKey.idpayplatinum)
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
	return (idpayplatinum.hashCode()
		 + (new java.lang.Integer(owner).hashCode()));
}
}
