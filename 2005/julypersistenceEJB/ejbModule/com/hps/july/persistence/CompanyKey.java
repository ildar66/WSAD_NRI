package com.hps.july.persistence;

public class CompanyKey implements java.io.Serializable {
	public int company;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CompanyKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argCompany int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CompanyKey(int argCompany) {
	company = argCompany;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof CompanyKey) {
		CompanyKey otherKey = (CompanyKey) o;
		return (((this.company == otherKey.company)));
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
	return ((new java.lang.Integer(company).hashCode()));
}
}
