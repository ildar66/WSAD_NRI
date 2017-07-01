package com.hps.july.persistence;

public class CableResourceBandKey implements java.io.Serializable {
	public short band;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer resource_resource;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CableResourceBandKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argBand short
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CableResourceBandKey(short argBand) {
	band = argBand;
}
/**
 * Initialize a key from the passed values
 * @param argBand short
 * @param argResource com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public CableResourceBandKey(short argBand, ResourceKey argResource) {
	band = argBand;
	privateSetResourceKey(argResource);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof CableResourceBandKey) {
		CableResourceBandKey otherKey = (CableResourceBandKey) o;
		return (((this.band == otherKey.band)
		 && this.resource_resource.equals(otherKey.resource_resource)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named CableResourceBand2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getResourceKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean resource_NULLTEST = true;
	resource_NULLTEST &= (resource_resource == null);
	temp.resource = ((resource_resource == null) ? 0 : resource_resource.intValue());
	if (resource_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return ((new Short(band).hashCode())
		 + resource_resource.hashCode());
}
/**
 * This method was generated for supporting the association named CableResourceBand2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
}
