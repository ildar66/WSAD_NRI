package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatefulDocumentProcessorHome
 */
public class EJSRemoteStatefulDocumentProcessorHome extends com.hps.july.inventory.sessionbean.EJSRemoteStatefulDocumentProcessorHome_9dc45a50 implements com.hps.july.inventory.sessionbean.DocumentProcessorHome {
	/**
	 * EJSRemoteStatefulDocumentProcessorHome
	 */
	public EJSRemoteStatefulDocumentProcessorHome() throws java.rmi.RemoteException {
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
