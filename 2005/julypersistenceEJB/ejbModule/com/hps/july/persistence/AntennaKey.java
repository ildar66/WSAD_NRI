package com.hps.july.persistence;

public class AntennaKey implements java.io.Serializable {
	public int idanten;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AntennaKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdanten int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AntennaKey(int argIdanten) {
	idanten = argIdanten;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof AntennaKey) {
		AntennaKey otherKey = (AntennaKey) o;
		return (((this.idanten == otherKey.idanten)));
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
	return ((new java.lang.Integer(idanten).hashCode()));
}
}
