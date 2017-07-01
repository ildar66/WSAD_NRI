package com.hps.july.persistence;

public class SuperRegionAccKey implements java.io.Serializable {
	public int accessid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SuperRegionAccKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAccessid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SuperRegionAccKey(int argAccessid) {
	accessid = argAccessid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof SuperRegionAccKey) {
		SuperRegionAccKey otherKey = (SuperRegionAccKey) o;
		return (((this.accessid == otherKey.accessid)));
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
	return ((new java.lang.Integer(accessid).hashCode()));
}
}
