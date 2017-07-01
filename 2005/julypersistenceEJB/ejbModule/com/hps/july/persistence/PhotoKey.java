package com.hps.july.persistence;

public class PhotoKey implements java.io.Serializable {
	public int photo;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PhotoKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argPhoto int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PhotoKey(int argPhoto) {
	photo = argPhoto;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PhotoKey) {
		PhotoKey otherKey = (PhotoKey) o;
		return (((this.photo == otherKey.photo)));
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
	return ((new java.lang.Integer(photo).hashCode()));
}
}
