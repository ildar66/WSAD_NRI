package com.hps.july.trailcom.beans;

public class AddressInfo2Key implements java.io.Serializable {
	public int addressportid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AddressInfo2Key() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAddressportid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AddressInfo2Key(int argAddressportid) {
	addressportid = argAddressportid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof AddressInfo2Key) {
		AddressInfo2Key otherKey = (AddressInfo2Key) o;
		return (((this.addressportid == otherKey.addressportid)));
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
	return ((new java.lang.Integer(addressportid).hashCode()));
}
}
