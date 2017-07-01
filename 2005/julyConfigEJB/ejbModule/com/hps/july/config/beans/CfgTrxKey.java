package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgTrx
 */
public class CfgTrxKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: trxid
	 */
	public int trxid;
	/**
	 * Creates an empty key for Entity Bean: CfgTrx
	 */
	public CfgTrxKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgTrx
	 */
	public CfgTrxKey(int savconfigid, int trxid) {
		this.savconfigid = savconfigid;
		this.trxid = trxid;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.config.beans.CfgTrxKey) {
			com.hps.july.config.beans.CfgTrxKey o =
				(com.hps.july.config.beans.CfgTrxKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid) && (this.trxid == o.trxid));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(savconfigid).hashCode())
				+ (new java.lang.Integer(trxid).hashCode()));
	}
}
