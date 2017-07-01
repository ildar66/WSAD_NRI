package com.hps.july.persistence2;
/**
 * Key class for Entity Bean: ResourceSetClass
 */
public class ResourceSetClassKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: classid
	 */
	public int classid;
	/**
	 * Creates an empty key for Entity Bean: ResourceSetClass
	 */
	public ResourceSetClassKey() {
	}
	/**
	 * Creates a key for Entity Bean: ResourceSetClass
	 */
	public ResourceSetClassKey(int classid) {
		this.classid = classid;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.hps.july.persistence2.ResourceSetClassKey) {
			com.hps.july.persistence2.ResourceSetClassKey o =
				(com.hps.july.persistence2.ResourceSetClassKey) otherKey;
			return ((this.classid == o.classid));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(classid).hashCode()));
	}
}
