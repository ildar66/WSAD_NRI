package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgStoragecard
 */
public class CfgStoragecardKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: storagecard
	 */
	public int storagecard;
	/**
	 * Creates an empty key for Entity Bean: CfgStoragecard
	 */
	public CfgStoragecardKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgStoragecard
	 */
	public CfgStoragecardKey(int savconfigid, int storagecard) {
		this.savconfigid = savconfigid;
		this.storagecard = storagecard;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.config.beans.CfgStoragecardKey) {
			com.hps.july.config.beans.CfgStoragecardKey o =
				(com.hps.july.config.beans.CfgStoragecardKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid)
					&& (this.storagecard == o.storagecard));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(savconfigid).hashCode())
				+ (new java.lang.Integer(storagecard).hashCode()));
	}
}
