package com.hps.july.persistence2;

public class Sitedoc2RegionKey implements java.io.Serializable {
	public int region;
	private final static long serialVersionUID = 3206093459760846163L;
	public int sitedoc;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Sitedoc2RegionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argRegion int
 * @param argSitedoc int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Sitedoc2RegionKey(int argRegion, int argSitedoc) {
	region = argRegion;
	sitedoc = argSitedoc;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof Sitedoc2RegionKey) {
		Sitedoc2RegionKey otherKey = (Sitedoc2RegionKey) o;
		return (((this.region == otherKey.region)
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
	return ((new java.lang.Integer(region).hashCode())
		 + (new java.lang.Integer(sitedoc).hashCode()));
}
}
