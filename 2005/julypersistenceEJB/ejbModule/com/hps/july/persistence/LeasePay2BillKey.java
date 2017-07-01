package com.hps.july.persistence;

public class LeasePay2BillKey implements java.io.Serializable {
	public int leasemutualact;
	private final static long serialVersionUID = 3206093459760846163L;
	public int leasecontract;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeasePay2BillKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argLeasemutualact int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeasePay2BillKey(int argLeasemutualact) {
	leasemutualact = argLeasemutualact;
}
/**
 * Initialize a key from the passed values
 * @param argLeasemutualact int
 * @param argLeasecontract int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeasePay2BillKey(int argLeasemutualact, int argLeasecontract) {
	leasemutualact = argLeasemutualact;
	leasecontract = argLeasecontract;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeasePay2BillKey) {
		LeasePay2BillKey otherKey = (LeasePay2BillKey) o;
		return (((this.leasemutualact == otherKey.leasemutualact)
		 && (this.leasecontract == otherKey.leasecontract)));
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
	return ((new java.lang.Integer(leasemutualact).hashCode())
		 + (new java.lang.Integer(leasecontract).hashCode()));
}
}
