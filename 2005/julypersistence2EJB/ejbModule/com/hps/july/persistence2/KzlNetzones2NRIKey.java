package com.hps.july.persistence2;

public class KzlNetzones2NRIKey implements java.io.Serializable {
	public int kzlregionid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public KzlNetzones2NRIKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argKzlregionid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public KzlNetzones2NRIKey(int argKzlregionid) {
	kzlregionid = argKzlregionid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof KzlNetzones2NRIKey) {
		KzlNetzones2NRIKey otherKey = (KzlNetzones2NRIKey) o;
		return (((this.kzlregionid == otherKey.kzlregionid)));
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
	return ((new java.lang.Integer(kzlregionid).hashCode()));
}
}
