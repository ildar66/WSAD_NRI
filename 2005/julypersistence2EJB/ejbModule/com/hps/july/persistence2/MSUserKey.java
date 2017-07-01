package com.hps.july.persistence2;

public class MSUserKey implements java.io.Serializable {
	public int msucode;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public MSUserKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argMsucode int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public MSUserKey(int argMsucode) {
	msucode = argMsucode;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof MSUserKey) {
		MSUserKey otherKey = (MSUserKey) o;
		return (((this.msucode == otherKey.msucode)));
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
	return ((new java.lang.Integer(msucode).hashCode()));
}
}
