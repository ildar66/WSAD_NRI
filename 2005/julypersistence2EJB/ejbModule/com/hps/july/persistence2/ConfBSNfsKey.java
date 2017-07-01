package com.hps.july.persistence2;
/**
 * Key class for Entity Bean: ConfBSNfs
 */
public class ConfBSNfsKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: id
	 */
	public int id;
	/**
	 * Creates an empty key for Entity Bean: ConfBSNfs
	 */
	public ConfBSNfsKey() {
	}
	/**
	 * Creates a key for Entity Bean: ConfBSNfs
	 */
	public ConfBSNfsKey(int id) {
		this.id = id;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.persistence2.ConfBSNfsKey) {
			com.hps.july.persistence2.ConfBSNfsKey o =
				(com.hps.july.persistence2.ConfBSNfsKey) otherKey;
			return ((this.id == o.id));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(id).hashCode()));
	}
}
