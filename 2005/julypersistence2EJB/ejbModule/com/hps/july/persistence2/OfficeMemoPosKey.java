package com.hps.july.persistence2;

public class OfficeMemoPosKey implements java.io.Serializable {
	public int idpos;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OfficeMemoPosKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdpos int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OfficeMemoPosKey(int argIdpos) {
	idpos = argIdpos;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof OfficeMemoPosKey) {
		OfficeMemoPosKey otherKey = (OfficeMemoPosKey) o;
		return (((this.idpos == otherKey.idpos)));
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
	return ((new java.lang.Integer(idpos).hashCode()));
}
}
