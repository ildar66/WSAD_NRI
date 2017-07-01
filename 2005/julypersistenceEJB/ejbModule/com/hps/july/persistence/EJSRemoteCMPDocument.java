package com.hps.july.persistence;

/**
 * EJSRemoteCMPDocument
 */
public class EJSRemoteCMPDocument extends com.hps.july.persistence.EJSRemoteCMPDocument_0fc4a4d2 implements Document {
	/**
	 * EJSRemoteCMPDocument
	 */
	public EJSRemoteCMPDocument() throws java.rmi.RemoteException {
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
