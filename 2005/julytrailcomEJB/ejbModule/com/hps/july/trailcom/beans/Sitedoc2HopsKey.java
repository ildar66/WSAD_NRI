package com.hps.july.trailcom.beans;

public class Sitedoc2HopsKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public int sitedoc;
	public java.lang.Integer hop_hopsid;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Sitedoc2HopsKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argSitedoc int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Sitedoc2HopsKey(int argSitedoc) {
	sitedoc = argSitedoc;
}
/**
 * Initialize a key from the passed values
 * @param argSitedoc int
 * @param argHop com.hps.july.trailcom.beans.HopKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Sitedoc2HopsKey(int argSitedoc, HopKey argHop) {
	sitedoc = argSitedoc;
	privateSetHopKey(argHop);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof Sitedoc2HopsKey) {
		Sitedoc2HopsKey otherKey = (Sitedoc2HopsKey) o;
		return (((this.sitedoc == otherKey.sitedoc)
		 && this.hop_hopsid.equals(otherKey.hop_hopsid)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named Sitedoc2Hops2hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.trailcom.beans.HopKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.HopKey getHopKey() {
	com.hps.july.trailcom.beans.HopKey temp = null;
	temp = new com.hps.july.trailcom.beans.HopKey();
	boolean hop_NULLTEST = true;
	hop_NULLTEST &= (hop_hopsid == null);
	temp.hopsid = ((hop_hopsid == null) ? 0 : hop_hopsid.intValue());
	if (hop_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return ((new java.lang.Integer(sitedoc).hashCode())
		 + hop_hopsid.hashCode());
}
/**
 * This method was generated for supporting the association named Sitedoc2Hops2hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.trailcom.beans.HopKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetHopKey(com.hps.july.trailcom.beans.HopKey inKey) {
	boolean hop_NULLTEST = (inKey == null);
	if (hop_NULLTEST) hop_hopsid = null; else hop_hopsid = (new Integer(inKey.hopsid));
}
}
