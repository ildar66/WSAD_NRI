package com.hps.july.persistence2;
/**
 * Key class for Entity Bean: Group2Resource
 */
public class Group2ResourceKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: groupid
	 */
	public int groupid;
	/**
	 * Implementation field for persistent attribute: resource
	 */
	public int resource;
	/**
	 * Creates an empty key for Entity Bean: Group2Resource
	 */
	public Group2ResourceKey() {
	}
	/**
	 * Creates a key for Entity Bean: Group2Resource
	 */
	public Group2ResourceKey(int groupid, int resource) {
		this.groupid = groupid;
		this.resource = resource;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.persistence2.Group2ResourceKey) {
			com.hps.july.persistence2.Group2ResourceKey o =
				(com.hps.july.persistence2.Group2ResourceKey) otherKey;
			return (
				(this.groupid == o.groupid) && (this.resource == o.resource));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(groupid).hashCode())
				+ (new java.lang.Integer(resource).hashCode()));
	}
}
