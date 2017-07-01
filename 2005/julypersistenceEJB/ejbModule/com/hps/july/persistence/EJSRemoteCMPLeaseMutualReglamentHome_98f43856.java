package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPLeaseMutualReglamentHome_98f43856
 */
public class EJSRemoteCMPLeaseMutualReglamentHome_98f43856 extends EJSWrapper implements com.hps.july.persistence.LeaseMutualReglamentHome {
	/**
	 * EJSRemoteCMPLeaseMutualReglamentHome_98f43856
	 */
	public EJSRemoteCMPLeaseMutualReglamentHome_98f43856() throws java.rmi.RemoteException {
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
	public com.hps.july.persistence.LeaseMutualReglament create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseMutualReglament _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argLeaseDocument);
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
	public com.hps.july.persistence.LeaseMutualReglament create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.String argMutualPeriod, java.lang.Integer argMainCurrency, java.lang.Boolean argCommonRate, java.lang.String argActType, java.lang.String argMutstate, java.lang.String argDutyraterule, java.sql.Date argStartDate, java.sql.Date argEndDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseMutualReglament _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(argLeaseDocument, argDocDate, argDocNumber, argMutualPeriod, argMainCurrency, argCommonRate, argActType, argMutstate, argDutyraterule, argStartDate, argEndDate);
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
	public com.hps.july.persistence.LeaseMutualReglament findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseMutualReglament _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 2, _EJS_s);
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
	 * findByLeaseDocumentOrderByDocumentNumberAsc
	 */
	public java.util.Enumeration findByLeaseDocumentOrderByDocumentNumberAsc(java.lang.Integer leaseDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findByLeaseDocumentOrderByDocumentNumberAsc(leaseDocument);
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
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isDocDate, java.sql.Date docDate, java.lang.Boolean isBlank, java.lang.String blank, java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isMutStateEdit, java.lang.Boolean isMutStateRun, java.lang.Boolean isMutStateClose, java.lang.Boolean isActType, java.lang.String actType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findByQBE(isDocDate, docDate, isBlank, blank, isLeaseContract, leaseContract, isMutStateEdit, isMutStateRun, isMutStateClose, isActType, actType, order);
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
	 * findByResourceContractDates
	 */
	public java.util.Enumeration findByResourceContractDates(java.lang.Integer resource, java.lang.Integer contract, java.sql.Date startDate, java.sql.Date finishDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findByResourceContractDates(resource, contract, startDate, finishDate);
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
	 * findByResourceContractMaxDateStart
	 */
	public java.util.Enumeration findByResourceContractMaxDateStart(java.lang.Integer resource, java.lang.Integer contract) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findByResourceContractMaxDateStart(resource, contract);
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
	 * findConcurentReglamentsByReglament
	 */
	public java.util.Enumeration findConcurentReglamentsByReglament(java.lang.Integer argReglament) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.findConcurentReglamentsByReglament(argReglament);
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
	 * findLeaseMutualReglamentsAddByAdditionalCurrency
	 */
	public java.util.Enumeration findLeaseMutualReglamentsAddByAdditionalCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.findLeaseMutualReglamentsAddByAdditionalCurrency(inKey);
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
	 * findLeaseMutualReglamentsMainByMaincurrency
	 */
	public java.util.Enumeration findLeaseMutualReglamentsMainByMaincurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.findLeaseMutualReglamentsMainByMaincurrency(inKey);
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
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 10, _EJS_s);
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
				container.postInvoke(this, 10, _EJS_s);
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
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 11, _EJS_s);
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
				container.postInvoke(this, 11, _EJS_s);
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
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 12, _EJS_s);
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
				container.postInvoke(this, 12, _EJS_s);
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
			com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualReglamentHomeBean_98f43856)container.preInvoke(this, 13, _EJS_s);
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
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
