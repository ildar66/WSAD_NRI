package com.hps.july.persistence;

/**
 * EJSRemoteCMPImportSession
 */
public class EJSRemoteCMPImportSession extends com.hps.july.persistence.EJSRemoteCMPImportSession_b9c67c10 implements ImportSession {
	/**
	 * EJSRemoteCMPImportSession
	 */
	public EJSRemoteCMPImportSession() throws java.rmi.RemoteException {
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
