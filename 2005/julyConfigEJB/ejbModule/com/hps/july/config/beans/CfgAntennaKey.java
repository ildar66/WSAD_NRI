package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgAntenna
 */
public class CfgAntennaKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: id_anten
	 */
	public int id_anten;
	/**
	 * Creates an empty key for Entity Bean: CfgAntenna
	 */
	public CfgAntennaKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgAntenna
	 */
	public CfgAntennaKey(int savconfigid, int id_anten) {
		this.savconfigid = savconfigid;
		this.id_anten = id_anten;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.config.beans.CfgAntennaKey) {
			com.hps.july.config.beans.CfgAntennaKey o =
				(com.hps.july.config.beans.CfgAntennaKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid)
					&& (this.id_anten == o.id_anten));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(savconfigid).hashCode())
				+ (new java.lang.Integer(id_anten).hashCode()));
	}
}
