package com.hps.july.persistence;

/**
 * EJSRemoteCMPUserReport
 */
public class EJSRemoteCMPUserReport extends com.hps.july.persistence.EJSRemoteCMPUserReport_7abdfa48 implements UserReport {
	/**
	 * EJSRemoteCMPUserReport
	 */
	public EJSRemoteCMPUserReport() throws java.rmi.RemoteException {
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
