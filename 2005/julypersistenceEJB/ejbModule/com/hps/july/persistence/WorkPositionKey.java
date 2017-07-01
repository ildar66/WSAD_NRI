package com.hps.july.persistence;

public class WorkPositionKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int workposition;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public WorkPositionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argWorkposition int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public WorkPositionKey(int argWorkposition) {
	workposition = argWorkposition;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof WorkPositionKey) {
		WorkPositionKey otherKey = (WorkPositionKey) o;
		return (((this.workposition == otherKey.workposition)));
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
	return ((new java.lang.Integer(workposition).hashCode()));
}
}
