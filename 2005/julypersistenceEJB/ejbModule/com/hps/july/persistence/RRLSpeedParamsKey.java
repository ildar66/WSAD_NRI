package com.hps.july.persistence;

public class RRLSpeedParamsKey implements java.io.Serializable {
	public int rrlspeedid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RRLSpeedParamsKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argRrlspeedid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RRLSpeedParamsKey(int argRrlspeedid) {
	rrlspeedid = argRrlspeedid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof RRLSpeedParamsKey) {
		RRLSpeedParamsKey otherKey = (RRLSpeedParamsKey) o;
		return (((this.rrlspeedid == otherKey.rrlspeedid)));
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
	return ((new java.lang.Integer(rrlspeedid).hashCode()));
}
}
