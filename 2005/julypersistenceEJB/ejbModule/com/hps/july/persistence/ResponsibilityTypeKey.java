package com.hps.july.persistence;

public class ResponsibilityTypeKey implements java.io.Serializable {
	public int responsibilityType;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResponsibilityTypeKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argResponsibilityType int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResponsibilityTypeKey(int argResponsibilityType) {
	responsibilityType = argResponsibilityType;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ResponsibilityTypeKey) {
		ResponsibilityTypeKey otherKey = (ResponsibilityTypeKey) o;
		return (((this.responsibilityType == otherKey.responsibilityType)));
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
	return ((new java.lang.Integer(responsibilityType).hashCode()));
}
}
