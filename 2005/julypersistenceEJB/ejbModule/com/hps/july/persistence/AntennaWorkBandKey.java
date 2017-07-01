package com.hps.july.persistence;

public class AntennaWorkBandKey implements java.io.Serializable {
	public short band;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer antenna_idanten;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AntennaWorkBandKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argBand short
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AntennaWorkBandKey(short argBand) {
	band = argBand;
}
/**
 * Initialize a key from the passed values
 * @param argBand short
 * @param argAntenna com.hps.july.persistence.AntennaKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AntennaWorkBandKey(short argBand, AntennaKey argAntenna) {
	band = argBand;
	privateSetAntennaKey(argAntenna);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof AntennaWorkBandKey) {
		AntennaWorkBandKey otherKey = (AntennaWorkBandKey) o;
		return (((this.band == otherKey.band)
		 && this.antenna_idanten.equals(otherKey.antenna_idanten)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named AntennaWorkBand2antenna.  
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
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return ((new Short(band).hashCode())
		 + antenna_idanten.hashCode());
}
/**
 * This method was generated for supporting the association named AntennaWorkBand2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.AntennaKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAntennaKey(com.hps.july.persistence.AntennaKey inKey) {
	boolean antenna_NULLTEST = (inKey == null);
	if (antenna_NULLTEST) antenna_idanten = null; else antenna_idanten = (new Integer(inKey.idanten));
}
}
