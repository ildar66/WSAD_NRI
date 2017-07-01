package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgBasestation
 */
public class CfgBasestationKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: equipment
	 */
	public int equipment;
	/**
	 * Creates an empty key for Entity Bean: CfgBasestation
	 */
	public CfgBasestationKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgBasestation
	 */
	public CfgBasestationKey(int savconfigid, int equipment) {
		this.savconfigid = savconfigid;
		this.equipment = equipment;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.config.beans.CfgBasestationKey) {
			com.hps.july.config.beans.CfgBasestationKey o =
				(com.hps.july.config.beans.CfgBasestationKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid)
					&& (this.equipment == o.equipment));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(savconfigid).hashCode())
				+ (new java.lang.Integer(equipment).hashCode()));
	}
}
