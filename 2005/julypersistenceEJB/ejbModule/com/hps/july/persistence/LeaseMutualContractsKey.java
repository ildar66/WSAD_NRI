package com.hps.july.persistence;

public class LeaseMutualContractsKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer reglament_leaseDocument;
	public java.lang.Integer contract_leaseDocument;
	public java.lang.Integer resource_resource;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseMutualContractsKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argReglament com.hps.july.persistence.LeaseDocumentKey
 * @param argContract com.hps.july.persistence.LeaseDocumentKey
 * @param argResource com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public LeaseMutualContractsKey(LeaseDocumentKey argReglament, LeaseDocumentKey argContract, ResourceKey argResource) {
	privateSetReglamentKey(argReglament);
	privateSetContractKey(argContract);
	privateSetResourceKey(argResource);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof LeaseMutualContractsKey) {
		LeaseMutualContractsKey otherKey = (LeaseMutualContractsKey) o;
		return ((this.reglament_leaseDocument.equals(otherKey.reglament_leaseDocument)
		 && this.contract_leaseDocument.equals(otherKey.contract_leaseDocument)
		 && this.resource_resource.equals(otherKey.resource_resource)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getContractKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean contract_NULLTEST = true;
	contract_NULLTEST &= (contract_leaseDocument == null);
	temp.leaseDocument = ((contract_leaseDocument == null) ? 0 : contract_leaseDocument.intValue());
	if (contract_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2reglament.  
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
 * This method was generated for supporting the association named LeaseMutualContracts2resources.  
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
		 + contract_leaseDocument.hashCode()
		 + resource_resource.hashCode());
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetContractKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean contract_NULLTEST = (inKey == null);
	if (contract_NULLTEST) contract_leaseDocument = null; else contract_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.LeaseDocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetReglamentKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean reglament_NULLTEST = (inKey == null);
	if (reglament_NULLTEST) reglament_leaseDocument = null; else reglament_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2resources.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
}
