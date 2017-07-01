package com.hps.july.persistence;

public class LeaseMutualRuleNewKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer reglament_leaseDocument;
	public java.lang.Integer resource_resource;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseMutualRuleNewKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argReglament com.hps.july.persistence.LeaseDocumentKey
 * @param argResource com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseMutualRuleNewKey(LeaseDocumentKey argReglament, ResourceKey argResource) {
	privateSetReglamentKey(argReglament);
	privateSetResourceKey(argResource);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseMutualRuleNewKey) {
		LeaseMutualRuleNewKey otherKey = (LeaseMutualRuleNewKey) o;
		return ((this.reglament_leaseDocument.equals(otherKey.reglament_leaseDocument)
		 && this.resource_resource.equals(otherKey.resource_resource)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getReglamentKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean reglament_NULLTEST = true;
	reglament_NULLTEST &= (reglament_leaseDocument == null);
	temp.leaseDocument = ((reglament_leaseDocument == null) ? 0 : reglament_leaseDocument.intValue());
	if (reglament_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
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
	return (reglament_leaseDocument.hashCode()
		 + resource_resource.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetReglamentKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean reglament_NULLTEST = (inKey == null);
	if (reglament_NULLTEST) reglament_leaseDocument = null; else reglament_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
}
