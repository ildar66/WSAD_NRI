package com.hps.july.persistence;

/**
 * EJSRemoteCMPWLAN
 */
public class EJSRemoteCMPWLAN extends com.hps.july.persistence.EJSRemoteCMPWLAN_a4ea2a90 implements WLAN {
	/**
	 * EJSRemoteCMPWLAN
	 */
	public EJSRemoteCMPWLAN() throws java.rmi.RemoteException {
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
