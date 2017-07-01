package com.hps.july.persistence;

public class PIEExpenceKey implements java.io.Serializable {
	public int idexpencenri;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEExpenceKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdexpencenri int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEExpenceKey(int argIdexpencenri) {
	idexpencenri = argIdexpencenri;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEExpenceKey) {
		PIEExpenceKey otherKey = (PIEExpenceKey) o;
		return (((this.idexpencenri == otherKey.idexpencenri)));
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
	return ((new java.lang.Integer(idexpencenri).hashCode()));
}
}
