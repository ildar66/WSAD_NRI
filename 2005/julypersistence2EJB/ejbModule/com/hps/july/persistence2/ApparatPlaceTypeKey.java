package com.hps.july.persistence2;

public class ApparatPlaceTypeKey implements java.io.Serializable {
	public int applacetypeid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ApparatPlaceTypeKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argApplacetypeid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ApparatPlaceTypeKey(int argApplacetypeid) {
	applacetypeid = argApplacetypeid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ApparatPlaceTypeKey) {
		ApparatPlaceTypeKey otherKey = (ApparatPlaceTypeKey) o;
		return (((this.applacetypeid == otherKey.applacetypeid)));
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
	return ((new java.lang.Integer(applacetypeid).hashCode()));
}
}
