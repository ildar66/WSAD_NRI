package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseDocumentHome
 */
public class EJSRemoteCMPLeaseDocumentHome extends com.hps.july.persistence.EJSRemoteCMPLeaseDocumentHome_a05aa12e implements com.hps.july.persistence.LeaseDocumentHome {
	/**
	 * EJSRemoteCMPLeaseDocumentHome
	 */
	public EJSRemoteCMPLeaseDocumentHome() throws java.rmi.RemoteException {
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
