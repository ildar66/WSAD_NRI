package com.hps.july.persistence;

public class ResourceSetKey implements java.io.Serializable {
	public int resourceset;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceSetKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argResourceset int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceSetKey(int argResourceset) {
	resourceset = argResourceset;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ResourceSetKey) {
		ResourceSetKey otherKey = (ResourceSetKey) o;
		return (((this.resourceset == otherKey.resourceset)));
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
	return ((new java.lang.Integer(resourceset).hashCode()));
}
}
