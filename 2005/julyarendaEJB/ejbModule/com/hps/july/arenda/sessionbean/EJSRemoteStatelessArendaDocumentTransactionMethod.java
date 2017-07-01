package com.hps.july.arenda.sessionbean;

/**
 * EJSRemoteStatelessArendaDocumentTransactionMethod
 */
public class EJSRemoteStatelessArendaDocumentTransactionMethod extends com.hps.july.arenda.sessionbean.EJSRemoteStatelessArendaDocumentTransactionMethod_51e18d53 implements ArendaDocumentTransactionMethod {
	/**
	 * EJSRemoteStatelessArendaDocumentTransactionMethod
	 */
	public EJSRemoteStatelessArendaDocumentTransactionMethod() throws java.rmi.RemoteException {
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
