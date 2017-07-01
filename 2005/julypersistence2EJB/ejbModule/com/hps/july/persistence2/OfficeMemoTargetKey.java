package com.hps.july.persistence2;

public class OfficeMemoTargetKey implements java.io.Serializable {
	public int idtarget;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OfficeMemoTargetKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdtarget int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OfficeMemoTargetKey(int argIdtarget) {
	idtarget = argIdtarget;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof OfficeMemoTargetKey) {
		OfficeMemoTargetKey otherKey = (OfficeMemoTargetKey) o;
		return (((this.idtarget == otherKey.idtarget)));
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
	return ((new java.lang.Integer(idtarget).hashCode()));
}
}
