package com.hps.july.persistence;

public class DopInfoLPaymentKey implements java.io.Serializable {
	public int leasedocposition;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DopInfoLPaymentKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeasedocposition int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DopInfoLPaymentKey(int argLeasedocposition) {
	leasedocposition = argLeasedocposition;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof DopInfoLPaymentKey) {
		DopInfoLPaymentKey otherKey = (DopInfoLPaymentKey) o;
		return (((this.leasedocposition == otherKey.leasedocposition)));
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
	return ((new java.lang.Integer(leasedocposition).hashCode()));
}
}
