package com.hps.july.trailcom.beans;

public class AddressInfoKey implements java.io.Serializable {
	public int resource;
	private final static long serialVersionUID = 3206093459760846163L;
	public short typeport;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AddressInfoKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argResource int
 * @param argTypeport short
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AddressInfoKey(int argResource, short argTypeport) {
	resource = argResource;
	typeport = argTypeport;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof AddressInfoKey) {
		AddressInfoKey otherKey = (AddressInfoKey) o;
		return (((this.resource == otherKey.resource)
		 && (this.typeport == otherKey.typeport)));
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
	return ((new java.lang.Integer(resource).hashCode())
		 + (new Short(typeport).hashCode()));
}
}
