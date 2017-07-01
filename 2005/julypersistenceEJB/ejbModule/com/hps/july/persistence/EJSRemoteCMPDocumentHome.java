package com.hps.july.persistence;

/**
 * EJSRemoteCMPDocumentHome
 */
public class EJSRemoteCMPDocumentHome extends com.hps.july.persistence.EJSRemoteCMPDocumentHome_0fc4a4d2 implements com.hps.july.persistence.DocumentHome {
	/**
	 * EJSRemoteCMPDocumentHome
	 */
	public EJSRemoteCMPDocumentHome() throws java.rmi.RemoteException {
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
