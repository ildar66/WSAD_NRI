package com.hps.july.persistence;

public class PIESerialResLinkKey implements java.io.Serializable {
	public int owner;
	private final static long serialVersionUID = 3206093459760846163L;
	public int storagecard;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIESerialResLinkKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argOwner int
 * @param argStoragecard int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIESerialResLinkKey(int argOwner, int argStoragecard) {
	owner = argOwner;
	storagecard = argStoragecard;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIESerialResLinkKey) {
		PIESerialResLinkKey otherKey = (PIESerialResLinkKey) o;
		return (((this.owner == otherKey.owner)
		 && (this.storagecard == otherKey.storagecard)));
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
	return ((new java.lang.Integer(owner).hashCode())
		 + (new java.lang.Integer(storagecard).hashCode()));
}
}
