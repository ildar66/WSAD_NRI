package com.hps.july.trailcom.beans;

public class HopLabelKey implements java.io.Serializable {
	public int hopslabelid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public HopLabelKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argHopslabelid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public HopLabelKey(int argHopslabelid) {
	hopslabelid = argHopslabelid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof HopLabelKey) {
		HopLabelKey otherKey = (HopLabelKey) o;
		return (((this.hopslabelid == otherKey.hopslabelid)));
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
	return ((new java.lang.Integer(hopslabelid).hashCode()));
}
}
