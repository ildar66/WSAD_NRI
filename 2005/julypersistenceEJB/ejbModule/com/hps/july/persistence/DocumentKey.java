package com.hps.july.persistence;

public class DocumentKey implements java.io.Serializable {
	public int document;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DocumentKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argDocument int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DocumentKey(int argDocument) {
	document = argDocument;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof DocumentKey) {
		DocumentKey otherKey = (DocumentKey) o;
		return (((this.document == otherKey.document)));
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
	return ((new java.lang.Integer(document).hashCode()));
}
}
