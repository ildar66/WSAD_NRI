package com.hps.july.persistence;

public class ProtoActionKey implements java.io.Serializable {
	public int projectaction;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProtoActionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argProjectaction int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProtoActionKey(int argProjectaction) {
	projectaction = argProjectaction;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ProtoActionKey) {
		ProtoActionKey otherKey = (ProtoActionKey) o;
		return (((this.projectaction == otherKey.projectaction)));
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
	return ((new java.lang.Integer(projectaction).hashCode()));
}
}
