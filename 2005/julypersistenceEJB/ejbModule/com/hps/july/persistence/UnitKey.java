package com.hps.july.persistence;

public class UnitKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int unit;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public UnitKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argUnit int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public UnitKey(int argUnit) {
	unit = argUnit;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof UnitKey) {
		UnitKey otherKey = (UnitKey) o;
		return (((this.unit == otherKey.unit)));
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
	return ((new java.lang.Integer(unit).hashCode()));
}
}
