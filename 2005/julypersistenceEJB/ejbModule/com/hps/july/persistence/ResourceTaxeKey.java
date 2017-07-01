package com.hps.july.persistence;

public class ResourceTaxeKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer resource_resource;
	public java.sql.Date date;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceTaxeKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argResource com.hps.july.persistence.ResourceKey
 * @param argDate java.sql.Date
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceTaxeKey(ResourceKey argResource, java.sql.Date argDate) {
	privateSetResourceKey(argResource);
	date = argDate;
}
/**
 * Initialize a key from the passed values
 * @param argDate java.util.Date
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ResourceTaxeKey(java.sql.Date argDate) {
	date = argDate;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof ResourceTaxeKey) {
		ResourceTaxeKey otherKey = (ResourceTaxeKey) o;
		return ((this.resource_resource.equals(otherKey.resource_resource)
		 && this.date.equals(otherKey.date)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
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
	return (resource_resource.hashCode()
		 + date.hashCode());
}
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
}
