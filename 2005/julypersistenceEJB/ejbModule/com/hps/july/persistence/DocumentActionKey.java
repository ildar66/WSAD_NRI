package com.hps.july.persistence;

public class DocumentActionKey implements java.io.Serializable {
	public int docAction;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DocumentActionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argDocAction int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DocumentActionKey(int argDocAction) {
	docAction = argDocAction;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof DocumentActionKey) {
		DocumentActionKey otherKey = (DocumentActionKey) o;
		return (((this.docAction == otherKey.docAction)));
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
	return ((new java.lang.Integer(docAction).hashCode()));
}
}
