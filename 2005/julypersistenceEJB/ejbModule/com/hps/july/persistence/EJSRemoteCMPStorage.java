package com.hps.july.persistence;

/**
 * EJSRemoteCMPStorage
 */
public class EJSRemoteCMPStorage extends com.hps.july.persistence.EJSRemoteCMPStorage_930d19ef implements Storage {
	/**
	 * EJSRemoteCMPStorage
	 */
	public EJSRemoteCMPStorage() throws java.rmi.RemoteException {
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
