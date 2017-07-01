package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPImportRecordHome_dac5a1dd
 */
public class EJSRemoteCMPImportRecordHome_dac5a1dd extends EJSWrapper implements com.hps.july.persistence.ImportRecordHome {
	/**
	 * EJSRemoteCMPImportRecordHome_dac5a1dd
	 */
	public EJSRemoteCMPImportRecordHome_dac5a1dd() throws java.rmi.RemoteException {
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
	public com.hps.july.persistence.ImportRecord create(int argImprecid, int argImpSesid, java.sql.Timestamp argRecendtime, java.lang.String argAction, java.lang.String argResult, java.lang.String argErrlabel) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.ImportRecord _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd beanRef = (com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argImprecid, argImpSesid, argRecendtime, argAction, argResult, argErrlabel);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ImportRecord findByPrimaryKey(com.hps.july.persistence.ImportRecordKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.ImportRecord _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd beanRef = (com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd)container.preInvoke(this, 1, _EJS_s);
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
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd beanRef = (com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.findByQBE(isRecendtime, beginDate, endDate, isOperator, operator, isKeyfields, keyfields, isImpsesid, impsesid, order);
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
	 * findByQBE1
	 */
	public java.util.Enumeration findByQBE1(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Boolean isResult, java.lang.String result, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd beanRef = (com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findByQBE1(isRecendtime, beginDate, endDate, isOperator, operator, isKeyfields, keyfields, isImpsesid, impsesid, isResult, result, order);
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
	 * findImportRecordsByImportsession
	 */
	public java.util.Enumeration findImportRecordsByImportsession(com.hps.july.persistence.ImportSessionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd beanRef = (com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findImportRecordsByImportsession(inKey);
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
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd beanRef = (com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd)container.preInvoke(this, 5, _EJS_s);
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
				container.postInvoke(this, 5, _EJS_s);
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
			com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd beanRef = (com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd)container.preInvoke(this, 6, _EJS_s);
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
				container.postInvoke(this, 6, _EJS_s);
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
			com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd beanRef = (com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd)container.preInvoke(this, 7, _EJS_s);
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
				container.postInvoke(this, 7, _EJS_s);
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
			com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd beanRef = (com.hps.july.persistence.EJSCMPImportRecordHomeBean_dac5a1dd)container.preInvoke(this, 8, _EJS_s);
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
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
