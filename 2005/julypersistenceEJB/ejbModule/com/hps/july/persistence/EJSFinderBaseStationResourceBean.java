package com.hps.july.persistence;

/**
 * EJSFinderBaseStationResourceBean
 */
public interface EJSFinderBaseStationResourceBean {
	/**
	 * findResourcesByQBE3
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourcesByQBE3(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer owner, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findResourcesByLeasePayRules
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourcesByLeasePayRules(java.util.Vector listContracts) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourceByReglamentOrderByCodeAsc(java.lang.Integer argReglament) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findResourcesByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourcesByQBE2(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findActiveResourceBySubtype
	 */
	public com.ibm.ejs.persistence.EJSFinder findActiveResourceBySubtype(java.lang.Integer argSubtype, java.lang.String argActive) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBasestationResourceForBowse
	 */
	public com.ibm.ejs.persistence.EJSFinder findBasestationResourceForBowse(java.lang.Boolean isResourcetype, java.lang.Integer resourcetype, java.lang.Boolean isResourcesubtype, java.lang.Integer resourcesubtype, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.String active, java.lang.Boolean isGeneration, java.lang.String generation, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findResourcesByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourcesByQBE(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findResourcesByLeaseChargeRules
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourcesByLeaseChargeRules(java.util.Vector listContracts) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBasestationByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findBasestationByQBE(java.lang.Boolean isType, java.lang.Integer type, java.lang.Boolean isSubtype, java.lang.Integer subtype, java.lang.Boolean isGeneration, java.lang.String generation, java.lang.String active, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isManufacturer, java.lang.String manufacturer, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
