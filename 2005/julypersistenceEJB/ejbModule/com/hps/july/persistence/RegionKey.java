package com.hps.july.persistence;

public class RegionKey implements java.io.Serializable {
	public int regionid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RegionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argRegionid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RegionKey(int argRegionid) {
	regionid = argRegionid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof RegionKey) {
		RegionKey otherKey = (RegionKey) o;
		return (((this.regionid == otherKey.regionid)));
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
	return ((new java.lang.Integer(regionid).hashCode()));
}
}
