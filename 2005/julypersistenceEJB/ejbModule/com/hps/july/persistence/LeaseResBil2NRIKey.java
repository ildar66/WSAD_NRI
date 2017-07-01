package com.hps.july.persistence;

public class LeaseResBil2NRIKey implements java.io.Serializable {
	public int idrecord;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseResBil2NRIKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdrecord int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseResBil2NRIKey(int argIdrecord) {
	idrecord = argIdrecord;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof LeaseResBil2NRIKey) {
		LeaseResBil2NRIKey otherKey = (LeaseResBil2NRIKey) o;
		return (((this.idrecord == otherKey.idrecord)));
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
	return ((new java.lang.Integer(idrecord).hashCode()));
}
}
