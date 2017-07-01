package com.hps.july.persistence;

public class SuperRegionKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int supregid;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SuperRegionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argSupregid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SuperRegionKey(int argSupregid) {
	supregid = argSupregid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof SuperRegionKey) {
		SuperRegionKey otherKey = (SuperRegionKey) o;
		return (((this.supregid == otherKey.supregid)));
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
	return ((new java.lang.Integer(supregid).hashCode()));
}
}
