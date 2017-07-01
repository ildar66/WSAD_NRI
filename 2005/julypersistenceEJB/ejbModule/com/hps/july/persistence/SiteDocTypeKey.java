package com.hps.july.persistence;

public class SiteDocTypeKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int sitedoctype;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SiteDocTypeKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argSitedoctype int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SiteDocTypeKey(int argSitedoctype) {
	sitedoctype = argSitedoctype;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof SiteDocTypeKey) {
		SiteDocTypeKey otherKey = (SiteDocTypeKey) o;
		return (((this.sitedoctype == otherKey.sitedoctype)));
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
	return ((new java.lang.Integer(sitedoctype).hashCode()));
}
}
