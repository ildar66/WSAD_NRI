package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface StorageCardHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.StorageCard
 * @param argStoragecard int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.StorageCard create(int argStoragecard) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.StorageCard
 * @param argStoragecard int
 * @param argResource java.lang.Integer
 * @param argDateOpened java.sql.Date
 * @param argOwner java.lang.Integer
 * @param argPolicy java.lang.String
 * @param argClosed java.lang.Boolean
 * @param argQty java.math.BigDecimal
 * @param argPrice java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.StorageCard create(int argStoragecard, java.lang.Integer argResource, 
	java.sql.Date argDateOpened, java.lang.Integer argOwner, java.lang.String argPolicy, 
	java.lang.Boolean argClosed, java.math.BigDecimal argQty, java.math.BigDecimal argPrice) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findBadAgregatesByDocument(Integer document) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByMainAgregateOrderByResourceAsc(Integer argAgregate) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByPartie(
    String argParstart,
    String argParend
)  throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByPartyMaskOrderByPartyAsc(
    String argPartymask
)  throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.StorageCard
 * @param key com.hps.july.persistence.StorageCardKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.StorageCard findByPrimaryKey(com.hps.july.persistence.StorageCardKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByResourceQBE( Integer argResourceSubType, Integer argStorage, String argPolicy,
	String argSerial, String argParty, Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.StorageCard
 * @param key com.hps.july.persistence.StorageCardKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.StorageCard findBySerial( String argSerial ) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findBySerialMaskOrderBySerialAsc(
    String argSermask
)  throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findBySerie(
    String argSerstart,
    String argSerend
)  throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByStorageAndI13nResourceSetAct( Integer argStorage, Integer act ) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByStorageNotAgregatedOrderByResourceAsc(Integer argStorage) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByStorageNotInDoc(
    Integer storageplace,
    Boolean useAgregate, Integer agregate,
    Integer document,
    Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.StorageCard
 * @param key com.hps.july.persistence.StorageCardKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.StorageCard findByStorageOwnerParty( Integer argStorage, Integer argOwner, String argParty ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.StorageCard
 * @param key com.hps.july.persistence.StorageCardKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.StorageCard findByStorageOwnerResource( Integer argStorage, Integer argOwner, Integer argResource ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByStorageResource(Integer storage, Integer resource) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.StorageCard
 * @param key com.hps.july.persistence.StorageCardKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.StorageCard findClosedBySerialInStorage( String argSerial, Integer argStorage ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findCurrentStorageCardByLastDocument(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.StorageCard
 * @param key com.hps.july.persistence.StorageCardKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.StorageCard findPosibillity2IgnoreI13nDate( Integer argCard, Integer argDocument ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findStorageCardByContract(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findStorageCardByCurrentstorage(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findStorageCardByOwner(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findStorageCardByQBE(
    Integer storageplace,
    Boolean isOwner, Integer owner,
    Boolean isResourceset, Integer resourceset,
    Boolean isResource, Integer resource,
    Boolean isSubType, Integer resourceSubType,
    Boolean isModel, String model, /* match строчка */
    Boolean isName, String name, /* match строчка */
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Integer order
)  throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findStorageCardByQBE2(
    Boolean isSubType, Integer resourceSubType,
    Boolean isModel, String model, /* match строчка */
    Boolean isName, String name, /* match строчка */
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Integer connected, Integer owner,
    Integer order
)  throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findStorageCardByQBE3(
    Integer storageplace,
    Boolean isOwner, Integer owner,
    Boolean isResourceset, Integer resourceset,
    Boolean isResource, Integer resource,
    Boolean isSubType, Integer resourceSubType,
    Boolean isModel, String model, /* match строчка */
    Boolean isName, String name, /* match строчка */
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Boolean onlyWithoutParts,
    Integer brokenType,
    Integer documentKey,
    Boolean useExcludeFilter, Integer storageCard,
    Boolean usePolicy, String policy,
    Integer order
)  throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findStorageCardByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
	public com.hps.july.persistence.StorageCard findBySerialResource(java.lang.String argSerial, java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
