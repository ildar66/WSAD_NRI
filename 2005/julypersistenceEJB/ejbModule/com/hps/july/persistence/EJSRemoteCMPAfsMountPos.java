package com.hps.july.persistence;

/**
 * EJSRemoteCMPAfsMountPos
 */
public class EJSRemoteCMPAfsMountPos extends com.hps.july.persistence.EJSRemoteCMPAfsMountPos_2f48d5de implements AfsMountPos {
	/**
	 * EJSRemoteCMPAfsMountPos
	 */
	public EJSRemoteCMPAfsMountPos() throws java.rmi.RemoteException {
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
