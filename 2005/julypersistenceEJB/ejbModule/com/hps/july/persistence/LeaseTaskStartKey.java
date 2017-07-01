package com.hps.july.persistence;

public class LeaseTaskStartKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int taskstart;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseTaskStartKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argTaskstart int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseTaskStartKey(int argTaskstart) {
	taskstart = argTaskstart;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof LeaseTaskStartKey) {
		LeaseTaskStartKey otherKey = (LeaseTaskStartKey) o;
		return (((this.taskstart == otherKey.taskstart)));
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
	return ((new java.lang.Integer(taskstart).hashCode()));
}
}
