package com.hps.july.persistence;

public class AbonentBillKey implements java.io.Serializable {
	public int leasebill;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AbonentBillKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeasebill int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AbonentBillKey(int argLeasebill) {
	leasebill = argLeasebill;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof AbonentBillKey) {
		AbonentBillKey otherKey = (AbonentBillKey) o;
		return (((this.leasebill == otherKey.leasebill)));
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
	return ((new java.lang.Integer(leasebill).hashCode()));
}
}
