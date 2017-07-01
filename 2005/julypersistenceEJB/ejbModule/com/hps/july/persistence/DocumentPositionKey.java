package com.hps.july.persistence;

public class DocumentPositionKey implements java.io.Serializable {
	public int docposition;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DocumentPositionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argDocposition int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DocumentPositionKey(int argDocposition) {
	docposition = argDocposition;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof DocumentPositionKey) {
		DocumentPositionKey otherKey = (DocumentPositionKey) o;
		return (((this.docposition == otherKey.docposition)));
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
	return ((new java.lang.Integer(docposition).hashCode()));
}
}
