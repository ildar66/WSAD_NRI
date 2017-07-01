package com.hps.july.persistence;

public class ProjectTypeKey implements java.io.Serializable {
	public int projecttype;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectTypeKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argProjecttype int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectTypeKey(int argProjecttype) {
	projecttype = argProjecttype;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ProjectTypeKey) {
		ProjectTypeKey otherKey = (ProjectTypeKey) o;
		return (((this.projecttype == otherKey.projecttype)));
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
	return ((new java.lang.Integer(projecttype).hashCode()));
}
}
