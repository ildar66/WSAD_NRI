package com.hps.july.persistence;

public class UserReportKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int userrepid;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public UserReportKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argUserrepid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public UserReportKey(int argUserrepid) {
	userrepid = argUserrepid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof UserReportKey) {
		UserReportKey otherKey = (UserReportKey) o;
		return (((this.userrepid == otherKey.userrepid)));
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
	return ((new java.lang.Integer(userrepid).hashCode()));
}
}
