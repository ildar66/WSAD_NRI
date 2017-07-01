package com.hps.july.persistence;

public class SwitchParamsKey implements java.io.Serializable {
	public int paramid;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SwitchParamsKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argParamid int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public SwitchParamsKey(int argParamid) {
	paramid = argParamid;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof SwitchParamsKey) {
		SwitchParamsKey otherKey = (SwitchParamsKey) o;
		return (((this.paramid == otherKey.paramid)));
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
	return ((new java.lang.Integer(paramid).hashCode()));
}
}
