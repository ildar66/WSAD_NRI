package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessDocumentPreprocessor_a3e982fa
 */
public class EJSRemoteStatelessDocumentPreprocessor_a3e982fa extends EJSWrapper implements DocumentPreprocessor {
	/**
	 * EJSRemoteStatelessDocumentPreprocessor_a3e982fa
	 */
	public EJSRemoteStatelessDocumentPreprocessor_a3e982fa() throws java.rmi.RemoteException {
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
	 * preprocessDocument
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException preprocessDocument(int argDoc) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.DocumentPreprocessorBean beanRef = (com.hps.july.inventory.sessionbean.DocumentPreprocessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.preprocessDocument(argDoc);
		}
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
}
