package com.hps.july.persistence;

public class ContractBLOBKey implements java.io.Serializable {
	public int document;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ContractBLOBKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argDocument int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ContractBLOBKey(int argDocument) {
	document = argDocument;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ContractBLOBKey) {
		ContractBLOBKey otherKey = (ContractBLOBKey) o;
		return (((this.document == otherKey.document)));
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
	return ((new java.lang.Integer(document).hashCode()));
}
}
