package com.hps.july.trailcom.beans;

public class HopKey implements java.io.Serializable {
	public int hopsid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public HopKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argHopsid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public HopKey(int argHopsid) {
	hopsid = argHopsid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof HopKey) {
		HopKey otherKey = (HopKey) o;
		return (((this.hopsid == otherKey.hopsid)));
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
	return ((new java.lang.Integer(hopsid).hashCode()));
}
}
