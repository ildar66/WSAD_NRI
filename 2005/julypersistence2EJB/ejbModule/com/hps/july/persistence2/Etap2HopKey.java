package com.hps.july.persistence2;

public class Etap2HopKey implements java.io.Serializable {
	public int hopsid;
	private final static long serialVersionUID = 3206093459760846163L;
	public int sitedoc;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Etap2HopKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argHopsid int
 * @param argSitedoc int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Etap2HopKey(int argHopsid, int argSitedoc) {
	hopsid = argHopsid;
	sitedoc = argSitedoc;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof Etap2HopKey) {
		Etap2HopKey otherKey = (Etap2HopKey) o;
		return (((this.hopsid == otherKey.hopsid)
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
	return ((new java.lang.Integer(hopsid).hashCode())
		 + (new java.lang.Integer(sitedoc).hashCode()));
}
}
