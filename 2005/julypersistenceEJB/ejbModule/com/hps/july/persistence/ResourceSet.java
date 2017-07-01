package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: ResourceSet
 */
public interface ResourceSet extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {










/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getMainpart() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getMainpartKey() throws java.rmi.RemoteException;
/**
 * Getter method for mainpartqty
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getMainpartqty() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getResourceset() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSetParts2ResourceSet.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSetParts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for type
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getType() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetMainpartKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSetParts2ResourceSet.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSetParts(com.hps.july.persistence.ResourceSetPart aSetParts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSetParts2ResourceSet.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSetParts(com.hps.july.persistence.ResourceSetPart aSetParts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMainpart(com.hps.july.persistence.Resource aMainpart) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMainpart(com.hps.july.persistence.Resource aMainpart) throws java.rmi.RemoteException;
/**
 * Setter method for mainpartqty
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setMainpartqty(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newResourceset int
 * @exception String The exception description.
 */
void setResourceset(int newResourceset) throws java.rmi.RemoteException;
/**
 * Setter method for type
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setType(java.lang.String newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: resourcesetclass
	 */
	public java.lang.Integer getResourcesetclass()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: resourcesetclass
	 */
	public void setResourcesetclass(java.lang.Integer newResourcesetclass)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: nfsitemid
	 */
	public java.lang.String getNfsitemid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: nfsitemid
	 */
	public void setNfsitemid(java.lang.String newNfsitemid)
		throws java.rmi.RemoteException;
}
