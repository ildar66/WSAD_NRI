package com.hps.july.persistence;
/**
 * Key class for Entity Bean: OrganizationNfs
 */
public class OrganizationNfsKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: organization
	 */
	public int organization;
	/**
	 * Creates an empty key for Entity Bean: OrganizationNfs
	 */
	public OrganizationNfsKey() {
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.persistence.OrganizationNfsKey) {
			com.hps.july.persistence.OrganizationNfsKey o = (com.hps.july.persistence.OrganizationNfsKey) otherKey;
			return ((this.organization == o.organization));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(organization).hashCode()));
	}
	/**
	 * Creates a key for Entity Bean: OrganizationNfs
	 */
	public OrganizationNfsKey(int organization) {
		this.organization = organization;
	}
}
