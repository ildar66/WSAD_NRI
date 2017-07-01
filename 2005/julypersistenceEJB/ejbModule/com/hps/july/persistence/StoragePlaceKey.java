package com.hps.july.persistence;

public class StoragePlaceKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int storageplace;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public StoragePlaceKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argStorageplace int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public StoragePlaceKey(int argStorageplace) {
	storageplace = argStorageplace;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof StoragePlaceKey) {
		StoragePlaceKey otherKey = (StoragePlaceKey) o;
		return (((this.storageplace == otherKey.storageplace)));
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
	return ((new java.lang.Integer(storageplace).hashCode()));
}
}
