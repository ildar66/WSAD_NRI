package com.hps.july.persistence;

public class ChanalPowerKey implements java.io.Serializable {
	public int chanal;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer basestation_storageplace;
	public java.lang.String polarization;
	public int band;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ChanalPowerKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argChanal int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ChanalPowerKey(int argChanal) {
	chanal = argChanal;
}
/**
 * Initialize a key from the passed values
 * @param argChanal int
 * @param argBasestation com.hps.july.persistence.StoragePlaceKey
 * @param argPolarization java.lang.String
 * @param argBand int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ChanalPowerKey(int argChanal, StoragePlaceKey argBasestation, java.lang.String argPolarization, int argBand) {
	chanal = argChanal;
	privateSetBasestationKey(argBasestation);
	polarization = argPolarization;
	band = argBand;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof ChanalPowerKey) {
		ChanalPowerKey otherKey = (ChanalPowerKey) o;
		return (((this.chanal == otherKey.chanal)
		 && this.basestation_storageplace.equals(otherKey.basestation_storageplace)
		 && this.polarization.equals(otherKey.polarization)
		 && (this.band == otherKey.band)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named ChanalPower2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getBasestationKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean basestation_NULLTEST = true;
	basestation_NULLTEST &= (basestation_storageplace == null);
	temp.storageplace = ((basestation_storageplace == null) ? 0 : basestation_storageplace.intValue());
	if (basestation_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return ((new java.lang.Integer(chanal).hashCode())
		 + basestation_storageplace.hashCode()
		 + polarization.hashCode()
		 + (new java.lang.Integer(band).hashCode()));
}
/**
 * This method was generated for supporting the association named ChanalPower2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.StoragePlaceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetBasestationKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean basestation_NULLTEST = (inKey == null);
	if (basestation_NULLTEST) basestation_storageplace = null; else basestation_storageplace = (new Integer(inKey.storageplace));
}
}
