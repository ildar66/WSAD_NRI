package com.hps.july.persistence;

public class ProjectActionDocumentKey implements java.io.Serializable {
	public int projectactiondocument;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectActionDocumentKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argProjectactiondocument int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectActionDocumentKey(int argProjectactiondocument) {
	projectactiondocument = argProjectactiondocument;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ProjectActionDocumentKey) {
		ProjectActionDocumentKey otherKey = (ProjectActionDocumentKey) o;
		return (((this.projectactiondocument == otherKey.projectactiondocument)));
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
	return ((new java.lang.Integer(projectactiondocument).hashCode()));
}
}
