package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface CableResourceHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.CableResource
 * @param argResource int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.CableResource create(int argResource) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return java.util.Enumeration
 * @param argSubtype java.lang.Integer
 * @param argActive java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findActiveResourceBySubtype(Integer argSubtype, String argActive) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.CableResource
 * @param key com.hps.july.persistence.ResourceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.CableResource findByPrimaryKey(ResourceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE4 (Boolean isType, Integer typeId,
                        Boolean isSubType, Integer subTypeId,
                        Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param argReglament java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findResourceByReglamentOrderByCodeAsc(Integer argReglament) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param listContracts java.util.Vector
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findResourcesByLeaseChargeRules(java.util.Vector listContracts) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param listContracts java.util.Vector
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findResourcesByLeasePayRules(java.util.Vector listContracts) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param isSubtypekey java.lang.Boolean
 * @param subtypeKey com.hps.july.persistence.ResourceSubTypeKey
 * @param isModel java.lang.Boolean
 * @param model java.lang.String
 * @param isName java.lang.Boolean
 * @param name java.lang.String
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findResourcesByQBE(Boolean isSubtypekey, ResourceSubTypeKey subtypeKey, Boolean isModel, String model, Boolean isName, String name, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param isSubtypekey java.lang.Boolean
 * @param subtypeKey com.hps.july.persistence.ResourceSubTypeKey
 * @param isModel java.lang.Boolean
 * @param model java.lang.String
 * @param isName java.lang.Boolean
 * @param name java.lang.String
 * @param isManufacturer java.lang.Boolean
 * @param manufacturer java.lang.Integer
 * @param isManucode java.lang.Boolean
 * @param manucode java.lang.String
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findResourcesByQBE2(Boolean isSubtypekey, ResourceSubTypeKey subtypeKey, Boolean isModel, String model, Boolean isName, String name, Boolean isManufacturer, Integer manufacturer, Boolean isManucode, String manucode, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param isSubtypekey java.lang.Boolean
 * @param subtypeKey com.hps.july.persistence.ResourceSubTypeKey
 * @param isModel java.lang.Boolean
 * @param model java.lang.String
 * @param isName java.lang.Boolean
 * @param name java.lang.String
 * @param isManufacturer java.lang.Boolean
 * @param manufacturer java.lang.Integer
 * @param isManucode java.lang.Boolean
 * @param manucode java.lang.String
 * @param connected java.lang.Integer
 * @param owner java.lang.Integer
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findResourcesByQBE3(Boolean isSubtypekey, ResourceSubTypeKey subtypeKey, Boolean isModel, String model, Boolean isName, String name, Boolean isManufacturer, Integer manufacturer, Boolean isManucode, String manucode, Integer connected, Integer owner, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param isSubtypekey java.lang.Boolean
 * @param subtypeKey com.hps.july.persistence.ResourceSubTypeKey
 * @param isModel java.lang.Boolean
 * @param model java.lang.String
 * @param isName java.lang.Boolean
 * @param name java.lang.String
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findResourcesByQBE4(Boolean isSubtypekey, ResourceSubTypeKey subtypeKey, Boolean isModel, String model, Boolean isName, String name, Integer active, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
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
	public com.hps.july.persistence.CableResource create(
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
		int argCableDiamId)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Creates an instance from a key for Entity Bean: CableResource
	 */
	public com.hps.july.persistence.CableResource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
