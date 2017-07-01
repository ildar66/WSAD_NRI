package com.hps.july.persistence2;

public class AntennaCableKey implements java.io.Serializable {
	public int idcable;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AntennaCableKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdcable int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AntennaCableKey(int argIdcable) {
	idcable = argIdcable;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof AntennaCableKey) {
		AntennaCableKey otherKey = (AntennaCableKey) o;
		return (((this.idcable == otherKey.idcable)));
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
	return ((new java.lang.Integer(idcable).hashCode()));
}
}
