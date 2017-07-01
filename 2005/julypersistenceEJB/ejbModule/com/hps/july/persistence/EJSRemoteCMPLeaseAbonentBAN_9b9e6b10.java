package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPLeaseAbonentBAN_9b9e6b10
 */
public class EJSRemoteCMPLeaseAbonentBAN_9b9e6b10 extends EJSWrapper implements LeaseAbonentBAN {
	/**
	 * EJSRemoteCMPLeaseAbonentBAN_9b9e6b10
	 */
	public EJSRemoteCMPLeaseAbonentBAN_9b9e6b10() throws java.rmi.RemoteException {
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
	 * getFlagworkpie
	 */
	public boolean getFlagworkpie() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getFlagworkpie();
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
	 * getTechcontract
	 */
	public boolean getTechcontract() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getTechcontract();
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
	 * getUseallben
	 */
	public boolean getUseallben() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getUseallben();
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
	 * getUseinacts
	 */
	public boolean getUseinacts() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getUseinacts();
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
	 * getChargeNds
	 */
	public boolean getChargeNds() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getChargeNds();
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
	 * getIsRateLimit
	 */
	public boolean getIsRateLimit() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getIsRateLimit();
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
	 * getNalogAgent
	 */
	public boolean getNalogAgent() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.getNalogAgent();
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
	 * getCurrency1
	 */
	public com.hps.july.persistence.Currency getCurrency1() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Currency _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.getCurrency1();
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
	 * getCurrency2
	 */
	public com.hps.july.persistence.Currency getCurrency2() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Currency _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.getCurrency2();
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
	 * getCurrency1Key
	 */
	public com.hps.july.persistence.CurrencyKey getCurrency1Key() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.CurrencyKey _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.getCurrency1Key();
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
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCurrency2Key
	 */
	public com.hps.july.persistence.CurrencyKey getCurrency2Key() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.CurrencyKey _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.getCurrency2Key();
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
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getOrgCustomer
	 */
	public com.hps.july.persistence.OrganizationNfs getOrgCustomer() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.OrganizationNfs _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.getOrgCustomer();
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
	 * getOrgExecutor
	 */
	public com.hps.july.persistence.OrganizationNfs getOrgExecutor() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.OrganizationNfs _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.getOrgExecutor();
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
	 * getOrgCustomerKey
	 */
	public com.hps.july.persistence.OrganizationNfsKey getOrgCustomerKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.OrganizationNfsKey _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.getOrgCustomerKey();
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
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getOrgExecutorKey
	 */
	public com.hps.july.persistence.OrganizationNfsKey getOrgExecutorKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.OrganizationNfsKey _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.getOrgExecutorKey();
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
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEconomist
	 */
	public com.hps.july.persistence.Worker getEconomist() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Worker _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.getEconomist();
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
	 * getManager
	 */
	public com.hps.july.persistence.Worker getManager() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Worker _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.getManager();
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
	 * getEconomistKey
	 */
	public com.hps.july.persistence.WorkerKey getEconomistKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.WorkerKey _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.getEconomistKey();
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
	 * getManagerKey
	 */
	public com.hps.july.persistence.WorkerKey getManagerKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.WorkerKey _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.getManagerKey();
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
	 * getBan
	 */
	public int getBan() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef.getBan();
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
	 * getLeaseDocument
	 */
	public int getLeaseDocument() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 20, _EJS_s);
			_EJS_result = beanRef.getLeaseDocument();
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
	 * getRegionid
	 */
	public int getRegionid() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 21, _EJS_s);
			_EJS_result = beanRef.getRegionid();
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
	 * getHavedocsigned
	 */
	public java.lang.Boolean getHavedocsigned() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 22, _EJS_s);
			_EJS_result = beanRef.getHavedocsigned();
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
	 * getHavedocsignedcustomer
	 */
	public java.lang.Boolean getHavedocsignedcustomer() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 23, _EJS_s);
			_EJS_result = beanRef.getHavedocsignedcustomer();
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
	 * getMainposition
	 */
	public java.lang.Integer getMainposition() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 24, _EJS_s);
			_EJS_result = beanRef.getMainposition();
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
	 * getOrgowner
	 */
	public java.lang.Integer getOrgowner() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 25, _EJS_s);
			_EJS_result = beanRef.getOrgowner();
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
	 * getCreatedby
	 */
	public java.lang.Integer getCreatedby() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 26, _EJS_s);
			_EJS_result = beanRef.getCreatedby();
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
	 * getModifiedby
	 */
	public java.lang.Integer getModifiedby() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 27, _EJS_s);
			_EJS_result = beanRef.getModifiedby();
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
	 * getOperator
	 */
	public java.lang.Integer getOperator() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 28, _EJS_s);
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
				container.postInvoke(this, 28, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getExtenddays
	 */
	public java.lang.Short getExtenddays() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Short _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 29, _EJS_s);
			_EJS_result = beanRef.getExtenddays();
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
	 * getExtendmonthes
	 */
	public java.lang.Short getExtendmonthes() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Short _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 30, _EJS_s);
			_EJS_result = beanRef.getExtendmonthes();
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
	 * getExtendyears
	 */
	public java.lang.Short getExtendyears() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Short _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 31, _EJS_s);
			_EJS_result = beanRef.getExtendyears();
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
	 * getRatecalcruleday
	 */
	public java.lang.Short getRatecalcruleday() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Short _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 32, _EJS_s);
			_EJS_result = beanRef.getRatecalcruleday();
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
	 * getAccounttype
	 */
	public java.lang.String getAccounttype() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 33, _EJS_s);
			_EJS_result = beanRef.getAccounttype();
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
	 * getBil_acctypename
	 */
	public java.lang.String getBil_acctypename() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 34, _EJS_s);
			_EJS_result = beanRef.getBil_acctypename();
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
				container.postInvoke(this, 34, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBil_billaddress
	 */
	public java.lang.String getBil_billaddress() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 35, _EJS_s);
			_EJS_result = beanRef.getBil_billaddress();
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
				container.postInvoke(this, 35, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBil_contrstatus
	 */
	public java.lang.String getBil_contrstatus() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 36, _EJS_s);
			_EJS_result = beanRef.getBil_contrstatus();
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
				container.postInvoke(this, 36, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBil_contrstname
	 */
	public java.lang.String getBil_contrstname() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 37, _EJS_s);
			_EJS_result = beanRef.getBil_contrstname();
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
				container.postInvoke(this, 37, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBil_inn
	 */
	public java.lang.String getBil_inn() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 38, _EJS_s);
			_EJS_result = beanRef.getBil_inn();
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
				container.postInvoke(this, 38, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBil_name
	 */
	public java.lang.String getBil_name() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 39, _EJS_s);
			_EJS_result = beanRef.getBil_name();
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
				container.postInvoke(this, 39, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProctype
	 */
	public java.lang.String getProctype() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 40, _EJS_s);
			_EJS_result = beanRef.getProctype();
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
				container.postInvoke(this, 40, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getBuchdocnumber
	 */
	public java.lang.String getBuchdocnumber() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 41, _EJS_s);
			_EJS_result = beanRef.getBuchdocnumber();
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
				container.postInvoke(this, 41, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getChangeenddate
	 */
	public java.lang.String getChangeenddate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 42, _EJS_s);
			_EJS_result = beanRef.getChangeenddate();
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
	 * getContractState
	 */
	public java.lang.String getContractState() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 43, _EJS_s);
			_EJS_result = beanRef.getContractState();
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
		return _EJS_result;
	}
	/**
	 * getContractType
	 */
	public java.lang.String getContractType() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 44, _EJS_s);
			_EJS_result = beanRef.getContractType();
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
		return _EJS_result;
	}
	/**
	 * getCustname
	 */
	public java.lang.String getCustname() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 45, _EJS_s);
			_EJS_result = beanRef.getCustname();
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
		return _EJS_result;
	}
	/**
	 * getDocFileName
	 */
	public java.lang.String getDocFileName() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 46, _EJS_s);
			_EJS_result = beanRef.getDocFileName();
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
		return _EJS_result;
	}
	/**
	 * getExecname
	 */
	public java.lang.String getExecname() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 47, _EJS_s);
			_EJS_result = beanRef.getExecname();
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
		return _EJS_result;
	}
	/**
	 * getExtendPeriod
	 */
	public java.lang.String getExtendPeriod() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 48, _EJS_s);
			_EJS_result = beanRef.getExtendPeriod();
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
		return _EJS_result;
	}
	/**
	 * getExtendType
	 */
	public java.lang.String getExtendType() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 49, _EJS_s);
			_EJS_result = beanRef.getExtendType();
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
		return _EJS_result;
	}
	/**
	 * getRatecalcrule
	 */
	public java.lang.String getRatecalcrule() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 50, _EJS_s);
			_EJS_result = beanRef.getRatecalcrule();
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
		return _EJS_result;
	}
	/**
	 * getReportPeriod
	 */
	public java.lang.String getReportPeriod() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 51, _EJS_s);
			_EJS_result = beanRef.getReportPeriod();
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
		return _EJS_result;
	}
	/**
	 * getDocumentNumber
	 */
	public java.lang.String getDocumentNumber() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 52, _EJS_s);
			_EJS_result = beanRef.getDocumentNumber();
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
		return _EJS_result;
	}
	/**
	 * getBalans
	 */
	public java.math.BigDecimal getBalans() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 53, _EJS_s);
			_EJS_result = beanRef.getBalans();
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
		return _EJS_result;
	}
	/**
	 * getRateLimitMax
	 */
	public java.math.BigDecimal getRateLimitMax() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 54, _EJS_s);
			_EJS_result = beanRef.getRateLimitMax();
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
		return _EJS_result;
	}
	/**
	 * getRateLimitMin
	 */
	public java.math.BigDecimal getRateLimitMin() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 55, _EJS_s);
			_EJS_result = beanRef.getRateLimitMin();
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
		return _EJS_result;
	}
	/**
	 * getRateNDS
	 */
	public java.math.BigDecimal getRateNDS() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 56, _EJS_s);
			_EJS_result = beanRef.getRateNDS();
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
		return _EJS_result;
	}
	/**
	 * getRatedelta
	 */
	public java.math.BigDecimal getRatedelta() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 57, _EJS_s);
			_EJS_result = beanRef.getRatedelta();
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
		return _EJS_result;
	}
	/**
	 * getSumm1
	 */
	public java.math.BigDecimal getSumm1() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 58, _EJS_s);
			_EJS_result = beanRef.getSumm1();
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
		return _EJS_result;
	}
	/**
	 * getSumm2
	 */
	public java.math.BigDecimal getSumm2() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 59, _EJS_s);
			_EJS_result = beanRef.getSumm2();
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
		return _EJS_result;
	}
	/**
	 * getBil_contrstdate
	 */
	public java.sql.Date getBil_contrstdate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 60, _EJS_s);
			_EJS_result = beanRef.getBil_contrstdate();
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
		return _EJS_result;
	}
	/**
	 * getBil_startservdate
	 */
	public java.sql.Date getBil_startservdate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 61, _EJS_s);
			_EJS_result = beanRef.getBil_startservdate();
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
		return _EJS_result;
	}
	/**
	 * getBil_suspdate
	 */
	public java.sql.Date getBil_suspdate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 62, _EJS_s);
			_EJS_result = beanRef.getBil_suspdate();
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
		return _EJS_result;
	}
	/**
	 * getDateclose
	 */
	public java.sql.Date getDateclose() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 63, _EJS_s);
			_EJS_result = beanRef.getDateclose();
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
		return _EJS_result;
	}
	/**
	 * getEndDate
	 */
	public java.sql.Date getEndDate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 64, _EJS_s);
			_EJS_result = beanRef.getEndDate();
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
		return _EJS_result;
	}
	/**
	 * getStartDate
	 */
	public java.sql.Date getStartDate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 65, _EJS_s);
			_EJS_result = beanRef.getStartDate();
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
		return _EJS_result;
	}
	/**
	 * getDocumentDate
	 */
	public java.sql.Date getDocumentDate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 66, _EJS_s);
			_EJS_result = beanRef.getDocumentDate();
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
		return _EJS_result;
	}
	/**
	 * getCreated
	 */
	public java.sql.Timestamp getCreated() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Timestamp _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 67, _EJS_s);
			_EJS_result = beanRef.getCreated();
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
		return _EJS_result;
	}
	/**
	 * getModified
	 */
	public java.sql.Timestamp getModified() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Timestamp _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 68, _EJS_s);
			_EJS_result = beanRef.getModified();
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
		return _EJS_result;
	}
	/**
	 * getAbonentBills
	 */
	public java.util.Enumeration getAbonentBills() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 69, _EJS_s);
			_EJS_result = beanRef.getAbonentBills();
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
				container.postInvoke(this, 69, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAbonentPayments
	 */
	public java.util.Enumeration getAbonentPayments() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 70, _EJS_s);
			_EJS_result = beanRef.getAbonentPayments();
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
				container.postInvoke(this, 70, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseAbonentBENs
	 */
	public java.util.Enumeration getLeaseAbonentBENs() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 71, _EJS_s);
			_EJS_result = beanRef.getLeaseAbonentBENs();
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
				container.postInvoke(this, 71, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseAbonentPhones
	 */
	public java.util.Enumeration getLeaseAbonentPhones() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 72, _EJS_s);
			_EJS_result = beanRef.getLeaseAbonentPhones();
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
				container.postInvoke(this, 72, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseDocPosition
	 */
	public java.util.Enumeration getLeaseDocPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 73, _EJS_s);
			_EJS_result = beanRef.getLeaseDocPosition();
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
				container.postInvoke(this, 73, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseMRCntPriors1
	 */
	public java.util.Enumeration getLeaseMRCntPriors1() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 74, _EJS_s);
			_EJS_result = beanRef.getLeaseMRCntPriors1();
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
				container.postInvoke(this, 74, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseMRCntPriors2
	 */
	public java.util.Enumeration getLeaseMRCntPriors2() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 75, _EJS_s);
			_EJS_result = beanRef.getLeaseMRCntPriors2();
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
				container.postInvoke(this, 75, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseMutualContracts
	 */
	public java.util.Enumeration getLeaseMutualContracts() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 76, _EJS_s);
			_EJS_result = beanRef.getLeaseMutualContracts();
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
				container.postInvoke(this, 76, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseSchetFakts
	 */
	public java.util.Enumeration getLeaseSchetFakts() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 77, _EJS_s);
			_EJS_result = beanRef.getLeaseSchetFakts();
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
				container.postInvoke(this, 77, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseVPaymentCs
	 */
	public java.util.Enumeration getLeaseVPaymentCs() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 78, _EJS_s);
			_EJS_result = beanRef.getLeaseVPaymentCs();
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
				container.postInvoke(this, 78, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseVPaymentDs
	 */
	public java.util.Enumeration getLeaseVPaymentDs() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 79, _EJS_s);
			_EJS_result = beanRef.getLeaseVPaymentDs();
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
				container.postInvoke(this, 79, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseRules
	 */
	public java.util.Enumeration getLeaseRules() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 80, _EJS_s);
			_EJS_result = beanRef.getLeaseRules();
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
				container.postInvoke(this, 80, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseTaskStarts
	 */
	public java.util.Enumeration getLeaseTaskStarts() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 81, _EJS_s);
			_EJS_result = beanRef.getLeaseTaskStarts();
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
				container.postInvoke(this, 81, _EJS_s);
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
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 82, _EJS_s);
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
				container.postInvoke(this, 82, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * addAbonentBills
	 */
	public void addAbonentBills(com.hps.july.persistence.AbonentBill anAbonentBills) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 83, _EJS_s);
			beanRef.addAbonentBills(anAbonentBills);
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
	 * addAbonentPayments
	 */
	public void addAbonentPayments(com.hps.july.persistence.AbonentPayment anAbonentPayments) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 84, _EJS_s);
			beanRef.addAbonentPayments(anAbonentPayments);
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
	 * secondaryAddAbonentBills
	 */
	public void secondaryAddAbonentBills(com.hps.july.persistence.AbonentBill anAbonentBills) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 85, _EJS_s);
			beanRef.secondaryAddAbonentBills(anAbonentBills);
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
	 * secondaryAddAbonentPayments
	 */
	public void secondaryAddAbonentPayments(com.hps.july.persistence.AbonentPayment anAbonentPayments) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 86, _EJS_s);
			beanRef.secondaryAddAbonentPayments(anAbonentPayments);
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
	 * secondaryAddLeaseAbonentBENs
	 */
	public void secondaryAddLeaseAbonentBENs(com.hps.july.persistence.LeaseAbonentBEN aLeaseAbonentBENs) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 87, _EJS_s);
			beanRef.secondaryAddLeaseAbonentBENs(aLeaseAbonentBENs);
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
	 * secondaryAddLeaseAbonentPhones
	 */
	public void secondaryAddLeaseAbonentPhones(com.hps.july.persistence.LeaseAbonentPhone aLeaseAbonentPhones) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 88, _EJS_s);
			beanRef.secondaryAddLeaseAbonentPhones(aLeaseAbonentPhones);
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
	 * secondaryRemoveAbonentBills
	 */
	public void secondaryRemoveAbonentBills(com.hps.july.persistence.AbonentBill anAbonentBills) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 89, _EJS_s);
			beanRef.secondaryRemoveAbonentBills(anAbonentBills);
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
	 * secondaryRemoveAbonentPayments
	 */
	public void secondaryRemoveAbonentPayments(com.hps.july.persistence.AbonentPayment anAbonentPayments) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 90, _EJS_s);
			beanRef.secondaryRemoveAbonentPayments(anAbonentPayments);
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
	 * secondaryRemoveLeaseAbonentBENs
	 */
	public void secondaryRemoveLeaseAbonentBENs(com.hps.july.persistence.LeaseAbonentBEN aLeaseAbonentBENs) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 91, _EJS_s);
			beanRef.secondaryRemoveLeaseAbonentBENs(aLeaseAbonentBENs);
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
	 * secondaryRemoveLeaseAbonentPhones
	 */
	public void secondaryRemoveLeaseAbonentPhones(com.hps.july.persistence.LeaseAbonentPhone aLeaseAbonentPhones) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 92, _EJS_s);
			beanRef.secondaryRemoveLeaseAbonentPhones(aLeaseAbonentPhones);
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
	 * setAccounttype
	 */
	public void setAccounttype(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 93, _EJS_s);
			beanRef.setAccounttype(newValue);
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
	 * setBalans
	 */
	public void setBalans(java.math.BigDecimal newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 94, _EJS_s);
			beanRef.setBalans(newValue);
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
	 * setBan
	 */
	public void setBan(int newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 95, _EJS_s);
			beanRef.setBan(newValue);
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
	 * setBil_acctypename
	 */
	public void setBil_acctypename(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 96, _EJS_s);
			beanRef.setBil_acctypename(newValue);
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
	 * setBil_billaddress
	 */
	public void setBil_billaddress(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 97, _EJS_s);
			beanRef.setBil_billaddress(newValue);
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
	 * setBil_contrstatus
	 */
	public void setBil_contrstatus(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 98, _EJS_s);
			beanRef.setBil_contrstatus(newValue);
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
	 * setBil_contrstdate
	 */
	public void setBil_contrstdate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 99, _EJS_s);
			beanRef.setBil_contrstdate(newValue);
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
	 * setBil_contrstname
	 */
	public void setBil_contrstname(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 100, _EJS_s);
			beanRef.setBil_contrstname(newValue);
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
	 * setBil_inn
	 */
	public void setBil_inn(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 101, _EJS_s);
			beanRef.setBil_inn(newValue);
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
	 * setBil_name
	 */
	public void setBil_name(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 102, _EJS_s);
			beanRef.setBil_name(newValue);
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
	 * setBil_startservdate
	 */
	public void setBil_startservdate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 103, _EJS_s);
			beanRef.setBil_startservdate(newValue);
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
	 * setBil_suspdate
	 */
	public void setBil_suspdate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 104, _EJS_s);
			beanRef.setBil_suspdate(newValue);
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
	/**
	 * setFlagworkpie
	 */
	public void setFlagworkpie(boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 105, _EJS_s);
			beanRef.setFlagworkpie(newValue);
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
				container.postInvoke(this, 105, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMainposition
	 */
	public void setMainposition(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 106, _EJS_s);
			beanRef.setMainposition(newValue);
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
				container.postInvoke(this, 106, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setProctype
	 */
	public void setProctype(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 107, _EJS_s);
			beanRef.setProctype(newValue);
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
				container.postInvoke(this, 107, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setTechcontract
	 */
	public void setTechcontract(boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 108, _EJS_s);
			beanRef.setTechcontract(newValue);
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
				container.postInvoke(this, 108, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setUseallben
	 */
	public void setUseallben(boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 109, _EJS_s);
			beanRef.setUseallben(newValue);
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
				container.postInvoke(this, 109, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setUseinacts
	 */
	public void setUseinacts(boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 110, _EJS_s);
			beanRef.setUseinacts(newValue);
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
				container.postInvoke(this, 110, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeaseDocPosition
	 */
	public void addLeaseDocPosition(com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 111, _EJS_s);
			beanRef.addLeaseDocPosition(aLeaseDocPosition);
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
				container.postInvoke(this, 111, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeaseSchetFakts
	 */
	public void addLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 112, _EJS_s);
			beanRef.addLeaseSchetFakts(aLeaseSchetFakts);
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
				container.postInvoke(this, 112, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetCurrency1Key
	 */
	public void privateSetCurrency1Key(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 113, _EJS_s);
			beanRef.privateSetCurrency1Key(inKey);
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
				container.postInvoke(this, 113, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetCurrency2Key
	 */
	public void privateSetCurrency2Key(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 114, _EJS_s);
			beanRef.privateSetCurrency2Key(inKey);
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
				container.postInvoke(this, 114, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetEconomistKey
	 */
	public void privateSetEconomistKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 115, _EJS_s);
			beanRef.privateSetEconomistKey(inKey);
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
				container.postInvoke(this, 115, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetManagerKey
	 */
	public void privateSetManagerKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 116, _EJS_s);
			beanRef.privateSetManagerKey(inKey);
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
				container.postInvoke(this, 116, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetOrgCustomerKey
	 */
	public void privateSetOrgCustomerKey(com.hps.july.persistence.OrganizationNfsKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 117, _EJS_s);
			beanRef.privateSetOrgCustomerKey(inKey);
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
				container.postInvoke(this, 117, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetOrgExecutorKey
	 */
	public void privateSetOrgExecutorKey(com.hps.july.persistence.OrganizationNfsKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 118, _EJS_s);
			beanRef.privateSetOrgExecutorKey(inKey);
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
				container.postInvoke(this, 118, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseDocPosition
	 */
	public void secondaryAddLeaseDocPosition(com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 119, _EJS_s);
			beanRef.secondaryAddLeaseDocPosition(aLeaseDocPosition);
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
				container.postInvoke(this, 119, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseMRCntPriors1
	 */
	public void secondaryAddLeaseMRCntPriors1(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors1) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 120, _EJS_s);
			beanRef.secondaryAddLeaseMRCntPriors1(aLeaseMRCntPriors1);
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
				container.postInvoke(this, 120, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseMRCntPriors2
	 */
	public void secondaryAddLeaseMRCntPriors2(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors2) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 121, _EJS_s);
			beanRef.secondaryAddLeaseMRCntPriors2(aLeaseMRCntPriors2);
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
				container.postInvoke(this, 121, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseMutualContracts
	 */
	public void secondaryAddLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 122, _EJS_s);
			beanRef.secondaryAddLeaseMutualContracts(aLeaseMutualContracts);
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
				container.postInvoke(this, 122, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseSchetFakts
	 */
	public void secondaryAddLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 123, _EJS_s);
			beanRef.secondaryAddLeaseSchetFakts(aLeaseSchetFakts);
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
				container.postInvoke(this, 123, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseVPaymentCs
	 */
	public void secondaryAddLeaseVPaymentCs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentCs) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 124, _EJS_s);
			beanRef.secondaryAddLeaseVPaymentCs(aLeaseVPaymentCs);
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
				container.postInvoke(this, 124, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseVPaymentDs
	 */
	public void secondaryAddLeaseVPaymentDs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentDs) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 125, _EJS_s);
			beanRef.secondaryAddLeaseVPaymentDs(aLeaseVPaymentDs);
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
				container.postInvoke(this, 125, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseDocPosition
	 */
	public void secondaryRemoveLeaseDocPosition(com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 126, _EJS_s);
			beanRef.secondaryRemoveLeaseDocPosition(aLeaseDocPosition);
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
				container.postInvoke(this, 126, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseMRCntPriors1
	 */
	public void secondaryRemoveLeaseMRCntPriors1(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors1) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 127, _EJS_s);
			beanRef.secondaryRemoveLeaseMRCntPriors1(aLeaseMRCntPriors1);
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
				container.postInvoke(this, 127, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseMRCntPriors2
	 */
	public void secondaryRemoveLeaseMRCntPriors2(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors2) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 128, _EJS_s);
			beanRef.secondaryRemoveLeaseMRCntPriors2(aLeaseMRCntPriors2);
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
				container.postInvoke(this, 128, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseMutualContracts
	 */
	public void secondaryRemoveLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 129, _EJS_s);
			beanRef.secondaryRemoveLeaseMutualContracts(aLeaseMutualContracts);
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
				container.postInvoke(this, 129, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseSchetFakts
	 */
	public void secondaryRemoveLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 130, _EJS_s);
			beanRef.secondaryRemoveLeaseSchetFakts(aLeaseSchetFakts);
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
				container.postInvoke(this, 130, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseVPaymentCs
	 */
	public void secondaryRemoveLeaseVPaymentCs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentCs) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 131, _EJS_s);
			beanRef.secondaryRemoveLeaseVPaymentCs(aLeaseVPaymentCs);
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
				container.postInvoke(this, 131, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseVPaymentDs
	 */
	public void secondaryRemoveLeaseVPaymentDs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentDs) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 132, _EJS_s);
			beanRef.secondaryRemoveLeaseVPaymentDs(aLeaseVPaymentDs);
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
				container.postInvoke(this, 132, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetCurrency1
	 */
	public void secondarySetCurrency1(com.hps.july.persistence.Currency aCurrency1) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 133, _EJS_s);
			beanRef.secondarySetCurrency1(aCurrency1);
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
				container.postInvoke(this, 133, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetCurrency2
	 */
	public void secondarySetCurrency2(com.hps.july.persistence.Currency aCurrency2) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 134, _EJS_s);
			beanRef.secondarySetCurrency2(aCurrency2);
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
				container.postInvoke(this, 134, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetEconomist
	 */
	public void secondarySetEconomist(com.hps.july.persistence.Worker anEconomist) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 135, _EJS_s);
			beanRef.secondarySetEconomist(anEconomist);
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
				container.postInvoke(this, 135, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetManager
	 */
	public void secondarySetManager(com.hps.july.persistence.Worker aManager) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 136, _EJS_s);
			beanRef.secondarySetManager(aManager);
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
				container.postInvoke(this, 136, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetOrgCustomer
	 */
	public void secondarySetOrgCustomer(com.hps.july.persistence.OrganizationNfs anOrgCustomer) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 137, _EJS_s);
			beanRef.secondarySetOrgCustomer(anOrgCustomer);
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
				container.postInvoke(this, 137, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetOrgExecutor
	 */
	public void secondarySetOrgExecutor(com.hps.july.persistence.OrganizationNfs anOrgExecutor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 138, _EJS_s);
			beanRef.secondarySetOrgExecutor(anOrgExecutor);
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
				container.postInvoke(this, 138, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBuchdocnumber
	 */
	public void setBuchdocnumber(java.lang.String newBuchdocnumber) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 139, _EJS_s);
			beanRef.setBuchdocnumber(newBuchdocnumber);
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
				container.postInvoke(this, 139, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setChangeenddate
	 */
	public void setChangeenddate(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 140, _EJS_s);
			beanRef.setChangeenddate(newValue);
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
				container.postInvoke(this, 140, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setChargeNds
	 */
	public void setChargeNds(boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 141, _EJS_s);
			beanRef.setChargeNds(newValue);
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
				container.postInvoke(this, 141, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractState
	 */
	public void setContractState(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 142, _EJS_s);
			beanRef.setContractState(newValue);
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
				container.postInvoke(this, 142, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setContractType
	 */
	public void setContractType(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 143, _EJS_s);
			beanRef.setContractType(newValue);
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
				container.postInvoke(this, 143, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCurrency1
	 */
	public void setCurrency1(com.hps.july.persistence.Currency aCurrency1) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 144, _EJS_s);
			beanRef.setCurrency1(aCurrency1);
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
				container.postInvoke(this, 144, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCurrency2
	 */
	public void setCurrency2(com.hps.july.persistence.Currency aCurrency2) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 145, _EJS_s);
			beanRef.setCurrency2(aCurrency2);
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
				container.postInvoke(this, 145, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCustname
	 */
	public void setCustname(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 146, _EJS_s);
			beanRef.setCustname(newValue);
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
				container.postInvoke(this, 146, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDateclose
	 */
	public void setDateclose(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 147, _EJS_s);
			beanRef.setDateclose(newValue);
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
				container.postInvoke(this, 147, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDocFileName
	 */
	public void setDocFileName(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 148, _EJS_s);
			beanRef.setDocFileName(newValue);
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
				container.postInvoke(this, 148, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setEconomist
	 */
	public void setEconomist(com.hps.july.persistence.Worker anEconomist) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 149, _EJS_s);
			beanRef.setEconomist(anEconomist);
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
				container.postInvoke(this, 149, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setEndDate
	 */
	public void setEndDate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 150, _EJS_s);
			beanRef.setEndDate(newValue);
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
				container.postInvoke(this, 150, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setExecname
	 */
	public void setExecname(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 151, _EJS_s);
			beanRef.setExecname(newValue);
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
				container.postInvoke(this, 151, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setExtendPeriod
	 */
	public void setExtendPeriod(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 152, _EJS_s);
			beanRef.setExtendPeriod(newValue);
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
				container.postInvoke(this, 152, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setExtendType
	 */
	public void setExtendType(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 153, _EJS_s);
			beanRef.setExtendType(newValue);
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
				container.postInvoke(this, 153, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setExtenddays
	 */
	public void setExtenddays(java.lang.Short newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 154, _EJS_s);
			beanRef.setExtenddays(newValue);
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
				container.postInvoke(this, 154, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setExtendmonthes
	 */
	public void setExtendmonthes(java.lang.Short newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 155, _EJS_s);
			beanRef.setExtendmonthes(newValue);
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
				container.postInvoke(this, 155, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setExtendyears
	 */
	public void setExtendyears(java.lang.Short newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 156, _EJS_s);
			beanRef.setExtendyears(newValue);
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
				container.postInvoke(this, 156, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setHavedocsigned
	 */
	public void setHavedocsigned(java.lang.Boolean newHavedocsigned) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 157, _EJS_s);
			beanRef.setHavedocsigned(newHavedocsigned);
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
				container.postInvoke(this, 157, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setHavedocsignedcustomer
	 */
	public void setHavedocsignedcustomer(java.lang.Boolean newHavedocsignedcustomer) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 158, _EJS_s);
			beanRef.setHavedocsignedcustomer(newHavedocsignedcustomer);
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
				container.postInvoke(this, 158, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIsRateLimit
	 */
	public void setIsRateLimit(boolean newIsRateLimit) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 159, _EJS_s);
			beanRef.setIsRateLimit(newIsRateLimit);
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
				container.postInvoke(this, 159, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setManager
	 */
	public void setManager(com.hps.july.persistence.Worker aManager) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 160, _EJS_s);
			beanRef.setManager(aManager);
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
				container.postInvoke(this, 160, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setNalogAgent
	 */
	public void setNalogAgent(boolean newNalogAgent) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 161, _EJS_s);
			beanRef.setNalogAgent(newNalogAgent);
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
				container.postInvoke(this, 161, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setOrgCustomer
	 */
	public void setOrgCustomer(com.hps.july.persistence.OrganizationNfs anOrgCustomer) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 162, _EJS_s);
			beanRef.setOrgCustomer(anOrgCustomer);
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
				container.postInvoke(this, 162, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setOrgExecutor
	 */
	public void setOrgExecutor(com.hps.july.persistence.OrganizationNfs anOrgExecutor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 163, _EJS_s);
			beanRef.setOrgExecutor(anOrgExecutor);
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
				container.postInvoke(this, 163, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setOrgowner
	 */
	public void setOrgowner(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 164, _EJS_s);
			beanRef.setOrgowner(newValue);
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
				container.postInvoke(this, 164, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRateLimitMax
	 */
	public void setRateLimitMax(java.math.BigDecimal newRateLimitMax) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 165, _EJS_s);
			beanRef.setRateLimitMax(newRateLimitMax);
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
				container.postInvoke(this, 165, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRateLimitMin
	 */
	public void setRateLimitMin(java.math.BigDecimal newRateLimitMin) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 166, _EJS_s);
			beanRef.setRateLimitMin(newRateLimitMin);
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
				container.postInvoke(this, 166, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRateNDS
	 */
	public void setRateNDS(java.math.BigDecimal newRateNDS) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 167, _EJS_s);
			beanRef.setRateNDS(newRateNDS);
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
				container.postInvoke(this, 167, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRatecalcrule
	 */
	public void setRatecalcrule(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 168, _EJS_s);
			beanRef.setRatecalcrule(newValue);
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
				container.postInvoke(this, 168, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRatecalcruleday
	 */
	public void setRatecalcruleday(java.lang.Short newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 169, _EJS_s);
			beanRef.setRatecalcruleday(newValue);
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
				container.postInvoke(this, 169, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRatedelta
	 */
	public void setRatedelta(java.math.BigDecimal newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 170, _EJS_s);
			beanRef.setRatedelta(newValue);
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
				container.postInvoke(this, 170, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setReportPeriod
	 */
	public void setReportPeriod(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 171, _EJS_s);
			beanRef.setReportPeriod(newValue);
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
				container.postInvoke(this, 171, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setStartDate
	 */
	public void setStartDate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 172, _EJS_s);
			beanRef.setStartDate(newValue);
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
				container.postInvoke(this, 172, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSumm1
	 */
	public void setSumm1(java.math.BigDecimal newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 173, _EJS_s);
			beanRef.setSumm1(newValue);
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
				container.postInvoke(this, 173, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSumm2
	 */
	public void setSumm2(java.math.BigDecimal newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 174, _EJS_s);
			beanRef.setSumm2(newValue);
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
				container.postInvoke(this, 174, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeaseRules
	 */
	public void addLeaseRules(com.hps.july.persistence.LeaseRule aLeaseRules) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 175, _EJS_s);
			beanRef.addLeaseRules(aLeaseRules);
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
				container.postInvoke(this, 175, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeaseTaskStarts
	 */
	public void addLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 176, _EJS_s);
			beanRef.addLeaseTaskStarts(aLeaseTaskStarts);
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
				container.postInvoke(this, 176, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeLeaseTaskStarts
	 */
	public void removeLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 177, _EJS_s);
			beanRef.removeLeaseTaskStarts(aLeaseTaskStarts);
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
				container.postInvoke(this, 177, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseRules
	 */
	public void secondaryAddLeaseRules(com.hps.july.persistence.LeaseRule aLeaseRules) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 178, _EJS_s);
			beanRef.secondaryAddLeaseRules(aLeaseRules);
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
				container.postInvoke(this, 178, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseTaskStarts
	 */
	public void secondaryAddLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 179, _EJS_s);
			beanRef.secondaryAddLeaseTaskStarts(aLeaseTaskStarts);
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
				container.postInvoke(this, 179, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseRules
	 */
	public void secondaryRemoveLeaseRules(com.hps.july.persistence.LeaseRule aLeaseRules) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 180, _EJS_s);
			beanRef.secondaryRemoveLeaseRules(aLeaseRules);
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
				container.postInvoke(this, 180, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseTaskStarts
	 */
	public void secondaryRemoveLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 181, _EJS_s);
			beanRef.secondaryRemoveLeaseTaskStarts(aLeaseTaskStarts);
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
				container.postInvoke(this, 181, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCreated
	 */
	public void setCreated(java.sql.Timestamp newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 182, _EJS_s);
			beanRef.setCreated(newValue);
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
				container.postInvoke(this, 182, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCreatedby
	 */
	public void setCreatedby(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 183, _EJS_s);
			beanRef.setCreatedby(newValue);
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
				container.postInvoke(this, 183, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDocumentDate
	 */
	public void setDocumentDate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 184, _EJS_s);
			beanRef.setDocumentDate(newValue);
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
				container.postInvoke(this, 184, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDocumentNumber
	 */
	public void setDocumentNumber(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 185, _EJS_s);
			beanRef.setDocumentNumber(newValue);
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
				container.postInvoke(this, 185, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setLeaseDocument
	 */
	public void setLeaseDocument(int newLeaseDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 186, _EJS_s);
			beanRef.setLeaseDocument(newLeaseDocument);
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
				container.postInvoke(this, 186, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setModified
	 */
	public void setModified(java.sql.Timestamp newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 187, _EJS_s);
			beanRef.setModified(newValue);
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
				container.postInvoke(this, 187, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setModifiedby
	 */
	public void setModifiedby(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 188, _EJS_s);
			beanRef.setModifiedby(newValue);
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
				container.postInvoke(this, 188, _EJS_s);
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
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 189, _EJS_s);
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
				container.postInvoke(this, 189, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegionid
	 */
	public void setRegionid(int newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 190, _EJS_s);
			beanRef.setRegionid(newValue);
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
				container.postInvoke(this, 190, _EJS_s);
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
			com.hps.july.persistence.LeaseAbonentBANBean beanRef = (com.hps.july.persistence.LeaseAbonentBANBean)container.preInvoke(this, 191, _EJS_s);
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
				container.postInvoke(this, 191, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
