package com.hps.july.persistence;

public class ChangeLogDetailsKey implements java.io.Serializable {
	public int logdetid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ChangeLogDetailsKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLogdetid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ChangeLogDetailsKey(int argLogdetid) {
	logdetid = argLogdetid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ChangeLogDetailsKey) {
		ChangeLogDetailsKey otherKey = (ChangeLogDetailsKey) o;
		return (((this.logdetid == otherKey.logdetid)));
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
	return ((new java.lang.Integer(logdetid).hashCode()));
}
}
