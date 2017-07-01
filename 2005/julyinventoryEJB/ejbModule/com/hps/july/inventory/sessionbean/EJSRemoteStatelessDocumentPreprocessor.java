package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessDocumentPreprocessor
 */
public class EJSRemoteStatelessDocumentPreprocessor extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessDocumentPreprocessor_a3e982fa implements DocumentPreprocessor {
	/**
	 * EJSRemoteStatelessDocumentPreprocessor
	 */
	public EJSRemoteStatelessDocumentPreprocessor() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return new com.ibm.ejs.container.EJSDeployedSupport();
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		return;
	}
}
