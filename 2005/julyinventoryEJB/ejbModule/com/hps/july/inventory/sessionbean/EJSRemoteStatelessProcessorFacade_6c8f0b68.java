package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessProcessorFacade_6c8f0b68
 */
public class EJSRemoteStatelessProcessorFacade_6c8f0b68 extends EJSWrapper implements ProcessorFacade {
	/**
	 * EJSRemoteStatelessProcessorFacade_6c8f0b68
	 */
	public EJSRemoteStatelessProcessorFacade_6c8f0b68() throws java.rmi.RemoteException {
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
	public boolean checkAddInfoModification(java.lang.Integer docCode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.inventory.sessionbean.ProcessorFacadeBean beanRef = (com.hps.july.inventory.sessionbean.ProcessorFacadeBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.checkAddInfoModification(docCode);
		}
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
	 * cancelDocument
	 */
	public void cancelDocument(java.lang.Integer docCode) throws java.rmi.RemoteException, com.hps.july.inventory.sessionbean.DocumentProcessingException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.ProcessorFacadeBean beanRef = (com.hps.july.inventory.sessionbean.ProcessorFacadeBean)container.preInvoke(this, 1, _EJS_s);
			beanRef.cancelDocument(docCode);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (com.hps.july.inventory.sessionbean.DocumentProcessingException ex) {
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
		return ;
	}
	/**
	 * cancelDocument
	 */
	public void cancelDocument(java.lang.Integer docCode, boolean deleteAddInfo) throws java.rmi.RemoteException, com.hps.july.inventory.sessionbean.DocumentProcessingException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.ProcessorFacadeBean beanRef = (com.hps.july.inventory.sessionbean.ProcessorFacadeBean)container.preInvoke(this, 2, _EJS_s);
			beanRef.cancelDocument(docCode, deleteAddInfo);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (com.hps.july.inventory.sessionbean.DocumentProcessingException ex) {
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
		return ;
	}
	/**
	 * deleteDocument
	 */
	public void deleteDocument(java.lang.Integer documentCode) throws java.rmi.RemoteException, com.hps.july.inventory.sessionbean.DocumentProcessingException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.ProcessorFacadeBean beanRef = (com.hps.july.inventory.sessionbean.ProcessorFacadeBean)container.preInvoke(this, 3, _EJS_s);
			beanRef.deleteDocument(documentCode);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (com.hps.july.inventory.sessionbean.DocumentProcessingException ex) {
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
		return ;
	}
	/**
	 * processDocument
	 */
	public void processDocument(java.lang.Integer docCode) throws java.rmi.RemoteException, com.hps.july.inventory.sessionbean.DocumentProcessingException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.ProcessorFacadeBean beanRef = (com.hps.july.inventory.sessionbean.ProcessorFacadeBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.processDocument(docCode);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (com.hps.july.inventory.sessionbean.DocumentProcessingException ex) {
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
		return ;
	}
	/**
	 * processDocument
	 */
	public void processDocument(java.lang.Integer docCode, boolean deleteAddInfo) throws java.rmi.RemoteException, com.hps.july.inventory.sessionbean.DocumentProcessingException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.ProcessorFacadeBean beanRef = (com.hps.july.inventory.sessionbean.ProcessorFacadeBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.processDocument(docCode, deleteAddInfo);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (com.hps.july.inventory.sessionbean.DocumentProcessingException ex) {
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
		return ;
	}
	/**
	 * processDocument
	 */
	public void processDocument(java.lang.Integer docCode, boolean deleteAddInfo, boolean generateAutoDocs) throws com.hps.july.inventory.sessionbean.DocumentProcessingException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.inventory.sessionbean.ProcessorFacadeBean beanRef = (com.hps.july.inventory.sessionbean.ProcessorFacadeBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.processDocument(docCode, deleteAddInfo, generateAutoDocs);
		}
		catch (com.hps.july.inventory.sessionbean.DocumentProcessingException ex) {
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
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
