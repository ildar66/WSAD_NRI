package com.hps.july.persistence2;

public class BeenetObjectKey implements java.io.Serializable {
	public java.lang.String beenetid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public BeenetObjectKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argBeenetid java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public BeenetObjectKey(java.lang.String argBeenetid) {
	beenetid = argBeenetid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof BeenetObjectKey) {
		BeenetObjectKey otherKey = (BeenetObjectKey) o;
		return ((this.beenetid.equals(otherKey.beenetid)));
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
	return (beenetid.hashCode());
}
}
