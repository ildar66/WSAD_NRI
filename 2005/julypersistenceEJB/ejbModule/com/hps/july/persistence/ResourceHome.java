package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ResourceHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Resource
 * @param argResource int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Resource create(int argResource) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findActiveResourceBySubtype(java.lang.Integer argSubtype, java.lang.String argActive) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Resource
 * @param key com.hps.july.persistence.ResourceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Resource findByPrimaryKey(com.hps.july.persistence.ResourceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findResourceByReglamentOrderByCodeAsc(java.lang.Integer argReglament) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findResourceBySubtype(com.hps.july.persistence.ResourceSubTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findResourcesByLeaseChargeRules( java.util.Vector listContracts ) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findResourcesByLeasePayRules( java.util.Vector listContracts ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findResourcesByQBE( Boolean isSubtypekey, ResourceSubTypeKey subtypeKey,
                                    Boolean isModel, String model,
                                    Boolean isName, String name,
                                    Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findResourcesByQBE2(Boolean isSubtypekey, ResourceSubTypeKey subtypeKey,
    Boolean isModel, String model,
    Boolean isName, String name,
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Integer order
) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findResourcesByQBE3(Boolean isSubtypekey, ResourceSubTypeKey subtypeKey,
    Boolean isModel, String model,
    Boolean isName, String name,
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Integer connected, Integer owner,
    Integer order
) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findResourcesByUnit(com.hps.july.persistence.UnitKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findResourcesForBrowse(
        Boolean isResourcetype, Integer resourcetype,
        Boolean isResourcesubtype, Integer resourcesubtype,
        Boolean isModel, String model,
        Boolean isName, String name,
        Boolean isManufacturer, Integer manufacturer,
        Boolean isManucode, String manucode,
        String active, /// '*' - все - 'Y' - только активные, 'N' - только устаревшие
        Integer order
	) throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * ejbCreate method for a CMP entity bean
	 * @param argResource int
	 * @exception javax.ejb.CreateException The exception description.
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public com.hps.july.persistence.Resource create(
		int argResource,
		String argName,
		String argModel,
		String argNotes,
		Boolean argComplect,
		String argCountpolicy,
		Boolean argBoxable,
		Boolean argPriceable,
		Boolean argComplectpart,
		Boolean argActive,
		int argSubType,
		int argResourceClass2)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Creates an instance from a key for Entity Bean: Resource
	 */
	public com.hps.july.persistence.Resource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
