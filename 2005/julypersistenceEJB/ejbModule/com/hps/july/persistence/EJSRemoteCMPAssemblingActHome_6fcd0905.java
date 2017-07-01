package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPAssemblingActHome_6fcd0905
 */
public class EJSRemoteCMPAssemblingActHome_6fcd0905 extends EJSWrapper implements com.hps.july.persistence.AssemblingActHome {
	/**
	 * EJSRemoteCMPAssemblingActHome_6fcd0905
	 */
	public EJSRemoteCMPAssemblingActHome_6fcd0905() throws java.rmi.RemoteException {
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
	public com.hps.july.persistence.AssemblingAct create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AssemblingAct _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argDocument);
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
	public com.hps.july.persistence.AssemblingAct create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination, java.lang.Integer argAgregat, java.lang.String argType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AssemblingAct _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(argDocument, argOwner, argFrom, argTo, argBlankDate, argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination, argAgregat, argType);
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
	 * create
	 */
	public com.hps.july.persistence.AssemblingAct create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination, java.lang.String argAgregatSerial, java.lang.String argType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AssemblingAct _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.create(argDocument, argOwner, argFrom, argTo, argBlankDate, argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination, argAgregatSerial, argType);
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
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AssemblingAct create(int argDocument, java.lang.Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AssemblingAct _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.create(argDocument, argOwner, argBlankDate, argBlankindex, argState);
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
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AssemblingAct findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.AssemblingAct _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 4, _EJS_s);
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAssemblingActByAgregat
	 */
	public java.util.Enumeration findAssemblingActByAgregat(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findAssemblingActByAgregat(inKey);
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
	 * findAssemblingActByMonter
	 */
	public java.util.Enumeration findAssemblingActByMonter(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findAssemblingActByMonter(inKey);
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
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.sql.Date startDate, java.sql.Date endDate, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isStorage, java.lang.Integer storage, java.lang.Boolean isOperationType, java.lang.String operationType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.findByQBE(startDate, endDate, isOrganization, organization, isStorage, storage, isOperationType, operationType, order);
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
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.sql.Date startDate, java.sql.Date endDate, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isOperationType, java.lang.String operationType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.findByQBE2(startDate, endDate, isOrganization, organization, isPosition, position, isOperationType, operationType, order);
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
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 9, _EJS_s);
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
				container.postInvoke(this, 9, _EJS_s);
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
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 10, _EJS_s);
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
				container.postInvoke(this, 10, _EJS_s);
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
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 11, _EJS_s);
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
				container.postInvoke(this, 11, _EJS_s);
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
			com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905 beanRef = (com.hps.july.persistence.EJSCMPAssemblingActHomeBean_6fcd0905)container.preInvoke(this, 12, _EJS_s);
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
}
