package com.hps.july.persistence;

public class ResourceTypeKey implements java.io.Serializable {
	public int resourcetype;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceTypeKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argResourcetype int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceTypeKey(int argResourcetype) {
	resourcetype = argResourcetype;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ResourceTypeKey) {
		ResourceTypeKey otherKey = (ResourceTypeKey) o;
		return (((this.resourcetype == otherKey.resourcetype)));
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
	return ((new java.lang.Integer(resourcetype).hashCode()));
}
}
