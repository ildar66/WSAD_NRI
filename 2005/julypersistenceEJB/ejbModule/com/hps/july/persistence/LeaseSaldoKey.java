package com.hps.july.persistence;

public class LeaseSaldoKey implements java.io.Serializable {
	public java.sql.Date SalDate;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer resource_resource;
	public java.lang.Integer leaseContract;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseSaldoKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argSalDate java.sql.Date
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseSaldoKey(java.sql.Date argSalDate) {
	SalDate = argSalDate;
}
/**
 * Initialize a key from the passed values
 * @param argSalDate java.sql.Date
 * @param argResource com.hps.july.persistence.ResourceKey
 * @param argLeaseContract java.lang.Integer
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseSaldoKey(java.sql.Date argSalDate, ResourceKey argResource, java.lang.Integer argLeaseContract) {
	SalDate = argSalDate;
	privateSetResourceKey(argResource);
	leaseContract = argLeaseContract;
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseSaldoKey) {
		LeaseSaldoKey otherKey = (LeaseSaldoKey) o;
		return ((this.SalDate.equals(otherKey.SalDate)
		 && this.resource_resource.equals(otherKey.resource_resource)
		 && this.leaseContract.equals(otherKey.leaseContract)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
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
	return (SalDate.hashCode()
		 + resource_resource.hashCode()
		 + leaseContract.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
}
