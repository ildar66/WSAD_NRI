package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPLeaseMutualActNewHome_c0a2cc67
 */
public class EJSRemoteCMPLeaseMutualActNewHome_c0a2cc67 extends EJSWrapper implements com.hps.july.persistence.LeaseMutualActNewHome {
	/**
	 * EJSRemoteCMPLeaseMutualActNewHome_c0a2cc67
	 */
	public EJSRemoteCMPLeaseMutualActNewHome_c0a2cc67() throws java.rmi.RemoteException {
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
	public com.hps.july.persistence.LeaseMutualActNew create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseMutualActNew _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 0, _EJS_s);
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
	public com.hps.july.persistence.LeaseMutualActNew create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.Integer argLeaseMutualReglament, java.lang.String argState, java.sql.Date actstartdate, java.sql.Date actenddate, boolean argIsTemp) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseMutualActNew _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(argLeaseDocument, argDocDate, argDocNumber, argLeaseMutualReglament, argState, actstartdate, actenddate, argIsTemp);
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
	public com.hps.july.persistence.LeaseMutualActNew create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.Integer argLeaseMutualReglament, java.lang.String argState, java.sql.Date actstartdate, java.sql.Date actenddate, boolean argIsTemp, java.lang.Boolean argIsSchetFakt) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseMutualActNew _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.create(argLeaseDocument, argDocDate, argDocNumber, argLeaseMutualReglament, argState, actstartdate, actenddate, argIsTemp, argIsSchetFakt);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseMutualActNew findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseMutualActNew _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 3, _EJS_s);
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
	public java.util.Enumeration findByQBE(java.lang.Boolean isMutualReglament, java.lang.Integer mutualReglament, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findByQBE(isMutualReglament, mutualReglament, isDate, fromDate, toDate, order);
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
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Integer mutualReglament, java.lang.Boolean isEdit, java.lang.Boolean isRun, java.lang.Boolean isClose, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findByQBE2(mutualReglament, isEdit, isRun, isClose, order);
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
	 * findLeaseMutualActNewByLeaseMutualReglament
	 */
	public java.util.Enumeration findLeaseMutualActNewByLeaseMutualReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findLeaseMutualActNewByLeaseMutualReglament(inKey);
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
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 7, _EJS_s);
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
				container.postInvoke(this, 7, _EJS_s);
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
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 8, _EJS_s);
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
				container.postInvoke(this, 8, _EJS_s);
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
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 9, _EJS_s);
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
				container.postInvoke(this, 9, _EJS_s);
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
			com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 beanRef = (com.hps.july.persistence.EJSCMPLeaseMutualActNewHomeBean_c0a2cc67)container.preInvoke(this, 10, _EJS_s);
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
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
