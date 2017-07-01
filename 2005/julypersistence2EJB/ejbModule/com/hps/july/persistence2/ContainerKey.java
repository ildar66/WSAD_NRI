package com.hps.july.persistence2;

public class ContainerKey implements java.io.Serializable {
	public int container;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ContainerKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argContainer int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ContainerKey(int argContainer) {
	container = argContainer;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ContainerKey) {
		ContainerKey otherKey = (ContainerKey) o;
		return (((this.container == otherKey.container)));
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
	return ((new java.lang.Integer(container).hashCode()));
}
}
