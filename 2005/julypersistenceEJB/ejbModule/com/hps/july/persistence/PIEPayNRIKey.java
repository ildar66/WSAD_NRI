package com.hps.july.persistence;

public class PIEPayNRIKey implements java.io.Serializable {
	public int id;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEPayNRIKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argId int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEPayNRIKey(int argId) {
	id = argId;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEPayNRIKey) {
		PIEPayNRIKey otherKey = (PIEPayNRIKey) o;
		return (((this.id == otherKey.id)));
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
	return ((new java.lang.Integer(id).hashCode()));
}
}
