package com.hps.july.persistence;

public class ResourceSetPartKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer set_resourceset;
	public java.lang.Integer part_resource;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceSetPartKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argSet com.hps.july.persistence.ResourceSetKey
 * @param argPart com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceSetPartKey(ResourceSetKey argSet, ResourceKey argPart) {
	privateSetSetKey(argSet);
	privateSetPartKey(argPart);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof ResourceSetPartKey) {
		ResourceSetPartKey otherKey = (ResourceSetPartKey) o;
		return ((this.set_resourceset.equals(otherKey.set_resourceset)
		 && this.part_resource.equals(otherKey.part_resource)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named ResourceSetPart2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getPartKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean part_NULLTEST = true;
	part_NULLTEST &= (part_resource == null);
	temp.resource = ((part_resource == null) ? 0 : part_resource.intValue());
	if (part_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named ResourceSetParts2ResourceSet.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.ResourceSetKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceSetKey getSetKey() {
	com.hps.july.persistence.ResourceSetKey temp = null;
	temp = new com.hps.july.persistence.ResourceSetKey();
	boolean set_NULLTEST = true;
	set_NULLTEST &= (set_resourceset == null);
	temp.resourceset = ((set_resourceset == null) ? 0 : set_resourceset.intValue());
	if (set_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (set_resourceset.hashCode()
		 + part_resource.hashCode());
}
/**
 * This method was generated for supporting the association named ResourceSetPart2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPartKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean part_NULLTEST = (inKey == null);
	if (part_NULLTEST) part_resource = null; else part_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named ResourceSetParts2ResourceSet.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResourceSetKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSetKey(com.hps.july.persistence.ResourceSetKey inKey) {
	boolean set_NULLTEST = (inKey == null);
	if (set_NULLTEST) set_resourceset = null; else set_resourceset = (new Integer(inKey.resourceset));
}
}
