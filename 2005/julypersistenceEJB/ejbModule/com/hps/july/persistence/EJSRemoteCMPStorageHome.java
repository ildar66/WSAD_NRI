package com.hps.july.persistence;

/**
 * EJSRemoteCMPStorageHome
 */
public class EJSRemoteCMPStorageHome extends com.hps.july.persistence.EJSRemoteCMPStorageHome_930d19ef implements com.hps.july.persistence.StorageHome {
	/**
	 * EJSRemoteCMPStorageHome
	 */
	public EJSRemoteCMPStorageHome() throws java.rmi.RemoteException {
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
