package com.hps.july.persistence;

public class PIEBudjetKey implements java.io.Serializable {
	public int idbudjetnri;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEBudjetKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdbudjetnri int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEBudjetKey(int argIdbudjetnri) {
	idbudjetnri = argIdbudjetnri;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEBudjetKey) {
		PIEBudjetKey otherKey = (PIEBudjetKey) o;
		return (((this.idbudjetnri == otherKey.idbudjetnri)));
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
	return ((new java.lang.Integer(idbudjetnri).hashCode()));
}
}
