package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgBsstands
 */
public class CfgBsstandsKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: standid
	 */
	public int standid;
	/**
	 * Creates an empty key for Entity Bean: CfgBsstands
	 */
	public CfgBsstandsKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgBsstands
	 */
	public CfgBsstandsKey(int savconfigid, int standid) {
		this.savconfigid = savconfigid;
		this.standid = standid;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.config.beans.CfgBsstandsKey) {
			com.hps.july.config.beans.CfgBsstandsKey o =
				(com.hps.july.config.beans.CfgBsstandsKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid)
					&& (this.standid == o.standid));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(savconfigid).hashCode())
				+ (new java.lang.Integer(standid).hashCode()));
	}
}
