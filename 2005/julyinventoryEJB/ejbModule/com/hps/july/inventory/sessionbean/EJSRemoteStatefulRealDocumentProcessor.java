package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatefulRealDocumentProcessor
 */
public class EJSRemoteStatefulRealDocumentProcessor extends com.hps.july.inventory.sessionbean.EJSRemoteStatefulRealDocumentProcessor_1a374c5e implements RealDocumentProcessor {
	/**
	 * EJSRemoteStatefulRealDocumentProcessor
	 */
	public EJSRemoteStatefulRealDocumentProcessor() throws java.rmi.RemoteException {
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
