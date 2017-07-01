package com.hps.july.persistence;

public class PIEDocInfoDocPosKey implements java.io.Serializable {
	public int docposition;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDocInfoDocPosKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argDocposition int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDocInfoDocPosKey(int argDocposition) {
	docposition = argDocposition;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEDocInfoDocPosKey) {
		PIEDocInfoDocPosKey otherKey = (PIEDocInfoDocPosKey) o;
		return (((this.docposition == otherKey.docposition)));
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
	return ((new java.lang.Integer(docposition).hashCode()));
}
}
