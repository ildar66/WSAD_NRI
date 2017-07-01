package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgAntennaCable
 */
public class CfgAntennaCableKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: idCable
	 */
	public int idCable;
	/**
	 * Creates an empty key for Entity Bean: CfgAntennaCable
	 */
	public CfgAntennaCableKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgAntennaCable
	 */
	public CfgAntennaCableKey(int savconfigid, int idCable) {
		this.savconfigid = savconfigid;
		this.idCable = idCable;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.config.beans.CfgAntennaCableKey) {
			com.hps.july.config.beans.CfgAntennaCableKey o =
				(com.hps.july.config.beans.CfgAntennaCableKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid)
					&& (this.idCable == o.idCable));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(savconfigid).hashCode())
				+ (new java.lang.Integer(idCable).hashCode()));
	}
}
