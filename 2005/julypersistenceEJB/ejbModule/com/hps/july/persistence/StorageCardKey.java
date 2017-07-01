package com.hps.july.persistence;

public class StorageCardKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int storagecard;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public StorageCardKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argStoragecard int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public StorageCardKey(int argStoragecard) {
	storagecard = argStoragecard;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof StorageCardKey) {
		StorageCardKey otherKey = (StorageCardKey) o;
		return (((this.storagecard == otherKey.storagecard)));
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
	return ((new java.lang.Integer(storagecard).hashCode()));
}
}
