package com.hps.july.persistence;

public class PIEDocNriKey implements java.io.Serializable {
	public int idrecdoc;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDocNriKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdrecdoc int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDocNriKey(int argIdrecdoc) {
	idrecdoc = argIdrecdoc;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEDocNriKey) {
		PIEDocNriKey otherKey = (PIEDocNriKey) o;
		return (((this.idrecdoc == otherKey.idrecdoc)));
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
	return ((new java.lang.Integer(idrecdoc).hashCode()));
}
}
