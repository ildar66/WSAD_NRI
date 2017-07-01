package com.hps.july.persistence2;

public class AntennPlacesKey implements java.io.Serializable {
	public int antplaceid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AntennPlacesKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAntplaceid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AntennPlacesKey(int argAntplaceid) {
	antplaceid = argAntplaceid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof AntennPlacesKey) {
		AntennPlacesKey otherKey = (AntennPlacesKey) o;
		return (((this.antplaceid == otherKey.antplaceid)));
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
	return ((new java.lang.Integer(antplaceid).hashCode()));
}
}
