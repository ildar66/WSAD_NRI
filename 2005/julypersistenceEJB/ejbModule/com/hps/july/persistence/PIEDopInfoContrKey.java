package com.hps.july.persistence;

public class PIEDopInfoContrKey implements java.io.Serializable {
	public int leasedocument;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDopInfoContrKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeasedocument int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDopInfoContrKey(int argLeasedocument) {
	leasedocument = argLeasedocument;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEDopInfoContrKey) {
		PIEDopInfoContrKey otherKey = (PIEDopInfoContrKey) o;
		return (((this.leasedocument == otherKey.leasedocument)));
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
	return ((new java.lang.Integer(leasedocument).hashCode()));
}
}
