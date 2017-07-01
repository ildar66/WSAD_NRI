package com.hps.july.persistence;

public class LeaseDocumentKey implements java.io.Serializable {
	public int leaseDocument;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseDocumentKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeaseDocument int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseDocumentKey(int argLeaseDocument) {
	leaseDocument = argLeaseDocument;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseDocumentKey) {
		LeaseDocumentKey otherKey = (LeaseDocumentKey) o;
		return (((this.leaseDocument == otherKey.leaseDocument)));
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
	return ((new java.lang.Integer(leaseDocument).hashCode()));
}
}
