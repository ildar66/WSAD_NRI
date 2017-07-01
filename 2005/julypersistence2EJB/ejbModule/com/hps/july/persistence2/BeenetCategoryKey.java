package com.hps.july.persistence2;

public class BeenetCategoryKey implements java.io.Serializable {
	public int categid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public BeenetCategoryKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argCategid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public BeenetCategoryKey(int argCategid) {
	categid = argCategid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof BeenetCategoryKey) {
		BeenetCategoryKey otherKey = (BeenetCategoryKey) o;
		return (((this.categid == otherKey.categid)));
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
	return ((new java.lang.Integer(categid).hashCode()));
}
}
