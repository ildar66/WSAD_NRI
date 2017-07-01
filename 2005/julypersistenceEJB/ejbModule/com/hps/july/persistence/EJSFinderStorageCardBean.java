package com.hps.july.persistence;

/**
 * EJSFinderStorageCardBean
 */
public interface EJSFinderStorageCardBean {
	/**
	 * findStorageCardByCurrentstorage
	 */
	public com.ibm.ejs.persistence.EJSFinder findStorageCardByCurrentstorage(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByResourceQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByResourceQBE(java.lang.Integer argResourceSubType, java.lang.Integer argStorage, java.lang.String argPolicy, java.lang.String argSerial, java.lang.String argParty, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByMainAgregateOrderByResourceAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByMainAgregateOrderByResourceAsc(java.lang.Integer argAgregate) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByStorageResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByStorageResource(java.lang.Integer storage, java.lang.Integer resource) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByStorageNotAgregatedOrderByResourceAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByStorageNotAgregatedOrderByResourceAsc(java.lang.Integer argStorage) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBadAgregatesByDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findBadAgregatesByDocument(java.lang.Integer document) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findStorageCardByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findStorageCardByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByStorageOwnerParty
	 */
	public com.hps.july.persistence.StorageCard findByStorageOwnerParty(java.lang.Integer argStorage, java.lang.Integer argOwner, java.lang.String argParty) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByPartyMaskOrderByPartyAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPartyMaskOrderByPartyAsc(java.lang.String argPartymask) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findStorageCardByQBE3
	 */
	public com.ibm.ejs.persistence.EJSFinder findStorageCardByQBE3(java.lang.Integer storageplace, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResourceset, java.lang.Integer resourceset, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Boolean onlyWithoutParts, java.lang.Integer brokenType, java.lang.Integer documentKey, java.lang.Boolean useExcludeFilter, java.lang.Integer storageCard, java.lang.Boolean usePolicy, java.lang.String policy, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByPartie
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPartie(java.lang.String argParstart, java.lang.String argParend) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByStorageOwnerResource
	 */
	public com.hps.july.persistence.StorageCard findByStorageOwnerResource(java.lang.Integer argStorage, java.lang.Integer argOwner, java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findStorageCardByOwner
	 */
	public com.ibm.ejs.persistence.EJSFinder findStorageCardByOwner(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySerie
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySerie(java.lang.String argSerstart, java.lang.String argSerend) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySerialResource
	 */
	public com.hps.july.persistence.StorageCard findBySerialResource(java.lang.String argSerial, java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPosibillity2IgnoreI13nDate
	 */
	public com.hps.july.persistence.StorageCard findPosibillity2IgnoreI13nDate(java.lang.Integer argCard, java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findStorageCardByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findStorageCardByQBE(java.lang.Integer storageplace, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResourceset, java.lang.Integer resourceset, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByStorageAndI13nResourceSetAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findByStorageAndI13nResourceSetAct(java.lang.Integer argStorage, java.lang.Integer act) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findStorageCardByContract
	 */
	public com.ibm.ejs.persistence.EJSFinder findStorageCardByContract(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByStorageNotInDoc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByStorageNotInDoc(java.lang.Integer storageplace, java.lang.Boolean useAgregate, java.lang.Integer agregate, java.lang.Integer document, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySerialMaskOrderBySerialAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySerialMaskOrderBySerialAsc(java.lang.String argSermask) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findCurrentStorageCardByLastDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findCurrentStorageCardByLastDocument(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySerial
	 */
	public com.hps.july.persistence.StorageCard findBySerial(java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findStorageCardByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findStorageCardByQBE2(java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer owner, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findClosedBySerialInStorage
	 */
	public com.hps.july.persistence.StorageCard findClosedBySerialInStorage(java.lang.String argSerial, java.lang.Integer argStorage) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
