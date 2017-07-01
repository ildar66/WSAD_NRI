package com.hps.july.platinum.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessPlatinumProcessor_4fefeba3
 */
public class EJSRemoteStatelessPlatinumProcessor_4fefeba3 extends EJSWrapper implements PlatinumProcessor {
	/**
	 * EJSRemoteStatelessPlatinumProcessor_4fefeba3
	 */
	public EJSRemoteStatelessPlatinumProcessor_4fefeba3() throws java.rmi.RemoteException {
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
	 * isProcessingEnabled
	 */
	public boolean isProcessingEnabled() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.platinum.sessionbean.PlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.PlatinumProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.isProcessingEnabled();
		}
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
	 * processVirtualDocument
	 */
	public java.lang.Integer processVirtualDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.platinum.sessionbean.PlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.PlatinumProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.processVirtualDocument(argDocument);
		}
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
	 * requestPlatinumResources
	 */
	public java.lang.Integer requestPlatinumResources() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.platinum.sessionbean.PlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.PlatinumProcessorBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.requestPlatinumResources();
		}
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
	 * requestPlatinumStorageplaces
	 */
	public java.lang.Integer requestPlatinumStorageplaces() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.platinum.sessionbean.PlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.PlatinumProcessorBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.requestPlatinumStorageplaces();
		}
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
	 * requestPlatinumUsers
	 */
	public java.lang.Integer requestPlatinumUsers() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.platinum.sessionbean.PlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.PlatinumProcessorBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.requestPlatinumUsers();
		}
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
	 * requestPlatinumValutes
	 */
	public java.lang.Integer requestPlatinumValutes(java.sql.Timestamp argStartDate) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.platinum.sessionbean.PlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.PlatinumProcessorBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.requestPlatinumValutes(argStartDate);
		}
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
	 * cancelDocument
	 */
	public void cancelDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.PlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.PlatinumProcessorBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.cancelDocument(argDocument);
		}
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
		return ;
	}
	/**
	 * processDocument
	 */
	public void processDocument(java.lang.Integer argQueryId, java.lang.Integer argDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.platinum.sessionbean.PlatinumProcessorBean beanRef = (com.hps.july.platinum.sessionbean.PlatinumProcessorBean)container.preInvoke(this, 7, _EJS_s);
			beanRef.processDocument(argQueryId, argDocument);
		}
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
