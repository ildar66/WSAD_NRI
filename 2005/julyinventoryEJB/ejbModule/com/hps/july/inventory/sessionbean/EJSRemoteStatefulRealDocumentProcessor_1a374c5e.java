package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatefulRealDocumentProcessor_1a374c5e
 */
public class EJSRemoteStatefulRealDocumentProcessor_1a374c5e extends EJSWrapper implements RealDocumentProcessor {
	/**
	 * EJSRemoteStatefulRealDocumentProcessor_1a374c5e
	 */
	public EJSRemoteStatefulRealDocumentProcessor_1a374c5e() throws java.rmi.RemoteException {
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
	 * applyDocument
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException applyDocument(java.lang.Integer argDoc) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.RealDocumentProcessorBean beanRef = (com.hps.july.inventory.sessionbean.RealDocumentProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.applyDocument(argDoc);
		}
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
	public com.hps.july.inventory.sessionbean.DocumentProcessingException cancelDocument(java.lang.Integer argDoc) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.RealDocumentProcessorBean beanRef = (com.hps.july.inventory.sessionbean.RealDocumentProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.cancelDocument(argDoc);
		}
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
	 * addPosition2Document
	 */
	public com.hps.july.inventory.sessionbean.ProcessingPositionError addPosition2Document(java.lang.Integer argPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.ProcessingPositionError _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.RealDocumentProcessorBean beanRef = (com.hps.july.inventory.sessionbean.RealDocumentProcessorBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.addPosition2Document(argPosition);
		}
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
	 * getDocumentSum
	 */
	public java.math.BigDecimal getDocumentSum(java.lang.Integer argDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.RealDocumentProcessorBean beanRef = (com.hps.july.inventory.sessionbean.RealDocumentProcessorBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getDocumentSum(argDocument);
		}
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
}
