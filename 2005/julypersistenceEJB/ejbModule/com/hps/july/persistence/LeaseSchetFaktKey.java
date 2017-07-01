package com.hps.july.persistence;

public class LeaseSchetFaktKey implements java.io.Serializable {
	public int idSchetFakt;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseSchetFaktKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdSchetFakt int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseSchetFaktKey(int argIdSchetFakt) {
	idSchetFakt = argIdSchetFakt;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof LeaseSchetFaktKey) {
		LeaseSchetFaktKey otherKey = (LeaseSchetFaktKey) o;
		return (((this.idSchetFakt == otherKey.idSchetFakt)));
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
	return ((new java.lang.Integer(idSchetFakt).hashCode()));
}
}
