package com.hps.july.persistence;

public class SectorKey implements java.io.Serializable {
	public int idsect;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SectorKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdsect int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SectorKey(int argIdsect) {
	idsect = argIdsect;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof SectorKey) {
		SectorKey otherKey = (SectorKey) o;
		return (((this.idsect == otherKey.idsect)));
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
	return ((new java.lang.Integer(idsect).hashCode()));
}
}
