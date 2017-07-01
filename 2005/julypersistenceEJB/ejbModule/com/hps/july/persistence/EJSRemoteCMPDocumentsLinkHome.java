package com.hps.july.persistence;

/**
 * EJSRemoteCMPDocumentsLinkHome
 */
public class EJSRemoteCMPDocumentsLinkHome extends com.hps.july.persistence.EJSRemoteCMPDocumentsLinkHome_27e6892f implements com.hps.july.persistence.DocumentsLinkHome {
	/**
	 * EJSRemoteCMPDocumentsLinkHome
	 */
	public EJSRemoteCMPDocumentsLinkHome() throws java.rmi.RemoteException {
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
