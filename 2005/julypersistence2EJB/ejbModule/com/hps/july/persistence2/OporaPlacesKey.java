package com.hps.july.persistence2;

public class OporaPlacesKey implements java.io.Serializable {
	public int oplaceid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OporaPlacesKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argOplaceid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OporaPlacesKey(int argOplaceid) {
	oplaceid = argOplaceid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof OporaPlacesKey) {
		OporaPlacesKey otherKey = (OporaPlacesKey) o;
		return (((this.oplaceid == otherKey.oplaceid)));
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
	return ((new java.lang.Integer(oplaceid).hashCode()));
}
}
