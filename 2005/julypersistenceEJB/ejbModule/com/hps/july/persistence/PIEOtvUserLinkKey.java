package com.hps.july.persistence;

public class PIEOtvUserLinkKey implements java.io.Serializable {
	public int otvusernri;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEOtvUserLinkKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argOtvusernri int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEOtvUserLinkKey(int argOtvusernri) {
	otvusernri = argOtvusernri;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEOtvUserLinkKey) {
		PIEOtvUserLinkKey otherKey = (PIEOtvUserLinkKey) o;
		return (((this.otvusernri == otherKey.otvusernri)));
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
	return ((new java.lang.Integer(otvusernri).hashCode()));
}
}
