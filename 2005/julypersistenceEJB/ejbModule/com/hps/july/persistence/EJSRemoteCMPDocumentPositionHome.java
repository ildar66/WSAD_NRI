package com.hps.july.persistence;

/**
 * EJSRemoteCMPDocumentPositionHome
 */
public class EJSRemoteCMPDocumentPositionHome extends com.hps.july.persistence.EJSRemoteCMPDocumentPositionHome_d62861c8 implements com.hps.july.persistence.DocumentPositionHome {
	/**
	 * EJSRemoteCMPDocumentPositionHome
	 */
	public EJSRemoteCMPDocumentPositionHome() throws java.rmi.RemoteException {
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
