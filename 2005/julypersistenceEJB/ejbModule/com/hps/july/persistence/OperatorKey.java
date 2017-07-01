package com.hps.july.persistence;

public class OperatorKey implements java.io.Serializable {
	public int operator;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OperatorKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argOperator int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OperatorKey(int argOperator) {
	operator = argOperator;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof OperatorKey) {
		OperatorKey otherKey = (OperatorKey) o;
		return (((this.operator == otherKey.operator)));
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
	return ((new java.lang.Integer(operator).hashCode()));
}
}
