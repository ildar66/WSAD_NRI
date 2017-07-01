package com.hps.july.persistence2;

public class FreqPermissionKey implements java.io.Serializable {
	public int freqpermid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public FreqPermissionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argFreqpermid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public FreqPermissionKey(int argFreqpermid) {
	freqpermid = argFreqpermid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof FreqPermissionKey) {
		FreqPermissionKey otherKey = (FreqPermissionKey) o;
		return (((this.freqpermid == otherKey.freqpermid)));
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
	return ((new java.lang.Integer(freqpermid).hashCode()));
}
}
