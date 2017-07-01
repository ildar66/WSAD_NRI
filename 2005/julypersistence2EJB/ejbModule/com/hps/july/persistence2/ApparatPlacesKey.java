package com.hps.july.persistence2;

public class ApparatPlacesKey implements java.io.Serializable {
	public int applaceid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ApparatPlacesKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argApplaceid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ApparatPlacesKey(int argApplaceid) {
	applaceid = argApplaceid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ApparatPlacesKey) {
		ApparatPlacesKey otherKey = (ApparatPlacesKey) o;
		return (((this.applaceid == otherKey.applaceid)));
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
	return ((new java.lang.Integer(applaceid).hashCode()));
}
}
