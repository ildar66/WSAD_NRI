package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessAfsActProcessor_ca1bbce9
 */
public class EJSRemoteStatelessAfsActProcessor_ca1bbce9 extends EJSWrapper implements AfsActProcessor {
	/**
	 * EJSRemoteStatelessAfsActProcessor_ca1bbce9
	 */
	public EJSRemoteStatelessAfsActProcessor_ca1bbce9() throws java.rmi.RemoteException {
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
	 * checkAddInfoModification
	 */
	public boolean checkAddInfoModification(java.lang.Integer argDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.inventory.sessionbean.AfsActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.AfsActProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.checkAddInfoModification(argDocument);
		}
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
	 * applyDocument
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException applyDocument(java.lang.Integer argDocument, boolean recreateAddInfo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.AfsActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.AfsActProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.applyDocument(argDocument, recreateAddInfo);
		}
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
	 * cancelDocument
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException cancelDocument(java.lang.Integer argDocument, boolean deleteAddInfo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.AfsActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.AfsActProcessorBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.cancelDocument(argDocument, deleteAddInfo);
		}
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
	 * applyAFSInfo
	 */
	public void applyAFSInfo(java.lang.Integer argDocument, boolean recreateAddInfo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.AfsActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.AfsActProcessorBean)container.preInvoke(this, 3, _EJS_s);
			beanRef.applyAFSInfo(argDocument, recreateAddInfo);
		}
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
		return ;
	}
	/**
	 * cancelAFSInfo
	 */
	public void cancelAFSInfo(java.lang.Integer argDocument, boolean deleteAddInfo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.AfsActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.AfsActProcessorBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.cancelAFSInfo(argDocument, deleteAddInfo);
		}
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
		return ;
	}
}
