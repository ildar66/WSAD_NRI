package com.hps.july.persistence;

public class ImportTaskKey implements java.io.Serializable {
	public int imptaskid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ImportTaskKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argImptaskid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ImportTaskKey(int argImptaskid) {
	imptaskid = argImptaskid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ImportTaskKey) {
		ImportTaskKey otherKey = (ImportTaskKey) o;
		return (((this.imptaskid == otherKey.imptaskid)));
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
	return ((new java.lang.Integer(imptaskid).hashCode()));
}
}
