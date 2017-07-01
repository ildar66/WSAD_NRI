package com.hps.july.persistence;

public class PIEQueryKey implements java.io.Serializable {
	public int idquery;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEQueryKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdquery int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEQueryKey(int argIdquery) {
	idquery = argIdquery;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEQueryKey) {
		PIEQueryKey otherKey = (PIEQueryKey) o;
		return (((this.idquery == otherKey.idquery)));
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
	return ((new java.lang.Integer(idquery).hashCode()));
}
}
