package com.hps.july.persistence;

/**
 * EJSRemoteCMPDocumentActionHome
 */
public class EJSRemoteCMPDocumentActionHome extends com.hps.july.persistence.EJSRemoteCMPDocumentActionHome_f5bd2b10 implements com.hps.july.persistence.DocumentActionHome {
	/**
	 * EJSRemoteCMPDocumentActionHome
	 */
	public EJSRemoteCMPDocumentActionHome() throws java.rmi.RemoteException {
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
