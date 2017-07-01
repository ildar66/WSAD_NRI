package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface RRLAntennaResourceHome extends javax.ejb.EJBHome {
/**
 * 
 * @return com.hps.july.persistence.RRLAntennaResource
 * @param argResource int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.RRLAntennaResource create(int argResource) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.RRLAntennaResource
 * @param argResource int
 * @param argName java.lang.String
 * @param argModel java.lang.String
 * @param argNotes java.lang.String
 * @param argComplect java.lang.Boolean
 * @param argCountpolicy java.lang.String
 * @param argBoxable java.lang.Boolean
 * @param argPriceable java.lang.Boolean
 * @param argComplectpart java.lang.Boolean
 * @param argActive java.lang.Boolean
 * @param argSubType int
 * @param argFreqDevLowK java.math.BigDecimal
 * @param argFreqDevLowLog10 int
 * @param argFreqDevHighK java.math.BigDecimal
 * @param argFreqDevHighLog10 int
 * @param argMkkrRecomm java.lang.String
 * @param argProtocolNum java.lang.String
 * @param argProtocolDate java.sql.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.RRLAntennaResource create(int argResource, java.lang.String argName, java.lang.String argModel, java.lang.String argNotes, java.lang.Boolean argComplect, java.lang.String argCountpolicy, java.lang.Boolean argBoxable, java.lang.Boolean argPriceable, java.lang.Boolean argComplectpart, java.lang.Boolean argActive, int argSubType, java.math.BigDecimal argFreqDevLowK, int argFreqDevLowLog10, java.math.BigDecimal argFreqDevHighK, int argFreqDevHighLog10, java.lang.String argMkkrRecomm, java.lang.String argProtocolNum, java.sql.Date argProtocolDate) throws javax.ejb.CreateException, java.rmi.RemoteException;
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
 * @return com.hps.july.persistence.RRLAntennaResource
 * @param key com.hps.july.persistence.ResourceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.RRLAntennaResource findByPrimaryKey(ResourceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
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
 * @param isResourcetype java.lang.Boolean
 * @param resourcetype java.lang.Integer
 * @param isResourcesubtype java.lang.Boolean
 * @param resourcesubtype java.lang.Integer
 * @param isModel java.lang.Boolean
 * @param model java.lang.String
 * @param isName java.lang.Boolean
 * @param name java.lang.String
 * @param isManufacturer java.lang.Boolean
 * @param manufacturer java.lang.Integer
 * @param isManucode java.lang.Boolean
 * @param manucode java.lang.String
 * @param active java.lang.String
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findResourcesForBrowse(Boolean isResourcetype, Integer resourcetype, Boolean isResourcesubtype, Integer resourcesubtype, Boolean isModel, String model, Boolean isName, String name, Boolean isManufacturer, Integer manufacturer, Boolean isManucode, String manucode, String active, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * Creates an instance from a key for Entity Bean: RRLAntennaResource
	 */
	public com.hps.july.persistence.RRLAntennaResource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
