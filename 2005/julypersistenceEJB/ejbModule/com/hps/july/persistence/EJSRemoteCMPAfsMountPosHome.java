package com.hps.july.persistence;

/**
 * EJSRemoteCMPAfsMountPosHome
 */
public class EJSRemoteCMPAfsMountPosHome extends com.hps.july.persistence.EJSRemoteCMPAfsMountPosHome_2f48d5de implements com.hps.july.persistence.AfsMountPosHome {
	/**
	 * EJSRemoteCMPAfsMountPosHome
	 */
	public EJSRemoteCMPAfsMountPosHome() throws java.rmi.RemoteException {
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
