package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseTaskStart
 */
public class EJSRemoteCMPLeaseTaskStart extends com.hps.july.persistence.EJSRemoteCMPLeaseTaskStart_4ec6dba1 implements LeaseTaskStart {
	/**
	 * EJSRemoteCMPLeaseTaskStart
	 */
	public EJSRemoteCMPLeaseTaskStart() throws java.rmi.RemoteException {
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
