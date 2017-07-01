package com.hps.july.persistence2;

public class LeaseZPKey implements java.io.Serializable {
	public int idzpnfs;
	public int leasedocposition;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseZPKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdzpnfs int
 * @param argLeasedocposition int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseZPKey(int argIdzpnfs, int argLeasedocposition) {
	idzpnfs = argIdzpnfs;
	leasedocposition = argLeasedocposition;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof LeaseZPKey) {
		LeaseZPKey otherKey = (LeaseZPKey) o;
		return (((this.idzpnfs == otherKey.idzpnfs)
		 && (this.leasedocposition == otherKey.leasedocposition)));
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
	return ((new java.lang.Integer(idzpnfs).hashCode())
		 + (new java.lang.Integer(leasedocposition).hashCode()));
}
}
