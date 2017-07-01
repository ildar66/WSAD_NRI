package com.hps.july.persistence;

public class RRLAntParamsKey implements java.io.Serializable {
	public int rrlantid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RRLAntParamsKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argRrlantid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RRLAntParamsKey(int argRrlantid) {
	rrlantid = argRrlantid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof RRLAntParamsKey) {
		RRLAntParamsKey otherKey = (RRLAntParamsKey) o;
		return (((this.rrlantid == otherKey.rrlantid)));
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
	return ((new java.lang.Integer(rrlantid).hashCode()));
}
}
