package com.hps.july.trailcom.beans;

public class AddressSpaceKey implements java.io.Serializable {
	public int portid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AddressSpaceKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argPortid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AddressSpaceKey(int argPortid) {
	portid = argPortid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof AddressSpaceKey) {
		AddressSpaceKey otherKey = (AddressSpaceKey) o;
		return (((this.portid == otherKey.portid)));
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
	return ((new java.lang.Integer(portid).hashCode()));
}
}
