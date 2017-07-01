package com.hps.july.persistence2;

public class Sitedoc2ResourceKey implements java.io.Serializable {
	public int resource;
	private final static long serialVersionUID = 3206093459760846163L;
	public int sitedoc;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Sitedoc2ResourceKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argResource int
 * @param argSitedoc int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Sitedoc2ResourceKey(int argResource, int argSitedoc) {
	resource = argResource;
	sitedoc = argSitedoc;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof Sitedoc2ResourceKey) {
		Sitedoc2ResourceKey otherKey = (Sitedoc2ResourceKey) o;
		return (((this.resource == otherKey.resource)
		 && (this.sitedoc == otherKey.sitedoc)));
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
	return ((new java.lang.Integer(resource).hashCode())
		 + (new java.lang.Integer(sitedoc).hashCode()));
}
}
