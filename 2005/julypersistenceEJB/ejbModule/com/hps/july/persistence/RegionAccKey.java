package com.hps.july.persistence;

public class RegionAccKey implements java.io.Serializable {
	public int accessid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RegionAccKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAccessid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RegionAccKey(int argAccessid) {
	accessid = argAccessid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof RegionAccKey) {
		RegionAccKey otherKey = (RegionAccKey) o;
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
