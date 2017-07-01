package com.hps.july.persistence;

public class OrganizationKey implements java.io.Serializable {
	public int organization;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OrganizationKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argOrganization int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OrganizationKey(int argOrganization) {
	organization = argOrganization;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(Object o) {
	if (o instanceof OrganizationKey) {
		OrganizationKey otherKey = (OrganizationKey) o;
		return (((this.organization == otherKey.organization)));
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
	return ((new java.lang.Integer(organization).hashCode()));
}
}
