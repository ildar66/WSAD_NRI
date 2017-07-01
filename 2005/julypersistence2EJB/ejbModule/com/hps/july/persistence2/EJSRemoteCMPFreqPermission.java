package com.hps.july.persistence2;

/**
 * EJSRemoteCMPFreqPermission
 */
public class EJSRemoteCMPFreqPermission extends com.hps.july.persistence2.EJSRemoteCMPFreqPermission_85b7d5de implements FreqPermission {
	/**
	 * EJSRemoteCMPFreqPermission
	 */
	public EJSRemoteCMPFreqPermission() throws java.rmi.RemoteException {
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
