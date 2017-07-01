package com.hps.july.persistence;

public class NamedValueKey implements java.io.Serializable {
	public java.lang.String id;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public NamedValueKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argId java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public NamedValueKey(java.lang.String argId) {
	id = argId;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof NamedValueKey) {
		NamedValueKey otherKey = (NamedValueKey) o;
		return ((this.id.equals(otherKey.id)));
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
	return (id.hashCode());
}
}
