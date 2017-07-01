package com.hps.july.persistence;

public class UserRepGroupKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int usrgrpid;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public UserRepGroupKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argUsrgrpid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public UserRepGroupKey(int argUsrgrpid) {
	usrgrpid = argUsrgrpid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof UserRepGroupKey) {
		UserRepGroupKey otherKey = (UserRepGroupKey) o;
		return (((this.usrgrpid == otherKey.usrgrpid)));
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
	return ((new java.lang.Integer(usrgrpid).hashCode()));
}
}
