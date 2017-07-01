package com.hps.july.persistence;

public class AbonentPaymentKey implements java.io.Serializable {
	public int paypos;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AbonentPaymentKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argPaypos int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AbonentPaymentKey(int argPaypos) {
	paypos = argPaypos;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof AbonentPaymentKey) {
		AbonentPaymentKey otherKey = (AbonentPaymentKey) o;
		return (((this.paypos == otherKey.paypos)));
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
	return ((new java.lang.Integer(paypos).hashCode()));
}
}
