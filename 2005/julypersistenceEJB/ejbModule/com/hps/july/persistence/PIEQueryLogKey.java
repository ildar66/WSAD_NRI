package com.hps.july.persistence;

public class PIEQueryLogKey implements java.io.Serializable {
	public int idnriquerylog;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEQueryLogKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argIdnriquerylog int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEQueryLogKey(int argIdnriquerylog) {
	idnriquerylog = argIdnriquerylog;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof PIEQueryLogKey) {
		PIEQueryLogKey otherKey = (PIEQueryLogKey) o;
		return (((this.idnriquerylog == otherKey.idnriquerylog)));
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
	return ((new java.lang.Integer(idnriquerylog).hashCode()));
}
}
