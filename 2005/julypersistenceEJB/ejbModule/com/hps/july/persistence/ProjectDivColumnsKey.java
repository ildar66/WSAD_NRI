package com.hps.july.persistence;

public class ProjectDivColumnsKey implements java.io.Serializable {
	public int divcolid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectDivColumnsKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argDivcolid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectDivColumnsKey(int argDivcolid) {
	divcolid = argDivcolid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ProjectDivColumnsKey) {
		ProjectDivColumnsKey otherKey = (ProjectDivColumnsKey) o;
		return (((this.divcolid == otherKey.divcolid)));
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
	return ((new java.lang.Integer(divcolid).hashCode()));
}
}
