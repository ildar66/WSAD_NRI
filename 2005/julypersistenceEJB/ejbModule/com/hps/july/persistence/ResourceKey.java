package com.hps.july.persistence;

public class ResourceKey implements java.io.Serializable {
	public int resource;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argResource int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceKey(int argResource) {
	resource = argResource;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ResourceKey) {
		ResourceKey otherKey = (ResourceKey) o;
		return (((this.resource == otherKey.resource)));
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
	return ((new java.lang.Integer(resource).hashCode()));
}
}
