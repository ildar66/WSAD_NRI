package com.hps.july.persistence2;

public class ApparatTypeKey implements java.io.Serializable {
	public int aptypeid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ApparatTypeKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAptypeid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ApparatTypeKey(int argAptypeid) {
	aptypeid = argAptypeid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ApparatTypeKey) {
		ApparatTypeKey otherKey = (ApparatTypeKey) o;
		return (((this.aptypeid == otherKey.aptypeid)));
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
	return ((new java.lang.Integer(aptypeid).hashCode()));
}
}
