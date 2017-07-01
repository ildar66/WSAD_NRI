package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPStorageCardHome_d765aaca
 */
public class EJSRemoteCMPStorageCardHome_d765aaca extends EJSWrapper implements com.hps.july.persistence.StorageCardHome {
	/**
	 * EJSRemoteCMPStorageCardHome_d765aaca
	 */
	public EJSRemoteCMPStorageCardHome_d765aaca() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return container.getEJSDeployedSupport(this);
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		container.putEJSDeployedSupport(support);
		return;
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.StorageCard create(int argStoragecard) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCard _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argStoragecard);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.StorageCard create(int argStoragecard, java.lang.Integer argResource, java.sql.Date argDateOpened, java.lang.Integer argOwner, java.lang.String argPolicy, java.lang.Boolean argClosed, java.math.BigDecimal argQty, java.math.BigDecimal argPrice) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCard _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(argStoragecard, argResource, argDateOpened, argOwner, argPolicy, argClosed, argQty, argPrice);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.StorageCard findByPrimaryKey(com.hps.july.persistence.StorageCardKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCard _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.findByPrimaryKey(key);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBySerial
	 */
	public com.hps.july.persistence.StorageCard findBySerial(java.lang.String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCard _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findBySerial(argSerial);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBySerialResource
	 */
	public com.hps.july.persistence.StorageCard findBySerialResource(java.lang.String argSerial, java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCard _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findBySerialResource(argSerial, argResource);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByStorageOwnerParty
	 */
	public com.hps.july.persistence.StorageCard findByStorageOwnerParty(java.lang.Integer argStorage, java.lang.Integer argOwner, java.lang.String argParty) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCard _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findByStorageOwnerParty(argStorage, argOwner, argParty);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByStorageOwnerResource
	 */
	public com.hps.july.persistence.StorageCard findByStorageOwnerResource(java.lang.Integer argStorage, java.lang.Integer argOwner, java.lang.Integer argResource) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCard _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findByStorageOwnerResource(argStorage, argOwner, argResource);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findClosedBySerialInStorage
	 */
	public com.hps.july.persistence.StorageCard findClosedBySerialInStorage(java.lang.String argSerial, java.lang.Integer argStorage) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCard _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.findClosedBySerialInStorage(argSerial, argStorage);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPosibillity2IgnoreI13nDate
	 */
	public com.hps.july.persistence.StorageCard findPosibillity2IgnoreI13nDate(java.lang.Integer argCard, java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCard _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.findPosibillity2IgnoreI13nDate(argCard, argDocument);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBadAgregatesByDocument
	 */
	public java.util.Enumeration findBadAgregatesByDocument(java.lang.Integer document) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.findBadAgregatesByDocument(document);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByMainAgregateOrderByResourceAsc
	 */
	public java.util.Enumeration findByMainAgregateOrderByResourceAsc(java.lang.Integer argAgregate) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.findByMainAgregateOrderByResourceAsc(argAgregate);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPartie
	 */
	public java.util.Enumeration findByPartie(java.lang.String argParstart, java.lang.String argParend) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.findByPartie(argParstart, argParend);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPartyMaskOrderByPartyAsc
	 */
	public java.util.Enumeration findByPartyMaskOrderByPartyAsc(java.lang.String argPartymask) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.findByPartyMaskOrderByPartyAsc(argPartymask);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByResourceQBE
	 */
	public java.util.Enumeration findByResourceQBE(java.lang.Integer argResourceSubType, java.lang.Integer argStorage, java.lang.String argPolicy, java.lang.String argSerial, java.lang.String argParty, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.findByResourceQBE(argResourceSubType, argStorage, argPolicy, argSerial, argParty, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBySerialMaskOrderBySerialAsc
	 */
	public java.util.Enumeration findBySerialMaskOrderBySerialAsc(java.lang.String argSermask) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.findBySerialMaskOrderBySerialAsc(argSermask);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBySerie
	 */
	public java.util.Enumeration findBySerie(java.lang.String argSerstart, java.lang.String argSerend) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.findBySerie(argSerstart, argSerend);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByStorageAndI13nResourceSetAct
	 */
	public java.util.Enumeration findByStorageAndI13nResourceSetAct(java.lang.Integer argStorage, java.lang.Integer act) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.findByStorageAndI13nResourceSetAct(argStorage, act);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByStorageNotAgregatedOrderByResourceAsc
	 */
	public java.util.Enumeration findByStorageNotAgregatedOrderByResourceAsc(java.lang.Integer argStorage) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.findByStorageNotAgregatedOrderByResourceAsc(argStorage);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByStorageNotInDoc
	 */
	public java.util.Enumeration findByStorageNotInDoc(java.lang.Integer storageplace, java.lang.Boolean useAgregate, java.lang.Integer agregate, java.lang.Integer document, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.findByStorageNotInDoc(storageplace, useAgregate, agregate, document, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByStorageResource
	 */
	public java.util.Enumeration findByStorageResource(java.lang.Integer storage, java.lang.Integer resource) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef.findByStorageResource(storage, resource);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findCurrentStorageCardByLastDocument
	 */
	public java.util.Enumeration findCurrentStorageCardByLastDocument(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 20, _EJS_s);
			_EJS_result = beanRef.findCurrentStorageCardByLastDocument(inKey);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findStorageCardByContract
	 */
	public java.util.Enumeration findStorageCardByContract(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 21, _EJS_s);
			_EJS_result = beanRef.findStorageCardByContract(inKey);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findStorageCardByCurrentstorage
	 */
	public java.util.Enumeration findStorageCardByCurrentstorage(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 22, _EJS_s);
			_EJS_result = beanRef.findStorageCardByCurrentstorage(inKey);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 22, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findStorageCardByOwner
	 */
	public java.util.Enumeration findStorageCardByOwner(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 23, _EJS_s);
			_EJS_result = beanRef.findStorageCardByOwner(inKey);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findStorageCardByQBE
	 */
	public java.util.Enumeration findStorageCardByQBE(java.lang.Integer storageplace, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResourceset, java.lang.Integer resourceset, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 24, _EJS_s);
			_EJS_result = beanRef.findStorageCardByQBE(storageplace, isOwner, owner, isResourceset, resourceset, isResource, resource, isSubType, resourceSubType, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 24, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findStorageCardByQBE2
	 */
	public java.util.Enumeration findStorageCardByQBE2(java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer owner, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 25, _EJS_s);
			_EJS_result = beanRef.findStorageCardByQBE2(isSubType, resourceSubType, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, connected, owner, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 25, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findStorageCardByQBE3
	 */
	public java.util.Enumeration findStorageCardByQBE3(java.lang.Integer storageplace, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResourceset, java.lang.Integer resourceset, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isSubType, java.lang.Integer resourceSubType, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Boolean onlyWithoutParts, java.lang.Integer brokenType, java.lang.Integer documentKey, java.lang.Boolean useExcludeFilter, java.lang.Integer storageCard, java.lang.Boolean usePolicy, java.lang.String policy, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 26, _EJS_s);
			_EJS_result = beanRef.findStorageCardByQBE3(storageplace, isOwner, owner, isResourceset, resourceset, isResource, resource, isSubType, resourceSubType, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, onlyWithoutParts, brokenType, documentKey, useExcludeFilter, storageCard, usePolicy, policy, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 26, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findStorageCardByResource
	 */
	public java.util.Enumeration findStorageCardByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 27, _EJS_s);
			_EJS_result = beanRef.findStorageCardByResource(inKey);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 27, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 28, _EJS_s);
			_EJS_result = beanRef.getEJBMetaData();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 28, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getHomeHandle
	 */
	public javax.ejb.HomeHandle getHomeHandle() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.HomeHandle _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 29, _EJS_s);
			_EJS_result = beanRef.getHomeHandle();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 29, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * remove
	 */
	public void remove(java.lang.Object arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 30, _EJS_s);
			beanRef.remove(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 30, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * remove
	 */
	public void remove(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca beanRef = (com.hps.july.persistence.EJSCMPStorageCardHomeBean_d765aaca)container.preInvoke(this, 31, _EJS_s);
			beanRef.remove(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 31, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
