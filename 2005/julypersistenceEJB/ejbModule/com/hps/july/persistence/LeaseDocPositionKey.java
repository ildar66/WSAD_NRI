package com.hps.july.persistence;

public class LeaseDocPositionKey implements java.io.Serializable {
	public int leaseDocPosition;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseDocPositionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeaseDocPosition int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseDocPositionKey(int argLeaseDocPosition) {
	leaseDocPosition = argLeaseDocPosition;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof LeaseDocPositionKey) {
		LeaseDocPositionKey otherKey = (LeaseDocPositionKey) o;
		return (((this.leaseDocPosition == otherKey.leaseDocPosition)));
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
	return ((new java.lang.Integer(leaseDocPosition).hashCode()));
}
}
