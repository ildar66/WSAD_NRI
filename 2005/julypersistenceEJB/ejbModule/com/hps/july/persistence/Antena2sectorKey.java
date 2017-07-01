package com.hps.july.persistence;

public class Antena2sectorKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer antenna_idanten;
	public java.lang.Integer sector_idsect;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Antena2sectorKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argAntenna com.hps.july.persistence.AntennaKey
 * @param argSector com.hps.july.persistence.SectorKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Antena2sectorKey(AntennaKey argAntenna, SectorKey argSector) {
	privateSetAntennaKey(argAntenna);
	privateSetSectorKey(argSector);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof Antena2sectorKey) {
		Antena2sectorKey otherKey = (Antena2sectorKey) o;
		return ((this.antenna_idanten.equals(otherKey.antenna_idanten)
		 && this.sector_idsect.equals(otherKey.sector_idsect)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named Antena2sector2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.AntennaKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AntennaKey getAntennaKey() {
	com.hps.july.persistence.AntennaKey temp = null;
	temp = new com.hps.july.persistence.AntennaKey();
	boolean antenna_NULLTEST = true;
	antenna_NULLTEST &= (antenna_idanten == null);
	temp.idanten = ((antenna_idanten == null) ? 0 : antenna_idanten.intValue());
	if (antenna_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Antena2sector2sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.SectorKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SectorKey getSectorKey() {
	com.hps.july.persistence.SectorKey temp = null;
	temp = new com.hps.july.persistence.SectorKey();
	boolean sector_NULLTEST = true;
	sector_NULLTEST &= (sector_idsect == null);
	temp.idsect = ((sector_idsect == null) ? 0 : sector_idsect.intValue());
	if (sector_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (antenna_idanten.hashCode()
		 + sector_idsect.hashCode());
}
/**
 * This method was generated for supporting the association named Antena2sector2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.AntennaKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAntennaKey(com.hps.july.persistence.AntennaKey inKey) {
	boolean antenna_NULLTEST = (inKey == null);
	if (antenna_NULLTEST) antenna_idanten = null; else antenna_idanten = (new Integer(inKey.idanten));
}
/**
 * This method was generated for supporting the association named Antena2sector2sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.SectorKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSectorKey(com.hps.july.persistence.SectorKey inKey) {
	boolean sector_NULLTEST = (inKey == null);
	if (sector_NULLTEST) sector_idsect = null; else sector_idsect = (new Integer(inKey.idsect));
}
}
