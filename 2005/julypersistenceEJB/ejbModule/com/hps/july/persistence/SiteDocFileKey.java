package com.hps.july.persistence;

public class SiteDocFileKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int sitedocfile;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SiteDocFileKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argSitedocfile int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SiteDocFileKey(int argSitedocfile) {
	sitedocfile = argSitedocfile;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof SiteDocFileKey) {
		SiteDocFileKey otherKey = (SiteDocFileKey) o;
		return (((this.sitedocfile == otherKey.sitedocfile)));
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
	return ((new java.lang.Integer(sitedocfile).hashCode()));
}
}
