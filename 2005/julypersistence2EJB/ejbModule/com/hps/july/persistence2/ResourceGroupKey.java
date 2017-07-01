package com.hps.july.persistence2;
/**
 * Key class for Entity Bean: ResourceGroup
 */
public class ResourceGroupKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: groupid
	 */
	public int groupid;
	/**
	 * Creates an empty key for Entity Bean: ResourceGroup
	 */
	public ResourceGroupKey() {
	}
	/**
	 * Creates a key for Entity Bean: ResourceGroup
	 */
	public ResourceGroupKey(int groupid) {
		this.groupid = groupid;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.persistence2.ResourceGroupKey) {
			com.hps.july.persistence2.ResourceGroupKey o =
				(com.hps.july.persistence2.ResourceGroupKey) otherKey;
			return ((this.groupid == o.groupid));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(groupid).hashCode()));
	}
}
