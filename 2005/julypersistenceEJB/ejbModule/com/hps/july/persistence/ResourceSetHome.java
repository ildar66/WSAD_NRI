package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ResourceSetHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.ResourceSet
 * @param argResourceset int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ResourceSet create(int argResourceset) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ResourceSet
 * @param key com.hps.july.persistence.ResourceSetKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ResourceSet findByPrimaryKey(com.hps.july.persistence.ResourceSetKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE( Boolean isSubtypekey, ResourceSubTypeKey subtypeKey,
                                    Boolean isModel, String model,
                                    Boolean isName, String name,
                                    Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findResourceSetsByMainpart(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findResourceSetsBySubtype(java.lang.Integer argSubtype) throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * ejbCreate method for a CMP entity bean
	 * @param argResourceset int
	 * @exception javax.ejb.CreateException The exception description.
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public com.hps.july.persistence.ResourceSet create(
		int argResourceset,
		String argName,
		Integer argMainPart,
		java.math.BigDecimal argMainPartQty,
		String argType)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
