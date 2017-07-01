package com.hps.july.persistence;

/**
 * EJSRemoteCMPStoragePlace
 */
public class EJSRemoteCMPStoragePlace extends com.hps.july.persistence.EJSRemoteCMPStoragePlace_f3647562 implements StoragePlace {
	/**
	 * EJSRemoteCMPStoragePlace
	 */
	public EJSRemoteCMPStoragePlace() throws java.rmi.RemoteException {
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
