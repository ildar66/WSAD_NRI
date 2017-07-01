package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgAntennaWorkBand
 */
public class CfgAntennaWorkBandKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: savconfigid
	 */
	public int savconfigid;
	/**
	 * Implementation field for persistent attribute: idanten
	 */
	public int idanten;
	/**
	 * Implementation field for persistent attribute: band
	 */
	public short band;
	/**
	 * Creates an empty key for Entity Bean: CfgAntennaWorkBand
	 */
	public CfgAntennaWorkBandKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgAntennaWorkBand
	 */
	public CfgAntennaWorkBandKey(int savconfigid, int idanten, short band) {
		this.savconfigid = savconfigid;
		this.idanten = idanten;
		this.band = band;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.hps.july.config.beans.CfgAntennaWorkBandKey) {
			com.hps.july.config.beans.CfgAntennaWorkBandKey o =
				(com.hps.july.config.beans.CfgAntennaWorkBandKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid)
					&& (this.idanten == o.idanten)
					&& (this.band == o.band));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (
			(new java.lang.Integer(savconfigid).hashCode())
				+ (new java.lang.Integer(idanten).hashCode())
				+ (new java.lang.Short(band).hashCode()));
	}
}
