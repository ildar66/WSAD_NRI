package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgSavedConfig
 */
public class CfgSavedConfigKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Creates an empty key for Entity Bean: CfgSavedConfig
	 */
	public CfgSavedConfigKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgSavedConfig
	 */
	public CfgSavedConfigKey(int savconfigid) {
		this.savconfigid = savconfigid;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.config.beans.CfgSavedConfigKey) {
			com.hps.july.config.beans.CfgSavedConfigKey o =
				(com.hps.july.config.beans.CfgSavedConfigKey) otherKey;
			return ((this.savconfigid == o.savconfigid));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(savconfigid).hashCode()));
	}
}
