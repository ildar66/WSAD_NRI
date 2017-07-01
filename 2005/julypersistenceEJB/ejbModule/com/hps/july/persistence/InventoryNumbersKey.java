package com.hps.july.persistence;

public class InventoryNumbersKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int serid;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public InventoryNumbersKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argSerid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public InventoryNumbersKey(int argSerid) {
	serid = argSerid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof InventoryNumbersKey) {
		InventoryNumbersKey otherKey = (InventoryNumbersKey) o;
		return (((this.serid == otherKey.serid)));
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
	return ((new java.lang.Integer(serid).hashCode()));
}
}
