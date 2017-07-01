package com.hps.july.persistence;

public class SupplyTypeKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int supplyType;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SupplyTypeKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argSupplyType int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SupplyTypeKey(int argSupplyType) {
	supplyType = argSupplyType;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof SupplyTypeKey) {
		SupplyTypeKey otherKey = (SupplyTypeKey) o;
		return (((this.supplyType == otherKey.supplyType)));
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
	return ((new java.lang.Integer(supplyType).hashCode()));
}
}
