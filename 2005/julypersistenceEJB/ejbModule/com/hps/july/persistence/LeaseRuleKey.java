package com.hps.july.persistence;

public class LeaseRuleKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int leaseRule;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseRuleKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeaseRule int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseRuleKey(int argLeaseRule) {
	leaseRule = argLeaseRule;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseRuleKey) {
		LeaseRuleKey otherKey = (LeaseRuleKey) o;
		return (((this.leaseRule == otherKey.leaseRule)));
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
	return ((new java.lang.Integer(leaseRule).hashCode()));
}
}
