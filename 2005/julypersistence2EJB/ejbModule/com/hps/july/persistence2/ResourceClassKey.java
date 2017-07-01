package com.hps.july.persistence2;
/**
 * Key class for Entity Bean: ResourceClass
 */
public class ResourceClassKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: classid
	 */
	public int classid;
	/**
	 * Creates an empty key for Entity Bean: ResourceClass
	 */
	public ResourceClassKey() {
	}
	/**
	 * Creates a key for Entity Bean: ResourceClass
	 */
	public ResourceClassKey(int classid) {
		this.classid = classid;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.persistence2.ResourceClassKey) {
			com.hps.july.persistence2.ResourceClassKey o =
				(com.hps.july.persistence2.ResourceClassKey) otherKey;
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
