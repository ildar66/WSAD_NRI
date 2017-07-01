package com.hps.july.persistence;

public class PIEOtvUserPlatinumKey implements java.io.Serializable {
	public java.lang.String otvuserplatinum;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEOtvUserPlatinumKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argOtvuserplatinum java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEOtvUserPlatinumKey(java.lang.String argOtvuserplatinum) {
	otvuserplatinum = argOtvuserplatinum;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEOtvUserPlatinumKey) {
		PIEOtvUserPlatinumKey otherKey = (PIEOtvUserPlatinumKey) o;
		return ((this.otvuserplatinum.equals(otherKey.otvuserplatinum)));
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
	return (otvuserplatinum.hashCode());
}
}
