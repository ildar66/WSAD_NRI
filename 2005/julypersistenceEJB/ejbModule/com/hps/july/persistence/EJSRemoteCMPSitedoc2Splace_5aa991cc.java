package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPSitedoc2Splace_5aa991cc
 */
public class EJSRemoteCMPSitedoc2Splace_5aa991cc extends EJSWrapper implements Sitedoc2Splace {
	/**
	 * EJSRemoteCMPSitedoc2Splace_5aa991cc
	 */
	public EJSRemoteCMPSitedoc2Splace_5aa991cc() throws java.rmi.RemoteException {
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
	 * getSiteDoc
	 */
	public com.hps.july.persistence.SiteDoc getSiteDoc() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.SiteDoc _EJS_result = null;
		try {
			com.hps.july.persistence.Sitedoc2SplaceBean beanRef = (com.hps.july.persistence.Sitedoc2SplaceBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getSiteDoc();
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
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSiteDocKey
	 */
	public com.hps.july.persistence.SiteDocKey getSiteDocKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.SiteDocKey _EJS_result = null;
		try {
			com.hps.july.persistence.Sitedoc2SplaceBean beanRef = (com.hps.july.persistence.Sitedoc2SplaceBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getSiteDocKey();
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
	 * getStoragePlace
	 */
	public com.hps.july.persistence.StoragePlace getStoragePlace() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StoragePlace _EJS_result = null;
		try {
			com.hps.july.persistence.Sitedoc2SplaceBean beanRef = (com.hps.july.persistence.Sitedoc2SplaceBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getStoragePlace();
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
	 * getStoragePlaceKey
	 */
	public com.hps.july.persistence.StoragePlaceKey getStoragePlaceKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StoragePlaceKey _EJS_result = null;
		try {
			com.hps.july.persistence.Sitedoc2SplaceBean beanRef = (com.hps.july.persistence.Sitedoc2SplaceBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getStoragePlaceKey();
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
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSiteDoc_sitedoc
	 */
	public java.lang.Integer getSiteDoc_sitedoc() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.Sitedoc2SplaceBean beanRef = (com.hps.july.persistence.Sitedoc2SplaceBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getSiteDoc_sitedoc();
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
	 * getStoragePlace_storageplace
	 */
	public java.lang.Integer getStoragePlace_storageplace() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.Sitedoc2SplaceBean beanRef = (com.hps.july.persistence.Sitedoc2SplaceBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getStoragePlace_storageplace();
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
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Hashtable _EJS_result = null;
		try {
			com.hps.july.persistence.Sitedoc2SplaceBean beanRef = (com.hps.july.persistence.Sitedoc2SplaceBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef._copyFromEJB();
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
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable arg0) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.Sitedoc2SplaceBean beanRef = (com.hps.july.persistence.Sitedoc2SplaceBean)container.preInvoke(this, 7, _EJS_s);
			beanRef._copyToEJB(arg0);
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
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
