package com.hps.july.persistence;

public class RoleKey implements java.io.Serializable {
	public java.lang.String role;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RoleKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argRole java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public RoleKey(java.lang.String argRole) {
	role = argRole;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof RoleKey) {
		RoleKey otherKey = (RoleKey) o;
		return ((this.role.equals(otherKey.role)));
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
	return (role.hashCode());
}
}
