package com.hps.july.persistence;

public class BaseAgreementKey implements java.io.Serializable {
	public int baseagreement;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public BaseAgreementKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argBaseagreement int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public BaseAgreementKey(int argBaseagreement) {
	baseagreement = argBaseagreement;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof BaseAgreementKey) {
		BaseAgreementKey otherKey = (BaseAgreementKey) o;
		return (((this.baseagreement == otherKey.baseagreement)));
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
	return ((new java.lang.Integer(baseagreement).hashCode()));
}
}
