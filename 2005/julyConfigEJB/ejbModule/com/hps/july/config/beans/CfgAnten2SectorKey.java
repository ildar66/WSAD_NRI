package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgAnten2Sector
 */
public class CfgAnten2SectorKey implements java.io.Serializable {
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
	 * Implementation field for persistent attribute: id_sect
	 */
	public int id_sect;
	/**
	 * Creates an empty key for Entity Bean: CfgAnten2Sector
	 */
	public CfgAnten2SectorKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgAnten2Sector
	 */
	public CfgAnten2SectorKey(int savconfigid, int id_anten, int id_sect) {
		this.savconfigid = savconfigid;
		this.id_anten = id_anten;
		this.id_sect = id_sect;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.config.beans.CfgAnten2SectorKey) {
			com.hps.july.config.beans.CfgAnten2SectorKey o =
				(com.hps.july.config.beans.CfgAnten2SectorKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid)
					&& (this.id_anten == o.id_anten)
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
				+ (new java.lang.Integer(id_anten).hashCode())
				+ (new java.lang.Integer(id_sect).hashCode()));
	}
}
