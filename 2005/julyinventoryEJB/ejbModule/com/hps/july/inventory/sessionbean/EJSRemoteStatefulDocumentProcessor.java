package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatefulDocumentProcessor
 */
public class EJSRemoteStatefulDocumentProcessor extends com.hps.july.inventory.sessionbean.EJSRemoteStatefulDocumentProcessor_9dc45a50 implements DocumentProcessor {
	/**
	 * EJSRemoteStatefulDocumentProcessor
	 */
	public EJSRemoteStatefulDocumentProcessor() throws java.rmi.RemoteException {
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
