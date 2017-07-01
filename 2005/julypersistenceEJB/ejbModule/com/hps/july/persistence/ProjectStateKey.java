package com.hps.july.persistence;

public class ProjectStateKey implements java.io.Serializable {
	public int projectstate;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectStateKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argProjectstate int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectStateKey(int argProjectstate) {
	projectstate = argProjectstate;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ProjectStateKey) {
		ProjectStateKey otherKey = (ProjectStateKey) o;
		return (((this.projectstate == otherKey.projectstate)));
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
	return ((new java.lang.Integer(projectstate).hashCode()));
}
}
