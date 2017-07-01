package com.hps.july.persistence;

public class PIEDocPosNriKey implements java.io.Serializable {
	public int idrecdocpos;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDocPosNriKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdrecdocpos int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDocPosNriKey(int argIdrecdocpos) {
	idrecdocpos = argIdrecdocpos;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEDocPosNriKey) {
		PIEDocPosNriKey otherKey = (PIEDocPosNriKey) o;
		return (((this.idrecdocpos == otherKey.idrecdocpos)));
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
	return ((new java.lang.Integer(idrecdocpos).hashCode()));
}
}
