package com.hps.july.persistence2;

public class OfficeMemoHeaderKey implements java.io.Serializable {
	public int idheader;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OfficeMemoHeaderKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdheader int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OfficeMemoHeaderKey(int argIdheader) {
	idheader = argIdheader;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof OfficeMemoHeaderKey) {
		OfficeMemoHeaderKey otherKey = (OfficeMemoHeaderKey) o;
		return (((this.idheader == otherKey.idheader)));
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
	return ((new java.lang.Integer(idheader).hashCode()));
}
}
