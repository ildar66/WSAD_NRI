package com.hps.july.trailcom.beans;

public class OpticalHopKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer hopid_hopsid;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OpticalHopKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argHopid com.hps.july.trailcom.beans.HopKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public OpticalHopKey(HopKey argHopid) {
	privateSetHopidKey(argHopid);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof OpticalHopKey) {
		OpticalHopKey otherKey = (OpticalHopKey) o;
		return ((this.hopid_hopsid.equals(otherKey.hopid_hopsid)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named OpticalHop2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.trailcom.beans.HopKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.HopKey getHopidKey() {
	com.hps.july.trailcom.beans.HopKey temp = null;
	temp = new com.hps.july.trailcom.beans.HopKey();
	boolean hopid_NULLTEST = true;
	hopid_NULLTEST &= (hopid_hopsid == null);
	temp.hopsid = ((hopid_hopsid == null) ? 0 : hopid_hopsid.intValue());
	if (hopid_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (hopid_hopsid.hashCode());
}
/**
 * This method was generated for supporting the association named OpticalHop2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.trailcom.beans.HopKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetHopidKey(com.hps.july.trailcom.beans.HopKey inKey) {
	boolean hopid_NULLTEST = (inKey == null);
	if (hopid_NULLTEST) hopid_hopsid = null; else hopid_hopsid = (new Integer(inKey.hopsid));
}
}
