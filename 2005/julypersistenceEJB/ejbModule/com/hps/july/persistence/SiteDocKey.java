package com.hps.july.persistence;

public class SiteDocKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int sitedoc;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SiteDocKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argSitedoc int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SiteDocKey(int argSitedoc) {
	sitedoc = argSitedoc;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof SiteDocKey) {
		SiteDocKey otherKey = (SiteDocKey) o;
		return (((this.sitedoc == otherKey.sitedoc)));
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
	return ((new java.lang.Integer(sitedoc).hashCode()));
}
}
