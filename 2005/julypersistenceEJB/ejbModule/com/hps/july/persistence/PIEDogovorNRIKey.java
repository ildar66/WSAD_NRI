package com.hps.july.persistence;

public class PIEDogovorNRIKey implements java.io.Serializable {
	public int idrecdogovor;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDogovorNRIKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdrecdogovor int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDogovorNRIKey(int argIdrecdogovor) {
	idrecdogovor = argIdrecdogovor;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEDogovorNRIKey) {
		PIEDogovorNRIKey otherKey = (PIEDogovorNRIKey) o;
		return (((this.idrecdogovor == otherKey.idrecdogovor)));
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
	return ((new java.lang.Integer(idrecdogovor).hashCode()));
}
}
