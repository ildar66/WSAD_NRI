package com.hps.july.persistence;

public class ImportSessionKey implements java.io.Serializable {
	public int impsesid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ImportSessionKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argImpsesid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ImportSessionKey(int argImpsesid) {
	impsesid = argImpsesid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ImportSessionKey) {
		ImportSessionKey otherKey = (ImportSessionKey) o;
		return (((this.impsesid == otherKey.impsesid)));
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
	return ((new java.lang.Integer(impsesid).hashCode()));
}
}
