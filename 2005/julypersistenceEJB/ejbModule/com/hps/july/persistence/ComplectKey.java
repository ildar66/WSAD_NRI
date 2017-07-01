package com.hps.july.persistence;

public class ComplectKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer complect_resource;
	public java.lang.Integer parts_resource;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ComplectKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argComplect com.hps.july.persistence.ResourceKey
 * @param argParts com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ComplectKey(ResourceKey argComplect, ResourceKey argParts) {
	privateSetComplectKey(argComplect);
	privateSetPartsKey(argParts);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof ComplectKey) {
		ComplectKey otherKey = (ComplectKey) o;
		return ((this.complect_resource.equals(otherKey.complect_resource)
		 && this.parts_resource.equals(otherKey.parts_resource)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named Complects2MainResource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getComplectKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean complect_NULLTEST = true;
	complect_NULLTEST &= (complect_resource == null);
	temp.resource = ((complect_resource == null) ? 0 : complect_resource.intValue());
	if (complect_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Complect2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getPartsKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean parts_NULLTEST = true;
	parts_NULLTEST &= (parts_resource == null);
	temp.resource = ((parts_resource == null) ? 0 : parts_resource.intValue());
	if (parts_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (complect_resource.hashCode()
		 + parts_resource.hashCode());
}
/**
 * This method was generated for supporting the association named Complects2MainResource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetComplectKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean complect_NULLTEST = (inKey == null);
	if (complect_NULLTEST) complect_resource = null; else complect_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named Complect2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPartsKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean parts_NULLTEST = (inKey == null);
	if (parts_NULLTEST) parts_resource = null; else parts_resource = (new Integer(inKey.resource));
}
}
