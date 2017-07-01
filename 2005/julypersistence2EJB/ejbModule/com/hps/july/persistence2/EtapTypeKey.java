package com.hps.july.persistence2;

public class EtapTypeKey implements java.io.Serializable {
	public int etaptypeid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public EtapTypeKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argEtaptypeid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public EtapTypeKey(int argEtaptypeid) {
	etaptypeid = argEtaptypeid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof EtapTypeKey) {
		EtapTypeKey otherKey = (EtapTypeKey) o;
		return (((this.etaptypeid == otherKey.etaptypeid)));
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
	return ((new java.lang.Integer(etaptypeid).hashCode()));
}
}
