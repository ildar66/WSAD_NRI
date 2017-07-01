package com.hps.july.persistence;

/**
 * EJSRemoteCMPStorageCardHome
 */
public class EJSRemoteCMPStorageCardHome extends com.hps.july.persistence.EJSRemoteCMPStorageCardHome_d765aaca implements com.hps.july.persistence.StorageCardHome {
	/**
	 * EJSRemoteCMPStorageCardHome
	 */
	public EJSRemoteCMPStorageCardHome() throws java.rmi.RemoteException {
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
