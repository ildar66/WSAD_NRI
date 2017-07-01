package com.hps.july.persistence;

public class ImportRecordKey implements java.io.Serializable {
	public int imprecid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ImportRecordKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argImprecid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ImportRecordKey(int argImprecid) {
	imprecid = argImprecid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof ImportRecordKey) {
		ImportRecordKey otherKey = (ImportRecordKey) o;
		return (((this.imprecid == otherKey.imprecid)));
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
	return ((new java.lang.Integer(imprecid).hashCode()));
}
}
