package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectActionDocumentHome
 */
public class EJSRemoteCMPProjectActionDocumentHome extends com.hps.july.persistence.EJSRemoteCMPProjectActionDocumentHome_957d9470 implements com.hps.july.persistence.ProjectActionDocumentHome {
	/**
	 * EJSRemoteCMPProjectActionDocumentHome
	 */
	public EJSRemoteCMPProjectActionDocumentHome() throws java.rmi.RemoteException {
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
