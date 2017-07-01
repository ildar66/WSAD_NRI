package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPStorageCardHomeBean_d765aaca
 */
public class EJSCMPStorageCardHomeBean_d765aaca extends EJSHome {
	/**
	 * EJSCMPStorageCardHomeBean_d765aaca
	 */
	public EJSCMPStorageCardHomeBean_d765aaca() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.StorageCard postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.StorageCard) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findStorageCardByCurrentstorage
	 */
	public java.util.Enumeration findStorageCardByCurrentstorage(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findStorageCardByCurrentstorage(inKey));	}
	/**
	 * findByResourceQBE
	 */
	public java.util.Enumeration findByResourceQBE(java.lang.Integer argResourceSubType, java.lang.Integer argStorage, java.lang.String argPolicy, java.lang.String argSerial, java.lang.String argParty, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findByResourceQBE(argResourceSubType, argStorage, argPolicy, argSerial, argParty, order));	}
	/**
	 * findByMainAgregateOrderByResourceAsc
	 */
	public java.util.Enumeration findByMainAgregateOrderByResourceAsc(java.lang.Integer argAgregate) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findByMainAgregateOrderByResourceAsc(argAgregate));	}
	/**
	 * findByStorageResource
	 */
	public java.util.Enumeration findByStorageResource(java.lang.Integer storage, java.lang.Integer resource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findByStorageResource(storage, resource));	}
	/**
	 * findByStorageNotAgregatedOrderByResourceAsc
	 */
	public java.util.Enumeration findByStorageNotAgregatedOrderByResourceAsc(java.lang.Integer argStorage) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findByStorageNotAgregatedOrderByResourceAsc(argStorage));	}
	/**
	 * findBadAgregatesByDocument
	 */
	public java.util.Enumeration findBadAgregatesByDocument(java.lang.Integer document) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findBadAgregatesByDocument(document));	}
	/**
	 * findStorageCardByResource
	 */
	public java.util.Enumeration findStorageCardByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findStorageCardByResource(inKey));	}
	/**
	 * findByStorageOwnerParty
	 */
	public com.hps.july.persistence.StorageCard findByStorageOwnerParty(java.lang.Integer argStorage, java.lang.Integer argOwner, java.lang.String argParty) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPStorageCardBean_d765aaca)persister).findByStorageOwnerParty(argStorage, argOwner, argParty);	}
	/**
	 * findByPartyMaskOrderByPartyAsc
	 */
	public java.util.Enumeration findByPartyMaskOrderByPartyAsc(java.lang.String argPartymask) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findByPartyMaskOrderByPartyAsc(argPartymask));	}
	/**
	 * findStorageCardByQBE3
	 */
	public java.util.Enumeration findStorageCardByQBE3(java.lang.Integer storageplace, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResourceset, java.lang.Integer resourceset, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Boolean onlyWithoutParts, java.lang.Integer brokenType, java.lang.Integer documentKey, java.lang.Boolean useExcludeFilter, java.lang.Integer storageCard, java.lang.Boolean usePolicy, java.lang.String policy, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findStorageCardByQBE3(storageplace, isOwner, owner, isResourceset, resourceset, isResource, resource, isSubType, resourceSubType, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, onlyWithoutParts, brokenType, documentKey, useExcludeFilter, storageCard, usePolicy, policy, order));	}
	/**
	 * findByPartie
	 */
	public java.util.Enumeration findByPartie(java.lang.String argParstart, java.lang.String argParend) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findByPartie(argParstart, argParend));	}
	/**
	 * findByStorageOwnerResource
	 */
	public com.hps.july.persistence.StorageCard findByStorageOwnerResource(java.lang.Integer argStorage, java.lang.Integer argOwner, java.lang.Integer argResource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPStorageCardBean_d765aaca)persister).findByStorageOwnerResource(argStorage, argOwner, argResource);	}
	/**
	 * findStorageCardByOwner
	 */
	public java.util.Enumeration findStorageCardByOwner(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findStorageCardByOwner(inKey));	}
	/**
	 * findBySerie
	 */
	public java.util.Enumeration findBySerie(java.lang.String argSerstart, java.lang.String argSerend) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findBySerie(argSerstart, argSerend));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.StorageCard create(int argStoragecard, java.lang.Integer argResource, java.sql.Date argDateOpened, java.lang.Integer argOwner, java.lang.String argPolicy, java.lang.Boolean argClosed, java.math.BigDecimal argQty, java.math.BigDecimal argPrice) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.StorageCard _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.StorageCardBean bean = (com.hps.july.persistence.StorageCardBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStoragecard, argResource, argDateOpened, argOwner, argPolicy, argClosed, argQty, argPrice);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBySerialResource
	 */
	public com.hps.july.persistence.StorageCard findBySerialResource(java.lang.String argSerial, java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPStorageCardBean_d765aaca)persister).findBySerialResource(argSerial, argResource);	}
	/**
	 * findPosibillity2IgnoreI13nDate
	 */
	public com.hps.july.persistence.StorageCard findPosibillity2IgnoreI13nDate(java.lang.Integer argCard, java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPStorageCardBean_d765aaca)persister).findPosibillity2IgnoreI13nDate(argCard, argDocument);	}
	/**
	 * findStorageCardByQBE
	 */
	public java.util.Enumeration findStorageCardByQBE(java.lang.Integer storageplace, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResourceset, java.lang.Integer resourceset, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findStorageCardByQBE(storageplace, isOwner, owner, isResourceset, resourceset, isResource, resource, isSubType, resourceSubType, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, order));	}
	/**
	 * findByStorageAndI13nResourceSetAct
	 */
	public java.util.Enumeration findByStorageAndI13nResourceSetAct(java.lang.Integer argStorage, java.lang.Integer act) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findByStorageAndI13nResourceSetAct(argStorage, act));	}
	/**
	 * findStorageCardByContract
	 */
	public java.util.Enumeration findStorageCardByContract(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findStorageCardByContract(inKey));	}
	/**
	 * findByStorageNotInDoc
	 */
	public java.util.Enumeration findByStorageNotInDoc(java.lang.Integer storageplace, java.lang.Boolean useAgregate, java.lang.Integer agregate, java.lang.Integer document, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findByStorageNotInDoc(storageplace, useAgregate, agregate, document, order));	}
	/**
	 * findBySerialMaskOrderBySerialAsc
	 */
	public java.util.Enumeration findBySerialMaskOrderBySerialAsc(java.lang.String argSermask) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findBySerialMaskOrderBySerialAsc(argSermask));	}
	/**
	 * findCurrentStorageCardByLastDocument
	 */
	public java.util.Enumeration findCurrentStorageCardByLastDocument(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findCurrentStorageCardByLastDocument(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.StorageCard findByPrimaryKey(com.hps.july.persistence.StorageCardKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPStorageCardBean_d765aaca) persister).findByPrimaryKey(key);
	}
	/**
	 * findBySerial
	 */
	public com.hps.july.persistence.StorageCard findBySerial(java.lang.String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPStorageCardBean_d765aaca)persister).findBySerial(argSerial);	}
	/**
	 * findStorageCardByQBE2
	 */
	public java.util.Enumeration findStorageCardByQBE2(java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer owner, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderStorageCardBean)persister).findStorageCardByQBE2(isSubType, resourceSubType, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, connected, owner, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.StorageCard create(int argStoragecard) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.StorageCard _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.StorageCardBean bean = (com.hps.july.persistence.StorageCardBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStoragecard);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argStoragecard);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findClosedBySerialInStorage
	 */
	public com.hps.july.persistence.StorageCard findClosedBySerialInStorage(java.lang.String argSerial, java.lang.Integer argStorage) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPStorageCardBean_d765aaca)persister).findClosedBySerialInStorage(argSerial, argStorage);	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.StorageCardBean tmpEJB = (com.hps.july.persistence.StorageCardBean) generalEJB;
		com.hps.july.persistence.StorageCardKey keyClass = new com.hps.july.persistence.StorageCardKey();
		keyClass.storagecard = tmpEJB.storagecard;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.StorageCardKey keyFromFields(int f0) {
		com.hps.july.persistence.StorageCardKey keyClass = new com.hps.july.persistence.StorageCardKey();
		keyClass.storagecard = f0;
		return keyClass;
	}
}
