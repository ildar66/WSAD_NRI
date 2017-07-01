package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgTrx2Sector
 */
public class CfgTrx2SectorKey implements java.io.Serializable {
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
	 * Implementation field for persistent attribute: id_sect
	 */
	public int id_sect;
	/**
	 * Creates an empty key for Entity Bean: CfgTrx2Sector
	 */
	public CfgTrx2SectorKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgTrx2Sector
	 */
	public CfgTrx2SectorKey(int savconfigid, int trxid, int id_sect) {
		this.savconfigid = savconfigid;
		this.trxid = trxid;
		this.id_sect = id_sect;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.config.beans.CfgTrx2SectorKey) {
			com.hps.july.config.beans.CfgTrx2SectorKey o =
				(com.hps.july.config.beans.CfgTrx2SectorKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid)
					&& (this.trxid == o.trxid)
					&& (this.id_sect == o.id_sect));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(savconfigid).hashCode())
				+ (new java.lang.Integer(trxid).hashCode())
				+ (new java.lang.Integer(id_sect).hashCode()));
	}
}
