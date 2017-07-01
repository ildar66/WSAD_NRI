package com.hps.july.persistence;

public class PeopleKey implements java.io.Serializable {
	public int man;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PeopleKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argMan int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PeopleKey(int argMan) {
	man = argMan;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PeopleKey) {
		PeopleKey otherKey = (PeopleKey) o;
		return (((this.man == otherKey.man)));
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
	return ((new java.lang.Integer(man).hashCode()));
}
}
