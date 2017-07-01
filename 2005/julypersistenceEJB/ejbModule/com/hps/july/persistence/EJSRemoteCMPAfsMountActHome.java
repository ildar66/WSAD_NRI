package com.hps.july.persistence;

/**
 * EJSRemoteCMPAfsMountActHome
 */
public class EJSRemoteCMPAfsMountActHome extends com.hps.july.persistence.EJSRemoteCMPAfsMountActHome_cf191c99 implements com.hps.july.persistence.AfsMountActHome {
	/**
	 * EJSRemoteCMPAfsMountActHome
	 */
	public EJSRemoteCMPAfsMountActHome() throws java.rmi.RemoteException {
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
