package com.hps.july.persistence;

/**
 * EJSRemoteCMPStorageCard
 */
public class EJSRemoteCMPStorageCard extends com.hps.july.persistence.EJSRemoteCMPStorageCard_d765aaca implements StorageCard {
	/**
	 * EJSRemoteCMPStorageCard
	 */
	public EJSRemoteCMPStorageCard() throws java.rmi.RemoteException {
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
