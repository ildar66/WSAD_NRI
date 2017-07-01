package com.hps.july.persistence;

/**
 * EJSRemoteCMPDocumentsLink
 */
public class EJSRemoteCMPDocumentsLink extends com.hps.july.persistence.EJSRemoteCMPDocumentsLink_27e6892f implements DocumentsLink {
	/**
	 * EJSRemoteCMPDocumentsLink
	 */
	public EJSRemoteCMPDocumentsLink() throws java.rmi.RemoteException {
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
