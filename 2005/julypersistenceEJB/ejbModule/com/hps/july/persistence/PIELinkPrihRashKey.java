package com.hps.july.persistence;

public class PIELinkPrihRashKey implements java.io.Serializable {
	public int idlinkprihodrashod;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIELinkPrihRashKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdlinkprihodrashod int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIELinkPrihRashKey(int argIdlinkprihodrashod) {
	idlinkprihodrashod = argIdlinkprihodrashod;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIELinkPrihRashKey) {
		PIELinkPrihRashKey otherKey = (PIELinkPrihRashKey) o;
		return (((this.idlinkprihodrashod == otherKey.idlinkprihodrashod)));
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
	return ((new java.lang.Integer(idlinkprihodrashod).hashCode()));
}
}
