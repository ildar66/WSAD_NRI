package com.hps.july.persistence2;

public class KzlAntennes2NRIKey implements java.io.Serializable {
	public int antposantennid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public KzlAntennes2NRIKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAntposantennid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public KzlAntennes2NRIKey(int argAntposantennid) {
	antposantennid = argAntposantennid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof KzlAntennes2NRIKey) {
		KzlAntennes2NRIKey otherKey = (KzlAntennes2NRIKey) o;
		return (((this.antposantennid == otherKey.antposantennid)));
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
	return ((new java.lang.Integer(antposantennid).hashCode()));
}
}
