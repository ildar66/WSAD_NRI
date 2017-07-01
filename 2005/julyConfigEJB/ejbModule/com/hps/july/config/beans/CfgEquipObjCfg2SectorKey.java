package com.hps.july.config.beans;
/**
 * Key class for Entity Bean: CfgEquipObjCfg2Sector
 */
public class CfgEquipObjCfg2SectorKey implements java.io.Serializable {
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
	 * Implementation field for persistent attribute: id_sect
	 */
	public int id_sect;
	/**
	 * Creates an empty key for Entity Bean: CfgEquipObjCfg2Sector
	 */
	public CfgEquipObjCfg2SectorKey() {
	}
	/**
	 * Creates a key for Entity Bean: CfgEquipObjCfg2Sector
	 */
	public CfgEquipObjCfg2SectorKey(
		int savconfigid,
		int objcfgid,
		int id_sect) {
		this.savconfigid = savconfigid;
		this.objcfgid = objcfgid;
		this.id_sect = id_sect;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.hps.july.config.beans.CfgEquipObjCfg2SectorKey) {
			com.hps.july.config.beans.CfgEquipObjCfg2SectorKey o =
				(com.hps.july.config.beans.CfgEquipObjCfg2SectorKey) otherKey;
			return (
				(this.savconfigid == o.savconfigid)
					&& (this.objcfgid == o.objcfgid)
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
				+ (new java.lang.Integer(objcfgid).hashCode())
				+ (new java.lang.Integer(id_sect).hashCode()));
	}
}