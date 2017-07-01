package com.hps.july.persistence;

public class RateTypeKey implements java.io.Serializable {
	public int ratetype;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RateTypeKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argRatetype int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RateTypeKey(int argRatetype) {
	ratetype = argRatetype;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof RateTypeKey) {
		RateTypeKey otherKey = (RateTypeKey) o;
		return (((this.ratetype == otherKey.ratetype)));
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
	return ((new java.lang.Integer(ratetype).hashCode()));
}
}
