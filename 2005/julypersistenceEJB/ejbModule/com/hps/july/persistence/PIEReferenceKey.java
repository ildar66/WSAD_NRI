package com.hps.july.persistence;

public class PIEReferenceKey implements java.io.Serializable {
	public int idreference;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEReferenceKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdreference int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEReferenceKey(int argIdreference) {
	idreference = argIdreference;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEReferenceKey) {
		PIEReferenceKey otherKey = (PIEReferenceKey) o;
		return (((this.idreference == otherKey.idreference)));
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
	return ((new java.lang.Integer(idreference).hashCode()));
}
}
