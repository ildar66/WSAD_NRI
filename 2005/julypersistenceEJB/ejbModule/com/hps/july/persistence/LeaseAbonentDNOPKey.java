package com.hps.july.persistence;

public class LeaseAbonentDNOPKey implements java.io.Serializable {
	public int idabonentdnop;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseAbonentDNOPKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdabonentdnop int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseAbonentDNOPKey(int argIdabonentdnop) {
	idabonentdnop = argIdabonentdnop;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof LeaseAbonentDNOPKey) {
		LeaseAbonentDNOPKey otherKey = (LeaseAbonentDNOPKey) o;
		return (((this.idabonentdnop == otherKey.idabonentdnop)));
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
	return ((new java.lang.Integer(idabonentdnop).hashCode()));
}
}
