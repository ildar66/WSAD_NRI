package com.hps.july.persistence;

public class DivisionKey implements java.io.Serializable {
	public int division;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DivisionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argDivision int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DivisionKey(int argDivision) {
	division = argDivision;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof DivisionKey) {
		DivisionKey otherKey = (DivisionKey) o;
		return (((this.division == otherKey.division)));
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
	return ((new java.lang.Integer(division).hashCode()));
}
}
