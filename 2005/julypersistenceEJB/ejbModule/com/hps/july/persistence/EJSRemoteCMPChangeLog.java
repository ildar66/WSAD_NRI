package com.hps.july.persistence;

/**
 * EJSRemoteCMPChangeLog
 */
public class EJSRemoteCMPChangeLog extends com.hps.july.persistence.EJSRemoteCMPChangeLog_7a6fd283 implements ChangeLog {
	/**
	 * EJSRemoteCMPChangeLog
	 */
	public EJSRemoteCMPChangeLog() throws java.rmi.RemoteException {
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
