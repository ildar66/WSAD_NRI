package com.hps.july.persistence;

/**
 * EJSRemoteCMPNetZone
 */
public class EJSRemoteCMPNetZone extends com.hps.july.persistence.EJSRemoteCMPNetZone_6ae04792 implements NetZone {
	/**
	 * EJSRemoteCMPNetZone
	 */
	public EJSRemoteCMPNetZone() throws java.rmi.RemoteException {
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
