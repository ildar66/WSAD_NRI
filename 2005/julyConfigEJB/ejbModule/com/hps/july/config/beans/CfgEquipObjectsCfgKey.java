package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgEquipObjectsCfg
 */
public class CfgEquipObjectsCfgKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: objcfgid
	 */
	public int objcfgid;
	/**
	 * Creates an empty key for Entity Bean: CfgEquipObjectsCfg
	 */
	public CfgEquipObjectsCfgKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgEquipObjectsCfg
	 */
	public CfgEquipObjectsCfgKey(int savconfigid, int objcfgid) {
		this.savconfigid = savconfigid;
		this.objcfgid = objcfgid;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.hps.july.config.beans.CfgEquipObjectsCfgKey) {
			com.hps.july.config.beans.CfgEquipObjectsCfgKey o =
				(com.hps.july.config.beans.CfgEquipObjectsCfgKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid)
					&& (this.objcfgid == o.objcfgid));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(savconfigid).hashCode())
				+ (new java.lang.Integer(objcfgid).hashCode()));
	}
}
