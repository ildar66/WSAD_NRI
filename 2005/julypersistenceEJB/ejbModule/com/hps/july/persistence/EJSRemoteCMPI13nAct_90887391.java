package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPI13nAct_90887391
 */
public class EJSRemoteCMPI13nAct_90887391 extends EJSWrapper implements I13nAct {
	/**
	 * EJSRemoteCMPI13nAct_90887391
	 */
	public EJSRemoteCMPI13nAct_90887391() throws java.rmi.RemoteException {
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
	 * getIsautodoc
	 */
	public boolean getIsautodoc() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getIsautodoc();
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
	 * getNeedapprove
	 */
	public boolean getNeedapprove() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getNeedapprove();
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
	 * getShowtouser
	 */
	public boolean getShowtouser() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getShowtouser();
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
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContragent
	 */
	public com.hps.july.persistence.Organization getContragent() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Organization _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getContragent();
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
	 * getOwner
	 */
	public com.hps.july.persistence.Organization getOwner() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Organization _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getOwner();
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getContragentKey
	 */
	public com.hps.july.persistence.OrganizationKey getContragentKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.OrganizationKey _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getContragentKey();
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
	 * getOwnerKey
	 */
	public com.hps.july.persistence.OrganizationKey getOwnerKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.OrganizationKey _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.getOwnerKey();
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
	 * getAgregate
	 */
	public com.hps.july.persistence.StorageCard getAgregate() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCard _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.getAgregate();
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
	 * getAgregateKey
	 */
	public com.hps.july.persistence.StorageCardKey getAgregateKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StorageCardKey _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.getAgregateKey();
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
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getFrom
	 */
	public com.hps.july.persistence.StoragePlace getFrom() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StoragePlace _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.getFrom();
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
	 * getTo
	 */
	public com.hps.july.persistence.StoragePlace getTo() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StoragePlace _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.getTo();
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
	 * getFromKey
	 */
	public com.hps.july.persistence.StoragePlaceKey getFromKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StoragePlaceKey _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.getFromKey();
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
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getToKey
	 */
	public com.hps.july.persistence.StoragePlaceKey getToKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StoragePlaceKey _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.getToKey();
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
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getStorageManager
	 */
	public com.hps.july.persistence.Worker getStorageManager() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Worker _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.getStorageManager();
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
	 * getTechStuff
	 */
	public com.hps.july.persistence.Worker getTechStuff() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Worker _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.getTechStuff();
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
	 * getStorageManagerKey
	 */
	public com.hps.july.persistence.WorkerKey getStorageManagerKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.WorkerKey _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.getStorageManagerKey();
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
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getTechStuffKey
	 */
	public com.hps.july.persistence.WorkerKey getTechStuffKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.WorkerKey _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.getTechStuffKey();
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
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBlankindex
	 */
	public int getBlankindex() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.getBlankindex();
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
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDocument
	 */
	public int getDocument() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.getDocument();
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
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getRecalcagrprice
	 */
	public java.lang.Boolean getRecalcagrprice() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef.getRecalcagrprice();
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
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getOperator
	 */
	public java.lang.Integer getOperator() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 20, _EJS_s);
			_EJS_result = beanRef.getOperator();
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
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getParentdocument
	 */
	public java.lang.Integer getParentdocument() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 21, _EJS_s);
			_EJS_result = beanRef.getParentdocument();
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
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProjectid
	 */
	public java.lang.Integer getProjectid() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 22, _EJS_s);
			_EJS_result = beanRef.getProjectid();
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
				container.postInvoke(this, 22, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getTo2
	 */
	public java.lang.Integer getTo2() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 23, _EJS_s);
			_EJS_result = beanRef.getTo2();
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
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getVisualtype
	 */
	public java.lang.Integer getVisualtype() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 24, _EJS_s);
			_EJS_result = beanRef.getVisualtype();
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
				container.postInvoke(this, 24, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAgregateresource
	 */
	public java.lang.Integer getAgregateresource() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 25, _EJS_s);
			_EJS_result = beanRef.getAgregateresource();
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
				container.postInvoke(this, 25, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBlanknumber
	 */
	public java.lang.String getBlanknumber() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 26, _EJS_s);
			_EJS_result = beanRef.getBlanknumber();
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
				container.postInvoke(this, 26, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDocumentState
	 */
	public java.lang.String getDocumentState() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 27, _EJS_s);
			_EJS_result = beanRef.getDocumentState();
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
				container.postInvoke(this, 27, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getInsuranceact
	 */
	public java.lang.String getInsuranceact() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 28, _EJS_s);
			_EJS_result = beanRef.getInsuranceact();
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
	 * getInsuranseMan
	 */
	public java.lang.String getInsuranseMan() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 29, _EJS_s);
			_EJS_result = beanRef.getInsuranseMan();
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
	 * getPrjstatus
	 */
	public java.lang.String getPrjstatus() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 30, _EJS_s);
			_EJS_result = beanRef.getPrjstatus();
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
				container.postInvoke(this, 30, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAgregateserial
	 */
	public java.lang.String getAgregateserial() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 31, _EJS_s);
			_EJS_result = beanRef.getAgregateserial();
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
				container.postInvoke(this, 31, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBlankdate
	 */
	public java.sql.Date getBlankdate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 32, _EJS_s);
			_EJS_result = beanRef.getBlankdate();
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
				container.postInvoke(this, 32, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getInsurancedate
	 */
	public java.sql.Date getInsurancedate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 33, _EJS_s);
			_EJS_result = beanRef.getInsurancedate();
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
				container.postInvoke(this, 33, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCardTrack
	 */
	public java.util.Enumeration getCardTrack() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 34, _EJS_s);
			_EJS_result = beanRef.getCardTrack();
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
				container.postInvoke(this, 34, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCurrentStorageCard
	 */
	public java.util.Enumeration getCurrentStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 35, _EJS_s);
			_EJS_result = beanRef.getCurrentStorageCard();
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
				container.postInvoke(this, 35, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDocumentPosition
	 */
	public java.util.Enumeration getDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 36, _EJS_s);
			_EJS_result = beanRef.getDocumentPosition();
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
				container.postInvoke(this, 36, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDocumentsLinkFrom
	 */
	public java.util.Enumeration getDocumentsLinkFrom() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 37, _EJS_s);
			_EJS_result = beanRef.getDocumentsLinkFrom();
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
				container.postInvoke(this, 37, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDocumentsLinkTo
	 */
	public java.util.Enumeration getDocumentsLinkTo() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 38, _EJS_s);
			_EJS_result = beanRef.getDocumentsLinkTo();
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
				container.postInvoke(this, 38, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getStorageCard
	 */
	public java.util.Enumeration getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 39, _EJS_s);
			_EJS_result = beanRef.getStorageCard();
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
				container.postInvoke(this, 39, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getI13nActResourceSet
	 */
	public java.util.Enumeration getI13nActResourceSet() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 40, _EJS_s);
			_EJS_result = beanRef.getI13nActResourceSet();
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
				container.postInvoke(this, 40, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getI13nDateSaving
	 */
	public java.util.Enumeration getI13nDateSaving() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 41, _EJS_s);
			_EJS_result = beanRef.getI13nDateSaving();
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
				container.postInvoke(this, 41, _EJS_s);
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
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 42, _EJS_s);
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
				container.postInvoke(this, 42, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * addCardTrack
	 */
	public void addCardTrack(com.hps.july.persistence.CardTrack aCardTrack) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 43, _EJS_s);
			beanRef.addCardTrack(aCardTrack);
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
				container.postInvoke(this, 43, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addCurrentStorageCard
	 */
	public void addCurrentStorageCard(com.hps.july.persistence.StorageCard aCurrentStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 44, _EJS_s);
			beanRef.addCurrentStorageCard(aCurrentStorageCard);
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
				container.postInvoke(this, 44, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addDocumentPosition
	 */
	public void addDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 45, _EJS_s);
			beanRef.addDocumentPosition(aDocumentPosition);
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
				container.postInvoke(this, 45, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addStorageCard
	 */
	public void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 46, _EJS_s);
			beanRef.addStorageCard(aStorageCard);
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
				container.postInvoke(this, 46, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetContragentKey
	 */
	public void privateSetContragentKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 47, _EJS_s);
			beanRef.privateSetContragentKey(inKey);
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
				container.postInvoke(this, 47, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetFromKey
	 */
	public void privateSetFromKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 48, _EJS_s);
			beanRef.privateSetFromKey(inKey);
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
				container.postInvoke(this, 48, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetOwnerKey
	 */
	public void privateSetOwnerKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 49, _EJS_s);
			beanRef.privateSetOwnerKey(inKey);
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
				container.postInvoke(this, 49, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetStorageManagerKey
	 */
	public void privateSetStorageManagerKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 50, _EJS_s);
			beanRef.privateSetStorageManagerKey(inKey);
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
				container.postInvoke(this, 50, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetToKey
	 */
	public void privateSetToKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 51, _EJS_s);
			beanRef.privateSetToKey(inKey);
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
				container.postInvoke(this, 51, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddCardTrack
	 */
	public void secondaryAddCardTrack(com.hps.july.persistence.CardTrack aCardTrack) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 52, _EJS_s);
			beanRef.secondaryAddCardTrack(aCardTrack);
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
				container.postInvoke(this, 52, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddCurrentStorageCard
	 */
	public void secondaryAddCurrentStorageCard(com.hps.july.persistence.StorageCard aCurrentStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 53, _EJS_s);
			beanRef.secondaryAddCurrentStorageCard(aCurrentStorageCard);
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
				container.postInvoke(this, 53, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddDocumentPosition
	 */
	public void secondaryAddDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 54, _EJS_s);
			beanRef.secondaryAddDocumentPosition(aDocumentPosition);
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
				container.postInvoke(this, 54, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddDocumentsLinkFrom
	 */
	public void secondaryAddDocumentsLinkFrom(com.hps.july.persistence.DocumentsLink aDocumentsLinkFrom) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 55, _EJS_s);
			beanRef.secondaryAddDocumentsLinkFrom(aDocumentsLinkFrom);
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
				container.postInvoke(this, 55, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddDocumentsLinkTo
	 */
	public void secondaryAddDocumentsLinkTo(com.hps.july.persistence.DocumentsLink aDocumentsLinkTo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 56, _EJS_s);
			beanRef.secondaryAddDocumentsLinkTo(aDocumentsLinkTo);
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
				container.postInvoke(this, 56, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddStorageCard
	 */
	public void secondaryAddStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 57, _EJS_s);
			beanRef.secondaryAddStorageCard(aStorageCard);
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
				container.postInvoke(this, 57, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveCardTrack
	 */
	public void secondaryRemoveCardTrack(com.hps.july.persistence.CardTrack aCardTrack) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 58, _EJS_s);
			beanRef.secondaryRemoveCardTrack(aCardTrack);
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
				container.postInvoke(this, 58, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveCurrentStorageCard
	 */
	public void secondaryRemoveCurrentStorageCard(com.hps.july.persistence.StorageCard aCurrentStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 59, _EJS_s);
			beanRef.secondaryRemoveCurrentStorageCard(aCurrentStorageCard);
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
				container.postInvoke(this, 59, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveDocumentPosition
	 */
	public void secondaryRemoveDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 60, _EJS_s);
			beanRef.secondaryRemoveDocumentPosition(aDocumentPosition);
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
				container.postInvoke(this, 60, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveDocumentsLinkFrom
	 */
	public void secondaryRemoveDocumentsLinkFrom(com.hps.july.persistence.DocumentsLink aDocumentsLinkFrom) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 61, _EJS_s);
			beanRef.secondaryRemoveDocumentsLinkFrom(aDocumentsLinkFrom);
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
				container.postInvoke(this, 61, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveDocumentsLinkTo
	 */
	public void secondaryRemoveDocumentsLinkTo(com.hps.july.persistence.DocumentsLink aDocumentsLinkTo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 62, _EJS_s);
			beanRef.secondaryRemoveDocumentsLinkTo(aDocumentsLinkTo);
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
				container.postInvoke(this, 62, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveStorageCard
	 */
	public void secondaryRemoveStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 63, _EJS_s);
			beanRef.secondaryRemoveStorageCard(aStorageCard);
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
				container.postInvoke(this, 63, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetContragent
	 */
	public void secondarySetContragent(com.hps.july.persistence.Organization aContragent) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 64, _EJS_s);
			beanRef.secondarySetContragent(aContragent);
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
				container.postInvoke(this, 64, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetFrom
	 */
	public void secondarySetFrom(com.hps.july.persistence.StoragePlace aFrom) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 65, _EJS_s);
			beanRef.secondarySetFrom(aFrom);
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
				container.postInvoke(this, 65, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetOwner
	 */
	public void secondarySetOwner(com.hps.july.persistence.Organization anOwner) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 66, _EJS_s);
			beanRef.secondarySetOwner(anOwner);
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
				container.postInvoke(this, 66, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetStorageManager
	 */
	public void secondarySetStorageManager(com.hps.july.persistence.Worker aStorageManager) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 67, _EJS_s);
			beanRef.secondarySetStorageManager(aStorageManager);
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
				container.postInvoke(this, 67, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetTo
	 */
	public void secondarySetTo(com.hps.july.persistence.StoragePlace aTo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 68, _EJS_s);
			beanRef.secondarySetTo(aTo);
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
				container.postInvoke(this, 68, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBlankdate
	 */
	public void setBlankdate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 69, _EJS_s);
			beanRef.setBlankdate(newValue);
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
				container.postInvoke(this, 69, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBlankindex
	 */
	public void setBlankindex(int newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 70, _EJS_s);
			beanRef.setBlankindex(newValue);
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
				container.postInvoke(this, 70, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBlanknumber
	 */
	public void setBlanknumber(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 71, _EJS_s);
			beanRef.setBlanknumber(newValue);
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
				container.postInvoke(this, 71, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContragent
	 */
	public void setContragent(com.hps.july.persistence.Organization aContragent) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 72, _EJS_s);
			beanRef.setContragent(aContragent);
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
				container.postInvoke(this, 72, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDocument
	 */
	public void setDocument(int newDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 73, _EJS_s);
			beanRef.setDocument(newDocument);
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
				container.postInvoke(this, 73, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDocumentState
	 */
	public void setDocumentState(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 74, _EJS_s);
			beanRef.setDocumentState(newValue);
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
				container.postInvoke(this, 74, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setFrom
	 */
	public void setFrom(com.hps.july.persistence.StoragePlace aFrom) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 75, _EJS_s);
			beanRef.setFrom(aFrom);
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
				container.postInvoke(this, 75, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setInsuranceact
	 */
	public void setInsuranceact(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 76, _EJS_s);
			beanRef.setInsuranceact(newValue);
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
				container.postInvoke(this, 76, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setInsurancedate
	 */
	public void setInsurancedate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 77, _EJS_s);
			beanRef.setInsurancedate(newValue);
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
				container.postInvoke(this, 77, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setInsuranseMan
	 */
	public void setInsuranseMan(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 78, _EJS_s);
			beanRef.setInsuranseMan(newValue);
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
				container.postInvoke(this, 78, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIsautodoc
	 */
	public void setIsautodoc(boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 79, _EJS_s);
			beanRef.setIsautodoc(newValue);
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
				container.postInvoke(this, 79, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setNeedapprove
	 */
	public void setNeedapprove(boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 80, _EJS_s);
			beanRef.setNeedapprove(newValue);
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
				container.postInvoke(this, 80, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setOperator
	 */
	public void setOperator(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 81, _EJS_s);
			beanRef.setOperator(newValue);
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
				container.postInvoke(this, 81, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setOwner
	 */
	public void setOwner(com.hps.july.persistence.Organization anOwner) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 82, _EJS_s);
			beanRef.setOwner(anOwner);
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
				container.postInvoke(this, 82, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setParentdocument
	 */
	public void setParentdocument(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 83, _EJS_s);
			beanRef.setParentdocument(newValue);
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
				container.postInvoke(this, 83, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPrjstatus
	 */
	public void setPrjstatus(java.lang.String newPrjstatus) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 84, _EJS_s);
			beanRef.setPrjstatus(newPrjstatus);
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
				container.postInvoke(this, 84, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setProjectid
	 */
	public void setProjectid(java.lang.Integer newProjectid) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 85, _EJS_s);
			beanRef.setProjectid(newProjectid);
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
				container.postInvoke(this, 85, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setShowtouser
	 */
	public void setShowtouser(boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 86, _EJS_s);
			beanRef.setShowtouser(newValue);
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
				container.postInvoke(this, 86, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setStorageManager
	 */
	public void setStorageManager(com.hps.july.persistence.Worker aStorageManager) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 87, _EJS_s);
			beanRef.setStorageManager(aStorageManager);
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
				container.postInvoke(this, 87, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setTo
	 */
	public void setTo(com.hps.july.persistence.StoragePlace aTo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 88, _EJS_s);
			beanRef.setTo(aTo);
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
				container.postInvoke(this, 88, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setTo2
	 */
	public void setTo2(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 89, _EJS_s);
			beanRef.setTo2(newValue);
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
				container.postInvoke(this, 89, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setVisualtype
	 */
	public void setVisualtype(java.lang.Integer newVisualtype) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 90, _EJS_s);
			beanRef.setVisualtype(newVisualtype);
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
				container.postInvoke(this, 90, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetAgregateKey
	 */
	public void privateSetAgregateKey(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 91, _EJS_s);
			beanRef.privateSetAgregateKey(inKey);
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
				container.postInvoke(this, 91, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetTechStuffKey
	 */
	public void privateSetTechStuffKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 92, _EJS_s);
			beanRef.privateSetTechStuffKey(inKey);
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
				container.postInvoke(this, 92, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddI13nActResourceSet
	 */
	public void secondaryAddI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 93, _EJS_s);
			beanRef.secondaryAddI13nActResourceSet(anI13nActResourceSet);
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
				container.postInvoke(this, 93, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddI13nDateSaving
	 */
	public void secondaryAddI13nDateSaving(com.hps.july.persistence.I13nDateSaving anI13nDateSaving) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 94, _EJS_s);
			beanRef.secondaryAddI13nDateSaving(anI13nDateSaving);
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
				container.postInvoke(this, 94, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveI13nActResourceSet
	 */
	public void secondaryRemoveI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 95, _EJS_s);
			beanRef.secondaryRemoveI13nActResourceSet(anI13nActResourceSet);
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
				container.postInvoke(this, 95, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveI13nDateSaving
	 */
	public void secondaryRemoveI13nDateSaving(com.hps.july.persistence.I13nDateSaving anI13nDateSaving) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 96, _EJS_s);
			beanRef.secondaryRemoveI13nDateSaving(anI13nDateSaving);
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
				container.postInvoke(this, 96, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetAgregate
	 */
	public void secondarySetAgregate(com.hps.july.persistence.StorageCard anAgregate) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 97, _EJS_s);
			beanRef.secondarySetAgregate(anAgregate);
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
				container.postInvoke(this, 97, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetTechStuff
	 */
	public void secondarySetTechStuff(com.hps.july.persistence.Worker aTechStuff) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 98, _EJS_s);
			beanRef.secondarySetTechStuff(aTechStuff);
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
				container.postInvoke(this, 98, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAgregate
	 */
	public void setAgregate(com.hps.july.persistence.StorageCard anAgregate) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 99, _EJS_s);
			beanRef.setAgregate(anAgregate);
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
				container.postInvoke(this, 99, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAgregateresource
	 */
	public void setAgregateresource(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 100, _EJS_s);
			beanRef.setAgregateresource(newValue);
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
				container.postInvoke(this, 100, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAgregateserial
	 */
	public void setAgregateserial(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 101, _EJS_s);
			beanRef.setAgregateserial(newValue);
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
				container.postInvoke(this, 101, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRecalcagrprice
	 */
	public void setRecalcagrprice(java.lang.Boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 102, _EJS_s);
			beanRef.setRecalcagrprice(newValue);
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
				container.postInvoke(this, 102, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setTechStuff
	 */
	public void setTechStuff(com.hps.july.persistence.Worker aTechStuff) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 103, _EJS_s);
			beanRef.setTechStuff(aTechStuff);
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
				container.postInvoke(this, 103, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable arg0) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.I13nActBean beanRef = (com.hps.july.persistence.I13nActBean)container.preInvoke(this, 104, _EJS_s);
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
				container.postInvoke(this, 104, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
