package com.hps.july.persistence;

public class PIEQueryListKey implements java.io.Serializable {
	public int idquerylist;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEQueryListKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdquerylist int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEQueryListKey(int argIdquerylist) {
	idquerylist = argIdquerylist;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEQueryListKey) {
		PIEQueryListKey otherKey = (PIEQueryListKey) o;
		return (((this.idquerylist == otherKey.idquerylist)));
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
	return ((new java.lang.Integer(idquerylist).hashCode()));
}
}
