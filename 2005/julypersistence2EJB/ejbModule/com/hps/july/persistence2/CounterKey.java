package com.hps.july.persistence2;

public class CounterKey implements java.io.Serializable {
	public int counterid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CounterKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argCounterid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CounterKey(int argCounterid) {
	counterid = argCounterid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof CounterKey) {
		CounterKey otherKey = (CounterKey) o;
		return (((this.counterid == otherKey.counterid)));
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
	return ((new java.lang.Integer(counterid).hashCode()));
}
}
