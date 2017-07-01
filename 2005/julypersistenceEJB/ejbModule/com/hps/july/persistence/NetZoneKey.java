package com.hps.july.persistence;

public class NetZoneKey implements java.io.Serializable {
	public int netzone;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public NetZoneKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argNetzone int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public NetZoneKey(int argNetzone) {
	netzone = argNetzone;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof NetZoneKey) {
		NetZoneKey otherKey = (NetZoneKey) o;
		return (((this.netzone == otherKey.netzone)));
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
	return ((new java.lang.Integer(netzone).hashCode()));
}
}
