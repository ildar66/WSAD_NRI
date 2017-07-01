package com.hps.july.persistence;

public class PIEValutesKey implements java.io.Serializable {
	public java.lang.String idvaluteplatinum;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEValutesKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdvaluteplatinum java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEValutesKey(java.lang.String argIdvaluteplatinum) {
	idvaluteplatinum = argIdvaluteplatinum;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEValutesKey) {
		PIEValutesKey otherKey = (PIEValutesKey) o;
		return ((this.idvaluteplatinum.equals(otherKey.idvaluteplatinum)));
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
	return (idvaluteplatinum.hashCode());
}
}
