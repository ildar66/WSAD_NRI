package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessDocumentPreprocessorHome
 */
public class EJSRemoteStatelessDocumentPreprocessorHome extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessDocumentPreprocessorHome_a3e982fa implements com.hps.july.inventory.sessionbean.DocumentPreprocessorHome {
	/**
	 * EJSRemoteStatelessDocumentPreprocessorHome
	 */
	public EJSRemoteStatelessDocumentPreprocessorHome() throws java.rmi.RemoteException {
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
