package com.hps.july.persistence2;

public class Perm2HopKey implements java.io.Serializable {
	public int freqpermid;
	public int hopsid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Perm2HopKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argFreqpermid int
 * @param argHopsid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Perm2HopKey(int argFreqpermid, int argHopsid) {
	freqpermid = argFreqpermid;
	hopsid = argHopsid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof Perm2HopKey) {
		Perm2HopKey otherKey = (Perm2HopKey) o;
		return (((this.freqpermid == otherKey.freqpermid)
		 && (this.hopsid == otherKey.hopsid)));
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
	return ((new java.lang.Integer(freqpermid).hashCode())
		 + (new java.lang.Integer(hopsid).hashCode()));
}
}
