package com.hps.july.persistence;

public class AbonentBillPosKey implements java.io.Serializable {
	public int billpos;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AbonentBillPosKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argBillpos int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AbonentBillPosKey(int argBillpos) {
	billpos = argBillpos;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof AbonentBillPosKey) {
		AbonentBillPosKey otherKey = (AbonentBillPosKey) o;
		return (((this.billpos == otherKey.billpos)));
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
	return ((new java.lang.Integer(billpos).hashCode()));
}
}
