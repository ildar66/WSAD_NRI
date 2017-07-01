package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * StorageCardFactory
 * @generated
 */
public class StorageCardFactory extends AbstractEJBFactory {
	/**
	 * StorageCardFactory
	 * @generated
	 */
	public StorageCardFactory() {
		super();
	}
	/**
	 * _acquireStorageCardHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.StorageCardHome _acquireStorageCardHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.StorageCardHome) _acquireEJBHome();
	}
	/**
	 * acquireStorageCardHome
	 * @generated
	 */
	public com.hps.july.persistence.StorageCardHome acquireStorageCardHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.StorageCardHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/StorageCard";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.StorageCardHome.class;
	}
	/**
	 * resetStorageCardHome
	 * @generated
	 */
	public void resetStorageCardHome() {
		resetEJBHome();
	}
	/**
	 * setStorageCardHome
	 * @generated
	 */
	public void setStorageCardHome(
		com.hps.july.persistence.StorageCardHome home) {
		setEJBHome(home);
	}
	/**
	 * findStorageCardByCurrentstorage
	 * @generated
	 */
	public java.util.Enumeration findStorageCardByCurrentstorage(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findStorageCardByCurrentstorage(inKey);
	}
	/**
	 * findByResourceQBE
	 * @generated
	 */
	public java.util.Enumeration findByResourceQBE(
		java.lang.Integer argResourceSubType,
		java.lang.Integer argStorage,
		java.lang.String argPolicy,
		java.lang.String argSerial,
		java.lang.String argParty,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findByResourceQBE(
			argResourceSubType,
			argStorage,
			argPolicy,
			argSerial,
			argParty,
			order);
	}
	/**
	 * findByMainAgregateOrderByResourceAsc
	 * @generated
	 */
	public java.util.Enumeration findByMainAgregateOrderByResourceAsc(
		java.lang.Integer argAgregate)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findByMainAgregateOrderByResourceAsc(
			argAgregate);
	}
	/**
	 * findByStorageResource
	 * @generated
	 */
	public java.util.Enumeration findByStorageResource(
		java.lang.Integer storage,
		java.lang.Integer resource)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findByStorageResource(
			storage,
			resource);
	}
	/**
	 * findByStorageNotAgregatedOrderByResourceAsc
	 * @generated
	 */
	public java.util.Enumeration findByStorageNotAgregatedOrderByResourceAsc(
		java.lang.Integer argStorage)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome()
			.findByStorageNotAgregatedOrderByResourceAsc(
			argStorage);
	}
	/**
	 * findBadAgregatesByDocument
	 * @generated
	 */
	public java.util.Enumeration findBadAgregatesByDocument(
		java.lang.Integer document)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findBadAgregatesByDocument(document);
	}
	/**
	 * findStorageCardByResource
	 * @generated
	 */
	public java.util.Enumeration findStorageCardByResource(
		com.hps.july.persistence.ResourceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findStorageCardByResource(inKey);
	}
	/**
	 * findByStorageOwnerParty
	 * @generated
	 */
	public com.hps.july.persistence.StorageCard findByStorageOwnerParty(
		java.lang.Integer argStorage,
		java.lang.Integer argOwner,
		java.lang.String argParty)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findByStorageOwnerParty(
			argStorage,
			argOwner,
			argParty);
	}
	/**
	 * findByPartyMaskOrderByPartyAsc
	 * @generated
	 */
	public java.util.Enumeration findByPartyMaskOrderByPartyAsc(
		java.lang.String argPartymask)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findByPartyMaskOrderByPartyAsc(
			argPartymask);
	}
	/**
	 * findStorageCardByQBE3
	 * @generated
	 */
	public java.util.Enumeration findStorageCardByQBE3(
		java.lang.Integer storageplace,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Boolean isResourceset,
		java.lang.Integer resourceset,
		java.lang.Boolean isResource,
		java.lang.Integer resource,
		java.lang.Boolean isSubType,
		java.lang.Integer resourceSubType,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Boolean isManufacturer,
		java.lang.Integer manufacturer,
		java.lang.Boolean isManucode,
		java.lang.String manucode,
		java.lang.Boolean onlyWithoutParts,
		java.lang.Integer brokenType,
		java.lang.Integer documentKey,
		java.lang.Boolean useExcludeFilter,
		java.lang.Integer storageCard,
		java.lang.Boolean usePolicy,
		java.lang.String policy,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findStorageCardByQBE3(
			storageplace,
			isOwner,
			owner,
			isResourceset,
			resourceset,
			isResource,
			resource,
			isSubType,
			resourceSubType,
			isModel,
			model,
			isName,
			name,
			isManufacturer,
			manufacturer,
			isManucode,
			manucode,
			onlyWithoutParts,
			brokenType,
			documentKey,
			useExcludeFilter,
			storageCard,
			usePolicy,
			policy,
			order);
	}
	/**
	 * findByPartie
	 * @generated
	 */
	public java.util.Enumeration findByPartie(
		java.lang.String argParstart,
		java.lang.String argParend)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findByPartie(argParstart, argParend);
	}
	/**
	 * findByStorageOwnerResource
	 * @generated
	 */
	public com.hps.july.persistence.StorageCard findByStorageOwnerResource(
		java.lang.Integer argStorage,
		java.lang.Integer argOwner,
		java.lang.Integer argResource)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findByStorageOwnerResource(
			argStorage,
			argOwner,
			argResource);
	}
	/**
	 * findStorageCardByOwner
	 * @generated
	 */
	public java.util.Enumeration findStorageCardByOwner(
		com.hps.july.persistence.OrganizationKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findStorageCardByOwner(inKey);
	}
	/**
	 * findBySerie
	 * @generated
	 */
	public java.util.Enumeration findBySerie(
		java.lang.String argSerstart,
		java.lang.String argSerend)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findBySerie(argSerstart, argSerend);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.StorageCard create(
		int argStoragecard,
		java.lang.Integer argResource,
		java.sql.Date argDateOpened,
		java.lang.Integer argOwner,
		java.lang.String argPolicy,
		java.lang.Boolean argClosed,
		java.math.BigDecimal argQty,
		java.math.BigDecimal argPrice)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireStorageCardHome().create(
			argStoragecard,
			argResource,
			argDateOpened,
			argOwner,
			argPolicy,
			argClosed,
			argQty,
			argPrice);
	}
	/**
	 * findPosibillity2IgnoreI13nDate
	 * @generated
	 */
	public com.hps.july.persistence.StorageCard findPosibillity2IgnoreI13nDate(
		java.lang.Integer argCard,
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findPosibillity2IgnoreI13nDate(
			argCard,
			argDocument);
	}
	/**
	 * findStorageCardByQBE
	 * @generated
	 */
	public java.util.Enumeration findStorageCardByQBE(
		java.lang.Integer storageplace,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Boolean isResourceset,
		java.lang.Integer resourceset,
		java.lang.Boolean isResource,
		java.lang.Integer resource,
		java.lang.Boolean isSubType,
		java.lang.Integer resourceSubType,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Boolean isManufacturer,
		java.lang.Integer manufacturer,
		java.lang.Boolean isManucode,
		java.lang.String manucode,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findStorageCardByQBE(
			storageplace,
			isOwner,
			owner,
			isResourceset,
			resourceset,
			isResource,
			resource,
			isSubType,
			resourceSubType,
			isModel,
			model,
			isName,
			name,
			isManufacturer,
			manufacturer,
			isManucode,
			manucode,
			order);
	}
	/**
	 * findByStorageAndI13nResourceSetAct
	 * @generated
	 */
	public java.util.Enumeration findByStorageAndI13nResourceSetAct(
		java.lang.Integer argStorage,
		java.lang.Integer act)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findByStorageAndI13nResourceSetAct(
			argStorage,
			act);
	}
	/**
	 * findStorageCardByContract
	 * @generated
	 */
	public java.util.Enumeration findStorageCardByContract(
		com.hps.july.persistence.DocumentKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findStorageCardByContract(inKey);
	}
	/**
	 * findByStorageNotInDoc
	 * @generated
	 */
	public java.util.Enumeration findByStorageNotInDoc(
		java.lang.Integer storageplace,
		java.lang.Boolean useAgregate,
		java.lang.Integer agregate,
		java.lang.Integer document,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findByStorageNotInDoc(
			storageplace,
			useAgregate,
			agregate,
			document,
			order);
	}
	/**
	 * findBySerialMaskOrderBySerialAsc
	 * @generated
	 */
	public java.util.Enumeration findBySerialMaskOrderBySerialAsc(
		java.lang.String argSermask)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findBySerialMaskOrderBySerialAsc(
			argSermask);
	}
	/**
	 * findCurrentStorageCardByLastDocument
	 * @generated
	 */
	public java.util.Enumeration findCurrentStorageCardByLastDocument(
		com.hps.july.persistence.DocumentKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findCurrentStorageCardByLastDocument(
			inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.StorageCard findByPrimaryKey(
		com.hps.july.persistence.StorageCardKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findByPrimaryKey(key);
	}
	/**
	 * findBySerial
	 * @generated
	 */
	public com.hps.july.persistence.StorageCard findBySerial(
		java.lang.String argSerial)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findBySerial(argSerial);
	}
	/**
	 * findStorageCardByQBE2
	 * @generated
	 */
	public java.util.Enumeration findStorageCardByQBE2(
		java.lang.Boolean isSubType,
		java.lang.Integer resourceSubType,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Boolean isManufacturer,
		java.lang.Integer manufacturer,
		java.lang.Boolean isManucode,
		java.lang.String manucode,
		java.lang.Integer connected,
		java.lang.Integer owner,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findStorageCardByQBE2(
			isSubType,
			resourceSubType,
			isModel,
			model,
			isName,
			name,
			isManufacturer,
			manufacturer,
			isManucode,
			manucode,
			connected,
			owner,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.StorageCard create(int argStoragecard)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireStorageCardHome().create(argStoragecard);
	}
	/**
	 * findClosedBySerialInStorage
	 * @generated
	 */
	public com.hps.july.persistence.StorageCard findClosedBySerialInStorage(
		java.lang.String argSerial,
		java.lang.Integer argStorage)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireStorageCardHome().findClosedBySerialInStorage(
			argSerial,
			argStorage);
	}
	/**
	 * findBySerialResource
	 * @generated
	 */
	public com.hps.july.persistence.StorageCard findBySerialResource(
		java.lang.String argSerial,
		java.lang.Integer argResource)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireStorageCardHome().findBySerialResource(
			argSerial,
			argResource);
	}
}
