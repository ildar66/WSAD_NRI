package com.hps.july.persistence;

public class LeasePosSchetFaktKey implements java.io.Serializable {
	public int idPosSchetFakt;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeasePosSchetFaktKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdPosSchetFakt int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeasePosSchetFaktKey(int argIdPosSchetFakt) {
	idPosSchetFakt = argIdPosSchetFakt;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof LeasePosSchetFaktKey) {
		LeasePosSchetFaktKey otherKey = (LeasePosSchetFaktKey) o;
		return (((this.idPosSchetFakt == otherKey.idPosSchetFakt)));
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
	return ((new java.lang.Integer(idPosSchetFakt).hashCode()));
}
}
