package com.hps.july.persistence;

public class OuterDocPositionKey implements java.io.Serializable {
	public int outerDocPosition;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OuterDocPositionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argOuterDocPosition int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OuterDocPositionKey(int argOuterDocPosition) {
	outerDocPosition = argOuterDocPosition;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof OuterDocPositionKey) {
		OuterDocPositionKey otherKey = (OuterDocPositionKey) o;
		return (((this.outerDocPosition == otherKey.outerDocPosition)));
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
	return ((new java.lang.Integer(outerDocPosition).hashCode()));
}
}
