package com.hps.july.arenda.sessionbean;

/**
 * EJSRemoteStatelessArendaDocumentProcessor
 */
public class EJSRemoteStatelessArendaDocumentProcessor extends com.hps.july.arenda.sessionbean.EJSRemoteStatelessArendaDocumentProcessor_49b89b95 implements ArendaDocumentProcessor {
	/**
	 * EJSRemoteStatelessArendaDocumentProcessor
	 */
	public EJSRemoteStatelessArendaDocumentProcessor() throws java.rmi.RemoteException {
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
